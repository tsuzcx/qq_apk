package com.tencent.token;

import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import oicq.wlogin_sdk.tools.MD5;

public final class aax
{
  public static aat a()
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
    return new aat(arrayOfByte);
  }
  
  public static String a(aat paramaat1, aat paramaat2)
  {
    if (paramaat1 != null)
    {
      if (paramaat2 == null) {
        return null;
      }
      aat localaat = new aat("2");
      try
      {
        paramaat1 = localaat.a(paramaat1, paramaat2);
        return paramaat1.a().toUpperCase();
      }
      catch (Exception paramaat1)
      {
        paramaat1.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static byte[] a(aat paramaat1, aat paramaat2, aat paramaat3)
  {
    paramaat1 = b(paramaat1, paramaat2, paramaat3);
    if (paramaat1 == null) {
      return null;
    }
    return MD5.toMD5Byte(ss.a(paramaat1.a()));
  }
  
  public static aat b(aat paramaat1, aat paramaat2, aat paramaat3)
  {
    if ((paramaat1 != null) && (paramaat2 != null))
    {
      if (paramaat3 == null) {
        return null;
      }
      try
      {
        paramaat1 = paramaat2.a(paramaat1, paramaat3);
        return paramaat1;
      }
      catch (Exception paramaat1)
      {
        paramaat1.printStackTrace();
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aax
 * JD-Core Version:    0.7.0.1
 */