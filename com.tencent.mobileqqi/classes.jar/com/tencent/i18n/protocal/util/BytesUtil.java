package com.tencent.i18n.protocal.util;

public class BytesUtil
{
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder("0x");
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(Integer.toHexString(k & 0xFF) + " ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)((0xFF00 & paramInt) >> 8);
    int k = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), k, j, i };
  }
  
  public static byte[] a(long paramLong)
  {
    int i = (byte)(int)(0xFF & paramLong);
    int j = (byte)(int)((0xFF00 & paramLong) >> 8);
    int k = (byte)(int)((0xFF0000 & paramLong) >> 16);
    int m = (byte)(int)((0xFF000000 & paramLong) >> 24);
    int n = (byte)(int)((0x0 & paramLong) >> 32);
    int i1 = (byte)(int)((0x0 & paramLong) >> 40);
    int i2 = (byte)(int)((0x0 & paramLong) >> 48);
    return new byte[] { (byte)(int)((0x0 & paramLong) >> 56), i2, i1, n, m, k, j, i };
  }
  
  public static byte[] a(short paramShort)
  {
    int i = (byte)(paramShort & 0xFF);
    return new byte[] { (byte)((0xFF00 & paramShort) >> 8), i };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.protocal.util.BytesUtil
 * JD-Core Version:    0.7.0.1
 */