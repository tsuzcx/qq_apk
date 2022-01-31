package com.tencent.mm.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LRUMap
{
  private Map c = null;
  private int d;
  private int e;
  private LRUMap.PreRemoveCallback f = null;
  
  public LRUMap(int paramInt)
  {
    this(paramInt, null);
  }
  
  public LRUMap(int paramInt, LRUMap.PreRemoveCallback paramPreRemoveCallback)
  {
    this.d = paramInt;
    this.e = 0;
    this.f = paramPreRemoveCallback;
    this.c = new HashMap();
  }
  
  public boolean check(Object paramObject)
  {
    return this.c.containsKey(paramObject);
  }
  
  public boolean checkAndUpTime(Object paramObject)
  {
    if (this.c.containsKey(paramObject))
    {
      ((LRUMap.TimeVal)this.c.get(paramObject)).UpTime();
      return true;
    }
    return false;
  }
  
  public void clear()
  {
    this.c.clear();
  }
  
  public void clear(LRUMap.OnClearListener paramOnClearListener)
  {
    if (this.c != null)
    {
      if (paramOnClearListener != null)
      {
        Iterator localIterator = this.c.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramOnClearListener.onClear(localEntry.getKey(), ((LRUMap.TimeVal)localEntry.getValue()).obj);
        }
      }
      this.c.clear();
    }
  }
  
  public Object get(Object paramObject)
  {
    return getAndUptime(paramObject);
  }
  
  public Object getAndUptime(Object paramObject)
  {
    paramObject = (LRUMap.TimeVal)this.c.get(paramObject);
    if (paramObject == null) {
      return null;
    }
    paramObject.UpTime();
    return paramObject.obj;
  }
  
  public void remove(Object paramObject)
  {
    if (!this.c.containsKey(paramObject)) {
      return;
    }
    if (this.f != null) {
      this.f.preRemoveCallback(paramObject, ((LRUMap.TimeVal)this.c.get(paramObject)).obj);
    }
    this.c.remove(paramObject);
  }
  
  public void setMaxSize(int paramInt)
  {
    if (paramInt > 0) {
      this.d = paramInt;
    }
  }
  
  public void setPerDeleteSize(int paramInt)
  {
    if (paramInt > 0) {
      this.e = paramInt;
    }
  }
  
  public int size()
  {
    return this.c.size();
  }
  
  public void update(Object paramObject1, Object paramObject2)
  {
    int i;
    if ((LRUMap.TimeVal)this.c.get(paramObject1) == null)
    {
      paramObject2 = new LRUMap.TimeVal(this, paramObject2);
      this.c.put(paramObject1, paramObject2);
      if (this.c.size() > this.d)
      {
        paramObject1 = new ArrayList(this.c.entrySet());
        Collections.sort(paramObject1, new LRUMap.1(this));
        if (this.e > 0) {
          break label150;
        }
        int j = this.d / 10;
        i = j;
        if (j <= 0) {
          i = 1;
        }
        paramObject1 = paramObject1.iterator();
      }
    }
    for (;;)
    {
      if (paramObject1.hasNext())
      {
        remove(((Map.Entry)paramObject1.next()).getKey());
        i -= 1;
        if (i > 0) {}
      }
      else
      {
        return;
        label150:
        i = this.e;
        break;
        ((LRUMap.TimeVal)this.c.get(paramObject1)).UpTime();
        ((LRUMap.TimeVal)this.c.get(paramObject1)).obj = paramObject2;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.algorithm.LRUMap
 * JD-Core Version:    0.7.0.1
 */