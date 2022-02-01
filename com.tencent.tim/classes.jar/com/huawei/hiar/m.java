package com.huawei.hiar;

import android.util.Log;
import java.lang.reflect.Method;

class m
{
  static Method a;
  private static final String b = m.class.getSimpleName();
  
  static
  {
    try
    {
      Method[] arrayOfMethod = Class.forName("android.os.SystemProperties").getMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if (localMethod.getName().equals("get")) {
          a = localMethod;
        }
        i += 1;
      }
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.w(b, "reflection for android.os.SystemProperties failed ", localClassNotFoundException);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      String str = (String)a.invoke(null, new Object[] { paramString1, paramString2 });
      return str;
    }
    catch (Exception localException)
    {
      Log.e(b, "get system properties " + paramString1 + " failed", localException);
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hiar.m
 * JD-Core Version:    0.7.0.1
 */