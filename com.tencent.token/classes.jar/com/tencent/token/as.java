package com.tencent.token;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class as
{
  public static as a = new as();
  private final Map<Class, a> b = new HashMap();
  private final Map<Class, Boolean> c = new HashMap();
  
  private a a(Class paramClass, Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = b((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((a)localObject1).b);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < j)
    {
      localObject2 = b(localObject1[i]).b.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (b)((Map.Entry)localObject3).getKey(), (av.a)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod == null) {
      paramArrayOfMethod = c(paramClass);
    }
    int k = paramArrayOfMethod.length;
    j = 0;
    boolean bool = false;
    while (j < k)
    {
      localObject1 = paramArrayOfMethod[j];
      localObject3 = (bf)((Method)localObject1).getAnnotation(bf.class);
      if (localObject3 != null)
      {
        localObject2 = ((Method)localObject1).getParameterTypes();
        if (localObject2.length > 0)
        {
          if (localObject2[0].isAssignableFrom(ay.class)) {
            i = 1;
          } else {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
        else {
          i = 0;
        }
        localObject3 = ((bf)localObject3).a();
        if (localObject2.length > 1) {
          if (localObject2[1].isAssignableFrom(av.a.class))
          {
            if (localObject3 == av.a.ON_ANY) {
              i = 2;
            } else {
              throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
            }
          }
          else {
            throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
          }
        }
        if (localObject2.length <= 2)
        {
          a(localHashMap, new b(i, (Method)localObject1), (av.a)localObject3, paramClass);
          bool = true;
        }
        else
        {
          throw new IllegalArgumentException("cannot have more than 2 params");
        }
      }
      j += 1;
    }
    paramArrayOfMethod = new a(localHashMap);
    this.b.put(paramClass, paramArrayOfMethod);
    this.c.put(paramClass, Boolean.valueOf(bool));
    return paramArrayOfMethod;
  }
  
  private static void a(Map<b, av.a> paramMap, b paramb, av.a parama, Class paramClass)
  {
    av.a locala = (av.a)paramMap.get(paramb);
    if ((locala != null) && (parama != locala))
    {
      paramMap = paramb.b;
      paramb = new StringBuilder("Method ");
      paramb.append(paramMap.getName());
      paramb.append(" in ");
      paramb.append(paramClass.getName());
      paramb.append(" already declared with different @OnLifecycleEvent value: previous value ");
      paramb.append(locala);
      paramb.append(", new value ");
      paramb.append(parama);
      throw new IllegalArgumentException(paramb.toString());
    }
    if (locala == null) {
      paramMap.put(paramb, parama);
    }
  }
  
  private static Method[] c(Class paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethods();
      return paramClass;
    }
    catch (NoClassDefFoundError paramClass)
    {
      throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", paramClass);
    }
  }
  
  final boolean a(Class paramClass)
  {
    if (this.c.containsKey(paramClass)) {
      return ((Boolean)this.c.get(paramClass)).booleanValue();
    }
    Method[] arrayOfMethod = c(paramClass);
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      if ((bf)arrayOfMethod[i].getAnnotation(bf.class) != null)
      {
        a(paramClass, arrayOfMethod);
        return true;
      }
      i += 1;
    }
    this.c.put(paramClass, Boolean.FALSE);
    return false;
  }
  
  public final a b(Class paramClass)
  {
    a locala = (a)this.b.get(paramClass);
    if (locala != null) {
      return locala;
    }
    return a(paramClass, null);
  }
  
  public static final class a
  {
    public final Map<av.a, List<as.b>> a;
    final Map<as.b, av.a> b;
    
    a(Map<as.b, av.a> paramMap)
    {
      this.b = paramMap;
      this.a = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        av.a locala = (av.a)localEntry.getValue();
        List localList = (List)this.a.get(locala);
        paramMap = localList;
        if (localList == null)
        {
          paramMap = new ArrayList();
          this.a.put(locala, paramMap);
        }
        paramMap.add(localEntry.getKey());
      }
    }
    
    public static void a(List<as.b> paramList, ay paramay, av.a parama, Object paramObject)
    {
      int i;
      as.b localb;
      if (paramList != null)
      {
        i = paramList.size() - 1;
        if (i >= 0) {
          localb = (as.b)paramList.get(i);
        }
      }
      for (;;)
      {
        try
        {
          switch (localb.a)
          {
          case 2: 
            localb.b.invoke(paramObject, new Object[] { paramay, parama });
            break;
          case 1: 
            localb.b.invoke(paramObject, new Object[] { paramay });
            break;
          case 0: 
            localb.b.invoke(paramObject, new Object[0]);
            i -= 1;
          }
        }
        catch (IllegalAccessException paramList)
        {
          throw new RuntimeException(paramList);
        }
        catch (InvocationTargetException paramList)
        {
          throw new RuntimeException("Failed to call observer method", paramList.getCause());
        }
        return;
      }
    }
  }
  
  static final class b
  {
    final int a;
    final Method b;
    
    b(int paramInt, Method paramMethod)
    {
      this.a = paramInt;
      this.b = paramMethod;
      this.b.setAccessible(true);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (b)paramObject;
        return (this.a == paramObject.a) && (this.b.getName().equals(paramObject.b.getName()));
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.a * 31 + this.b.getName().hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.as
 * JD-Core Version:    0.7.0.1
 */