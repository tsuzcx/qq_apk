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
    return (paramArrayOfByte[paramInt] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0;
  }
  
  public static long byteArrayHLToLong(byte[] paramArrayOfByte)
  {
    return byteArrayHLToLong(paramArrayOfByte, 0);
  }
  
  public static long byteArrayHLToLong(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] & 0xFF) << 56 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 48 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 40 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 32 | (paramArrayOfByte[(paramInt + 4)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 5)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 6)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 0;
  }
  
  public static int byteArrayLHToInt(byte[] paramArrayOfByte)
  {
    return byteArrayLHToInt(paramArrayOfByte, 0);
  }
  
  public static int byteArrayLHToInt(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[paramInt] & 0xFF) << 0;
  }
  
  public static long byteArrayLHToLong(byte[] paramArrayOfByte)
  {
    return byteArrayLHToLong(paramArrayOfByte, 0);
  }
  
  public static long byteArrayLHToLong(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 56 | (paramArrayOfByte[(paramInt + 6)] & 0xFF) << 48 | (paramArrayOfByte[5] & 0xFF) << 40 | (paramArrayOfByte[(paramInt + 4)] & 0xFF) << 32 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[paramInt] & 0xFF) << 0;
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