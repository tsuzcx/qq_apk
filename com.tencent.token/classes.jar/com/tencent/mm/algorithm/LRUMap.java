package com.tencent.mm.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LRUMap<K, O>
{
  private Map<K, LRUMap<K, O>.TimeVal<O>> c = null;
  private int d;
  private int e;
  private PreRemoveCallback<K, O> f = null;
  
  public LRUMap(int paramInt)
  {
    this(paramInt, null);
  }
  
  public LRUMap(int paramInt, PreRemoveCallback<K, O> paramPreRemoveCallback)
  {
    this.d = paramInt;
    this.e = 0;
    this.f = paramPreRemoveCallback;
    this.c = new HashMap();
  }
  
  public boolean check(K paramK)
  {
    return this.c.containsKey(paramK);
  }
  
  public boolean checkAndUpTime(K paramK)
  {
    if (this.c.containsKey(paramK))
    {
      ((TimeVal)this.c.get(paramK)).UpTime();
      return true;
    }
    return false;
  }
  
  public void clear()
  {
    this.c.clear();
  }
  
  public void clear(OnClearListener<K, O> paramOnClearListener)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (paramOnClearListener != null)
      {
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          paramOnClearListener.onClear(localEntry.getKey(), ((TimeVal)localEntry.getValue()).obj);
        }
      }
      this.c.clear();
    }
  }
  
  public O get(K paramK)
  {
    return getAndUptime(paramK);
  }
  
  public O getAndUptime(K paramK)
  {
    paramK = (TimeVal)this.c.get(paramK);
    if (paramK == null) {
      return null;
    }
    paramK.UpTime();
    return paramK.obj;
  }
  
  public void remove(K paramK)
  {
    if (!this.c.containsKey(paramK)) {
      return;
    }
    PreRemoveCallback localPreRemoveCallback = this.f;
    if (localPreRemoveCallback != null) {
      localPreRemoveCallback.preRemoveCallback(paramK, ((TimeVal)this.c.get(paramK)).obj);
    }
    this.c.remove(paramK);
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
  
  public void update(K paramK, O paramO)
  {
    if ((TimeVal)this.c.get(paramK) == null)
    {
      paramO = new TimeVal(paramO);
      this.c.put(paramK, paramO);
      if (this.c.size() > this.d)
      {
        paramK = new ArrayList(this.c.entrySet());
        Collections.sort(paramK, new LRUMap.1(this));
        int j = this.e;
        int i = j;
        if (j <= 0)
        {
          j = this.d / 10;
          i = j;
          if (j <= 0) {
            i = 1;
          }
        }
        paramK = paramK.iterator();
        do
        {
          if (!paramK.hasNext()) {
            break;
          }
          remove(((Map.Entry)paramK.next()).getKey());
          j = i - 1;
          i = j;
        } while (j > 0);
      }
      return;
    }
    ((TimeVal)this.c.get(paramK)).UpTime();
    ((TimeVal)this.c.get(paramK)).obj = paramO;
  }
  
  public static abstract interface OnClearListener<K, O>
  {
    public abstract void onClear(K paramK, O paramO);
  }
  
  public static abstract interface PreRemoveCallback<K, O>
  {
    public abstract void preRemoveCallback(K paramK, O paramO);
  }
  
  public class TimeVal<OO>
  {
    public OO obj;
    public Long t;
    
    public TimeVal()
    {
      Object localObject;
      this.obj = localObject;
      UpTime();
    }
    
    public void UpTime()
    {
      this.t = Long.valueOf(System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.algorithm.LRUMap
 * JD-Core Version:    0.7.0.1
 */