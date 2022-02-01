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
      str = str + paramString;
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
      if (!b()) {
        break label56;
      }
      str = c();
    }
    label56:
    for (String str = str + "assert failed";; str = "assert failed")
    {
      if (a()) {
        Log.e("TokenLog", str);
      }
      a(16, "TokenLog", str);
      return;
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
      str = str + paramString;
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
      localObject = "" + "[" + str.getFileName() + ":" + str.getLineNumber() + "|";
      str = (String)localObject + str.getMethodName() + "()] ";
    }
    return str;
  }
  
  public static void c(String paramString)
  {
    String str = paramString;
    if (b())
    {
      str = c();
      str = str + paramString;
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