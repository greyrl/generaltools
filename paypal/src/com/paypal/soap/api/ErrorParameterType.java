/*     */ package com.paypal.soap.api;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.xml.namespace.QName;
/*     */ import org.apache.axis.description.AttributeDesc;
/*     */ import org.apache.axis.description.ElementDesc;
/*     */ import org.apache.axis.description.TypeDesc;
/*     */ import org.apache.axis.encoding.Deserializer;
/*     */ import org.apache.axis.encoding.Serializer;
/*     */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*     */ import org.apache.axis.encoding.ser.BeanSerializer;
/*     */ 
/*     */ public class ErrorParameterType
/*     */   implements Serializable
/*     */ {
/*     */   private String value;
/*     */   private String paramID;
/*  66 */   private Object __equalsCalc = null;
/*     */ 
/*  88 */   private boolean __hashCodeCalc = false;
/*     */ 
/* 106 */   private static TypeDesc typeDesc = new TypeDesc(ErrorParameterType.class, true);
/*     */ 
/*     */   public ErrorParameterType()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ErrorParameterType(String value, String paramID)
/*     */   {
/*  22 */     this.value = value;
/*  23 */     this.paramID = paramID;
/*     */   }
/*     */ 
/*     */   public String getValue()
/*     */   {
/*  33 */     return this.value;
/*     */   }
/*     */ 
/*     */   public void setValue(String value)
/*     */   {
/*  43 */     this.value = value;
/*     */   }
/*     */ 
/*     */   public String getParamID()
/*     */   {
/*  53 */     return this.paramID;
/*     */   }
/*     */ 
/*     */   public void setParamID(String paramID)
/*     */   {
/*  63 */     this.paramID = paramID;
/*     */   }
/*     */ 
/*     */   public synchronized boolean equals(Object obj)
/*     */   {
/*  68 */     if (!(obj instanceof ErrorParameterType)) return false;
/*  69 */     ErrorParameterType other = (ErrorParameterType)obj;
/*  70 */     if (obj == null) return false;
/*  71 */     if (this == obj) return true;
/*  72 */     if (this.__equalsCalc != null) {
/*  73 */       return (this.__equalsCalc == obj);
/*     */     }
/*  75 */     this.__equalsCalc = obj;
/*     */ 
/*  77 */     boolean _equals = ((this.value == null) && (other.getValue() == null)) || ((this.value != null) && (this.value.equals(other.getValue())) && ((((this.paramID == null) && (other.getParamID() == null)) || ((this.paramID != null) && (this.paramID.equals(other.getParamID()))))));
/*     */ 
/*  84 */     this.__equalsCalc = null;
/*  85 */     return _equals;
/*     */   }
/*     */ 
/*     */   public synchronized int hashCode()
/*     */   {
/*  90 */     if (this.__hashCodeCalc) {
/*  91 */       return 0;
/*     */     }
/*  93 */     this.__hashCodeCalc = true;
/*  94 */     int _hashCode = 1;
/*  95 */     if (getValue() != null) {
/*  96 */       _hashCode += getValue().hashCode();
/*     */     }
/*  98 */     if (getParamID() != null) {
/*  99 */       _hashCode += getParamID().hashCode();
/*     */     }
/* 101 */     this.__hashCodeCalc = false;
/* 102 */     return _hashCode;
/*     */   }
/*     */ 
/*     */   public static TypeDesc getTypeDesc()
/*     */   {
/* 128 */     return typeDesc;
/*     */   }
/*     */ 
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/* 138 */     return new BeanSerializer(_javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/* 150 */     return new BeanDeserializer(_javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/* 110 */     typeDesc.setXmlType(new QName("urn:ebay:apis:eBLBaseComponents", "ErrorParameterType"));
/* 111 */     AttributeDesc attrField = new AttributeDesc();
/* 112 */     attrField.setFieldName("paramID");
/* 113 */     attrField.setXmlName(new QName("", "ParamID"));
/* 114 */     attrField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 115 */     typeDesc.addFieldDesc(attrField);
/* 116 */     ElementDesc elemField = new ElementDesc();
/* 117 */     elemField.setFieldName("value");
/* 118 */     elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "Value"));
/* 119 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 120 */     elemField.setNillable(false);
/* 121 */     typeDesc.addFieldDesc(elemField);
/*     */   }
/*     */ }

/* Location:           /Users/rgrey/Desktop/solaris/
 * Qualified Name:     com.paypal.soap.api.ErrorParameterType
 * JD-Core Version:    0.5.3
 */