package com.tencent.thumbplayer.utils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TPThreadAnnotations
{
  private static ArrayList<RegisterMethod> mRegisterMethods = new ArrayList();
  
  public static boolean checkObj(Class<?> paramClass, int paramInt)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return false;
    }
    paramClass = (Method)paramClass.get(Integer.valueOf(paramInt));
    if (paramClass != null)
    {
      paramClass = (ThreadSwitch)paramClass.getAnnotation(ThreadSwitch.class);
      if (paramClass != null) {
        return paramClass.checkObj();
      }
    }
    return false;
  }
  
  public static String getApi(Class<?> paramClass, int paramInt)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return "unknown";
    }
    paramClass = (Method)paramClass.get(Integer.valueOf(paramInt));
    if (paramClass != null) {
      return paramClass.getName();
    }
    return "unknown";
  }
  
  public static Method getMethod(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return null;
    }
    paramClass = paramClass.entrySet().iterator();
    while (paramClass.hasNext())
    {
      Method localMethod = (Method)((Map.Entry)paramClass.next()).getValue();
      if ((localMethod != null) && (paramString.equals(localMethod.getName())) && (isMatchParams(localMethod, paramArrayOfObject))) {
        return localMethod;
      }
    }
    return null;
  }
  
  public static Method getMethodByMsgId(Class<?> paramClass, int paramInt)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return null;
    }
    return (Method)paramClass.get(Integer.valueOf(paramInt));
  }
  
  public static int getMethodMsgId(Class<?> paramClass, String paramString, Object[] paramArrayOfObject)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return -1;
    }
    paramClass = paramClass.entrySet().iterator();
    while (paramClass.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramClass.next();
      Method localMethod = (Method)localEntry.getValue();
      if ((localMethod != null) && (paramString.equals(localMethod.getName())) && (isMatchParams(localMethod, paramArrayOfObject))) {
        return ((Integer)localEntry.getKey()).intValue();
      }
    }
    return -1;
  }
  
  private static Map<Integer, Method> getRegisterMethodMap(Class<?> paramClass)
  {
    Iterator localIterator = mRegisterMethods.iterator();
    while (localIterator.hasNext())
    {
      RegisterMethod localRegisterMethod = (RegisterMethod)localIterator.next();
      if ((localRegisterMethod != null) && (localRegisterMethod.className != null) && (localRegisterMethod.className.equals(paramClass.getName()))) {
        return localRegisterMethod.methodMap;
      }
    }
    return null;
  }
  
  private static boolean isMatchParams(Method paramMethod, Object[] paramArrayOfObject)
  {
    boolean bool2 = false;
    paramMethod = paramMethod.getParameterTypes();
    boolean bool1;
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
    {
      bool1 = bool2;
      if (paramMethod.length == 0) {
        bool1 = true;
      }
    }
    int i;
    Class localClass;
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramMethod.length != paramArrayOfObject.length);
      i = 0;
      if (i >= paramMethod.length) {
        break label103;
      }
      localClass = paramMethod[i];
      if (paramArrayOfObject[i] != null) {
        break;
      }
      bool1 = bool2;
    } while (localClass.isPrimitive());
    while ((localClass.isAssignableFrom(paramArrayOfObject[i].getClass())) || (isSamePrimitive(localClass, paramArrayOfObject[i])))
    {
      i += 1;
      break;
    }
    return false;
    label103:
    return true;
  }
  
  public static boolean isNeedWait(Class<?> paramClass, int paramInt)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return false;
    }
    paramClass = (Method)paramClass.get(Integer.valueOf(paramInt));
    if (paramClass != null)
    {
      Class[] arrayOfClass = paramClass.getExceptionTypes();
      if ((arrayOfClass != null) && (arrayOfClass.length > 0)) {
        return true;
      }
      paramClass = (ThreadSwitch)paramClass.getAnnotation(ThreadSwitch.class);
      if (paramClass != null) {
        return paramClass.needWait();
      }
    }
    return false;
  }
  
  private static boolean isRegistered(Class<?> paramClass)
  {
    Iterator localIterator = mRegisterMethods.iterator();
    while (localIterator.hasNext())
    {
      RegisterMethod localRegisterMethod = (RegisterMethod)localIterator.next();
      if ((localRegisterMethod != null) && (localRegisterMethod.className != null) && (localRegisterMethod.className.equals(paramClass.getName()))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean isSamePrimitive(Class<?> paramClass, Object paramObject)
  {
    if (!paramClass.isPrimitive()) {
      return false;
    }
    try
    {
      boolean bool = paramObject.getClass().getField("TYPE").get(null).equals(paramClass);
      return bool;
    }
    catch (Exception paramClass) {}
    return false;
  }
  
  public static boolean register(Class<?> paramClass, int paramInt)
  {
    label153:
    for (;;)
    {
      try
      {
        boolean bool = isRegistered(paramClass);
        if (bool)
        {
          bool = true;
          return bool;
        }
        HashMap localHashMap = new HashMap();
        int i;
        try
        {
          localObject1 = paramClass.getMethods();
          int j = localObject1.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          Object localObject2 = localObject1[i];
          if ((ThreadSwitch)localObject2.getAnnotation(ThreadSwitch.class) == null) {
            break label153;
          }
          localHashMap.put(Integer.valueOf(paramInt), localObject2);
          paramInt += 1;
        }
        catch (Exception paramClass)
        {
          localHashMap.clear();
          bool = false;
        }
        continue;
        Object localObject1 = new RegisterMethod(null);
        ((RegisterMethod)localObject1).className = paramClass.getName();
        ((RegisterMethod)localObject1).methodMap = localHashMap;
        mRegisterMethods.add(localObject1);
        bool = true;
        continue;
        i += 1;
      }
      finally {}
    }
  }
  
  public static boolean removeRepeat(Class<?> paramClass, int paramInt)
  {
    paramClass = getRegisterMethodMap(paramClass);
    if (paramClass == null) {
      return false;
    }
    paramClass = (Method)paramClass.get(Integer.valueOf(paramInt));
    if (paramClass != null)
    {
      paramClass = (ThreadSwitch)paramClass.getAnnotation(ThreadSwitch.class);
      if (paramClass != null) {
        return paramClass.removeRepeat();
      }
    }
    return false;
  }
  
  static class RegisterMethod
  {
    String className;
    Map<Integer, Method> methodMap;
  }
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.TYPE})
  public static @interface ThreadSwitch
  {
    boolean checkObj() default false;
    
    boolean needWait() default false;
    
    boolean removeRepeat() default false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPThreadAnnotations
 * JD-Core Version:    0.7.0.1
 */