package com.tencent.token;

import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import oicq.wlogin_sdk.tools.MD5;

public final class abs
{
  public static abo a()
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
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(str1);
    ((StringBuffer)localObject).append(localSecureRandom2.nextInt());
    ((StringBuffer)localObject).append(System.currentTimeMillis());
    ((StringBuffer)localObject).append(j);
    ((StringBuffer)localObject).append(new Object().hashCode());
    localSecureRandom1.a(((StringBuffer)localObject).toString().getBytes());
    int i = 1;
    while (i < 14)
    {
      arrayOfByte[i] = ((byte)(Math.abs(localSecureRandom1.nextInt()) % 256));
      localObject = new byte[i];
      localSecureRandom2.nextBytes((byte[])localObject);
      localSecureRandom2.a((byte[])localObject);
      localObject = new StringBuffer();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      ((StringBuffer)localObject).append(localStringBuilder.toString());
      ((StringBuffer)localObject).append(localSecureRandom2.nextInt());
      ((StringBuffer)localObject).append(j);
      ((StringBuffer)localObject).append(new Object().hashCode());
      ((StringBuffer)localObject).insert(Math.abs(localSecureRandom2.nextInt()) % ((StringBuffer)localObject).length(), str1);
      localSecureRandom1.a(((StringBuffer)localObject).toString().getBytes());
      i += 1;
    }
    arrayOfByte[0] = ((byte)(Math.abs(localSecureRandom1.nextInt()) % 64));
    return new abo(arrayOfByte);
  }
  
  public static String a(abo paramabo1, abo paramabo2)
  {
    if (paramabo1 != null)
    {
      if (paramabo2 == null) {
        return null;
      }
      abo localabo = new abo("2");
      try
      {
        paramabo1 = localabo.a(paramabo1, paramabo2);
        return paramabo1.a().toUpperCase();
      }
      catch (Exception paramabo1)
      {
        paramabo1.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static byte[] a(abo paramabo1, abo paramabo2, abo paramabo3)
  {
    paramabo1 = b(paramabo1, paramabo2, paramabo3);
    if (paramabo1 == null) {
      return null;
    }
    return MD5.toMD5Byte(tl.a(paramabo1.a()));
  }
  
  public static abo b(abo paramabo1, abo paramabo2, abo paramabo3)
  {
    if ((paramabo1 != null) && (paramabo2 != null))
    {
      if (paramabo3 == null) {
        return null;
      }
      try
      {
        paramabo1 = paramabo2.a(paramabo1, paramabo3);
        return paramabo1;
      }
      catch (Exception paramabo1)
      {
        paramabo1.printStackTrace();
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abs
 * JD-Core Version:    0.7.0.1
 */