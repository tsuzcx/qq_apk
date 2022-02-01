package com.tencent.token;

import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import oicq.wlogin_sdk.tools.MD5;

public final class aaw
{
  public static aas a()
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
    return new aas(arrayOfByte);
  }
  
  public static String a(aas paramaas1, aas paramaas2)
  {
    if (paramaas1 != null)
    {
      if (paramaas2 == null) {
        return null;
      }
      aas localaas = new aas("2");
      try
      {
        paramaas1 = localaas.a(paramaas1, paramaas2);
        return paramaas1.a().toUpperCase();
      }
      catch (Exception paramaas1)
      {
        paramaas1.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static byte[] a(aas paramaas1, aas paramaas2, aas paramaas3)
  {
    paramaas1 = b(paramaas1, paramaas2, paramaas3);
    if (paramaas1 == null) {
      return null;
    }
    return MD5.toMD5Byte(sr.a(paramaas1.a()));
  }
  
  public static aas b(aas paramaas1, aas paramaas2, aas paramaas3)
  {
    if ((paramaas1 != null) && (paramaas2 != null))
    {
      if (paramaas3 == null) {
        return null;
      }
      try
      {
        paramaas1 = paramaas2.a(paramaas1, paramaas3);
        return paramaas1;
      }
      catch (Exception paramaas1)
      {
        paramaas1.printStackTrace();
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aaw
 * JD-Core Version:    0.7.0.1
 */