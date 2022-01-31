package com.tencent.token.utils.encrypt;

import com.tencent.token.dg;
import com.tencent.token.ex;
import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import oicq.wlogin_sdk.tools.MD5;

public class b
{
  public static ex a()
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
    return new ex(arrayOfByte);
  }
  
  public static String a(ex paramex1, long paramLong, ex paramex2)
  {
    if ((paramex1 == null) || (paramex2 == null)) {
      return null;
    }
    ex localex = new ex(paramLong + "");
    try
    {
      paramex1 = localex.a(paramex1, paramex2);
      return paramex1.e().toUpperCase();
    }
    catch (Exception paramex1)
    {
      paramex1.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(ex paramex1, ex paramex2, ex paramex3)
  {
    paramex1 = b(paramex1, paramex2, paramex3);
    if (paramex1 == null) {
      return null;
    }
    return MD5.toMD5Byte(dg.a(paramex1.e()));
  }
  
  public static ex b(ex paramex1, ex paramex2, ex paramex3)
  {
    if ((paramex1 == null) || (paramex2 == null) || (paramex3 == null)) {
      return null;
    }
    try
    {
      paramex1 = paramex2.a(paramex1, paramex3);
      return paramex1;
    }
    catch (Exception paramex1)
    {
      paramex1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.b
 * JD-Core Version:    0.7.0.1
 */