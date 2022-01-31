package com.tmsdk.base.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConvertUtil
{
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static final String bytesToHexString(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str.toUpperCase());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static int bytesToInt(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    while (paramArrayOfByte.length != 4) {
      return 0;
    }
    return paramArrayOfByte[0] & 0xFF | (paramArrayOfByte[1] & 0xFF) << 8 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[3] & 0xFF) << 24;
  }
  
  public static final String bytesToString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append((char)paramArrayOfByte[i]);
      i += 1;
    }
    return localStringBuffer.toString().toUpperCase();
  }
  
  public static byte[] hexStringToByte(String paramString)
  {
    int i = 0;
    if ((paramString == null) || (paramString.trim().length() <= 0))
    {
      paramString = new byte[0];
      return paramString;
    }
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    char[] arrayOfChar = paramString.toCharArray();
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = a(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(a(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  public static byte[] inputStreamToBytes(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      try
      {
        localIOException2.close();
        throw paramInputStream;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    catch (IOException paramInputStream)
    {
      paramInputStream = paramInputStream;
      paramInputStream.printStackTrace();
      paramInputStream = new byte[0];
      try
      {
        localByteArrayOutputStream.close();
        return paramInputStream;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return paramInputStream;
      }
      paramInputStream = localIOException1.toByteArray();
      try
      {
        localIOException1.close();
        return paramInputStream;
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
        return paramInputStream;
      }
    }
    finally {}
  }
  
  public static byte[] intToBytes(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 24 & 0xFF) };
  }
  
  public static byte stringToByte(String paramString)
  {
    byte b2 = -1;
    byte b1 = b2;
    if (paramString != null) {
      b1 = b2;
    }
    try
    {
      if (paramString.trim().length() > 0) {
        b1 = Byte.valueOf(paramString).byteValue();
      }
      return b1;
    }
    catch (Throwable paramString) {}
    return -1;
  }
  
  public static byte[] stringToBytes(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length()];
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length())
    {
      arrayOfByte[i] = ((byte)arrayOfChar[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int stringToInt(String paramString)
  {
    int j = -1;
    int i = j;
    if (paramString != null) {
      i = j;
    }
    try
    {
      if (paramString.trim().length() > 0) {
        i = Integer.valueOf(paramString).intValue();
      }
      return i;
    }
    catch (Throwable paramString) {}
    return -1;
  }
  
  public static long stringToLong(String paramString)
  {
    long l2 = -1L;
    long l1 = l2;
    if (paramString != null) {
      l1 = l2;
    }
    try
    {
      if (paramString.trim().length() > 0) {
        l1 = Long.valueOf(paramString).longValue();
      }
      return l1;
    }
    catch (Exception paramString) {}
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.ConvertUtil
 * JD-Core Version:    0.7.0.1
 */