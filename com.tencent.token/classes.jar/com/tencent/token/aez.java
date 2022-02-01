package com.tencent.token;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public final class aez
{
  public static HashMap<String, Class<?>> a = new HashMap();
  public static HashMap<Class<?>, HashMap<String, Field>> b = new HashMap();
  public static HashMap<Class<?>, HashMap<String, Method>> c = new HashMap();
  
  public static Object a(Class<?> paramClass, String paramString, Object paramObject)
  {
    if (paramClass == null) {
      paramClass = null;
    }
    while (paramClass != null)
    {
      for (;;)
      {
        Object localObject2;
        try
        {
          Object localObject1;
          paramClass.printStackTrace();
        }
        catch (Throwable paramClass)
        {
          paramClass.printStackTrace();
          return null;
        }
        paramClass = paramClass.get(paramObject);
        return paramClass;
        paramClass = (Class<?>)localObject2;
      }
      paramClass = null;
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2)
  {
    Class localClass1;
    try
    {
      Class localClass2 = (Class)a.get(paramString1);
      localClass1 = localClass2;
      if (localClass2 == null) {
        localClass1 = Class.forName(paramString1);
      }
      if (localClass1 != null) {
        a.put(paramString1, localClass1);
      }
    }
    catch (Throwable paramString1) {}
    for (;;)
    {
      try
      {
        paramString1.printStackTrace();
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      paramString1 = a(localClass1, paramString2, null);
      return paramString1;
      localClass1 = null;
    }
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    if (paramClass != null) {}
    Object localObject2;
    label115:
    do
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label115;
        }
        str = paramString;
        localObject2 = (HashMap)c.get(paramClass);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new HashMap();
          c.put(paramClass, localObject1);
        }
        Method localMethod = (Method)((HashMap)localObject1).get(str);
        localObject2 = localMethod;
        if (localMethod != null) {
          continue;
        }
        localObject2 = paramClass.getDeclaredMethod(paramString, paramVarArgs);
      }
      catch (Throwable paramClass)
      {
        String str;
        Object localObject1;
        paramClass.printStackTrace();
      }
      ((Method)localObject2).setAccessible(true);
      ((HashMap)localObject1).put(str, localObject2);
      return localObject2;
      return null;
    } while (localObject2 != null);
    return null;
  }
  
  public static Object b(Class<?> paramClass, String paramString, Object paramObject)
  {
    try
    {
      paramClass = a(paramClass, paramString, new Class[0]);
      if (paramClass == null) {
        return null;
      }
      paramClass = paramClass.invoke(paramObject, new Object[0]);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aez
 * JD-Core Version:    0.7.0.1
 */