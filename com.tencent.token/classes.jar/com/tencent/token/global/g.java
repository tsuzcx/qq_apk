package com.tencent.token.global;

import android.util.Log;
import com.tencent.token.dx;

public class g
{
  private static void a(int paramInt, String paramString1, String paramString2)
  {
    dx.a().a(paramInt, paramString1, paramString2, null);
  }
  
  public static void a(String paramString)
  {
    String str = paramString;
    if (b())
    {
      str = c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      str = localStringBuilder.toString();
    }
    if (a()) {
      Log.d("TokenLog", str);
    }
    a(2, "TokenLog", str);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      String str;
      if (b())
      {
        str = c();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("assert failed");
        str = localStringBuilder.toString();
      }
      else
      {
        str = "assert failed";
      }
      if (a()) {
        Log.e("TokenLog", str);
      }
      a(16, "TokenLog", str);
    }
  }
  
  public static boolean a()
  {
    return dx.a().f();
  }
  
  public static void b(String paramString)
  {
    String str = paramString;
    if (b())
    {
      str = c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      str = localStringBuilder.toString();
    }
    if (a()) {
      Log.i("TokenLog", str);
    }
    a(4, "TokenLog", str);
  }
  
  public static boolean b()
  {
    return dx.a().g();
  }
  
  private static String c()
  {
    String str = "";
    Object localObject = new Throwable().getStackTrace();
    if (localObject.length > 2)
    {
      str = localObject[2];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(str.getFileName());
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(str.getLineNumber());
      ((StringBuilder)localObject).append("|");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str.getMethodName());
      localStringBuilder.append("()] ");
      str = localStringBuilder.toString();
    }
    return str;
  }
  
  public static void c(String paramString)
  {
    String str = paramString;
    if (b())
    {
      str = c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      str = localStringBuilder.toString();
    }
    if (a()) {
      Log.e("TokenLog", str);
    }
    a(16, "TokenLog", str);
  }
  
  public static void d(String paramString)
  {
    c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.g
 * JD-Core Version:    0.7.0.1
 */