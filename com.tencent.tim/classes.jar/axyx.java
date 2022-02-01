import android.support.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class axyx
{
  static axyx a = new axyx();
  private final Map<Class, axyx.a> mCallbackMap = new HashMap();
  private final Map<Class, Boolean> mHasLifecycleMethods = new HashMap();
  
  private axyx.a a(Class paramClass, @Nullable Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = a((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((axyx.a)localObject1).mHandlerToEvent);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = a(localObject1[i]).mHandlerToEvent.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        a(localHashMap, (axyx.b)((Map.Entry)localObject3).getKey(), (axzd.a)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod != null) {}
    boolean bool;
    for (;;)
    {
      int k = paramArrayOfMethod.length;
      j = 0;
      bool = false;
      for (;;)
      {
        if (j >= k) {
          break label347;
        }
        localObject1 = paramArrayOfMethod[j];
        localObject2 = (axzi)((Method)localObject1).getAnnotation(axzi.class);
        if (localObject2 != null) {
          break;
        }
        j += 1;
      }
      paramArrayOfMethod = getDeclaredMethods(paramClass);
    }
    Object localObject3 = ((Method)localObject1).getParameterTypes();
    if (localObject3.length > 0) {
      if (!localObject3[0].isAssignableFrom(axzf.class)) {
        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
      }
    }
    for (i = 1;; i = 0)
    {
      int m = ((axzi)localObject2).value();
      if (localObject3.length > 1)
      {
        if (!localObject3[1].isAssignableFrom(axzd.a.class)) {
          throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
        }
        if (m != 6) {
          throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
        }
        i = 2;
      }
      if (localObject3.length > 2) {
        throw new IllegalArgumentException("cannot have more than 2 params");
      }
      a(localHashMap, new axyx.b(i, (Method)localObject1), axzd.a.a(m), paramClass);
      bool = true;
      break;
      label347:
      paramArrayOfMethod = new axyx.a(localHashMap);
      this.mCallbackMap.put(paramClass, paramArrayOfMethod);
      this.mHasLifecycleMethods.put(paramClass, Boolean.valueOf(bool));
      return paramArrayOfMethod;
    }
  }
  
  private void a(Map<axyx.b, axzd.a> paramMap, axyx.b paramb, axzd.a parama, Class paramClass)
  {
    axzd.a locala = (axzd.a)paramMap.get(paramb);
    if ((locala != null) && (parama != locala))
    {
      paramMap = paramb.mMethod;
      throw new IllegalArgumentException("Method " + paramMap.getName() + " in " + paramClass.getName() + " already declared with different @OnLifecycleEvent value: previous value " + locala + ", new value " + parama);
    }
    if (locala == null) {
      paramMap.put(paramb, parama);
    }
  }
  
  private Method[] getDeclaredMethods(Class paramClass)
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
  
  axyx.a a(Class paramClass)
  {
    axyx.a locala = (axyx.a)this.mCallbackMap.get(paramClass);
    if (locala != null) {
      return locala;
    }
    return a(paramClass, null);
  }
  
  boolean hasLifecycleMethods(Class paramClass)
  {
    if (this.mHasLifecycleMethods.containsKey(paramClass)) {
      return ((Boolean)this.mHasLifecycleMethods.get(paramClass)).booleanValue();
    }
    Method[] arrayOfMethod = getDeclaredMethods(paramClass);
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      if ((axzi)arrayOfMethod[i].getAnnotation(axzi.class) != null)
      {
        a(paramClass, arrayOfMethod);
        return true;
      }
      i += 1;
    }
    this.mHasLifecycleMethods.put(paramClass, Boolean.valueOf(false));
    return false;
  }
  
  static class a
  {
    final Map<axzd.a, List<axyx.b>> mEventToHandlers;
    final Map<axyx.b, axzd.a> mHandlerToEvent;
    
    a(Map<axyx.b, axzd.a> paramMap)
    {
      this.mHandlerToEvent = paramMap;
      this.mEventToHandlers = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        axzd.a locala = (axzd.a)localEntry.getValue();
        List localList = (List)this.mEventToHandlers.get(locala);
        paramMap = localList;
        if (localList == null)
        {
          paramMap = new ArrayList();
          this.mEventToHandlers.put(locala, paramMap);
        }
        paramMap.add(localEntry.getKey());
      }
    }
  }
  
  static class b
  {
    final int mCallType;
    final Method mMethod;
    
    b(int paramInt, Method paramMethod)
    {
      this.mCallType = paramInt;
      this.mMethod = paramMethod;
      this.mMethod.setAccessible(true);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (b)paramObject;
      } while ((this.mCallType == paramObject.mCallType) && (this.mMethod.getName().equals(paramObject.mMethod.getName())));
      return false;
    }
    
    public int hashCode()
    {
      return this.mCallType * 31 + this.mMethod.getName().hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyx
 * JD-Core Version:    0.7.0.1
 */