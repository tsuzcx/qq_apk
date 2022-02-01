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
    Object localObject2 = System.getProperty("microedition.platform");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int j = Runtime.getRuntime().hashCode();
    try
    {
      PRNGFixes.a();
      localObject2 = new SecureRandom();
      SecureRandom localSecureRandom = new SecureRandom();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append((String)localObject1).append(localSecureRandom.nextInt()).append(System.currentTimeMillis()).append(j).append(new Object().hashCode());
      ((SecureRandom)localObject2).a(localStringBuffer.toString().getBytes());
      int i = 1;
      while (i < arrayOfByte.length)
      {
        arrayOfByte[i] = ((byte)(Math.abs(((SecureRandom)localObject2).nextInt()) % 256));
        localSecureRandom.a(localSecureRandom.a(i));
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(System.currentTimeMillis() + "").append(localSecureRandom.nextInt()).append(j).append(new Object().hashCode());
        localStringBuffer.insert(Math.abs(localSecureRandom.nextInt()) % localStringBuffer.length(), (String)localObject1);
        ((SecureRandom)localObject2).a(localStringBuffer.toString().getBytes());
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      arrayOfByte[0] = ((byte)(Math.abs(localException.nextInt()) % 64));
    }
    return new dq(arrayOfByte);
  }
  
  public static String a(dq paramdq1, long paramLong, dq paramdq2)
  {
    if ((paramdq1 == null) || (paramdq2 == null)) {
      return null;
    }
    dq localdq = new dq(paramLong + "");
    try
    {
      paramdq1 = localdq.a(paramdq1, paramdq2);
      return paramdq1.e().toUpperCase();
    }
    catch (Exception paramdq1)
    {
      paramdq1.printStackTrace();
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
    if ((paramdq1 == null) || (paramdq2 == null) || (paramdq3 == null)) {
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
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.b
 * JD-Core Version:    0.7.0.1
 */