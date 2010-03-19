ackage com.paypal.soap.api;

mport java.io.ObjectStreamException;
mport java.io.Serializable;
mport java.util.HashMap;
mport javax.xml.namespace.QName;
mport org.apache.axis.description.TypeDesc;
mport org.apache.axis.encoding.Deserializer;
mport org.apache.axis.encoding.Serializer;
mport org.apache.axis.encoding.ser.EnumDeserializer;
mport org.apache.axis.encoding.ser.EnumSerializer;
mport org.apache.axis.types.Token;

ublic class SeverityCodeType
 implements Serializable

 private Token _value_;
 private static HashMap _table_ = new HashMap();

 public static final Token _Warning = new Token("Warning");
 public static final Token _Error = new Token("Error");
 public static final Token _CustomCode = new Token("CustomCode");
 public static final SeverityCodeType Warning = new SeverityCodeType(_Warning);
 public static final SeverityCodeType Error = new SeverityCodeType(_Error);
 public static final SeverityCodeType CustomCode = new SeverityCodeType(_CustomCode);

 private static TypeDesc typeDesc = new TypeDesc(SeverityCodeType.class);

 protected SeverityCodeType(Token value)
 {
   this._value_ = value;
   _table_.put(this._value_, this);
 }

 public Token getValue()
 {
   return this._value_; }

 public static SeverityCodeType fromValue(Token value) throws IllegalArgumentException {
   SeverityCodeType enumeration = (SeverityCodeType)_table_.get(value);

   if (enumeration == null) throw new IllegalArgumentException();
   return enumeration;
 }

 public static SeverityCodeType fromString(String value) throws IllegalArgumentException {
   try {
     return fromValue(new Token(value));
   } catch (Exception e) {
     throw new IllegalArgumentException(); } }

 public boolean equals(Object obj) {
   return (obj == this); } 
 public int hashCode() { return toString().hashCode(); } 
 public String toString() { return this._value_.toString(); } 
 public Object readResolve() throws ObjectStreamException { return fromValue(this._value_);
 }

 public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
 {
   return new EnumSerializer(_javaType, _xmlType);
 }

 public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
 {
   return new EnumDeserializer(_javaType, _xmlType);
 }

 public static TypeDesc getTypeDesc()
 {
   return typeDesc;
 }

 static
 {
   typeDesc.setXmlType(new QName("urn:ebay:apis:eBLBaseComponents", "SeverityCodeType"));
 }

