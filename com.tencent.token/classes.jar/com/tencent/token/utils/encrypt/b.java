package com.tencent.token.utils.encrypt;

import com.tencent.token.fu;
import com.tencent.token.utils.encrypt.random.PRNGFixes;
import com.tencent.token.utils.encrypt.random.SecureRandom;

public final class b
{
  public static fu a()
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
    return new fu(arrayOfByte);
  }
  
  public static fu a(fu paramfu1, fu paramfu2, fu paramfu3)
  {
    if ((paramfu1 == null) || (paramfu2 == null) || (paramfu3 == null)) {
      return null;
    }
    try
    {
      paramfu1 = paramfu2.a(paramfu1, paramfu3);
      return paramfu1;
    }
    catch (Exception paramfu1)
    {
      paramfu1.printStackTrace();
    }
    return null;
  }
  
  public static String a(fu paramfu1, fu paramfu2)
  {
    if ((paramfu1 == null) || (paramfu2 == null)) {
      return null;
    }
    fu localfu = new fu(2L + "");
    try
    {
      paramfu1 = localfu.a(paramfu1, paramfu2);
      return paramfu1.a().toUpperCase();
    }
    catch (Exception paramfu1)
    {
      paramfu1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.b
 * JD-Core Version:    0.7.0.1
 */