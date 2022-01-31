package com.dataline.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DatalineMathUtil
{
  private static String a = "9u23fh$jkf^%43hj";
  private static String b = "1234567890123456";
  
  public static int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j = j << 8 | paramArrayOfByte[i];
      i += 1;
    }
    return j;
  }
  
  public static long a()
  {
    WifiManager localWifiManager = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
    if (!localWifiManager.isWifiEnabled()) {
      return 0L;
    }
    return localWifiManager.getConnectionInfo().getIpAddress();
  }
  
  public static String a(long paramLong)
  {
    if (paramLong > 4294967295L) {
      throw new IllegalArgumentException("invalid ip");
    }
    long l = paramLong;
    if (paramLong < 0L)
    {
      paramLong += 4294967296L;
      l = paramLong;
      if (paramLong < 0L) {
        throw new IllegalArgumentException("invalid ip");
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i <= 3)
    {
      int j = i * 8;
      localStringBuilder.append((255 << j & l) >> j);
      if (i < 3) {
        localStringBuilder.append(".");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[18];
    System.arraycopy(a((short)1), 0, arrayOfByte, 0, 2);
    System.arraycopy(b(paramLong), 0, arrayOfByte, 2, 8);
    System.arraycopy(a((int)537035245L), 0, arrayOfByte, 10, 4);
    System.arraycopy(a(a()), 0, arrayOfByte, 14, 4);
    return Base64Util.a(new Cryptor().encrypt(arrayOfByte, paramArrayOfByte), 2);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int k;
    int j;
    if (i < paramArrayOfByte.length)
    {
      k = paramArrayOfByte[i] >>> 4 & 0xF;
      j = 0;
    }
    for (;;)
    {
      if ((k >= 0) && (k <= 9)) {
        localStringBuffer.append((char)(k + 48));
      }
      for (;;)
      {
        k = paramArrayOfByte[i];
        if (j < 1) {
          break label94;
        }
        i += 1;
        break;
        localStringBuffer.append((char)(k - 10 + 97));
      }
      return localStringBuffer.toString();
      label94:
      j += 1;
      k &= 0xF;
    }
  }
  
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 4)
    {
      arrayOfByte[paramInt] = Integer.valueOf(i >>> 24).byteValue();
      i <<= 8;
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfByte[i] = Long.valueOf(paramLong >>> 24).byteValue();
      paramLong <<= 8;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong1, long paramLong2, byte paramByte)
  {
    byte[] arrayOfByte = new byte[29];
    System.arraycopy(b.getBytes(), 0, arrayOfByte, 0, 16);
    System.arraycopy(a((int)paramLong1), 0, arrayOfByte, 16, 4);
    System.arraycopy(b(paramLong2), 0, arrayOfByte, 20, 8);
    arrayOfByte[28] = paramByte;
    return new Cryptor().encrypt(arrayOfByte, a.getBytes());
  }
  
  public static byte[] a(String paramString)
  {
    l1 = 10002432L;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      localFileInputStream = new FileInputStream(paramString);
      l2 = new File(paramString).length();
      if (l2 <= 10002432L) {
        break label131;
      }
    }
    catch (NoSuchAlgorithmException paramString)
    {
      MessageDigest localMessageDigest;
      FileInputStream localFileInputStream;
      paramString.printStackTrace();
      return null;
      localFileInputStream.close();
      paramString = localMessageDigest.digest();
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        long l2;
        paramString.printStackTrace();
        continue;
        l1 = l2;
      }
    }
    paramString = new byte[1024];
    while (l1 > 0L)
    {
      int j = localFileInputStream.read(paramString);
      if (j == -1) {
        break;
      }
      int i = j;
      if (j > l1) {
        i = (int)l1;
      }
      l1 -= i;
      localMessageDigest.update(paramString, 0, i);
    }
  }
  
  public static byte[] a(short paramShort)
  {
    byte[] arrayOfByte = new byte[2];
    short s = 0;
    int i = paramShort;
    paramShort = s;
    while (paramShort < 2)
    {
      arrayOfByte[paramShort] = Integer.valueOf(i >>> 8).byteValue();
      i = (short)(i << 8);
      paramShort += 1;
    }
    return arrayOfByte;
  }
  
  public static int b(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 24 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[2] & 0xFF) << 8 | paramArrayOfByte[3] & 0xFF;
  }
  
  public static byte[] b(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)((0xFF00 & paramInt) >> 8);
    int k = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), k, j, i };
  }
  
  public static byte[] b(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[i] = Integer.valueOf((int)(paramLong >>> 56)).byteValue();
      paramLong <<= 8;
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.DatalineMathUtil
 * JD-Core Version:    0.7.0.1
 */