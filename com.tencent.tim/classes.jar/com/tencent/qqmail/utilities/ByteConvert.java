package com.tencent.qqmail.utilities;

public class ByteConvert
{
  public static int bytesToInt(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  public static int bytesToInt(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[paramInt] & 0xFF) << 24;
  }
  
  public static int bytesToIntLE(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24;
  }
  
  public static long bytesToLong(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 56 | (paramArrayOfByte[1] & 0xFF) << 48 | (paramArrayOfByte[2] & 0xFF) << 40 | (paramArrayOfByte[3] & 0xFF) << 32 | (paramArrayOfByte[4] & 0xFF) << 24 | (paramArrayOfByte[5] & 0xFF) << 16 | (paramArrayOfByte[6] & 0xFF) << 8 | (paramArrayOfByte[7] & 0xFF) << 0;
  }
  
  public static long bytesToLong(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 0)] & 0xFF) << 56 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 48 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 40 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 32 | (paramArrayOfByte[(paramInt + 4)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 5)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 6)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 7)] & 0xFF) << 0;
  }
  
  public static short bytesToShort(byte[] paramArrayOfByte)
  {
    return (short)(paramArrayOfByte[1] & 0xFF | (paramArrayOfByte[0] & 0xFF) << 8);
  }
  
  public static short bytesToShort(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(paramArrayOfByte[(paramInt + 1)] & 0xFF | (paramArrayOfByte[paramInt] & 0xFF) << 8);
  }
  
  public static int bytesToUbyte(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF;
  }
  
  public static int bytesToUbyte(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public static long bytesToUint(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[3] & 0xFF | (paramArrayOfByte[2] & 0xFF) << 8 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[0] & 0xFF) << 24;
  }
  
  public static long bytesToUint(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[paramInt] & 0xFF) << 24;
  }
  
  public static int bytesToUshort(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[1] & 0xFF | (paramArrayOfByte[0] & 0xFF) << 8;
  }
  
  public static int bytesToUshort(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 1)] & 0xFF | (paramArrayOfByte[paramInt] & 0xFF) << 8;
  }
  
  public static void intToBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 16 & 0xFF));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 24 & 0xFF));
  }
  
  public static byte[] intToBytes(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >>> 8 & 0xFF);
    int k = (byte)(paramInt >>> 16 & 0xFF);
    return new byte[] { (byte)(paramInt >>> 24 & 0xFF), k, j, i };
  }
  
  public static byte[] intToBytesLE(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 24 & 0xFF) };
  }
  
  public static void longToBytes(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)(paramLong & 0xFF));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >> 16 & 0xFF));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >> 24 & 0xFF));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 32 & 0xFF));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 40 & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 48 & 0xFF));
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong >> 56 & 0xFF));
  }
  
  public static byte[] longToBytes(long paramLong)
  {
    int i = (byte)(int)(paramLong & 0xFF);
    int j = (byte)(int)(paramLong >> 8 & 0xFF);
    int k = (byte)(int)(paramLong >> 16 & 0xFF);
    int m = (byte)(int)(paramLong >> 24 & 0xFF);
    int n = (byte)(int)(paramLong >> 32 & 0xFF);
    int i1 = (byte)(int)(paramLong >> 40 & 0xFF);
    int i2 = (byte)(int)(paramLong >> 48 & 0xFF);
    return new byte[] { (byte)(int)(paramLong >> 56 & 0xFF), i2, i1, n, m, k, j, i };
  }
  
  public static void shortToBytes(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramShort & 0xFF));
    paramArrayOfByte[paramInt] = ((byte)(paramShort >> 8 & 0xFF));
  }
  
  public static byte[] shortToBytes(short paramShort)
  {
    int i = (byte)(paramShort & 0xFF);
    return new byte[] { (byte)(paramShort >> 8 & 0xFF), i };
  }
  
  public static void ubyteToBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[0] = ((byte)(paramInt1 & 0xFF));
  }
  
  public static byte[] ubyteToBytes(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF) };
  }
  
  public static void uintToBytes(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8 & 0xFF));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16 & 0xFF));
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24 & 0xFF));
  }
  
  public static byte[] uintToBytes(long paramLong)
  {
    int i = (byte)(int)(paramLong & 0xFF);
    int j = (byte)(int)(paramLong >> 8 & 0xFF);
    int k = (byte)(int)(paramLong >> 16 & 0xFF);
    return new byte[] { (byte)(int)(paramLong >> 24 & 0xFF), k, j, i };
  }
  
  public static void ushortToBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >> 8 & 0xFF));
  }
  
  public static byte[] ushortToBytes(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    return new byte[] { (byte)(paramInt >> 8 & 0xFF), i };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ByteConvert
 * JD-Core Version:    0.7.0.1
 */