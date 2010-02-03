/*     */ package com.paypal.soap.api;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Arrays;
/*     */ import javax.xml.namespace.QName;
/*     */ import org.apache.axis.description.ElementDesc;
/*     */ import org.apache.axis.description.TypeDesc;
/*     */ import org.apache.axis.encoding.Deserializer;
/*     */ import org.apache.axis.encoding.Serializer;
/*     */ import org.apache.axis.encoding.ser.BeanDeserializer;
/*     */ import org.apache.axis.encoding.ser.BeanSerializer;
/*     */ import org.apache.axis.types.Token;
/*     */ 
/*     */ public class ErrorType
/*     */   implements Serializable
/*     */ {
/*     */   private String shortMessage;
/*     */   private String longMessage;
/*     */   private Token errorCode;
/*     */   private SeverityCodeType severityCode;
/*     */   private ErrorParameterType[] errorParameters;
/* 181 */   private Object __equalsCalc = null;
/*     */ 
/* 212 */   private boolean __hashCodeCalc = false;
/*     */ 
/* 247 */   private static TypeDesc typeDesc = new TypeDesc(ErrorType.class, true);
/*     */ 
/*     */   public ErrorType()
/*     */   {
/*     */   }
/*     */ 
/*     */   public ErrorType(String shortMessage, String longMessage, Token errorCode, SeverityCodeType severityCode, ErrorParameterType[] errorParameters)
/*     */   {
/*  44 */     this.shortMessage = shortMessage;
/*  45 */     this.longMessage = longMessage;
/*  46 */     this.errorCode = errorCode;
/*  47 */     this.severityCode = severityCode;
/*  48 */     this.errorParameters = errorParameters;
/*     */   }
/*     */ 
/*     */   public String getShortMessage()
/*     */   {
/*  58 */     return this.shortMessage;
/*     */   }
/*     */ 
/*     */   public void setShortMessage(String shortMessage)
/*     */   {
/*  68 */     this.shortMessage = shortMessage;
/*     */   }
/*     */ 
/*     */   public String getLongMessage()
/*     */   {
/*  78 */     return this.longMessage;
/*     */   }
/*     */ 
/*     */   public void setLongMessage(String longMessage)
/*     */   {
/*  88 */     this.longMessage = longMessage;
/*     */   }
/*     */ 
/*     */   public Token getErrorCode()
/*     */   {
/* 101 */     return this.errorCode;
/*     */   }
/*     */ 
/*     */   public void setErrorCode(Token errorCode)
/*     */   {
/* 114 */     this.errorCode = errorCode;
/*     */   }
/*     */ 
/*     */   public SeverityCodeType getSeverityCode()
/*     */   {
/* 126 */     return this.severityCode;
/*     */   }
/*     */ 
/*     */   public void setSeverityCode(SeverityCodeType severityCode)
/*     */   {
/* 138 */     this.severityCode = severityCode;
/*     */   }
/*     */ 
/*     */   public ErrorParameterType[] getErrorParameters()
/*     */   {
/* 154 */     return this.errorParameters;
/*     */   }
/*     */ 
/*     */   public void setErrorParameters(ErrorParameterType[] errorParameters)
/*     */   {
/* 170 */     this.errorParameters = errorParameters;
/*     */   }
/*     */ 
/*     */   public ErrorParameterType getErrorParameters(int i) {
/* 174 */     return this.errorParameters[i];
/*     */   }
/*     */ 
/*     */   public void setErrorParameters(int i, ErrorParameterType _value) {
/* 178 */     this.errorParameters[i] = _value;
/*     */   }
/*     */ 
/*     */   public synchronized boolean equals(Object obj)
/*     */   {
/* 183 */     if (!(obj instanceof ErrorType)) return false;
/* 184 */     ErrorType other = (ErrorType)obj;
/* 185 */     if (obj == null) return false;
/* 186 */     if (this == obj) return true;
/* 187 */     if (this.__equalsCalc != null) {
/* 188 */       return (this.__equalsCalc == obj);
/*     */     }
/* 190 */     this.__equalsCalc = obj;
/*     */ 
/* 192 */     boolean _equals = ((this.shortMessage == null) && (other.getShortMessage() == null)) || ((this.shortMessage != null) && (this.shortMessage.equals(other.getShortMessage())) && ((((this.longMessage == null) && (other.getLongMessage() == null)) || ((this.longMessage != null) && (this.longMessage.equals(other.getLongMessage())) && ((((this.errorCode == null) && (other.getErrorCode() == null)) || ((this.errorCode != null) && (this.errorCode.equals(other.getErrorCode())) && ((((this.severityCode == null) && (other.getSeverityCode() == null)) || ((this.severityCode != null) && (this.severityCode.equals(other.getSeverityCode())) && ((((this.errorParameters == null) && (other.getErrorParameters() == null)) || ((this.errorParameters != null) && (Arrays.equals(this.errorParameters, other.getErrorParameters())))))))))))))));
/*     */ 
/* 208 */     this.__equalsCalc = null;
/* 209 */     return _equals;
/*     */   }
/*     */ 
/*     */   public synchronized int hashCode()
/*     */   {
/* 214 */     if (this.__hashCodeCalc) {
/* 215 */       return 0;
/*     */     }
/* 217 */     this.__hashCodeCalc = true;
/* 218 */     int _hashCode = 1;
/* 219 */     if (getShortMessage() != null) {
/* 220 */       _hashCode += getShortMessage().hashCode();
/*     */     }
/* 222 */     if (getLongMessage() != null) {
/* 223 */       _hashCode += getLongMessage().hashCode();
/*     */     }
/* 225 */     if (getErrorCode() != null) {
/* 226 */       _hashCode += getErrorCode().hashCode();
/*     */     }
/* 228 */     if (getSeverityCode() != null) {
/* 229 */       _hashCode += getSeverityCode().hashCode();
/*     */     }
/* 231 */     if (getErrorParameters() != null) {
/* 232 */       int i = 0;
/* 233 */       while (i < Array.getLength(getErrorParameters()))
/*     */       {
/* 235 */         Object obj = Array.get(getErrorParameters(), i);
/* 236 */         if ((obj != null) && (!(obj.getClass().isArray())))
/*     */         {
/* 238 */           _hashCode += obj.hashCode();
/*     */         }
/* 234 */         ++i;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 242 */     this.__hashCodeCalc = false;
/* 243 */     return _hashCode;
/*     */   }
/*     */ 
/*     */   public static TypeDesc getTypeDesc()
/*     */   {
/* 291 */     return typeDesc;
/*     */   }
/*     */ 
/*     */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/* 301 */     return new BeanSerializer(_javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/*     */   {
/* 313 */     return new BeanDeserializer(_javaType, _xmlType, typeDesc);
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/* 251 */     typeDesc.setXmlType(new QName("urn:ebay:apis:eBLBaseComponents", "ErrorType"));
/* 252 */     ElementDesc elemField = new ElementDesc();
/* 253 */     elemField.setFieldName("shortMessage");
/* 254 */     elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "ShortMessage"));
/* 255 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 256 */     elemField.setNillable(false);
/* 257 */     typeDesc.addFieldDesc(elemField);
/* 258 */     elemField = new ElementDesc();
/* 259 */     elemField.setFieldName("longMessage");
/* 260 */     elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "LongMessage"));
/* 261 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
/* 262 */     elemField.setMinOccurs(0);
/* 263 */     elemField.setNillable(false);
/* 264 */     typeDesc.addFieldDesc(elemField);
/* 265 */     elemField = new ElementDesc();
/* 266 */     elemField.setFieldName("errorCode");
/* 267 */     elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "ErrorCode"));
/* 268 */     elemField.setXmlType(new QName("http://www.w3.org/2001/XMLSchema", "token"));
/* 269 */     elemField.setNillable(false);
/* 270 */     typeDesc.addFieldDesc(elemField);
/* 271 */     elemField = new ElementDesc();
/* 272 */     elemField.setFieldName("severityCode");
/* 273 */     elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "SeverityCode"));
/* 274 */     elemField.setXmlType(new QName("urn:ebay:apis:eBLBaseComponents", "SeverityCodeType"));
/* 275 */     elemField.setNillable(false);
/* 276 */     typeDesc.addFieldDesc(elemField);
/* 277 */     elemField = new ElementDesc();
/* 278 */     elemField.setFieldName("errorParameters");
/* 279 */     elemField.setXmlName(new QName("urn:ebay:apis:eBLBaseComponents", "ErrorParameters"));
/* 280 */     elemField.setXmlType(new QName("urn:ebay:apis:eBLBaseComponents", "ErrorParameterType"));
/* 281 */     elemField.setMinOccurs(0);
/* 282 */     elemField.setNillable(false);
/* 283 */     elemField.setMaxOccursUnbounded(true);
/* 284 */     typeDesc.addFieldDesc(elemField);
/*     */   }
/*     */ }

/* Location:           /Users/rgrey/Work/nec/tmp/paypal/paypal_nvp_java_sdk/lib/solaris/
 * Qualified Name:     com.paypal.soap.api.ErrorType
 * JD-Core Version:    0.5.3
 */