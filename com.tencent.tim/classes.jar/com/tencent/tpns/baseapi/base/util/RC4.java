package com.tencent.tpns.baseapi.base.util;

import android.os.Build.VERSION;
import android.util.Base64;

public class RC4
{
  static byte[] a()
  {
    return Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0);
  }
  
  static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int m = 0;
    int[] arrayOfInt1 = new int[256];
    int[] arrayOfInt2 = new int[256];
    int j = paramArrayOfByte2.length;
    if ((j < 1) || (j > 256)) {
      throw new IllegalArgumentException("key must be between 1 and 256 bytes");
    }
    int i = 0;
    while (i < 256)
    {
      arrayOfInt1[i] = i;
      arrayOfInt2[i] = paramArrayOfByte2[(i % j)];
      i += 1;
    }
    i = 0;
    j = 0;
    while (i < 256)
    {
      j = j + arrayOfInt1[i] + arrayOfInt2[i] & 0xFF;
      k = arrayOfInt1[i];
      arrayOfInt1[i] = arrayOfInt1[j];
      arrayOfInt1[j] = k;
      i += 1;
    }
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length];
    j = 0;
    int k = 0;
    i = m;
    while (i < paramArrayOfByte1.length)
    {
      k = k + 1 & 0xFF;
      j = j + arrayOfInt1[k] & 0xFF;
      m = arrayOfInt1[k];
      arrayOfInt1[k] = arrayOfInt1[j];
      arrayOfInt1[j] = m;
      paramArrayOfByte2[i] = ((byte)(arrayOfInt1[(arrayOfInt1[k] + arrayOfInt1[j] & 0xFF)] ^ paramArrayOfByte1[i]));
      i += 1;
    }
    return paramArrayOfByte2;
  }
  
  public static String decode(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (Build.VERSION.SDK_INT < 8);
    try
    {
      str = new String(decrypt(Base64.decode(paramString.getBytes("UTF-8"), 0)), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("RC4", "decode error", localThrowable);
    }
    return paramString;
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte)
  {
    return decrypt(paramArrayOfByte, a());
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static String encode(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (Build.VERSION.SDK_INT < 8);
    try
    {
      str = new String(Base64.encode(encrypt(paramString.getBytes("UTF-8")), 0), "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("RC4", "encode error", localThrowable);
    }
    return paramString;
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.RC4
 * JD-Core Version:    0.7.0.1
 */