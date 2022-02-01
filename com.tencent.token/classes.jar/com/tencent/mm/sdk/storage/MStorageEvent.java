package com.tencent.mm.sdk.storage;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class MStorageEvent<T, E>
{
  private int bY = 0;
  private final Hashtable<T, Object> bZ = new Hashtable();
  private final CopyOnWriteArraySet<E> ca = new CopyOnWriteArraySet();
  
  private Vector<T> e()
  {
    try
    {
      Vector localVector = new Vector();
      localVector.addAll(this.bZ.keySet());
      return localVector;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f()
  {
    Object localObject1 = e();
    if (localObject1 != null)
    {
      if (((Vector)localObject1).size() <= 0) {
        return;
      }
      HashMap localHashMap = new HashMap();
      Iterator localIterator1 = ((Vector)localObject1).iterator();
      while (localIterator1.hasNext())
      {
        Object localObject2 = localIterator1.next();
        Object localObject3 = this.bZ.get(localObject2);
        Iterator localIterator2 = this.ca.iterator();
        while (localIterator2.hasNext())
        {
          Object localObject4 = localIterator2.next();
          if ((localObject4 != null) && (localObject3 != null)) {
            if ((localObject3 instanceof Looper))
            {
              Looper localLooper = (Looper)localObject3;
              Handler localHandler = (Handler)localHashMap.get(localLooper);
              localObject1 = localHandler;
              if (localHandler == null)
              {
                localObject1 = new Handler(localLooper);
                localHashMap.put(localLooper, localObject1);
              }
              ((Handler)localObject1).post(new MStorageEvent.1(this, localObject2, localObject4));
            }
            else
            {
              processEvent(localObject2, localObject4);
            }
          }
        }
      }
      this.ca.clear();
    }
  }
  
  public void add(T paramT, Looper paramLooper)
  {
    try
    {
      if (!this.bZ.containsKey(paramT))
      {
        if (paramLooper != null)
        {
          this.bZ.put(paramT, paramLooper);
          return;
        }
        this.bZ.put(paramT, new Object());
      }
      return;
    }
    finally {}
  }
  
  public void doNotify()
  {
    if (!isLocked()) {
      f();
    }
  }
  
  public boolean event(E paramE)
  {
    return this.ca.add(paramE);
  }
  
  public boolean isLocked()
  {
    return this.bY > 0;
  }
  
  public void lock()
  {
    this.bY += 1;
  }
  
  protected abstract void processEvent(T paramT, E paramE);
  
  public void remove(T paramT)
  {
    try
    {
      this.bZ.remove(paramT);
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public void removeAll()
  {
    try
    {
      this.bZ.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void unlock()
  {
    this.bY -= 1;
    if (this.bY <= 0)
    {
      this.bY = 0;
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MStorageEvent
 * JD-Core Version:    0.7.0.1
 */