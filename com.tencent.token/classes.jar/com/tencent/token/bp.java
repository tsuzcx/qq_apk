package com.tencent.token;

import android.arch.lifecycle.CompositeGeneratedAdaptersObserver;
import android.arch.lifecycle.FullLifecycleObserver;
import android.arch.lifecycle.FullLifecycleObserverAdapter;
import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.ReflectiveGenericLifecycleObserver;
import android.arch.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class bp
{
  private static Map<Class, Integer> a = new HashMap();
  private static Map<Class, List<Constructor<? extends bi>>> b = new HashMap();
  
  static GenericLifecycleObserver a(Object paramObject)
  {
    if ((paramObject instanceof FullLifecycleObserver)) {
      return new FullLifecycleObserverAdapter((FullLifecycleObserver)paramObject);
    }
    if ((paramObject instanceof GenericLifecycleObserver)) {
      return (GenericLifecycleObserver)paramObject;
    }
    Object localObject = paramObject.getClass();
    if (b((Class)localObject) == 2)
    {
      localObject = (List)b.get(localObject);
      int j = ((List)localObject).size();
      int i = 0;
      if (j == 1) {
        return new SingleGeneratedAdapterObserver(a((Constructor)((List)localObject).get(0), paramObject));
      }
      bi[] arrayOfbi = new bi[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        arrayOfbi[i] = a((Constructor)((List)localObject).get(i), paramObject);
        i += 1;
      }
      return new CompositeGeneratedAdaptersObserver(arrayOfbi);
    }
    return new ReflectiveGenericLifecycleObserver(paramObject);
  }
  
  private static bi a(Constructor<? extends bi> paramConstructor, Object paramObject)
  {
    try
    {
      paramConstructor = (bi)paramConstructor.newInstance(new Object[] { paramObject });
      return paramConstructor;
    }
    catch (InvocationTargetException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (InstantiationException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
    catch (IllegalAccessException paramConstructor)
    {
      throw new RuntimeException(paramConstructor);
    }
  }
  
  private static Constructor<? extends bi> a(Class<?> paramClass)
  {
    try
    {
      localObject = paramClass.getPackage();
      str = paramClass.getCanonicalName();
      if (localObject == null) {
        break label166;
      }
      localObject = ((Package)localObject).getName();
    }
    catch (NoSuchMethodException paramClass)
    {
      String str;
      StringBuilder localStringBuilder;
      throw new RuntimeException(paramClass);
      return null;
    }
    catch (ClassNotFoundException paramClass)
    {
      for (;;)
      {
        continue;
        label166:
        Object localObject = "";
      }
    }
    if (!((String)localObject).isEmpty()) {
      str = str.substring(((String)localObject).length() + 1);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str.replace(".", "_"));
    localStringBuilder.append("_LifecycleAdapter");
    str = localStringBuilder.toString();
    if (((String)localObject).isEmpty())
    {
      localObject = str;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      localObject = localStringBuilder.toString();
    }
    paramClass = Class.forName((String)localObject).getDeclaredConstructor(new Class[] { paramClass });
    if (!paramClass.isAccessible()) {
      paramClass.setAccessible(true);
    }
    return paramClass;
  }
  
  private static int b(Class<?> paramClass)
  {
    if (a.containsKey(paramClass)) {
      return ((Integer)a.get(paramClass)).intValue();
    }
    int i = c(paramClass);
    a.put(paramClass, Integer.valueOf(i));
    return i;
  }
  
  private static int c(Class<?> paramClass)
  {
    if (paramClass.getCanonicalName() == null) {
      return 1;
    }
    Object localObject1 = a(paramClass);
    if (localObject1 != null)
    {
      b.put(paramClass, Collections.singletonList(localObject1));
      return 2;
    }
    if (bg.a.a(paramClass)) {
      return 1;
    }
    Object localObject2 = paramClass.getSuperclass();
    localObject1 = null;
    if (d((Class)localObject2))
    {
      if (b((Class)localObject2) == 1) {
        return 1;
      }
      localObject1 = new ArrayList((Collection)b.get(localObject2));
    }
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      localObject2 = localObject1;
      if (d(localClass))
      {
        if (b(localClass) == 1) {
          return 1;
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((List)localObject2).addAll((Collection)b.get(localClass));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      b.put(paramClass, localObject1);
      return 2;
    }
    return 1;
  }
  
  private static boolean d(Class<?> paramClass)
  {
    return (paramClass != null) && (bl.class.isAssignableFrom(paramClass));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bp
 * JD-Core Version:    0.7.0.1
 */