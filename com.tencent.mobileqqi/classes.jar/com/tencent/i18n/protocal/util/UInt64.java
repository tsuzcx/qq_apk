package com.tencent.i18n.protocal.util;

import java.math.BigInteger;
import java.nio.ByteOrder;
import java.util.Arrays;

public class UInt64
  extends Number
  implements Comparable
{
  public static final int LENGTH = 8;
  public static final BigInteger MAX_VALUE;
  public static final BigInteger MIN_VALUE = BigInteger.ZERO;
  public static final int SIZE = 64;
  private static final long serialVersionUID = 7987516191009019528L;
  private final BigInteger value;
  
  static
  {
    byte[] arrayOfByte = new byte[8];
    Arrays.fill(arrayOfByte, (byte)-1);
    MAX_VALUE = new BigInteger(1, arrayOfByte);
  }
  
  public UInt64(String paramString)
  {
    this(new BigInteger(paramString));
  }
  
  public UInt64(BigInteger paramBigInteger)
  {
    if (((paramBigInteger.min(MIN_VALUE).equals(paramBigInteger)) && (!paramBigInteger.equals(MIN_VALUE))) || ((paramBigInteger.max(MAX_VALUE).equals(paramBigInteger)) && (!paramBigInteger.equals(MAX_VALUE)))) {
      throw new NumberFormatException("Value out of range for UInt64: \"" + paramBigInteger + "\"");
    }
    this.value = paramBigInteger;
  }
  
  private static int a(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    if (paramBigInteger1.equals(paramBigInteger2)) {
      return 0;
    }
    if (paramBigInteger1.min(paramBigInteger2).equals(paramBigInteger1)) {
      return -1;
    }
    return 1;
  }
  
  public static byte[] getBytes(BigInteger paramBigInteger)
  {
    if (((paramBigInteger.min(MIN_VALUE).equals(paramBigInteger)) && (!paramBigInteger.equals(MIN_VALUE))) || ((paramBigInteger.max(MAX_VALUE).equals(paramBigInteger)) && (!paramBigInteger.equals(MAX_VALUE)))) {
      throw new NumberFormatException("Value out of range for UInt64: \"" + paramBigInteger + "\"");
    }
    return BytesUtil.a(paramBigInteger.longValue());
  }
  
  public BigInteger bigIntegerValue()
  {
    return this.value;
  }
  
  public byte byteValue()
  {
    return this.value.byteValue();
  }
  
  public int compareTo(UInt64 paramUInt64)
  {
    return a(this.value, paramUInt64.value);
  }
  
  public double doubleValue()
  {
    return this.value.doubleValue();
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof UInt64)) && (((UInt64)paramObject).value == this.value);
  }
  
  public float floatValue()
  {
    return this.value.floatValue();
  }
  
  public byte[] getBigEndianBytes()
  {
    return BytesUtil.a(this.value.longValue());
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
    return BytesUtil.a(Long.reverseBytes(this.value.longValue()));
  }
  
  public int hashCode()
  {
    return this.value.hashCode();
  }
  
  public int intValue()
  {
    return this.value.intValue();
  }
  
  public long longValue()
  {
    return this.value.longValue();
  }
  
  public short shortValue()
  {
    return this.value.shortValue();
  }
  
  public String toString()
  {
    return this.value.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.protocal.util.UInt64
 * JD-Core Version:    0.7.0.1
 */