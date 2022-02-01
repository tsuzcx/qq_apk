package com.tencent.token;

import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import oicq.wlogin_sdk.tools.MD5;

public final class abi
{
  public static abe a()
  {
    byte[] arrayOfByte = new byte[14];
    String str2 = System.getProperty("microedition.platform");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    int j = Runtime.getRuntime().hashCode();
    try
    {
      PRNGFixes.a();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    SecureRandom localSecureRandom1 = new SecureRandom();
    SecureRandom localSecureRandom2 = new SecureRandom();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(str1);
    localStringBuffer.append(localSecureRandom2.nextInt());
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append(j);
    localStringBuffer.append(new Object().hashCode());
    localSecureRandom1.a(localStringBuffer.toString().getBytes());
    int i = 1;
    while (i < 14)
    {
      arrayOfByte[i] = ((byte)(Math.abs(localSecureRandom1.nextInt()) % 256));
      localSecureRandom2.a(localSecureRandom2.a(i));
      localStringBuffer = new StringBuffer();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append(localSecureRandom2.nextInt());
      localStringBuffer.append(j);
      localStringBuffer.append(new Object().hashCode());
      localStringBuffer.insert(Math.abs(localSecureRandom2.nextInt()) % localStringBuffer.length(), str1);
      localSecureRandom1.a(localStringBuffer.toString().getBytes());
      i += 1;
    }
    arrayOfByte[0] = ((byte)(Math.abs(localSecureRandom1.nextInt()) % 64));
    return new abe(arrayOfByte);
  }
  
  public static String a(abe paramabe1, abe paramabe2)
  {
    if (paramabe1 != null)
    {
      if (paramabe2 == null) {
        return null;
      }
      abe localabe = new abe("2");
      try
      {
        paramabe1 = localabe.a(paramabe1, paramabe2);
        return paramabe1.a().toUpperCase();
      }
      catch (Exception paramabe1)
      {
        paramabe1.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static byte[] a(abe paramabe1, abe paramabe2, abe paramabe3)
  {
    paramabe1 = b(paramabe1, paramabe2, paramabe3);
    if (paramabe1 == null) {
      return null;
    }
    return MD5.toMD5Byte(sz.a(paramabe1.a()));
  }
  
  public static abe b(abe paramabe1, abe paramabe2, abe paramabe3)
  {
    if ((paramabe1 != null) && (paramabe2 != null))
    {
      if (paramabe3 == null) {
        return null;
      }
      try
      {
        paramabe1 = paramabe2.a(paramabe1, paramabe3);
        return paramabe1;
      }
      catch (Exception paramabe1)
      {
        paramabe1.printStackTrace();
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abi
 * JD-Core Version:    0.7.0.1
 */