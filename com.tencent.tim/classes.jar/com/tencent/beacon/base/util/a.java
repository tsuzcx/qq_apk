package com.tencent.beacon.base.util;

import android.os.Build.VERSION;
import java.lang.reflect.Method;

public class a
{
  private static String a;
  
  public static String a()
  {
    String str = a;
    if (str != null) {
      return str;
    }
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("android.app.ActivityThread");
        int i = Build.VERSION.SDK_INT;
        if (i < 18) {
          continue;
        }
        str = "currentProcessName";
        a = (String)localClass.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
      }
      catch (Throwable localThrowable)
      {
        c.a(localThrowable);
        continue;
      }
      return "";
      str = "currentPackageName";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.util.a
 * JD-Core Version:    0.7.0.1
 */