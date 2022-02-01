package com.tencent.wework.api.util;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ReflecterHelper
{
  private static final String LOG_TAG = "ReflecterHelper";
  public static Class<?> mCurrentClass;
  
  public static void dump(Class<?> paramClass)
  {
    Log.v("ReflecterHelper", paramClass.getCanonicalName());
    paramClass = paramClass.getMethods();
    int k = paramClass.length;
    int i = 0;
    while (i < k)
    {
      Object localObject = paramClass[i];
      Class[] arrayOfClass = localObject.getParameterTypes();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("  - ");
      localStringBuilder.append(localObject.getReturnType());
      localStringBuilder.append(' ');
      localStringBuilder.append(localObject.getName());
      localStringBuilder.append('(');
      int m = arrayOfClass.length;
      int j = 0;
      while (j != m)
      {
        localStringBuilder.append(arrayOfClass[j].getName());
        if (j != m - 1) {
          localStringBuilder.append(", ");
        }
        j += 1;
      }
      localStringBuilder.append(')');
      Log.v("ReflecterHelper", localStringBuilder.toString());
      i += 1;
    }
  }
  
  private static Class<?>[] getArgsClasses(Object[] paramArrayOfObject)
  {
    Object localObject = (Class[])null;
    if (paramArrayOfObject != null)
    {
      Class[] arrayOfClass = new Class[paramArrayOfObject.length];
      int i = 0;
      int j = paramArrayOfObject.length;
      localObject = arrayOfClass;
      if (i < j)
      {
        if (paramArrayOfObject[i] != null)
        {
          arrayOfClass[i] = paramArrayOfObject[i].getClass();
          label45:
          if (arrayOfClass[i] != Integer.class) {
            break label77;
          }
          arrayOfClass[i] = Integer.TYPE;
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfClass[i] = String.class;
          break label45;
          label77:
          if (arrayOfClass[i] == Boolean.class) {
            arrayOfClass[i] = Boolean.TYPE;
          } else if (arrayOfClass[i] == Long.class) {
            arrayOfClass[i] = Long.TYPE;
          }
        }
      }
    }
    return localObject;
  }
  
  public static Class<?> getClass(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Field[] getDeclaredFields(Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramObject != null) {}
    try
    {
      paramObject = paramObject.getClass();
      localObject1 = localObject2;
      if (paramObject != null) {
        localObject1 = paramObject.getDeclaredFields();
      }
      return localObject1;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static Method[] getDeclaredMethods(Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramObject != null) {}
    try
    {
      paramObject = paramObject.getClass();
      localObject1 = localObject2;
      if (paramObject != null) {
        localObject1 = paramObject.getDeclaredMethods();
      }
      return localObject1;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  private static final Field getField(String paramString)
  {
    // Byte code:
    //   0: getstatic 121	com/tencent/wework/api/util/ReflecterHelper:mCurrentClass	Ljava/lang/Class;
    //   3: aload_0
    //   4: invokevirtual 124	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   7: astore_0
    //   8: aload_0
    //   9: iconst_1
    //   10: invokevirtual 130	java/lang/reflect/Field:setAccessible	(Z)V
    //   13: aload_0
    //   14: areturn
    //   15: astore_1
    //   16: aconst_null
    //   17: astore_0
    //   18: aload_1
    //   19: invokevirtual 131	java/lang/SecurityException:printStackTrace	()V
    //   22: aload_0
    //   23: areturn
    //   24: astore_1
    //   25: aconst_null
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 132	java/lang/NoSuchFieldException:printStackTrace	()V
    //   31: aload_0
    //   32: areturn
    //   33: astore_1
    //   34: goto -7 -> 27
    //   37: astore_1
    //   38: goto -20 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	paramString	String
    //   15	4	1	localSecurityException1	java.lang.SecurityException
    //   24	4	1	localNoSuchFieldException1	NoSuchFieldException
    //   33	1	1	localNoSuchFieldException2	NoSuchFieldException
    //   37	1	1	localSecurityException2	java.lang.SecurityException
    // Exception table:
    //   from	to	target	type
    //   0	8	15	java/lang/SecurityException
    //   0	8	24	java/lang/NoSuchFieldException
    //   8	13	33	java/lang/NoSuchFieldException
    //   8	13	37	java/lang/SecurityException
  }
  
  private static Field getFieldInternal(Object paramObject, String paramString)
    throws NoSuchFieldException
  {
    Object localObject2 = null;
    paramObject = paramObject.getClass();
    for (;;)
    {
      Object localObject1 = localObject2;
      if (paramObject != null) {}
      try
      {
        localObject1 = paramObject.getDeclaredField(paramString);
        if (localObject1 != null) {
          break;
        }
        throw new NoSuchFieldException("setProperty field " + paramString + " not found");
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        paramObject = paramObject.getSuperclass();
      }
    }
    return localNoSuchFieldException;
  }
  
  public static final int getIntValue(Object paramObject, String paramString, int paramInt)
  {
    setClass(paramObject.getClass().getName());
    paramString = getField(paramString);
    int i = paramInt;
    if (paramString != null) {}
    try
    {
      i = paramString.getInt(paramObject);
      return i;
    }
    catch (IllegalArgumentException paramObject)
    {
      paramObject.printStackTrace();
      return paramInt;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
    }
    return paramInt;
  }
  
  public static Object getProperty(Object paramObject, String paramString)
    throws Exception
  {
    paramString = getFieldInternal(paramObject, paramString);
    paramString.setAccessible(true);
    return paramString.get(paramObject);
  }
  
  public static final int getStaticIntValue(String paramString, int paramInt)
  {
    paramString = getField(paramString);
    int i = paramInt;
    if (paramString != null) {}
    try
    {
      i = paramString.getInt(null);
      return i;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
      return paramInt;
    }
    catch (IllegalAccessException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static Object getStaticProperty(String paramString1, String paramString2)
  {
    Object localObject = null;
    setClass(paramString1);
    paramString2 = getField(paramString2);
    paramString1 = localObject;
    if (paramString2 != null) {}
    try
    {
      paramString1 = paramString2.get(null);
      return paramString1;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString)
    throws Exception
  {
    return invokeMethod(paramObject, paramString, null);
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    throws Exception
  {
    localClass = paramObject.getClass();
    localObject2 = null;
    try
    {
      localObject1 = localClass.getDeclaredMethod(paramString, paramArrayOfClass);
      paramString = (String)localObject1;
    }
    catch (Exception localException)
    {
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (0 == 0)
        {
          localObject1 = localObject2;
          if (localClass.getSuperclass() != null) {
            localObject1 = localClass.getSuperclass().getDeclaredMethod(paramString, paramArrayOfClass);
          }
        }
        paramString = (String)localObject1;
      } while (localObject1 != null);
      throw localException;
    }
    paramString.setAccessible(true);
    return paramString.invoke(paramObject, paramArrayOfObject);
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws Exception
  {
    return invokeMethod(paramObject, paramString, getArgsClasses(paramArrayOfObject), paramArrayOfObject);
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2)
    throws Exception
  {
    return invokeStaticMethod(paramString1, paramString2, (Object[])null);
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject)
    throws Exception
  {
    return invokeStaticMethod(paramString1, paramString2, paramArrayOfObject, getArgsClasses(paramArrayOfObject));
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws Exception
  {
    localClass = Class.forName(paramString1);
    localObject = null;
    try
    {
      paramString1 = localClass.getDeclaredMethod(paramString2, paramArrayOfClass);
      paramString2 = paramString1;
    }
    catch (Exception localException)
    {
      do
      {
        paramString1 = localObject;
        if (0 == 0)
        {
          paramString1 = localObject;
          if (localClass.getSuperclass() != null) {
            paramString1 = localClass.getSuperclass().getDeclaredMethod(paramString2, paramArrayOfClass);
          }
        }
        paramString2 = paramString1;
      } while (paramString1 != null);
      throw localException;
    }
    paramString2.setAccessible(true);
    return paramString2.invoke(localClass, paramArrayOfObject);
  }
  
  public static Object newInstance(String paramString)
    throws Exception
  {
    return newInstance(paramString, (Object[])null);
  }
  
  public static Object newInstance(String paramString, Object[] paramArrayOfObject)
    throws Exception
  {
    paramString = Class.forName(paramString).getDeclaredConstructor(getArgsClasses(paramArrayOfObject));
    paramString.setAccessible(true);
    return paramString.newInstance(paramArrayOfObject);
  }
  
  public static Object newInstance(String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
    throws Exception
  {
    paramString = Class.forName(paramString).getDeclaredConstructor(paramArrayOfClass);
    paramString.setAccessible(true);
    return paramString.newInstance(paramArrayOfObject);
  }
  
  public static Method reflectStaticMethod(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass)
    throws Exception
  {
    localObject2 = null;
    try
    {
      localObject1 = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      paramClass = (Class<?>)localObject1;
    }
    catch (Exception localException)
    {
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (0 == 0)
        {
          localObject1 = localObject2;
          if (paramClass.getSuperclass() != null) {
            localObject1 = paramClass.getSuperclass().getDeclaredMethod(paramString, paramArrayOfClass);
          }
        }
        paramClass = (Class<?>)localObject1;
      } while (localObject1 != null);
      throw localException;
    }
    paramClass.setAccessible(true);
    return paramClass;
  }
  
  public static Method reflectStaticMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass)
    throws Exception
  {
    return reflectStaticMethod(Class.forName(paramString1), paramString2, paramArrayOfClass);
  }
  
  public static final boolean setClass(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = Class.forName(paramString);
      mCurrentClass = paramString;
      if (mCurrentClass != null) {
        return true;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localObject;
      }
    }
    return false;
  }
  
  public static void setProperty(Object paramObject1, String paramString, Object paramObject2)
    throws Exception
  {
    setPropertyInternal(paramObject1, paramString, paramObject2);
  }
  
  private static void setPropertyInternal(Object paramObject1, String paramString, Object paramObject2)
    throws Exception
  {
    if (paramObject1 == null) {
      throw new NullPointerException("setProperty null owner");
    }
    paramString = getFieldInternal(paramObject1, paramString);
    try
    {
      paramString.setAccessible(true);
      paramString.set(paramObject1, paramObject2);
      return;
    }
    catch (Exception paramObject1)
    {
      throw paramObject1;
    }
  }
  
  public static boolean setPropertyNoThrowable(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      setPropertyInternal(paramObject1, paramString, paramObject2);
      return true;
    }
    catch (Exception paramObject1) {}
    return false;
  }
  
  public static void setStaticProperty(String paramString1, String paramString2, Object paramObject)
  {
    setClass(paramString1);
    paramString1 = getField(paramString2);
    if (paramString1 != null) {}
    try
    {
      paramString1.set(null, paramObject);
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.util.ReflecterHelper
 * JD-Core Version:    0.7.0.1
 */