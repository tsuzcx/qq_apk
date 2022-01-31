package com.tencent.i18n.protocal.util;

public class UInt8
  extends Number
  implements Comparable
{
  public static final int LENGTH = 1;
  public static final short MAX_VALUE = 255;
  public static final short MIN_VALUE = 0;
  public static final int SIZE = 8;
  private static final long serialVersionUID = -5557903487371364797L;
  private final short value;
  
  public UInt8(String paramString)
  {
    this(Short.parseShort(paramString));
  }
  
  public UInt8(short paramShort)
  {
    if ((paramShort < 0) || (paramShort > 255)) {
      throw new NumberFormatException("Value out of range for UInt8: \"" + paramShort + "\"");
    }
    this.value = paramShort;
  }
  
  private static int a(short paramShort1, short paramShort2)
  {
    if (paramShort1 < paramShort2) {
      return -1;
    }
    if (paramShort1 == paramShort2) {
      return 0;
    }
    return 1;
  }
  
  public static byte getByte(short paramShort)
  {
    if ((paramShort < 0) || (paramShort > 255)) {
      throw new NumberFormatException("Value out of range for UInt32: \"" + paramShort + "\"");
    }
    return (byte)paramShort;
  }
  
  public byte byteValue()
  {
    return (byte)this.value;
  }
  
  public int compareTo(UInt8 paramUInt8)
  {
    return a(this.value, paramUInt8.value);
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof UInt8)) && (((UInt8)paramObject).value == this.value);
  }
  
  public float floatValue()
  {
    return this.value;
  }
  
  public byte getByte()
  {
    return byteValue();
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public short shortValue()
  {
    return this.value;
  }
  
  public String toString()
  {
    return Short.toString(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.protocal.util.UInt8
 * JD-Core Version:    0.7.0.1
 */