/*    */ package com.paypal.soap.api;
/*    */ 
/*    */ import java.io.ObjectStreamException;
/*    */ import java.io.Serializable;
/*    */ import java.util.HashMap;
/*    */ import javax.xml.namespace.QName;
/*    */ import org.apache.axis.description.TypeDesc;
/*    */ import org.apache.axis.encoding.Deserializer;
/*    */ import org.apache.axis.encoding.Serializer;
/*    */ import org.apache.axis.encoding.ser.EnumDeserializer;
/*    */ import org.apache.axis.encoding.ser.EnumSerializer;
/*    */ import org.apache.axis.types.Token;
/*    */ 
/*    */ public class SeverityCodeType
/*    */   implements Serializable
/*    */ {
/*    */   private Token _value_;
/* 12 */   private static HashMap _table_ = new HashMap();
/*    */ 
/* 20 */   public static final Token _Warning = new Token("Warning");
/* 21 */   public static final Token _Error = new Token("Error");
/* 22 */   public static final Token _CustomCode = new Token("CustomCode");
/* 23 */   public static final SeverityCodeType Warning = new SeverityCodeType(_Warning);
/* 24 */   public static final SeverityCodeType Error = new SeverityCodeType(_Error);
/* 25 */   public static final SeverityCodeType CustomCode = new SeverityCodeType(_CustomCode);
/*    */ 
/* 63 */   private static TypeDesc typeDesc = new TypeDesc(SeverityCodeType.class);
/*    */ 
/*    */   protected SeverityCodeType(Token value)
/*    */   {
/* 16 */     this._value_ = value;
/* 17 */     _table_.put(this._value_, this);
/*    */   }
/*    */ 
/*    */   public Token getValue()
/*    */   {
/* 26 */     return this._value_; }
/*    */ 
/*    */   public static SeverityCodeType fromValue(Token value) throws IllegalArgumentException {
/* 29 */     SeverityCodeType enumeration = (SeverityCodeType)_table_.get(value);
/*    */ 
/* 31 */     if (enumeration == null) throw new IllegalArgumentException();
/* 32 */     return enumeration;
/*    */   }
/*    */ 
/*    */   public static SeverityCodeType fromString(String value) throws IllegalArgumentException {
/*    */     try {
/* 37 */       return fromValue(new Token(value));
/*    */     } catch (Exception e) {
/* 39 */       throw new IllegalArgumentException(); } }
/*    */ 
/*    */   public boolean equals(Object obj) {
/* 42 */     return (obj == this); } 
/*    */   public int hashCode() { return toString().hashCode(); } 
/*    */   public String toString() { return this._value_.toString(); } 
/*    */   public Object readResolve() throws ObjectStreamException { return fromValue(this._value_);
/*    */   }
/*    */ 
/*    */   public static Serializer getSerializer(String mechType, Class _javaType, QName _xmlType)
/*    */   {
/* 50 */     return new EnumSerializer(_javaType, _xmlType);
/*    */   }
/*    */ 
/*    */   public static Deserializer getDeserializer(String mechType, Class _javaType, QName _xmlType)
/*    */   {
/* 58 */     return new EnumDeserializer(_javaType, _xmlType);
/*    */   }
/*    */ 
/*    */   public static TypeDesc getTypeDesc()
/*    */   {
/* 73 */     return typeDesc;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 67 */     typeDesc.setXmlType(new QName("urn:ebay:apis:eBLBaseComponents", "SeverityCodeType"));
/*    */   }
/*    */ }

/* Location:           /Users/rgrey/Desktop/solaris/
 * Qualified Name:     com.paypal.soap.api.SeverityCodeType
 * JD-Core Version:    0.5.3
 */