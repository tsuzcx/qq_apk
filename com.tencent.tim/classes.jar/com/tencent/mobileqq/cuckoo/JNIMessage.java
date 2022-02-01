package com.tencent.mobileqq.cuckoo;

public class JNIMessage
{
  private boolean booleanValue;
  private byte byteValue;
  private char charValue;
  private double doubleValue;
  private float floatValue;
  private int intValue;
  private long longValue;
  private Object objectValue;
  private short shortValue;
  private String type;
  
  public JNIMessage(String paramString, byte paramByte)
  {
    this.type = paramString;
    this.byteValue = paramByte;
  }
  
  public JNIMessage(String paramString, char paramChar)
  {
    this.type = paramString;
    this.charValue = paramChar;
  }
  
  public JNIMessage(String paramString, double paramDouble)
  {
    this.type = paramString;
    this.doubleValue = paramDouble;
  }
  
  public JNIMessage(String paramString, float paramFloat)
  {
    this.type = paramString;
    this.floatValue = paramFloat;
  }
  
  public JNIMessage(String paramString, int paramInt)
  {
    this.type = paramString;
    this.intValue = paramInt;
  }
  
  public JNIMessage(String paramString, long paramLong)
  {
    this.type = paramString;
    this.longValue = paramLong;
  }
  
  public JNIMessage(String paramString, Object paramObject)
  {
    this.type = paramString;
    this.objectValue = paramObject;
  }
  
  public JNIMessage(String paramString, short paramShort)
  {
    this.type = paramString;
    this.shortValue = paramShort;
  }
  
  public JNIMessage(String paramString, boolean paramBoolean)
  {
    this.type = paramString;
    this.booleanValue = paramBoolean;
  }
  
  public Object getMessage()
  {
    if ("I".equals(this.type)) {
      return new Integer(this.intValue);
    }
    if ("B".equals(this.type)) {
      return new Byte(this.byteValue);
    }
    if ("Z".equals(this.type)) {
      return new Boolean(this.booleanValue);
    }
    if ("C".equals(this.type)) {
      return new String(String.valueOf(this.charValue));
    }
    if ("S".equals(this.type)) {
      return new Short(this.shortValue);
    }
    if ("J".equals(this.type)) {
      return new Long(this.longValue);
    }
    if ("F".equals(this.type)) {
      return new Float(this.floatValue);
    }
    if ("D".equals(this.type)) {
      return new Double(this.doubleValue);
    }
    return this.objectValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.cuckoo.JNIMessage
 * JD-Core Version:    0.7.0.1
 */