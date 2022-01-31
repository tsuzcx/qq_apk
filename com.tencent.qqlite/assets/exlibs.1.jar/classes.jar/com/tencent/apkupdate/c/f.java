package com.tencent.apkupdate.c;

import android.util.Log;
import java.util.HashMap;

public final class f
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
      Log.i(paramString1, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.c.f
 * JD-Core Version:    0.7.0.1
 */