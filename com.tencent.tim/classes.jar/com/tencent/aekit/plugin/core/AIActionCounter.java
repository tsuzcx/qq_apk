package com.tencent.aekit.plugin.core;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AIActionCounter
{
  private static Map<Integer, ActionCounter> actionCounterList = new Hashtable();
  private static Map<String, ActionCounter> commonActionCounterMap = new Hashtable();
  
  private static void clearAction(int paramInt)
  {
    ActionCounter localActionCounter = (ActionCounter)actionCounterList.get(Integer.valueOf(paramInt));
    if (localActionCounter != null) {
      localActionCounter.clear();
    }
  }
  
  public static void clearAction(AEDetectorType paramAEDetectorType)
  {
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[paramAEDetectorType.ordinal()])
    {
    }
    for (;;)
    {
      return;
      paramAEDetectorType = PTHandAttr.handTypes;
      int j = paramAEDetectorType.length;
      int i = 0;
      while (i < j)
      {
        clearAction(paramAEDetectorType[i]);
        i += 1;
      }
      continue;
      Iterator localIterator = commonActionCounterMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        if (str.startsWith(paramAEDetectorType.value)) {
          clearAction(str);
        }
      }
    }
  }
  
  private static void clearAction(String paramString)
  {
    paramString = (ActionCounter)commonActionCounterMap.get(paramString);
    if (paramString != null) {
      paramString.clear();
    }
  }
  
  public static void clearAll()
  {
    actionCounterList.clear();
    commonActionCounterMap.clear();
  }
  
  public static Map<Integer, Integer> getActions(AEDetectorType paramAEDetectorType)
  {
    HashMap localHashMap = new HashMap();
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[paramAEDetectorType.ordinal()])
    {
    default: 
      return localHashMap;
    }
    paramAEDetectorType = PTHandAttr.handTypes;
    int j = paramAEDetectorType.length;
    int i = 0;
    label48:
    int k;
    if (i < j)
    {
      k = paramAEDetectorType[i];
      ActionCounter localActionCounter = (ActionCounter)actionCounterList.get(Integer.valueOf(k));
      if (localActionCounter == null) {
        break label106;
      }
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(localActionCounter.count));
    }
    for (;;)
    {
      i += 1;
      break label48;
      break;
      label106:
      localHashMap.put(Integer.valueOf(k), Integer.valueOf(0));
    }
  }
  
  public static Map<String, Integer> getCommonActions(AEDetectorType paramAEDetectorType)
  {
    HashMap localHashMap = new HashMap();
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[paramAEDetectorType.ordinal()])
    {
    }
    for (;;)
    {
      return localHashMap;
      Iterator localIterator = commonActionCounterMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getKey();
        if (str.startsWith(paramAEDetectorType.name()))
        {
          str = str.substring(paramAEDetectorType.value.length());
          localObject = (ActionCounter)((Map.Entry)localObject).getValue();
          if (localObject != null) {
            localHashMap.put(str, Integer.valueOf(((ActionCounter)localObject).count));
          } else {
            localHashMap.put(str, Integer.valueOf(0));
          }
        }
      }
    }
  }
  
  private static void lockAction(int paramInt)
  {
    ActionCounter localActionCounter = (ActionCounter)actionCounterList.get(Integer.valueOf(paramInt));
    if (localActionCounter != null) {
      localActionCounter.lockCounter();
    }
  }
  
  public static void lockAction(AEDetectorType paramAEDetectorType)
  {
    switch (AIActionCounter.1.$SwitchMap$com$tencent$aekit$plugin$core$AEDetectorType[paramAEDetectorType.ordinal()])
    {
    }
    for (;;)
    {
      return;
      paramAEDetectorType = PTHandAttr.handTypes;
      int j = paramAEDetectorType.length;
      int i = 0;
      while (i < j)
      {
        lockAction(paramAEDetectorType[i]);
        i += 1;
      }
      continue;
      Iterator localIterator = commonActionCounterMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        if (str.startsWith(paramAEDetectorType.name())) {
          lockAction(str);
        }
      }
    }
  }
  
  private static void lockAction(String paramString)
  {
    paramString = (ActionCounter)commonActionCounterMap.get(paramString);
    if (paramString != null) {
      paramString.lockCounter();
    }
  }
  
  public static void updateAction(int paramInt)
  {
    ActionCounter localActionCounter2 = (ActionCounter)actionCounterList.get(Integer.valueOf(paramInt));
    ActionCounter localActionCounter1 = localActionCounter2;
    if (localActionCounter2 == null) {
      localActionCounter1 = new ActionCounter(0, -1L);
    }
    if (!localActionCounter1.locked)
    {
      long l = System.currentTimeMillis();
      if (l - localActionCounter1.updateTime > 1000L)
      {
        localActionCounter1.count += 1;
        localActionCounter1.updateTime = l;
      }
      actionCounterList.put(Integer.valueOf(paramInt), localActionCounter1);
    }
  }
  
  public static void updateAction(String paramString)
  {
    ActionCounter localActionCounter2 = (ActionCounter)commonActionCounterMap.get(paramString);
    ActionCounter localActionCounter1 = localActionCounter2;
    if (localActionCounter2 == null) {
      localActionCounter1 = new ActionCounter(0, -1L);
    }
    if (!localActionCounter1.locked)
    {
      long l = System.currentTimeMillis();
      if (l - localActionCounter1.updateTime > 1000L)
      {
        localActionCounter1.count += 1;
        localActionCounter1.updateTime = l;
      }
      commonActionCounterMap.put(paramString, localActionCounter1);
    }
  }
  
  static class ActionCounter
  {
    public int count;
    public boolean locked = false;
    public long updateTime;
    
    public ActionCounter(int paramInt, long paramLong)
    {
      this.count = paramInt;
      this.updateTime = paramLong;
    }
    
    public void clear()
    {
      this.count = 0;
      this.updateTime = 0L;
      this.locked = false;
    }
    
    public void lockCounter()
    {
      this.locked = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.AIActionCounter
 * JD-Core Version:    0.7.0.1
 */