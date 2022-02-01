package com.tencent.tpns.reflecttools;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Reflect
{
  private final Object object;
  private final Class<?> type;
  
  private Reflect(Class<?> paramClass)
  {
    this(paramClass, paramClass);
  }
  
  private Reflect(Class<?> paramClass, Object paramObject)
  {
    this.type = paramClass;
    this.object = paramObject;
  }
  
  public static <T extends AccessibleObject> T accessible(T paramT)
  {
    T ?;
    if (paramT == null) {
      ? = null;
    }
    do
    {
      Member localMember;
      do
      {
        return ?;
        if (!(paramT instanceof Member)) {
          break;
        }
        localMember = (Member)paramT;
        if (!Modifier.isPublic(localMember.getModifiers())) {
          break;
        }
        ? = paramT;
      } while (Modifier.isPublic(localMember.getDeclaringClass().getModifiers()));
      ? = paramT;
    } while (paramT.isAccessible());
    paramT.setAccessible(true);
    return paramT;
  }
  
  private Method exactMethod(String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject = type();
    try
    {
      Method localMethod1 = ((Class)localObject).getMethod(paramString, paramArrayOfClass);
      return localMethod1;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Class localClass;
      do
      {
        try
        {
          Method localMethod2 = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass);
          return localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localClass = ((Class)localObject).getSuperclass();
          localObject = localClass;
        }
      } while (localClass != null);
      throw new NoSuchMethodException();
    }
  }
  
  private Field field0(String paramString)
  {
    Class localClass = type();
    try
    {
      Field localField1 = (Field)accessible(localClass.getField(paramString));
      return localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException1) {}
    for (;;)
    {
      try
      {
        Field localField2 = (Field)accessible(localClass.getDeclaredField(paramString));
        return localField2;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        localClass = localClass.getSuperclass();
        if (localClass == null) {
          throw new ReflectException(localNoSuchFieldException1);
        }
      }
    }
  }
  
  public static Class<?> forName(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  private static Class<?> forName(String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramString = Class.forName(paramString, true, paramClassLoader);
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  private boolean isSimilarSignature(Method paramMethod, String paramString, Class<?>[] paramArrayOfClass)
  {
    return (paramMethod.getName().equals(paramString)) && (match(paramMethod.getParameterTypes(), paramArrayOfClass));
  }
  
  private boolean match(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    if (paramArrayOfClass1.length == paramArrayOfClass2.length)
    {
      int i = 0;
      if (i < paramArrayOfClass2.length)
      {
        if (paramArrayOfClass2[i] == a.class) {}
        while (wrapper(paramArrayOfClass1[i]).isAssignableFrom(wrapper(paramArrayOfClass2[i])))
        {
          i += 1;
          break;
        }
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public static Reflect on(Class<?> paramClass)
  {
    return new Reflect(paramClass);
  }
  
  private static Reflect on(Class<?> paramClass, Object paramObject)
  {
    return new Reflect(paramClass, paramObject);
  }
  
  public static Reflect on(Object paramObject)
  {
    if (paramObject == null) {}
    for (Object localObject = Object.class;; localObject = paramObject.getClass()) {
      return new Reflect((Class)localObject, paramObject);
    }
  }
  
  public static Reflect on(String paramString)
  {
    return on(forName(paramString));
  }
  
  public static Reflect on(String paramString, ClassLoader paramClassLoader)
  {
    return on(forName(paramString, paramClassLoader));
  }
  
  private static Reflect on(Constructor<?> paramConstructor, Object... paramVarArgs)
  {
    try
    {
      paramConstructor = on(paramConstructor.getDeclaringClass(), ((Constructor)accessible(paramConstructor)).newInstance(paramVarArgs));
      return paramConstructor;
    }
    catch (Throwable paramConstructor)
    {
      throw new ReflectException(paramConstructor);
    }
  }
  
  private static Reflect on(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      accessible(paramMethod);
      if (paramMethod.getReturnType() == Void.TYPE)
      {
        paramMethod.invoke(paramObject, paramVarArgs);
        return on(paramObject);
      }
      paramMethod = on(paramMethod.invoke(paramObject, paramVarArgs));
      return paramMethod;
    }
    catch (Throwable paramMethod)
    {
      throw new ReflectException(paramMethod);
    }
  }
  
  private static String property(String paramString)
  {
    int i = paramString.length();
    if (i == 0) {
      return "";
    }
    if (i == 1) {
      return paramString.toLowerCase();
    }
    return paramString.substring(0, 1).toLowerCase() + paramString.substring(1);
  }
  
  private Method similarMethod(String paramString, Class<?>[] paramArrayOfClass)
  {
    Object localObject2 = type();
    Method[] arrayOfMethod = ((Class)localObject2).getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      localObject1 = arrayOfMethod[i];
      if (isSimilarSignature((Method)localObject1, paramString, paramArrayOfClass)) {
        return localObject1;
      }
      i += 1;
    }
    do
    {
      localObject2 = ((Class)localObject1).getDeclaredMethods();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        arrayOfMethod = localObject2[i];
        if (isSimilarSignature(arrayOfMethod, paramString, paramArrayOfClass)) {
          return arrayOfMethod;
        }
        i += 1;
      }
      localObject2 = ((Class)localObject1).getSuperclass();
      localObject1 = localObject2;
    } while (localObject2 != null);
    throw new NoSuchMethodException("No similar method " + paramString + " with params " + Arrays.toString(paramArrayOfClass) + " could be found on type " + type() + ".");
  }
  
  private static Class<?>[] types(Object... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {
      return new Class[0];
    }
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    if (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject == null) {}
      for (localObject = a.class;; localObject = localObject.getClass())
      {
        arrayOfClass[i] = localObject;
        i += 1;
        break;
      }
    }
    return arrayOfClass;
  }
  
  private static Object unwrap(Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof Reflect)) {
      localObject = ((Reflect)paramObject).get();
    }
    return localObject;
  }
  
  public static Class<?> wrapper(Class<?> paramClass)
  {
    Class<?> localClass;
    if (paramClass == null) {
      localClass = null;
    }
    do
    {
      do
      {
        return localClass;
        localClass = paramClass;
      } while (!paramClass.isPrimitive());
      if (Boolean.TYPE == paramClass) {
        return Boolean.class;
      }
      if (Integer.TYPE == paramClass) {
        return Integer.class;
      }
      if (Long.TYPE == paramClass) {
        return Long.class;
      }
      if (Short.TYPE == paramClass) {
        return Short.class;
      }
      if (Byte.TYPE == paramClass) {
        return Byte.class;
      }
      if (Double.TYPE == paramClass) {
        return Double.class;
      }
      if (Float.TYPE == paramClass) {
        return Float.class;
      }
      if (Character.TYPE == paramClass) {
        return Character.class;
      }
      localClass = paramClass;
    } while (Void.TYPE != paramClass);
    return Void.class;
  }
  
  public <P> P as(Class<P> paramClass)
  {
    Reflect.1 local1 = new Reflect.1(this, this.object instanceof Map);
    return Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, local1);
  }
  
  public Reflect call(String paramString)
  {
    return call(paramString, new Object[0]);
  }
  
  public Reflect call(String paramString, Object... paramVarArgs)
  {
    Class[] arrayOfClass = types(paramVarArgs);
    try
    {
      Reflect localReflect = on(exactMethod(paramString, arrayOfClass), this.object, paramVarArgs);
      return localReflect;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        paramString = on(similarMethod(paramString, arrayOfClass), this.object, paramVarArgs);
        return paramString;
      }
      catch (NoSuchMethodException paramString)
      {
        throw new ReflectException(paramString);
      }
    }
  }
  
  public Reflect create()
  {
    return create(new Object[0]);
  }
  
  public Reflect create(Object... paramVarArgs)
  {
    Class[] arrayOfClass = types(paramVarArgs);
    try
    {
      Reflect localReflect = on(type().getDeclaredConstructor(arrayOfClass), paramVarArgs);
      return localReflect;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Constructor[] arrayOfConstructor = type().getDeclaredConstructors();
      int j = arrayOfConstructor.length;
      int i = 0;
      while (i < j)
      {
        Constructor localConstructor = arrayOfConstructor[i];
        if (match(localConstructor.getParameterTypes(), arrayOfClass)) {
          return on(localConstructor, paramVarArgs);
        }
        i += 1;
      }
      throw new ReflectException(localNoSuchMethodException);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Reflect)) {
      return this.object.equals(((Reflect)paramObject).get());
    }
    return false;
  }
  
  public Reflect field(String paramString)
  {
    try
    {
      paramString = field0(paramString);
      paramString = on(paramString.getType(), paramString.get(this.object));
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  public Map<String, Reflect> fields()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject1 = type();
    Object localObject2;
    do
    {
      localObject2 = ((Class)localObject1).getDeclaredFields();
      int k = localObject2.length;
      int i = 0;
      if (i < k)
      {
        String str = localObject2[i];
        if (this.type != this.object) {}
        for (int j = 1;; j = 0)
        {
          if ((j ^ Modifier.isStatic(str.getModifiers())) != 0)
          {
            str = str.getName();
            if (!localLinkedHashMap.containsKey(str)) {
              localLinkedHashMap.put(str, field(str));
            }
          }
          i += 1;
          break;
        }
      }
      localObject2 = ((Class)localObject1).getSuperclass();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return localLinkedHashMap;
  }
  
  public <T> T get()
  {
    return this.object;
  }
  
  public <T> T get(String paramString)
  {
    return field(paramString).get();
  }
  
  public int hashCode()
  {
    return this.object.hashCode();
  }
  
  public Reflect set(String paramString, Object paramObject)
  {
    try
    {
      paramString = field0(paramString);
      if ((paramString.getModifiers() & 0x10) == 16)
      {
        Field localField = Field.class.getDeclaredField("modifiers");
        localField.setAccessible(true);
        localField.setInt(paramString, paramString.getModifiers() & 0xFFFFFFEF);
      }
      paramString.set(this.object, unwrap(paramObject));
      return this;
    }
    catch (Throwable paramString)
    {
      throw new ReflectException(paramString);
    }
  }
  
  public String toString()
  {
    return this.object.toString();
  }
  
  public Class<?> type()
  {
    return this.type;
  }
  
  static class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.reflecttools.Reflect
 * JD-Core Version:    0.7.0.1
 */