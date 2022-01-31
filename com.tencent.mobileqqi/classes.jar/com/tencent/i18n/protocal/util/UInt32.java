package com.tencent.i18n.protocal.util;

import java.nio.ByteOrder;

public class UInt32
  extends Number
  implements Comparable
{
  public static final int LENGTH = 4;
  public static final long MAX_VALUE = 4294967295L;
  public static final long MIN_VALUE = 0L;
  public static final int SIZE = 32;
  private static final long serialVersionUID = -8651879679006231785L;
  private final long value;
  
  public UInt32(long paramLong)
  {
    if ((paramLong < 0L) || (paramLong > 4294967295L)) {
      throw new NumberFormatException("Value out of range for UInt32: \"" + paramLong + "\"");
    }
    this.value = paramLong;
  }
  
  public UInt32(String paramString)
  {
    this(Long.parseLong(paramString));
  }
  
  private static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public static byte[] getBytes(long paramLong)
  {
    if ((paramLong < 0L) || (paramLong > 4294967295L)) {
      throw new NumberFormatException("Value out of range for UInt32: \"" + paramLong + "\"");
    }
    return BytesUtil.a((int)paramLong);
  }
  
  public byte byteValue()
  {
    return (byte)(int)this.value;
  }
  
  public int compareTo(UInt32 paramUInt32)
  {
    return a(this.value, paramUInt32.value);
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof UInt32)) && (((UInt32)paramObject).value == this.value);
  }
  
  public float floatValue()
  {
    return (float)this.value;
  }
  
  public byte[] getBigEndianBytes()
  {
    return BytesUtil.a((int)this.value);
  }
  
  public byte[] getBytes()
  {
    return getBigEndianBytes();
  }
  
  public byte[] getBytes(ByteOrder paramByteOrder)
  {
    if (paramByteOrder.equals(ByteOrder.LITTLE_ENDIAN)) {
      return getLittleEndianBytes();
    }
    return getBigEndianBytes();
  }
  
  public byte[] getLittleEndianBytes()
  {
    return BytesUtil.a(Integer.reverseBytes((int)this.value));
  }
  
  public int hashCode()
  {
    return (int)(this.value ^ this.value >>> 32);
  }
  
  public int intValue()
  {
    return (int)this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public short shortValue()
  {
    return (short)(int)this.value;
  }
  
  public String toString()
  {
    return Long.toString(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.protocal.util.UInt32
 * JD-Core Version:    0.7.0.1
 */