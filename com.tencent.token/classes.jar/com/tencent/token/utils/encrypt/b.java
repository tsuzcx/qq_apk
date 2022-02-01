package com.tencent.token.utils.encrypt;

import com.tencent.token.cj;
import com.tencent.token.dq;
import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import oicq.wlogin_sdk.tools.MD5;

public class b
{
  public static dq a()
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
    return new dq(arrayOfByte);
  }
  
  public static String a(dq paramdq1, long paramLong, dq paramdq2)
  {
    if (paramdq1 != null)
    {
      if (paramdq2 == null) {
        return null;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("");
      localObject = new dq(((StringBuilder)localObject).toString());
      try
      {
        paramdq1 = ((dq)localObject).a(paramdq1, paramdq2);
        return paramdq1.e().toUpperCase();
      }
      catch (Exception paramdq1)
      {
        paramdq1.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static byte[] a(dq paramdq1, dq paramdq2, dq paramdq3)
  {
    paramdq1 = b(paramdq1, paramdq2, paramdq3);
    if (paramdq1 == null) {
      return null;
    }
    return MD5.toMD5Byte(cj.a(paramdq1.e()));
  }
  
  public static dq b(dq paramdq1, dq paramdq2, dq paramdq3)
  {
    if ((paramdq1 != null) && (paramdq2 != null))
    {
      if (paramdq3 == null) {
        return null;
      }
      try
      {
        paramdq1 = paramdq2.a(paramdq1, paramdq3);
        return paramdq1;
      }
      catch (Exception paramdq1)
      {
        paramdq1.printStackTrace();
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