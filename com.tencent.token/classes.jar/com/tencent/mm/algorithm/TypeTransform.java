package com.tencent.mm.algorithm;

public final class TypeTransform
{
  private static byte[] a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = paramArrayOfByte[(j - 1 - i)];
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int byteArrayHLToInt(byte[] paramArrayOfByte)
  {
    return byteArrayHLToInt(paramArrayOfByte, 0);
  }
  
  public static int byteArrayHLToInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0 | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public static long byteArrayHLToLong(byte[] paramArrayOfByte)
  {
    return byteArrayHLToLong(paramArrayOfByte, 0);
  }
  
  public static long byteArrayHLToLong(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[paramInt];
    long l2 = paramArrayOfByte[(paramInt + 1)];
    long l3 = paramArrayOfByte[(paramInt + 2)];
    long l4 = paramArrayOfByte[(paramInt + 3)];
    long l5 = paramArrayOfByte[(paramInt + 4)];
    long l6 = paramArrayOfByte[(paramInt + 5)];
    long l7 = paramArrayOfByte[(paramInt + 6)];
    return (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 0 | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
  
  public static int byteArrayLHToInt(byte[] paramArrayOfByte)
  {
    return byteArrayLHToInt(paramArrayOfByte, 0);
  }
  
  public static int byteArrayLHToInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 3)];
    int j = paramArrayOfByte[(paramInt + 2)];
    int k = paramArrayOfByte[(paramInt + 1)];
    return (paramArrayOfByte[paramInt] & 0xFF) << 0 | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public static long byteArrayLHToLong(byte[] paramArrayOfByte)
  {
    return byteArrayLHToLong(paramArrayOfByte, 0);
  }
  
  public static long byteArrayLHToLong(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = paramArrayOfByte[(paramInt + 7)];
    long l2 = paramArrayOfByte[(paramInt + 6)];
    long l3 = paramArrayOfByte[5];
    long l4 = paramArrayOfByte[(paramInt + 4)];
    long l5 = paramArrayOfByte[(paramInt + 3)];
    long l6 = paramArrayOfByte[(paramInt + 2)];
    long l7 = paramArrayOfByte[(paramInt + 1)];
    return (paramArrayOfByte[paramInt] & 0xFF) << 0 | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
  
  public static byte[] intToByteArrayHL(int paramInt)
  {
    return a(intToByteArrayLH(paramInt));
  }
  
  public static byte[] intToByteArrayLH(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfByte[i] = ((byte)(paramInt >> i * 8 & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] longToByteArrayHL(long paramLong)
  {
    return a(longToByteArrayLH(paramLong));
  }
  
  public static byte[] longToByteArrayLH(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >> i * 8));
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.algorithm.TypeTransform
 * JD-Core Version:    0.7.0.1
 */