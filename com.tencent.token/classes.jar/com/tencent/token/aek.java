package com.tencent.token;

import android.content.Context;
import java.lang.reflect.Method;

public final class aek
{
  static
  {
    new Object();
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = aef.a.getClassLoader();
      localObject = ((ClassLoader)localObject).loadClass("android.os.SystemProperties");
      Method localMethod = ((Class)localObject).getMethod("get", new Class[] { String.class, String.class });
      paramString = new String(paramString);
      paramString = (String)localMethod.invoke(localObject, new Object[] { paramString, new String("") });
    }
    catch (IllegalArgumentException paramString)
    {
      Object localObject;
      throw paramString;
    }
    catch (Exception paramString)
    {
      label76:
      break label76;
    }
    paramString = "";
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aek
 * JD-Core Version:    0.7.0.1
 */