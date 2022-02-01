package com.tencent.token.utils.encrypt;

import com.tencent.token.ck;
import com.tencent.token.dr;
import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import oicq.wlogin_sdk.tools.MD5;

public class b
{
  public static dr a()
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
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(Math.abs(localSecureRandom1.nextInt()) % 256));
      localSecureRandom2.a(localSecureRandom2.a(i));
      localStringBuffer = new StringBuffer();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append("");
      localStringBuffer.append(localStringBuilder.toString());
      localStringBuffer.append(localSecureRandom2.nextInt());
      localStringBuffer.append(j);
      localStringBuffer.append(new Object().hashCode());
      localStringBuffer.insert(Math.abs(localSecureRandom2.nextInt()) % localStringBuffer.length(), str1);
      localSecureRandom1.a(localStringBuffer.toString().getBytes());
      i += 1;
    }
    arrayOfByte[0] = ((byte)(Math.abs(localSecureRandom1.nextInt()) % 64));
    return new dr(arrayOfByte);
  }
  
  public static String a(dr paramdr1, long paramLong, dr paramdr2)
  {
    if (paramdr1 != null)
    {
      if (paramdr2 == null) {
        return null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("");
      localObject = new dr(((StringBuilder)localObject).toString());
      try
      {
        paramdr1 = ((dr)localObject).a(paramdr1, paramdr2);
        return paramdr1.e().toUpperCase();
      }
      catch (Exception paramdr1)
      {
        paramdr1.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static byte[] a(dr paramdr1, dr paramdr2, dr paramdr3)
  {
    paramdr1 = b(paramdr1, paramdr2, paramdr3);
    if (paramdr1 == null) {
      return null;
    }
    return MD5.toMD5Byte(ck.a(paramdr1.e()));
  }
  
  public static dr b(dr paramdr1, dr paramdr2, dr paramdr3)
  {
    if ((paramdr1 != null) && (paramdr2 != null))
    {
      if (paramdr3 == null) {
        return null;
      }
      try
      {
        paramdr1 = paramdr2.a(paramdr1, paramdr3);
        return paramdr1;
      }
      catch (Exception paramdr1)
      {
        paramdr1.printStackTrace();
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.b
 * JD-Core Version:    0.7.0.1
 */