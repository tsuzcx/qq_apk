package com.tmsdk.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import tmsdk.common.tcc.b;

public class MD5Util
{
  private static final char[] L = "0123456789abcdef".toCharArray();
  
  public static String Dec_HexString(String paramString)
  {
    int j = 0;
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    paramString = paramString.toUpperCase().toCharArray();
    int k = 0;
    int m = 0;
    if (j < paramString.length)
    {
      int n;
      if (paramString[j] > '@')
      {
        n = paramString[j] - '7';
        label47:
        if (j % 2 != 0) {
          break label78;
        }
      }
      label78:
      int i;
      for (m = (byte)(n << 4);; m = i)
      {
        j += 1;
        break;
        n = paramString[j] - '0';
        break label47;
        i = (byte)(m + (n & 0xF));
        arrayOfByte[k] = i;
        k += 1;
      }
    }
    return new String(b.decrypt(arrayOfByte, null), Charset.forName("UTF-8"));
  }
  
  public static byte[] encrypt(String paramString)
  {
    return encrypt(paramString.getBytes());
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static String encrypt_bytes(byte[] paramArrayOfByte)
  {
    return encrypt_string(encrypt(paramArrayOfByte));
  }
  
  public static String encrypt_string(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 3);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      localStringBuilder.append(L[(k >> 4)]);
      localStringBuilder.append(L[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString().toUpperCase();
  }
  
  public static String encyptToSubHexString(String paramString)
  {
    paramString = encrypt(paramString);
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length * 2);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(Integer.toHexString(paramString[i] & 0xFF).substring(0, 1));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String getFileMD5(File paramFile)
  {
    try
    {
      paramFile = new FileInputStream(paramFile);
      return getStreamMD5(paramFile);
    }
    catch (FileNotFoundException paramFile) {}
    return null;
  }
  
  public static String getStreamMD5(InputStream paramInputStream)
  {
    MessageDigest localMessageDigest = null;
    String str2 = null;
    if (paramInputStream == null) {}
    for (;;)
    {
      return str2;
      if (paramInputStream != null) {}
      try
      {
        localMessageDigest = MessageDigest.getInstance("MD5");
        byte[] arrayOfByte = new byte[8192];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localMessageDigest.update(arrayOfByte, 0, i);
        }
      }
      catch (Exception localException)
      {
        if (paramInputStream != null)
        {
          try
          {
            paramInputStream.close();
            return null;
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
            return null;
          }
          String str1 = encrypt_string(localException.digest());
          str2 = str1;
          if (paramInputStream != null) {
            try
            {
              paramInputStream.close();
              return str1;
            }
            catch (IOException paramInputStream)
            {
              paramInputStream.printStackTrace();
              return str1;
            }
          }
        }
      }
      finally
      {
        if (paramInputStream == null) {}
      }
    }
    try
    {
      paramInputStream.close();
      throw localObject;
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  public static byte[] intToByteArray(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.utils.MD5Util
 * JD-Core Version:    0.7.0.1
 */