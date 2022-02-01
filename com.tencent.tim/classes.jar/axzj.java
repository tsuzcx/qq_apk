import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class axzj
  implements axzc
{
  static final Map<Class, axzj.a> qQ = new HashMap();
  private final axzj.a a;
  private final Object mWrapped;
  
  axzj(Object paramObject)
  {
    this.mWrapped = paramObject;
    this.a = a(this.mWrapped.getClass());
  }
  
  private static axzj.a a(Class paramClass)
  {
    axzj.a locala = (axzj.a)qQ.get(paramClass);
    if (locala != null) {
      return locala;
    }
    return b(paramClass);
  }
  
  private void a(axzj.a parama, axzf paramaxzf, axzd.a parama1)
  {
    a((List)parama.mEventToHandlers.get(parama1), paramaxzf, parama1);
    a((List)parama.mEventToHandlers.get(axzd.a.g), paramaxzf, parama1);
  }
  
  private void a(axzj.b paramb, axzf paramaxzf, axzd.a parama)
  {
    try
    {
      switch (paramb.mCallType)
      {
      case 0: 
        paramb.mMethod.invoke(this.mWrapped, new Object[0]);
        return;
      }
    }
    catch (InvocationTargetException paramb)
    {
      throw new RuntimeException("Failed to call observer method", paramb.getCause());
      paramb.mMethod.invoke(this.mWrapped, new Object[] { paramaxzf });
      return;
    }
    catch (IllegalAccessException paramb)
    {
      throw new RuntimeException(paramb);
    }
    paramb.mMethod.invoke(this.mWrapped, new Object[] { paramaxzf, parama });
    return;
  }
  
  private void a(List<axzj.b> paramList, axzf paramaxzf, axzd.a parama)
  {
    if (paramList != null)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        a((axzj.b)paramList.get(i), paramaxzf, parama);
        i -= 1;
      }
    }
  }
  
  private static void a(Map<axzj.b, axzd.a> paramMap, axzj.b paramb, axzd.a parama, Class paramClass)
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
  
  private static axzj.a b(Class paramClass)
  {
    Object localObject2 = paramClass.getSuperclass();
    Object localObject1 = new HashMap();
    if (localObject2 != null)
    {
      localObject2 = a((Class)localObject2);
      if (localObject2 != null) {
        ((Map)localObject1).putAll(((axzj.a)localObject2).mHandlerToEvent);
      }
    }
    localObject2 = paramClass.getDeclaredMethods();
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    Object localObject3;
    Object localObject4;
    while (i < j)
    {
      localObject3 = a(arrayOfClass[i]).mHandlerToEvent.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        a((Map)localObject1, (axzj.b)((Map.Entry)localObject4).getKey(), (axzd.a)((Map.Entry)localObject4).getValue(), paramClass);
      }
      i += 1;
    }
    int k = localObject2.length;
    j = 0;
    for (;;)
    {
      if (j < k)
      {
        arrayOfClass = localObject2[j];
        localObject3 = (axzi)arrayOfClass.getAnnotation(axzi.class);
        if (localObject3 == null)
        {
          j += 1;
        }
        else
        {
          localObject4 = arrayOfClass.getParameterTypes();
          if (localObject4.length <= 0) {
            break label349;
          }
          if (!localObject4[0].isAssignableFrom(axzf.class)) {
            throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
          }
        }
      }
    }
    label349:
    for (i = 1;; i = 0)
    {
      int m = ((axzi)localObject3).value();
      if (localObject4.length > 1)
      {
        if (!localObject4[1].isAssignableFrom(axzd.a.class)) {
          throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
        }
        if (m != 6) {
          throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
        }
        i = 2;
      }
      if (localObject4.length > 2) {
        throw new IllegalArgumentException("cannot have more than 2 params");
      }
      a((Map)localObject1, new axzj.b(i, arrayOfClass), axzd.a.a(m), paramClass);
      break;
      localObject1 = new axzj.a((Map)localObject1);
      qQ.put(paramClass, localObject1);
      return localObject1;
    }
  }
  
  public void a(axzf paramaxzf, axzd.a parama)
  {
    a(this.a, paramaxzf, parama);
  }
  
  static class a
  {
    final Map<axzd.a, List<axzj.b>> mEventToHandlers;
    final Map<axzj.b, axzd.a> mHandlerToEvent;
    
    a(Map<axzj.b, axzd.a> paramMap)
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
 * Qualified Name:     axzj
 * JD-Core Version:    0.7.0.1
 */