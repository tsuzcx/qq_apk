package com.tencent.token.global;

import android.util.Log;
import com.tencent.token.gb;

public final class e
{
  private static String a()
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
  
  public static void a(String paramString)
  {
    String str = paramString;
    if (gb.a().d())
    {
      str = a();
      str = str + paramString;
    }
    if (gb.a().c()) {
      Log.d("TokenLog", str);
    }
    gb.a().a(2, "TokenLog", str);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (!gb.a().d()) {
        break label65;
      }
      str = a();
    }
    label65:
    for (String str = str + "assert failed";; str = "assert failed")
    {
      if (gb.a().c()) {
        Log.e("TokenLog", str);
      }
      gb.a().a(16, "TokenLog", str);
      return;
    }
  }
  
  public static void b(String paramString)
  {
    String str = paramString;
    if (gb.a().d())
    {
      str = a();
      str = str + paramString;
    }
    if (gb.a().c()) {
      Log.i("TokenLog", str);
    }
    gb.a().a(4, "TokenLog", str);
  }
  
  public static void c(String paramString)
  {
    String str = paramString;
    if (gb.a().d())
    {
      str = a();
      str = str + paramString;
    }
    if (gb.a().c()) {
      Log.e("TokenLog", str);
    }
    gb.a().a(16, "TokenLog", str);
  }
  
  public static void d(String paramString)
  {
    c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.e
 * JD-Core Version:    0.7.0.1
 */