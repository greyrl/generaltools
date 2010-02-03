#!/bin/sh

INTERFACE="eth0"
INTERNAL_IP="192.168.1.1"
CMD="/sbin/iptables"
LOCAL_IP=`/sbin/ip addr show $INTERFACE | grep "inet " | awk '{print $2}' | sed 's/\/.*//' | grep -v 192.168`
PARTNER_IP=`resolveip -s partner 2>/dev/null`
SAFE_NETWORKS="<add your networks here>"

cd `dirname $0`

# create virtual interface
if [ -z "`ip addr show $INTERFACE:1 | grep 192.168`" ]; then
    /sbin/ifconfig $INTERFACE:1 $INTERNAL_IP netmask 255.255.255.0
fi

# set base configuration
echo 1 > /proc/sys/net/ipv4/ip_dynaddr
echo 1 > /proc/sys/net/ipv4/ip_forward
echo 1 > /proc/sys/net/ipv4/tcp_syncookies
echo 1 > /proc/sys/net/ipv4/conf/all/rp_filter
/sbin/iptables-restore < firewall.rules

# GLOBAL RULES
for net in $SAFE_NETWORKS; do
    $CMD -t filter -A INPUT -p tcp -m tcp -s $net -d $LOCAL_IP --dport 22 -j ACCEPT
done
if [ -n "$PARTNER_IP" ]; then
    $CMD -t filter -A INPUT -p tcp -m tcp -s $PARTNER_IP -d $LOCAL_IP --dport 22 -j ACCEPT
fi

# FORWARD SAFE HTTP REQUESTS
for net in $SAFE_NETWORKS; do
    $CMD -t filter -A INPUT -p tcp -m state --state NEW -s $net --dport 80 -i $INTERFACE -j ACCEPT
    $CMD -t filter -A INPUT -p tcp -m state --state NEW -d $INTERNAL_IP --dport 8080 -j ACCEPT
    $CMD -t nat -A PREROUTING -p tcp -m tcp -s $net -d $LOCAL_IP --dport 80 -j DNAT --to-destination $INTERNAL_IP:8080
done

# FORWARD ALL HTTPS REQUESTS
$CMD -t filter -A INPUT -p tcp -m state --state NEW --dport 443 -i $INTERFACE -j ACCEPT
$CMD -t nat -A PREROUTING -p tcp -m tcp -d $LOCAL_IP --dport 443 -j DNAT --to-destination $INTERNAL_IP:443

# LOG DROPS
#$CMD -A INPUT -j LOG --log-level 4
