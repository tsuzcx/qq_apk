package com.tencent.mobileqq.ark;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArkAppCenterEvent
{
  private static DictObservers a = new DictObservers();
  
  public static void a(int paramInt, String paramString, Object paramObject)
  {
    Object localObject = (Observers)a.get(paramString);
    if (localObject != null)
    {
      localObject = ((Observers)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (localEntry.getValue() != null) {
          ((a)localEntry.getValue()).b(paramInt, paramString, paramObject);
        }
      }
    }
  }
  
  public static class DictObservers
    extends HashMap<String, ArkAppCenterEvent.Observers>
  {}
  
  public static class Observers
    extends HashMap<String, ArkAppCenterEvent.a>
  {}
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, String paramString, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenterEvent
 * JD-Core Version:    0.7.0.1
 */