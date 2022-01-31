package com.tencent.smtt.utils;

import java.lang.reflect.Method;

public class ReflectionUtils
{
  public static Object invokeInstance(Object paramObject, String paramString)
  {
    return invokeInstance(paramObject, paramString, null, new Object[0]);
  }
  
  public static Object invokeInstance(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      paramArrayOfClass = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramString = paramVarArgs;
      if (paramVarArgs.length == 0) {
        paramString = null;
      }
      paramObject = paramArrayOfClass.invoke(paramObject, paramString);
      return paramObject;
    }
    catch (Throwable paramObject) {}
    return null;
  }
  
  public static Object invokeStatic(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      paramClass.setAccessible(true);
      paramClass = paramClass.invoke(null, paramVarArgs);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Object invokeStatic(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getMethod(paramString2, new Class[0]).invoke(null, new Object[0]);
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.utils.ReflectionUtils
 * JD-Core Version:    0.7.0.1
 */