package com.paypal.soap.api;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.axis.description.ElementDesc;
import org.apache.axis.description.TypeDesc;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.encoding.ser.BeanDeserializer;
import org.apache.axis.encoding.ser.BeanSerializer;
import org.apache.axis.types.Token;

public class ErrorType
  implements Serializable
{
  private String shortMessage;
  private String longMessage;
  private Token errorCode;
  private SeverityCodeType severityCode;
  private ErrorParameterType[] errorParameters;
  private Object __equalsCalc = null;

  private boolean __hashCodeCalc = false;

  private static TypeDesc typeDesc = new TypeDesc(ErrorType.class, true);

  public ErrorType()
  {
  }

  public ErrorType(String shortMessage, String longMessage, Token errorCode, SeverityCodeType severityCode, ErrorParameterType[] errorParameters)
  {
    this.shortMessage = shortMessage;
    this.longMessage = longMessage;
    this.errorCode = errorCode;
    this.severityCode = severityCode;
    this.errorParameters = errorParameters;
  }

  public String getShortMessage()
  {
    return this.shortMessage;
  }

  public void setShortMessage(String shortMessage)
  {
    this.shortMessage = shortMessage;
  }

  public String getLongMessage()
  {
    return this.longMessage;
  }

  public void setLongMessage(String longMessage)
  {
    this.longMessage = longMessage;
  }

  public Token getErrorCode()
  {
    return this.errorCode;
  }

  public void setErrorCode(Token errorCode)
  {
    this.errorCode = errorCode;
  }

  public SeverityCodeType getSeverityCode()
  {
    return this.severityCode;
  }

  public void setSeverityCode(SeverityCodeType severityCode)
  {
    this.severityCode = severityCode;
  }

  public ErrorParameterType[] getErrorParameters()
  {
    return this.errorParameters;
  }

  public void setErrorParameters(ErrorParameterType[] errorParameters)
  {
    this.errorParameters = errorParameters;
  }

  public ErrorParameterType getErrorParameters(int i) {
    return this.errorParameters[i];
  }

  public void setErrorParameters(int i, ErrorParameterType _value) {
    this.errorParameters[i] = _value;
  }

  public synchronized boolean equals(Object obj)
  {
    if (!(obj instanceof ErrorType)) return false;
    ErrorType other = (ErrorType)obj;
    if (obj == null) return false;
    if (this == obj) return true;
    if (this.__equalsCalc != null) {
      return (this.__equalsCalc == obj);
    }
    this.__equalsCalc = obj;

    boolean _equals = ((this.shortMessage == null) && (other.getShortMessage() == null)) || ((this.shortMessage != null) && (this.shortMessage.equals(other.getShortMessage())) && ((((this.longMessage == null) && (other.getLongMessage() == null)) || ((this.longMessage != null) && (this.longMessage.equals(other.getLongMessage())) && ((((this.errorCode == null) && (other.getErrorCode() == null)) || ((this.errorCode != null) && (this.errorCode.equals(other.getErrorCode())) && ((((this.severityCode == null) && (other.getSeverityCode() == null)) || ((this.severityCode != null) && (this.severityCode.equals(other.getSeverityCode())) && ((((this.errorParameters == null) && (other.getErrorParameters() == null)) || ((this.errorParameters != null) && (Arrays.equals(this.errorParameters, other.getErrorParameters())))))))))))))));

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
    if (getShortMessage() != null) {
      _hashCode += getShortMessage().hashCode();
    }
    if (getLongMessage() != null) {
      _hashCode += getLongMessage().hashCode();
    }
    if (getErrorCode() != null) {
      _hashCode += getErrorCode().hashCode();
    }
    if (getSeverityCode() != null) {
      _hashCode += getSeverityCode().hashCode();
    }
    if (getErrorParameters() != null) {
      int i = 0;
      while (i < Array.getLength(getErrorParameters()))
      {
        Object obj = Array.get(getErrorParameters(), i);
        if ((obj != null) && (!(obj.getClass().isArray())))
        {
          _hashCode += obj.hashCode();
        }
        ++i;
      }

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
    typeDesc.setXmlType(new QName("urn:ebay:apis:eBLBaseComponents", "ErrorType"));
    ElementDesc elemField = new ElementDesc();
    elemField.setFieldName("shortMessage");
    elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "ShortMessage"));
    elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
    elemField = new ElementDesc();
    elemField.setFieldName("longMessage");
    elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "LongMessage"));
    elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
    elemField.setMinOccurs(0);
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
    elemField = new ElementDesc();
    elemField.setFieldName("errorCode");
    elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "ErrorCode"));
    elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "token"));
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
    elemField = new ElementDesc();
    elemField.setFieldName("severityCode");
    elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "SeverityCode"));
    elemField.setXmlType(new QName("urn:ebay:apis:eBLBaseComponents", "SeverityCodeType"));
    elemField.setNillable(false);
    typeDesc.addFieldDesc(elemField);
    elemField = new ElementDesc();
    elemField.setFieldName("errorParameters");
    elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "ErrorParameters"));
    elemField.setXmlType(new QName("urn:ebay:apis:eBLBaseComponents", "ErrorParameterType"));
    elemField.setMinOccurs(0);
    elemField.setNillable(false);
    elemField.setMaxOccursUnbounded(true);
    typeDesc.addFieldDesc(elemField);
  }
}

