package com.tencent.moai.proxycat.util;

import android.annotation.SuppressLint;
import java.net.InetAddress;

public class ByteUtils
{
  public static int readInt(byte[] paramArrayOfByte, int paramInt)
  {
    return 0xFF000000 & paramArrayOfByte[paramInt] << 24 | 0xFF0000 & paramArrayOfByte[(paramInt + 1)] << 16 | 0xFF00 & paramArrayOfByte[(paramInt + 2)] << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  public static int readShort(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] << 8 & 0xFF00 | paramArrayOfByte[(paramInt + 1)] & 0xFF;
  }
  
  public static int toInteger(InetAddress paramInetAddress)
  {
    return readInt(paramInetAddress.getAddress(), 0);
  }
  
  @SuppressLint({"DefaultLocale"})
  public static String toString(int paramInt)
  {
    return String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(paramInt >> 24 & 0xFF), Integer.valueOf(paramInt >> 16 & 0xFF), Integer.valueOf(paramInt >> 8 & 0xFF), Integer.valueOf(paramInt & 0xFF) });
  }
  
  public static void writeInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 24 & 0xFF));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16 & 0xFF));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 & 0xFF));
  }
  
  public static void writeShort(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 8 & 0xFF));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 & 0xFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.util.ByteUtils
 * JD-Core Version:    0.7.0.1
 */