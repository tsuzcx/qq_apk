package com.tencent.token.utils.encrypt;

import com.tencent.token.ci;
import com.tencent.token.dp;
import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;
import oicq.wlogin_sdk.tools.MD5;

public class b
{
  public static dp a()
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
    return new dp(arrayOfByte);
  }
  
  public static String a(dp paramdp1, long paramLong, dp paramdp2)
  {
    if ((paramdp1 == null) || (paramdp2 == null)) {
      return null;
    }
    dp localdp = new dp(paramLong + "");
    try
    {
      paramdp1 = localdp.a(paramdp1, paramdp2);
      return paramdp1.e().toUpperCase();
    }
    catch (Exception paramdp1)
    {
      paramdp1.printStackTrace();
    }
    return null;
  }
  
  public static byte[] a(dp paramdp1, dp paramdp2, dp paramdp3)
  {
    paramdp1 = b(paramdp1, paramdp2, paramdp3);
    if (paramdp1 == null) {
      return null;
    }
    return MD5.toMD5Byte(ci.a(paramdp1.e()));
  }
  
  public static dp b(dp paramdp1, dp paramdp2, dp paramdp3)
  {
    if ((paramdp1 == null) || (paramdp2 == null) || (paramdp3 == null)) {
      return null;
    }
    try
    {
      paramdp1 = paramdp2.a(paramdp1, paramdp3);
      return paramdp1;
    }
    catch (Exception paramdp1)
    {
      paramdp1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.b
 * JD-Core Version:    0.7.0.1
 */