package android.arch.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ClassesInfoCache$CallbackInfo
{
  final Map mEventToHandlers;
  final Map mHandlerToEvent;
  
  ClassesInfoCache$CallbackInfo(Map paramMap)
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
  
  private static void invokeMethodsForEvent(List paramList, LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent, Object paramObject)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.lifecycle.ClassesInfoCache.CallbackInfo
 * JD-Core Version:    0.7.0.1
 */