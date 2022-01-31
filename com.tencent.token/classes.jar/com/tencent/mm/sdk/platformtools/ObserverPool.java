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
  
  /* Error */
  public final boolean add(String paramString, Listener paramListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 31	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   6: aload_0
    //   7: getfield 22	com/tencent/mm/sdk/platformtools/ObserverPool:ay	Ljava/util/HashMap;
    //   10: aload_1
    //   11: invokevirtual 35	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 37	java/util/LinkedList
    //   17: astore 5
    //   19: aload 5
    //   21: astore 4
    //   23: aload 5
    //   25: ifnonnull +23 -> 48
    //   28: new 37	java/util/LinkedList
    //   31: dup
    //   32: invokespecial 38	java/util/LinkedList:<init>	()V
    //   35: astore 4
    //   37: aload_0
    //   38: getfield 22	com/tencent/mm/sdk/platformtools/ObserverPool:ay	Ljava/util/HashMap;
    //   41: aload_1
    //   42: aload 4
    //   44: invokevirtual 42	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: aload 4
    //   50: aload_2
    //   51: invokevirtual 46	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   54: ifeq +30 -> 84
    //   57: ldc 48
    //   59: ldc 50
    //   61: iconst_2
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_1
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: invokestatic 56	com/tencent/mm/sdk/platformtools/Util:getStack	()Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: iconst_0
    //   79: istore_3
    //   80: aload_0
    //   81: monitorexit
    //   82: iload_3
    //   83: ireturn
    //   84: aload 4
    //   86: aload_2
    //   87: invokevirtual 64	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   90: istore_3
    //   91: goto -11 -> 80
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	ObserverPool
    //   0	99	1	paramString	String
    //   0	99	2	paramListener	Listener
    //   79	12	3	bool	boolean
    //   21	64	4	localLinkedList1	LinkedList
    //   17	7	5	localLinkedList2	LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	19	94	finally
    //   28	48	94	finally
    //   48	78	94	finally
    //   84	91	94	finally
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
    int i = 0;
    Assert.assertNotNull(paramEvent);
    Object localObject = paramEvent.getId();
    LinkedList localLinkedList = (LinkedList)this.ay.get(localObject);
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
    localStringBuilder.append("\tEvent number: ").append(this.ay.size()).append("\n");
    localStringBuilder.append("\tDetail:\n");
    Iterator localIterator = this.ay.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append("\t").append(str).append(" : ").append(((LinkedList)this.ay.get(str)).size()).append("\n");
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