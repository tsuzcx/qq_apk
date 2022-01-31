package com.tencent.tmassistantsdk.f;

import android.util.Log;
import java.util.HashMap;

public final class j
{
  private static boolean a = true;
  
  static
  {
    new HashMap();
    new HashMap();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      Log.v(paramString1, str);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      Log.i(paramString1, str);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      Log.d(paramString1, str);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      Log.w(paramString1, str);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (a)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      Log.e(paramString1, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.f.j
 * JD-Core Version:    0.7.0.1
 */