package com.paypal.soap.api;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.axis.description.AttributeDesc;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;

public class ErrorParameterType
  implements Serializable
{
  private String value;
  private String paramID;
  private Object __equalsCalc = null;

  private boolean __hashCodeCalc = false;

  private static TypeDesc typeDesc = new TypeDesc(ErrorParameterType.class, true);

  public ErrorParameterType()
  {
  }

  public ErrorParameterType(String value, String paramID)
  {
    this.value = value;
    this.paramID = paramID;
  }

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public String getParamID()
  {
    return this.paramID;
  }

  public void setParamID(String paramID)
  {
    this.paramID = paramID;
  }

  public synchronized boolean equals(Object obj)
  {
    if (!(obj instanceof ErrorParameterType)) return false;
    ErrorParameterType other = (ErrorParameterType)obj;
    if (obj == null) return false;
    if (this == obj) return true;
    if (this.__equalsCalc != null) {
      return (this.__equalsCalc == obj);
    }
    this.__equalsCalc = obj;

    boolean _equals = ((this.value == null) && (other.getValue() == null)) || ((this.value != null) && (this.value.equals(other.getValue())) && ((((this.paramID == null) && (other.getParamID() == null)) || ((this.paramID != null) && (this.paramID.equals(other.getParamID()))))));

    this.__equalsCalc = null;
    return _equals;
  }

  public synchronized int hashCode()
  {
    if (this.__hashCodeCalc) {
      return 0;
    }
    this.__hashCodeCalc = true;
    int _hashCode = 1;
    if (getValue() != null) {
      _hashCode += getValue().hashCode();
    }
    if (getParamID() != null) {
      _hashCode += getParamID().hashCode();
    }
    this.__hashCodeCalc = false;
    return _hashCode;
  }

  public static TypeDesc getTypeDesc()
  {
    return typeDesc;
  }

  public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
  {
    return new BeanSerializer(_javaType, _xmlType, typeDesc);
  }

  public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
  {
    return new BeanDeserializer(_javaType, _xmlType, typeDesc);
  }

  static
  {
    typeDesc.setXmlType(new QName("urn:ebay:apis:eBLBaseComponents", "ErrorParameterType"));
    AttributeDesc attrField = new AttributeDesc();
    attrField.setFieldName("paramID");
    attrField.setXmlName(new QName("", "ParamID"));
    attrField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    typeDesc.addFieldDesc(attrField);
    ElementDesc elemField = new ElementDesc();
    elemField.setFieldName("value");
    elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "Value"));
    elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
  }
}

