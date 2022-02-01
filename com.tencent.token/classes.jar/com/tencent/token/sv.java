package com.tencent.token;

import com.tmsdk.common.util.TmsLog;

public final class sv
{
  private static sv b;
  private static String c = "";
  private static String d = "https://aq.qq.com";
  public to a = null;
  
  static
  {
    if (aaw.c == 0) {
      d = "http://test.aq.qq.com";
    }
  }
  
  public static String a()
  {
    return c;
  }
  
  public static void a(long paramLong)
  {
    if (paramLong * 1000L > 0L)
    {
      System.currentTimeMillis();
      b();
      b();
      b();
    }
  }
  
  public static void a(String paramString)
  {
    d = paramString;
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("recv initCode, hexStr: ");
    localStringBuilder.append(aay.a(paramArrayOfByte));
    TmsLog.i("mod_seed", localStringBuilder.toString());
    if (paramArrayOfByte != null) {
      wn.a(false);
    }
  }
  
  public static sv b()
  {
    if (b == null) {
      b = new sv();
    }
    return b;
  }
  
  public static void b(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 15) {
      str = paramString.substring(0, 15);
    }
    c = abt.b(abt.a(str.getBytes()));
  }
  
  public static String c()
  {
    String str2 = "0000";
    String str3 = rt.a().e();
    String str1 = str2;
    if (str3 != null)
    {
      str1 = str2;
      if (str3.length() != 0)
      {
        str1 = str2;
        if (str3.length() >= 4) {
          str1 = str3.substring(0, 4);
        }
      }
    }
    return str1;
  }
  
  public static long d()
  {
    return 30000L - (System.currentTimeMillis() + rt.a().g()) % 30000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sv
 * JD-Core Version:    0.7.0.1
 */