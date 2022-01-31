package com.tencent.i18n.protocal.util;

import java.nio.ByteOrder;

public class UInt16
  extends Number
  implements Comparable
{
  public static final int LENGTH = 2;
  public static final int MAX_VALUE = 65535;
  public static final int MIN_VALUE = 0;
  public static final int SIZE = 16;
  private static final long serialVersionUID = 8424310302420205216L;
  private final int value;
  
  public UInt16(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new NumberFormatException("Value out of range for UInt16: \"" + paramInt + "\"");
    }
    this.value = paramInt;
  }
  
  public UInt16(String paramString)
  {
    this(Integer.parseInt(paramString));
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  public static byte[] getBytes(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new NumberFormatException("Value out of range for UInt32: \"" + paramInt + "\"");
    }
    return BytesUtil.a((short)paramInt);
  }
  
  public byte byteValue()
  {
    return (byte)this.value;
  }
  
  public int compareTo(UInt16 paramUInt16)
  {
    return a(this.value, paramUInt16.value);
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof UInt16)) && (((UInt16)paramObject).value == this.value);
  }
  
  public float floatValue()
  {
    return this.value;
  }
  
  public byte[] getBigEndianBytes()
  {
    return BytesUtil.a((short)this.value);
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
    return BytesUtil.a(Short.reverseBytes((short)this.value));
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
    return (short)this.value;
  }
  
  public String toString()
  {
    return Integer.toString(this.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.protocal.util.UInt16
 * JD-Core Version:    0.7.0.1
 */