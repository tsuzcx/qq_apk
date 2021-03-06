package android.arch.lifecycle;

import android.support.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ClassesInfoCache
{
  private static final int CALL_TYPE_NO_ARG = 0;
  private static final int CALL_TYPE_PROVIDER = 1;
  private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
  static ClassesInfoCache sInstance = new ClassesInfoCache();
  private final Map<Class, CallbackInfo> mCallbackMap = new HashMap();
  private final Map<Class, Boolean> mHasLifecycleMethods = new HashMap();
  
  private CallbackInfo createInfo(Class paramClass, @Nullable Method[] paramArrayOfMethod)
  {
    Object localObject1 = paramClass.getSuperclass();
    HashMap localHashMap = new HashMap();
    if (localObject1 != null)
    {
      localObject1 = getInfo((Class)localObject1);
      if (localObject1 != null) {
        localHashMap.putAll(((CallbackInfo)localObject1).mHandlerToEvent);
      }
    }
    localObject1 = paramClass.getInterfaces();
    int j = localObject1.length;
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject2 = getInfo(localObject1[i]).mHandlerToEvent.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        verifyAndPutHandler(localHashMap, (MethodReference)((Map.Entry)localObject3).getKey(), (Lifecycle.Event)((Map.Entry)localObject3).getValue(), paramClass);
      }
      i += 1;
    }
    if (paramArrayOfMethod != null) {}
    boolean bool;
    for (;;)
    {
      int k = paramArrayOfMethod.length;
      bool = false;
      j = 0;
      for (;;)
      {
        if (j >= k) {
          break label350;
        }
        localObject1 = paramArrayOfMethod[j];
        localObject3 = (OnLifecycleEvent)((Method)localObject1).getAnnotation(OnLifecycleEvent.class);
        if (localObject3 != null) {
          break;
        }
        j += 1;
      }
      paramArrayOfMethod = getDeclaredMethods(paramClass);
    }
    Object localObject2 = ((Method)localObject1).getParameterTypes();
    if (localObject2.length > 0) {
      if (!localObject2[0].isAssignableFrom(LifecycleOwner.class)) {}
    }
    for (i = 1;; i = 0)
    {
      localObject3 = ((OnLifecycleEvent)localObject3).value();
      if (localObject2.length > 1)
      {
        if (!localObject2[1].isAssignableFrom(Lifecycle.Event.class)) {
          break label330;
        }
        if (localObject3 != Lifecycle.Event.ON_ANY) {
          break label320;
        }
        i = 2;
      }
      if (localObject2.length > 2) {
        break label340;
      }
      verifyAndPutHandler(localHashMap, new MethodReference(i, (Method)localObject1), (Lifecycle.Event)localObject3, paramClass);
      bool = true;
      break;
      throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
    }
    label320:
    throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
    label330:
    throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
    label340:
    throw new IllegalArgumentException("cannot have more than 2 params");
    label350:
    paramArrayOfMethod = new CallbackInfo(localHashMap);
    this.mCallbackMap.put(paramClass, paramArrayOfMethod);
    this.mHasLifecycleMethods.put(paramClass, Boolean.valueOf(bool));
    return paramArrayOfMethod;
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
  
  private void verifyAndPutHandler(Map<MethodReference, Lifecycle.Event> paramMap, MethodReference paramMethodReference, Lifecycle.Event paramEvent, Class paramClass)
  {
    Lifecycle.Event localEvent = (Lifecycle.Event)paramMap.get(paramMethodReference);
    if ((localEvent == null) || (paramEvent == localEvent))
    {
      if (localEvent == null) {
        paramMap.put(paramMethodReference, paramEvent);
      }
      return;
    }
    paramMap = paramMethodReference.mMethod;
    paramMethodReference = new StringBuilder();
    paramMethodReference.append("Method ");
    paramMethodReference.append(paramMap.getName());
    paramMethodReference.append(" in ");
    paramMethodReference.append(paramClass.getName());
    paramMethodReference.append(" already declared with different @OnLifecycleEvent value: previous value ");
    paramMethodReference.append(localEvent);
    paramMethodReference.append(", new value ");
    paramMethodReference.append(paramEvent);
    throw new IllegalArgumentException(paramMethodReference.toString());
  }
  
  CallbackInfo getInfo(Class paramClass)
  {
    CallbackInfo localCallbackInfo = (CallbackInfo)this.mCallbackMap.get(paramClass);
    if (localCallbackInfo != null) {
      return localCallbackInfo;
    }
    return createInfo(paramClass, null);
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
      if ((OnLifecycleEvent)arrayOfMethod[i].getAnnotation(OnLifecycleEvent.class) != null)
      {
        createInfo(paramClass, arrayOfMethod);
        return true;
      }
      i += 1;
    }
    this.mHasLifecycleMethods.put(paramClass, Boolean.valueOf(false));
    return false;
  }
  
  static class CallbackInfo
  {
    final Map<Lifecycle.Event, List<ClassesInfoCache.MethodReference>> mEventToHandlers;
    final Map<ClassesInfoCache.MethodReference, Lifecycle.Event> mHandlerToEvent;
    
    CallbackInfo(Map<ClassesInfoCache.MethodReference, Lifecycle.Event> paramMap)
    {
      this.mHandlerToEvent = paramMap;
      this.mEventToHandlers = new HashMap();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Lifecycle.Event localEvent = (Lifecycle.Event)localEntry.getValue();
        List localList = (List)this.mEventToHandlers.get(localEvent);
        paramMap = localList;
        if (localList == null)
        {
          paramMap = new ArrayList();
          this.mEventToHandlers.put(localEvent, paramMap);
        }
        paramMap.add(localEntry.getKey());
      }
    }
    
    private static void invokeMethodsForEvent(List<ClassesInfoCache.MethodReference> paramList, LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent, Object paramObject)
    {
      if (paramList != null)
      {
        int i = paramList.size() - 1;
        while (i >= 0)
        {
          ((ClassesInfoCache.MethodReference)paramList.get(i)).invokeCallback(paramLifecycleOwner, paramEvent, paramObject);
          i -= 1;
        }
      }
    }
    
    void invokeCallbacks(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent, Object paramObject)
    {
      invokeMethodsForEvent((List)this.mEventToHandlers.get(paramEvent), paramLifecycleOwner, paramEvent, paramObject);
      invokeMethodsForEvent((List)this.mEventToHandlers.get(Lifecycle.Event.ON_ANY), paramLifecycleOwner, paramEvent, paramObject);
    }
  }
  
  static class MethodReference
  {
    final int mCallType;
    final Method mMethod;
    
    MethodReference(int paramInt, Method paramMethod)
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
        paramObject = (MethodReference)paramObject;
      } while ((this.mCallType == paramObject.mCallType) && (this.mMethod.getName().equals(paramObject.mMethod.getName())));
      return false;
    }
    
    public int hashCode()
    {
      return this.mCallType * 31 + this.mMethod.getName().hashCode();
    }
    
    void invokeCallback(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent, Object paramObject)
    {
      try
      {
        switch (this.mCallType)
        {
        case 2: 
          this.mMethod.invoke(paramObject, new Object[] { paramLifecycleOwner, paramEvent });
          return;
        }
      }
      catch (InvocationTargetException paramLifecycleOwner)
      {
        throw new RuntimeException("Failed to call observer method", paramLifecycleOwner.getCause());
        this.mMethod.invoke(paramObject, new Object[] { paramLifecycleOwner });
        return;
      }
      catch (IllegalAccessException paramLifecycleOwner)
      {
        throw new RuntimeException(paramLifecycleOwner);
      }
      this.mMethod.invoke(paramObject, new Object[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     android.arch.lifecycle.ClassesInfoCache
 * JD-Core Version:    0.7.0.1
 */