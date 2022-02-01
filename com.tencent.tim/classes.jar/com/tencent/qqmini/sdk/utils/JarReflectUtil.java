package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JarReflectUtil
{
  private static final String TAG = "JarReflectUtil";
  
  public static Object callSpecifiedMethod(Object paramObject, String paramString, boolean paramBoolean, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if ((paramObject == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Class localClass = paramObject.getClass();
    if ((paramBoolean) || (paramArrayOfClass != null)) {}
    try
    {
      if (paramArrayOfClass.length == 0) {
        paramString = localClass.getMethod(paramString, new Class[0]);
      }
      while ((paramVarArgs == null) || (paramVarArgs.length == 0))
      {
        return paramString.invoke(paramObject, new Object[0]);
        paramString = localClass.getMethod(paramString, paramArrayOfClass);
        continue;
        if ((paramArrayOfClass == null) || (paramArrayOfClass.length == 0)) {
          paramString = localClass.getDeclaredMethod(paramString, new Class[0]);
        } else {
          paramString = localClass.getDeclaredMethod(paramString, paramArrayOfClass);
        }
      }
      paramObject = paramString.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (NoSuchMethodException paramObject)
    {
      QMLog.e("JarReflectUtil", "NoSuchMethodException: " + paramObject.getMessage());
      paramObject.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramObject)
    {
      QMLog.e("JarReflectUtil", "InvocationTargetException: " + paramObject.getMessage());
      paramObject.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
      QMLog.e("JarReflectUtil", "IllegalAccessException: " + paramObject.getMessage());
      return null;
    }
    catch (NullPointerException paramObject)
    {
      paramObject.printStackTrace();
      QMLog.e("JarReflectUtil", "NullPointerException: " + paramObject.getMessage());
    }
    return null;
  }
  
  public static Object callSpecifiedStaticMethod(String paramString1, String paramString2, boolean paramBoolean, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString1 = Class.forName(paramString1);
        if (!paramBoolean)
        {
          if ((paramArrayOfClass == null) || (paramArrayOfClass.length == 0))
          {
            paramString1 = paramString1.getMethod(paramString2, new Class[0]);
            if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
              continue;
            }
            return paramString1.invoke(null, new Object[0]);
          }
          paramString1 = paramString1.getMethod(paramString2, paramArrayOfClass);
          continue;
        }
        if ((paramArrayOfClass != null) && (paramArrayOfClass.length != 0)) {
          continue;
        }
        paramString1 = paramString1.getDeclaredMethod(paramString2, new Class[0]);
      }
      catch (NoSuchMethodException paramString1)
      {
        paramString1.printStackTrace();
        QMLog.e("JarReflectUtil", "NoSuchMethodException: " + paramString1.getMessage());
        return null;
        paramString1 = paramString1.getDeclaredMethod(paramString2, paramArrayOfClass);
        continue;
        paramString1 = paramString1.invoke(null, paramVarArgs);
        return paramString1;
      }
      catch (InvocationTargetException paramString1)
      {
        paramString1.printStackTrace();
        QMLog.e("JarReflectUtil", "InvocationTargetException: " + paramString1.getMessage());
        return null;
      }
      catch (IllegalAccessException paramString1)
      {
        paramString1.printStackTrace();
        QMLog.e("JarReflectUtil", "IllegalAccessException: " + paramString1.getMessage());
        return null;
      }
      catch (ClassNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        QMLog.e("JarReflectUtil", "ClassNotFoundException: " + paramString1.getMessage());
        return null;
      }
      catch (NullPointerException paramString1)
      {
        paramString1.printStackTrace();
        QMLog.e("JarReflectUtil", "NullPointerException: " + paramString1.getMessage());
      }
      paramString1.setAccessible(true);
    }
    return null;
  }
  
  public static Object creatSpecifiedObject(String paramString, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Class.forName(paramString);
      if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
        return paramString.newInstance();
      }
      paramString = paramString.getConstructor(paramArrayOfClass).newInstance(paramVarArgs);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      QMLog.e("JarReflectUtil", "ClassNotFoundException: " + paramString.getMessage());
      paramString.printStackTrace();
      return null;
    }
    catch (InstantiationException paramString)
    {
      QMLog.e("JarReflectUtil", "InstantiationException: " + paramString.getMessage());
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      QMLog.e("JarReflectUtil", "IllegalAccessException: " + paramString.getMessage());
      paramString.printStackTrace();
      return null;
    }
    catch (NoSuchMethodException paramString)
    {
      QMLog.e("JarReflectUtil", "NoSuchMethodException: " + paramString.getMessage());
      paramString.printStackTrace();
      return null;
    }
    catch (InvocationTargetException paramString)
    {
      QMLog.e("JarReflectUtil", "InvocationTargetException: " + paramString.getMessage());
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Object getClassSingleInstance(String paramString1, String paramString2, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    return callSpecifiedStaticMethod(paramString1, paramString2, false, paramArrayOfClass, paramVarArgs);
  }
  
  public static Field getField(Object paramObject, String paramString)
  {
    paramObject = paramObject.getClass();
    try
    {
      paramObject = paramObject.getDeclaredField(paramString);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static Class[] getParamsClass(Class... paramVarArgs)
  {
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfClass[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfClass;
  }
  
  public static Object getSpecifiedField(Object paramObject, String paramString, boolean paramBoolean)
  {
    if ((paramObject == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    Class localClass = paramObject.getClass();
    if (!paramBoolean) {}
    try
    {
      return localClass.getField(paramString).get(paramObject);
    }
    catch (NoSuchFieldException paramObject)
    {
      QMLog.e("JarReflectUtil", "NoSuchFieldException: ");
      paramObject.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      QMLog.e("JarReflectUtil", "IllegalAccessException: ");
      paramObject.printStackTrace();
    }
    paramString = localClass.getDeclaredField(paramString);
    paramString.setAccessible(true);
    paramObject = paramString.get(paramObject);
    return paramObject;
    return null;
  }
  
  public static Object getStaticField(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    try
    {
      paramString1 = Class.forName(paramString1);
      paramString1 = paramString1.getField(paramString2).get(paramString1);
      return paramString1;
    }
    catch (NoSuchFieldException paramString1)
    {
      QMLog.e("JarReflectUtil", "NoSuchFieldException: ");
      paramString1.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      QMLog.e("JarReflectUtil", "IllegalAccessException: ");
      paramString1.printStackTrace();
      return null;
    }
    catch (ClassNotFoundException paramString1)
    {
      QMLog.e("JarReflectUtil", "ClassNotFoundException: ");
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.JarReflectUtil
 * JD-Core Version:    0.7.0.1
 */