package com.tencent.mm.sdk.platformtools;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import junit.framework.Assert;

public final class ObserverPool
{
  private final HashMap<String, LinkedList<Listener>> ay = new HashMap();
  
  public final boolean add(String paramString, Listener paramListener)
  {
    try
    {
      Assert.assertNotNull(paramListener);
      LinkedList localLinkedList2 = (LinkedList)this.ay.get(paramString);
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        this.ay.put(paramString, localLinkedList1);
      }
      if (localLinkedList1.contains(paramListener))
      {
        Log.e("MicroMsg.ObserverPool", "Cannot add the same listener twice. EventId: %s, Stack: %s.", new Object[] { paramString, Util.getStack() });
        return false;
      }
      boolean bool = localLinkedList1.add(paramListener);
      return bool;
    }
    finally {}
  }
  
  public final void asyncPublish(Event paramEvent)
  {
    asyncPublish(paramEvent, Looper.myLooper());
  }
  
  public final void asyncPublish(Event paramEvent, Looper paramLooper)
  {
    Assert.assertNotNull(paramLooper);
    new Handler(paramLooper).post(new ObserverPool.2(this, paramEvent));
  }
  
  public final boolean publish(Event paramEvent)
  {
    Assert.assertNotNull(paramEvent);
    Object localObject = paramEvent.getId();
    LinkedList localLinkedList = (LinkedList)this.ay.get(localObject);
    int i = 0;
    if (localLinkedList == null)
    {
      Log.w("MicroMsg.ObserverPool", "No listener for this event %s, Stack: %s.", new Object[] { localObject, Util.getStack() });
      return false;
    }
    if ((paramEvent.getFlag() & 0x1) != 0) {
      i = 1;
    }
    if (i != 0) {
      Collections.sort(localLinkedList, new ObserverPool.1(this));
    }
    localObject = localLinkedList.iterator();
    while ((((Iterator)localObject).hasNext()) && ((!((Listener)((Iterator)localObject).next()).callback(paramEvent)) || (i == 0))) {}
    paramEvent.onComplete();
    return true;
  }
  
  public final void release()
  {
    try
    {
      this.ay.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean remove(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 31	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   6: aload_0
    //   7: getfield 22	com/tencent/mm/sdk/platformtools/ObserverPool:ay	Ljava/util/HashMap;
    //   10: aload_1
    //   11: invokevirtual 142	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +9 -> 25
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: iconst_0
    //   26: istore_2
    //   27: goto -6 -> 21
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	ObserverPool
    //   0	35	1	paramString	String
    //   20	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	15	30	finally
  }
  
  public final boolean remove(String paramString, Listener paramListener)
  {
    for (;;)
    {
      try
      {
        Assert.assertNotNull(paramListener);
        LinkedList localLinkedList = (LinkedList)this.ay.get(paramString);
        if (localLinkedList != null)
        {
          bool = localLinkedList.remove(paramListener);
          if (!bool) {
            Log.e("MicroMsg.ObserverPool", "Listener isnot existed in the map. EventId: %s, Stack: %s.", new Object[] { paramString, Util.getStack() });
          }
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ObserverPool profile:\n");
    localStringBuilder.append("\tEvent number: ");
    localStringBuilder.append(this.ay.size());
    localStringBuilder.append("\n");
    localStringBuilder.append("\tDetail:\n");
    Iterator localIterator = this.ay.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append("\t");
      localStringBuilder.append(str);
      localStringBuilder.append(" : ");
      localStringBuilder.append(((LinkedList)this.ay.get(str)).size());
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("End...");
    return localStringBuilder.toString();
  }
  
  public static class Event
  {
    public static final int FLAG_ORDER_EXE = 1;
    private final String aB;
    private int aC;
    public final Bundle data = new Bundle();
    
    public Event(String paramString)
    {
      Assert.assertNotNull(paramString);
      this.aB = paramString;
    }
    
    public int getFlag()
    {
      return this.aC;
    }
    
    public String getId()
    {
      return this.aB;
    }
    
    public void onComplete() {}
    
    public Event setFlag(int paramInt)
    {
      this.aC = paramInt;
      return this;
    }
  }
  
  public static abstract class Listener
  {
    private final int priority;
    
    public Listener()
    {
      this.priority = 0;
    }
    
    public Listener(int paramInt)
    {
      this.priority = paramInt;
    }
    
    public abstract boolean callback(ObserverPool.Event paramEvent);
    
    public int getPriority()
    {
      return this.priority;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ObserverPool
 * JD-Core Version:    0.7.0.1
 */