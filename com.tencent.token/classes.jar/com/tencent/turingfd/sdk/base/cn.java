package com.tencent.turingfd.sdk.base;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class cn
{
  public static HashMap<String, Class<?>> a = new HashMap();
  public static HashMap<Class<?>, HashMap<String, Field>> b = new HashMap();
  public static HashMap<Class<?>, HashMap<String, Method>> c = new HashMap();
  
  public static Object a(Class<?> paramClass, String paramString, Object paramObject)
  {
    Object localObject;
    if (paramClass == null) {
      localObject = null;
    }
    for (;;)
    {
      if (localObject == null) {
        return null;
      }
      label115:
      label118:
      do
      {
        for (;;)
        {
          try
          {
            localHashMap = (HashMap)b.get(paramClass);
            if (localHashMap != null) {
              break label115;
            }
            localHashMap = new HashMap();
            b.put(paramClass, localHashMap);
            Field localField = (Field)localHashMap.get(paramString);
            localObject = localField;
            if (localField != null) {
              break label118;
            }
            localObject = paramClass.getDeclaredField(paramString);
          }
          catch (Throwable paramClass)
          {
            try
            {
              HashMap localHashMap;
              paramClass.printStackTrace();
            }
            catch (Throwable paramClass)
            {
              paramClass.printStackTrace();
              return null;
            }
          }
          ((Field)localObject).setAccessible(true);
          localHashMap.put(paramString, localObject);
          break;
          paramClass = ((Field)localObject).get(paramObject);
          return paramClass;
        }
      } while (localObject != null);
      localObject = null;
    }
  }
  
  public static Object a(String paramString1, String paramString2)
  {
    try
    {
      Class localClass2 = (Class)a.get(paramString1);
      localClass1 = localClass2;
      if (localClass2 == null) {
        localClass1 = Class.forName(paramString1);
      }
      if (localClass1 != null) {
        break label37;
      }
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        Class localClass1;
        label37:
        paramString1.printStackTrace();
      }
    }
    localClass1 = null;
    for (;;)
    {
      try
      {
        paramString1 = a(localClass1, paramString2, null);
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
      a.put(paramString1, localClass1);
    }
    return null;
  }
  
  public static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    if (paramClass != null) {}
    Object localObject2;
    label168:
    label173:
    do
    {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          localObject1 = new StringBuffer(paramString);
          if (paramVarArgs != null)
          {
            int i = 0;
            if (i < paramVarArgs.length)
            {
              localObject2 = paramVarArgs[i];
              ((StringBuffer)localObject1).append("+");
              ((StringBuffer)localObject1).append(((Class)localObject2).getName());
              i += 1;
              continue;
            }
          }
          str = ((StringBuffer)localObject1).toString();
          localObject1 = (HashMap)c.get(paramClass);
          if (localObject1 != null) {
            break label168;
          }
          localObject1 = new HashMap();
          c.put(paramClass, localObject1);
          Method localMethod = (Method)((HashMap)localObject1).get(str);
          localObject2 = localMethod;
          if (localMethod != null) {
            break label173;
          }
          localObject2 = paramClass.getDeclaredMethod(paramString, paramVarArgs);
        }
        catch (Throwable paramClass)
        {
          Object localObject1;
          String str;
          paramClass.printStackTrace();
          return null;
        }
        ((Method)localObject2).setAccessible(true);
        ((HashMap)localObject1).put(str, localObject2);
        return localObject2;
      }
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
 * Qualified Name:     com.tencent.turingfd.sdk.base.cn
 * JD-Core Version:    0.7.0.1
 */