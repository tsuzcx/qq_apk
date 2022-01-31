package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.c;
import com.tencent.beacon.a.e;
import com.tencent.beacon.d.b;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
  implements g
{
  private Context a;
  private boolean b = false;
  private List<h> c;
  private Runnable d = new Runnable()
  {
    public final void run()
    {
      a.this.a();
    }
  };
  private Runnable e = new Runnable()
  {
    public final void run()
    {
      com.tencent.beacon.d.a.f(" maxN to up}", new Object[0]);
      try
      {
        m.g();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  };
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.c = new ArrayList(25);
  }
  
  /* Error */
  private List<h> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/beacon/event/a:c	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 44	com/tencent/beacon/event/a:c	Ljava/util/List;
    //   13: invokeinterface 52 1 0
    //   18: ifle +12 -> 30
    //   21: aload_0
    //   22: invokespecial 55	com/tencent/beacon/event/a:c	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +9 -> 36
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: new 39	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 56	java/util/ArrayList:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 44	com/tencent/beacon/event/a:c	Ljava/util/List;
    //   49: invokeinterface 60 2 0
    //   54: pop
    //   55: aload_0
    //   56: getfield 44	com/tencent/beacon/event/a:c	Ljava/util/List;
    //   59: invokeinterface 63 1 0
    //   64: new 65	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 67
    //   70: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_2
    //   74: invokeinterface 52 1 0
    //   79: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 83	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: goto -60 -> 32
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   25	2	1	bool	boolean
    //   31	43	2	localObject1	Object
    //   95	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	95	finally
    //   36	92	95	finally
  }
  
  private boolean c()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void a()
  {
    if (!c()) {
      com.tencent.beacon.d.a.c(" err su 1R}", new Object[0]);
    }
    List localList;
    do
    {
      return;
      localList = b();
    } while ((localList == null) || (localList.size() <= 0) || (!e.a(this.a, localList)));
    long l2 = m.d().k().e();
    long l1 = l2;
    if (b.a(this.a))
    {
      com.tencent.beacon.d.a.e(" onwifi, so half mSZ} " + l2, new Object[0]);
      l1 = l2 / 2L;
    }
    int i;
    if (e.m(this.a) >= l1)
    {
      i = 1;
      label121:
      if (i == 0) {
        break label185;
      }
      if (com.tencent.beacon.upload.h.a(this.a).a() < 5) {
        break label187;
      }
      com.tencent.beacon.d.a.c(" doUpload request failed 5 times sleep...}", new Object[0]);
      c.a().a(this.e, 600000L);
      com.tencent.beacon.upload.h.a(this.a).a(0);
    }
    for (;;)
    {
      com.tencent.beacon.d.a.e(" max Up", new Object[0]);
      return;
      i = 0;
      break label121;
      label185:
      break;
      label187:
      this.e.run();
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/beacon/event/a:b	Z
    //   6: iload_1
    //   7: if_icmpeq +41 -> 48
    //   10: aload_0
    //   11: iload_1
    //   12: putfield 27	com/tencent/beacon/event/a:b	Z
    //   15: iload_1
    //   16: ifeq +35 -> 51
    //   19: invokestatic 101	com/tencent/beacon/event/m:d	()Lcom/tencent/beacon/event/m;
    //   22: invokevirtual 105	com/tencent/beacon/event/m:k	()Lcom/tencent/beacon/event/d;
    //   25: invokevirtual 158	com/tencent/beacon/event/d:d	()I
    //   28: sipush 1000
    //   31: imul
    //   32: i2l
    //   33: lstore_2
    //   34: invokestatic 141	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   37: bipush 102
    //   39: aload_0
    //   40: getfield 32	com/tencent/beacon/event/a:d	Ljava/lang/Runnable;
    //   43: lload_2
    //   44: lload_2
    //   45: invokevirtual 161	com/tencent/beacon/a/c:a	(ILjava/lang/Runnable;JJ)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: invokestatic 141	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   54: bipush 102
    //   56: iconst_1
    //   57: invokevirtual 164	com/tencent/beacon/a/c:a	(IZ)V
    //   60: aload_0
    //   61: invokevirtual 166	com/tencent/beacon/event/a:a	()V
    //   64: goto -16 -> 48
    //   67: astore 4
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 4
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	paramBoolean	boolean
    //   33	12	2	l	long
    //   67	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	67	finally
    //   19	48	67	finally
    //   51	64	67	finally
  }
  
  public final boolean a(h paramh)
  {
    boolean bool = false;
    Object localObject1;
    Object localObject2;
    if (paramh == null)
    {
      localObject1 = "null";
      if (paramh != null) {
        break label88;
      }
      localObject2 = "null";
    }
    for (;;)
    {
      try
      {
        com.tencent.beacon.d.a.f(" BF eN:}%s   isRT:}%b  isCR:}%b", new Object[] { localObject1, Boolean.valueOf(true), localObject2 });
        if ((this.a == null) || (paramh == null) || (!this.b))
        {
          com.tencent.beacon.d.a.d(" err BF 1R", new Object[0]);
          return bool;
          localObject1 = paramh.d();
          break;
          label88:
          localObject2 = Boolean.valueOf(paramh.f());
          continue;
        }
        if (!c())
        {
          com.tencent.beacon.d.a.d(" err BF 2R", new Object[0]);
          continue;
        }
        localObject1 = m.d().k();
      }
      finally {}
      int i = ((d)localObject1).c();
      long l = ((d)localObject1).d() * 1000;
      int j = this.c.size();
      if (j >= i)
      {
        com.tencent.beacon.d.a.d(" err BF 3R! list size:" + j, new Object[0]);
      }
      else
      {
        this.c.add(paramh);
        if (j + 1 >= i)
        {
          com.tencent.beacon.d.a.f(" BF mN!}", new Object[0]);
          c.a().a(this.d);
          c.a().a(102, this.d, l, l);
        }
        bool = true;
      }
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2, CountItem... paramVarArgs)
  {
    Object localObject;
    int j;
    int i;
    try
    {
      com.tencent.beacon.d.a.e(" onUAC %s", new Object[] { paramString });
      CountItem localCountItem = null;
      if ((paramString == null) || (this.a == null)) {
        if (" err 1R} " + this.a == null)
        {
          paramString = "context";
          com.tencent.beacon.d.a.e(paramString, new Object[0]);
        }
      }
      for (paramBoolean = false;; paramBoolean = false)
      {
        return paramBoolean;
        paramString = "en";
        break;
        Iterator localIterator = this.c.iterator();
        do
        {
          localObject = localCountItem;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (h)localIterator.next();
        } while ((!((h)localObject).f()) || (!((h)localObject).d().equals(paramString)));
        if (localObject != null) {
          break label468;
        }
        com.tencent.beacon.d.a.e(" onUAC add new}", new Object[0]);
        localObject = new HashMap();
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          j = paramVarArgs.length;
          i = 0;
          while (i < j)
          {
            localCountItem = paramVarArgs[i];
            ((Map)localObject).put(localCountItem.name, Long.toString(localCountItem.addValue));
            i += 1;
          }
        }
        paramString = e.a(this.a, paramString, paramBoolean, paramLong1, paramLong2, (Map)localObject);
        if (paramString != null) {
          break label241;
        }
      }
      label241:
      paramVarArgs = paramString.e();
      paramVarArgs.put("C1", Long.toString(paramString.c()));
      paramVarArgs.put("C2", Long.toString(1L));
      if (paramBoolean)
      {
        paramVarArgs.put("C4", Long.toString(paramLong1));
        paramVarArgs.put("C5", Long.toString(paramLong2));
        paramVarArgs.put("C6", Long.toString(0L));
        paramVarArgs.put("C7", Long.toString(0L));
        paramVarArgs.put("C8", Long.toString(0L));
      }
      for (;;)
      {
        paramString.a(true);
        com.tencent.beacon.d.a.b(" add record, return!}", new Object[0]);
        paramBoolean = a(paramString);
        break;
        paramVarArgs.put("C4", Long.toString(0L));
        paramVarArgs.put("C5", Long.toString(0L));
        paramVarArgs.put("C6", Long.toString(1L));
        paramVarArgs.put("C7", Long.toString(paramLong1));
        paramVarArgs.put("C8", Long.toString(paramLong2));
      }
      com.tencent.beacon.d.a.e(" onUAC up O}", new Object[0]);
    }
    finally {}
    label468:
    ((h)localObject).c(((h)localObject).g() + 1L);
    if (paramLong1 >= 1200000L)
    {
      ((h)localObject).b(true);
      ((h)localObject).d(((h)localObject).i() + 1L);
    }
    if (paramLong2 >= 50000000L)
    {
      ((h)localObject).b(true);
      ((h)localObject).d(((h)localObject).i() + 1L);
    }
    paramString = ((h)localObject).e();
    if (paramString == null)
    {
      com.tencent.beacon.d.a.c(" err ? ep==null} %s", new Object[] { ((h)localObject).d() });
      paramString = new HashMap();
      ((h)localObject).a(paramString);
    }
    for (;;)
    {
      paramString.put("C1", Long.toString(new Date().getTime()));
      e.a(paramString, "A26", paramLong1);
      e.a(paramString, "A27", paramLong2);
      e.a(paramString, "C2", 1L);
      if (paramBoolean)
      {
        e.a(paramString, "C4", paramLong1);
        e.a(paramString, "C5", paramLong2);
      }
      while ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        j = paramVarArgs.length;
        i = 0;
        while (i < j)
        {
          localObject = paramVarArgs[i];
          e.a(paramString, ((CountItem)localObject).name, ((CountItem)localObject).addValue);
          i += 1;
        }
        e.a(paramString, "C6", 1L);
        e.a(paramString, "C7", paramLong1);
        e.a(paramString, "C8", paramLong2);
      }
      paramBoolean = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.event.a
 * JD-Core Version:    0.7.0.1
 */