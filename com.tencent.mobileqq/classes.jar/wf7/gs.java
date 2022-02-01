package wf7;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class gs
{
  private static HashMap<Class<?>, HashMap<String, Method>> sA = new HashMap();
  private static HashMap<String, Class<?>> sy = new HashMap();
  private static HashMap<Class<?>, HashMap<String, Field>> sz = new HashMap();
  
  public static Object a(Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object paramObject, Object[] paramArrayOfObject)
  {
    try
    {
      paramClass = a(paramClass, paramString, paramArrayOfClass);
      if (paramClass == null) {
        return null;
      }
      paramClass = paramClass.invoke(paramObject, paramArrayOfObject);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object paramObject, Object[] paramArrayOfObject)
  {
    try
    {
      paramString1 = a(e(null, paramString1), paramString2, paramArrayOfClass, paramObject, paramArrayOfObject);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    if (paramClass != null) {}
    Object localObject2;
    do
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        localObject1 = new StringBuffer(paramString);
        if (paramVarArgs != null)
        {
          int i = 0;
          while (i < paramVarArgs.length)
          {
            localObject2 = paramVarArgs[i];
            ((StringBuffer)localObject1).append("+");
            ((StringBuffer)localObject1).append(((Class)localObject2).getName());
            i += 1;
          }
        }
        str = ((StringBuffer)localObject1).toString();
        localObject2 = (HashMap)sA.get(paramClass);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new HashMap();
          sA.put(paramClass, localObject1);
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
        Object localObject1;
        String str;
        paramClass.printStackTrace();
      }
      ((Method)localObject2).setAccessible(true);
      ((HashMap)localObject1).put(str, localObject2);
      return localObject2;
      return null;
    } while (localObject2 != null);
    return null;
  }
  
  private static Class<?> e(Context paramContext, String paramString)
  {
    Class localClass1;
    do
    {
      try
      {
        Class localClass2 = (Class)sy.get(paramString);
        localClass1 = localClass2;
        if (localClass2 != null) {
          continue;
        }
        if (paramContext != null) {
          localClass1 = paramContext.getClassLoader().loadClass(paramString);
        } else {
          localClass1 = Class.forName(paramString);
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      sy.put(paramString, localClass1);
      return localClass1;
    } while (localClass1 != null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gs
 * JD-Core Version:    0.7.0.1
 */