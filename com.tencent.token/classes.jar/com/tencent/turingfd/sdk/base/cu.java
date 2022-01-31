package com.tencent.turingfd.sdk.base;

import android.content.Context;
import java.lang.reflect.Method;

public final class cu
{
  static
  {
    new Object();
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = cm.a.getClassLoader();
      localObject = ((ClassLoader)localObject).loadClass("android.os.SystemProperties");
      Method localMethod = ((Class)localObject).getMethod("get", new Class[] { String.class, String.class });
      paramString = new String(paramString);
      paramString = (String)localMethod.invoke(localObject, new Object[] { paramString, new String("") });
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        paramString = "";
      }
    }
    catch (IllegalArgumentException paramString)
    {
      throw paramString;
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cu
 * JD-Core Version:    0.7.0.1
 */