package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.d;
import com.tencent.beacon.d.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j
  implements h
{
  private boolean a = false;
  private List<i> b;
  private Context c;
  private Runnable d = new Runnable()
  {
    public final void run()
    {
      try
      {
        j.this.b();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  };
  
  public j(Context paramContext)
  {
    this.c = paramContext;
    this.b = Collections.synchronizedList(new ArrayList(25));
  }
  
  private boolean c()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final List<i> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/tencent/beacon/event/j:b	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 46	com/tencent/beacon/event/j:b	Ljava/util/List;
    //   13: invokeinterface 55 1 0
    //   18: ifle +12 -> 30
    //   21: aload_0
    //   22: invokespecial 57	com/tencent/beacon/event/j:c	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +9 -> 36
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: new 35	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 58	java/util/ArrayList:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 46	com/tencent/beacon/event/j:b	Ljava/util/List;
    //   49: invokeinterface 62 2 0
    //   54: pop
    //   55: aload_0
    //   56: getfield 46	com/tencent/beacon/event/j:b	Ljava/util/List;
    //   59: invokeinterface 65 1 0
    //   64: new 67	java/lang/StringBuilder
    //   67: dup
    //   68: ldc 69
    //   70: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_2
    //   74: invokeinterface 55 1 0
    //   79: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: iconst_0
    //   86: anewarray 4	java/lang/Object
    //   89: invokestatic 85	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: goto -60 -> 32
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	j
    //   25	2	1	bool	boolean
    //   31	43	2	localObject1	Object
    //   95	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	95	finally
    //   36	92	95	finally
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/tencent/beacon/event/j:a	Z
    //   6: iload_1
    //   7: if_icmpeq +43 -> 50
    //   10: iload_1
    //   11: ifeq +42 -> 53
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 26	com/tencent/beacon/event/j:a	Z
    //   19: invokestatic 93	com/tencent/beacon/event/n:d	()Lcom/tencent/beacon/event/n;
    //   22: invokevirtual 97	com/tencent/beacon/event/n:k	()Lcom/tencent/beacon/event/e;
    //   25: invokevirtual 101	com/tencent/beacon/event/e:b	()I
    //   28: sipush 1000
    //   31: imul
    //   32: i2l
    //   33: lstore_2
    //   34: invokestatic 106	com/tencent/beacon/a/d:a	()Lcom/tencent/beacon/a/d;
    //   37: bipush 103
    //   39: aload_0
    //   40: getfield 31	com/tencent/beacon/event/j:d	Ljava/lang/Runnable;
    //   43: ldc2_w 107
    //   46: lload_2
    //   47: invokevirtual 111	com/tencent/beacon/a/d:a	(ILjava/lang/Runnable;JJ)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: invokestatic 106	com/tencent/beacon/a/d:a	()Lcom/tencent/beacon/a/d;
    //   56: bipush 103
    //   58: iconst_1
    //   59: invokevirtual 114	com/tencent/beacon/a/d:a	(IZ)V
    //   62: aload_0
    //   63: getfield 46	com/tencent/beacon/event/j:b	Ljava/util/List;
    //   66: ifnull +27 -> 93
    //   69: aload_0
    //   70: getfield 46	com/tencent/beacon/event/j:b	Ljava/util/List;
    //   73: invokeinterface 55 1 0
    //   78: ifle +15 -> 93
    //   81: aload_0
    //   82: getfield 33	com/tencent/beacon/event/j:c	Landroid/content/Context;
    //   85: aload_0
    //   86: getfield 46	com/tencent/beacon/event/j:b	Ljava/util/List;
    //   89: invokestatic 119	com/tencent/beacon/a/g:a	(Landroid/content/Context;Ljava/util/List;)[Ljava/lang/Long;
    //   92: pop
    //   93: aload_0
    //   94: iload_1
    //   95: putfield 26	com/tencent/beacon/event/j:a	Z
    //   98: goto -48 -> 50
    //   101: astore 4
    //   103: aload_0
    //   104: monitorexit
    //   105: aload 4
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	j
    //   0	108	1	paramBoolean	boolean
    //   33	14	2	l	long
    //   101	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	101	finally
    //   14	50	101	finally
    //   53	93	101	finally
    //   93	98	101	finally
  }
  
  public final boolean a(i parami)
  {
    boolean bool = false;
    Object localObject1;
    Object localObject2;
    if (parami == null)
    {
      localObject1 = "null";
      if (parami != null) {
        break label79;
      }
      localObject2 = "null";
    }
    for (;;)
    {
      try
      {
        com.tencent.beacon.d.a.f(" BF eN:%s   isRT:%b  isCR:%b", new Object[] { localObject1, Boolean.valueOf(true), localObject2 });
        if ((this.c == null) || (parami == null))
        {
          com.tencent.beacon.d.a.c("processUA return false, context is null or bean is null !", new Object[0]);
          return bool;
          localObject1 = parami.d();
          break;
          label79:
          localObject2 = Boolean.valueOf(parami.f());
          continue;
        }
        if (!c())
        {
          com.tencent.beacon.d.a.c("processUA return false, isEnable is false !", new Object[0]);
          continue;
        }
        localObject1 = n.d().k();
      }
      finally {}
      int i = ((e)localObject1).a();
      long l = ((e)localObject1).b() * 1000;
      if (this.b.size() >= i)
      {
        com.tencent.beacon.d.a.f(" BF mN!", new Object[0]);
        d.a().a(this.d);
        d.a().a(103, this.d, l, l);
      }
      this.b.add(parami);
      if (this.b.size() >= i) {
        com.tencent.beacon.d.a.c(" err BF 3R! num:" + this.b.size(), new Object[0]);
      }
      if ("rqd_applaunched".equals(parami.d())) {
        d.a().a(this.d);
      }
      com.tencent.beacon.d.a.a("processUA:true!", new Object[0]);
      bool = true;
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean, long paramLong1, long paramLong2, c... paramVarArgs)
  {
    Object localObject;
    int j;
    int i;
    try
    {
      com.tencent.beacon.d.a.e(" onUAC  %s RT", new Object[] { paramString });
      c localc = null;
      if ((paramString == null) || (this.c == null)) {
        if (" err 1R " + this.c == null)
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
        Iterator localIterator = this.b.iterator();
        do
        {
          localObject = localc;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (i)localIterator.next();
        } while ((!((i)localObject).f()) || (!((i)localObject).d().equals(paramString)));
        if (localObject != null) {
          break label446;
        }
        com.tencent.beacon.d.a.e(" onUAC add new", new Object[0]);
        localObject = new HashMap();
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          j = paramVarArgs.length;
          i = 0;
          while (i < j)
          {
            localc = paramVarArgs[i];
            ((Map)localObject).put(localc.a, Long.toString(localc.b));
            i += 1;
          }
        }
        paramString = a.a(this.c, paramString, paramBoolean, paramLong1, paramLong2, (Map)localObject);
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
        paramBoolean = a(paramString);
        break;
        paramVarArgs.put("C4", Long.toString(0L));
        paramVarArgs.put("C5", Long.toString(0L));
        paramVarArgs.put("C6", Long.toString(1L));
        paramVarArgs.put("C7", Long.toString(paramLong1));
        paramVarArgs.put("C8", Long.toString(paramLong2));
      }
      com.tencent.beacon.d.a.e(" onUAC up O", new Object[0]);
    }
    finally {}
    label446:
    ((i)localObject).c(((i)localObject).g() + 1L);
    if (paramLong1 >= 1200000L)
    {
      ((i)localObject).b(true);
      ((i)localObject).d(((i)localObject).i() + 1L);
    }
    if (paramLong2 >= 50000000L)
    {
      ((i)localObject).b(true);
      ((i)localObject).d(((i)localObject).i() + 1L);
    }
    paramString = ((i)localObject).e();
    if (paramString == null)
    {
      com.tencent.beacon.d.a.c(" err ? ep==null} %s", new Object[] { ((i)localObject).d() });
      paramString = new HashMap();
      ((i)localObject).a(paramString);
    }
    for (;;)
    {
      paramString.put("C1", Long.toString(new Date().getTime()));
      com.tencent.beacon.a.g.a(paramString, "A26", paramLong1);
      com.tencent.beacon.a.g.a(paramString, "A27", paramLong2);
      com.tencent.beacon.a.g.a(paramString, "C2", 1L);
      if (paramBoolean)
      {
        com.tencent.beacon.a.g.a(paramString, "C4", paramLong1);
        com.tencent.beacon.a.g.a(paramString, "C5", paramLong2);
      }
      while ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        j = paramVarArgs.length;
        i = 0;
        while (i < j)
        {
          localObject = paramVarArgs[i];
          com.tencent.beacon.a.g.a(paramString, ((c)localObject).a, ((c)localObject).b);
          i += 1;
        }
        com.tencent.beacon.a.g.a(paramString, "C6", 1L);
        com.tencent.beacon.a.g.a(paramString, "C7", paramLong1);
        com.tencent.beacon.a.g.a(paramString, "C8", paramLong2);
      }
      paramBoolean = true;
      break;
    }
  }
  
  protected final void b()
  {
    if (!c()) {
      com.tencent.beacon.d.a.c(" err su 1R", new Object[0]);
    }
    List localList;
    do
    {
      return;
      localList = a();
    } while ((localList == null) || (localList.size() <= 0));
    com.tencent.beacon.upload.g localg = n.d().j();
    if ((!b.b(this.c)) || (localg == null))
    {
      com.tencent.beacon.d.a.f(" dsu real events 2 db" + localList.size(), new Object[0]);
      com.tencent.beacon.a.g.a(this.c, localList);
      return;
    }
    com.tencent.beacon.d.a.f(" dsu real events 2 up " + localList.size(), new Object[0]);
    localg.a(new a(this.c, localList));
  }
  
  static final class a
    extends com.tencent.beacon.upload.a
  {
    private List<i> d = null;
    private Context e;
    private Long[] f = null;
    private boolean g = false;
    
    public a(Context paramContext, List<i> paramList)
    {
      super(1, 2);
      this.d = paramList;
      this.e = paramContext;
      if ((this.d.size() == 1) && ("rqd_heartbeat".equals(((i)this.d.get(0)).d()))) {
        this.g = true;
      }
    }
    
    /* Error */
    public final com.tencent.beacon.c.a.b a()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 60
      //   4: iconst_0
      //   5: anewarray 62	java/lang/Object
      //   8: invokestatic 68	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   11: aload_0
      //   12: getfield 23	com/tencent/beacon/event/j$a:d	Ljava/util/List;
      //   15: ifnull +17 -> 32
      //   18: aload_0
      //   19: getfield 23	com/tencent/beacon/event/j$a:d	Ljava/util/List;
      //   22: invokeinterface 35 1 0
      //   27: istore_1
      //   28: iload_1
      //   29: ifgt +9 -> 38
      //   32: aconst_null
      //   33: astore_2
      //   34: aload_0
      //   35: monitorexit
      //   36: aload_2
      //   37: areturn
      //   38: aload_0
      //   39: getfield 29	com/tencent/beacon/event/j$a:e	Landroid/content/Context;
      //   42: aload_0
      //   43: getfield 71	com/tencent/beacon/event/j$a:a	I
      //   46: aload_0
      //   47: getfield 23	com/tencent/beacon/event/j$a:d	Ljava/util/List;
      //   50: invokestatic 76	com/tencent/beacon/event/k:a	(Landroid/content/Context;ILjava/util/List;)Lcom/tencent/beacon/c/a/b;
      //   53: astore_3
      //   54: aload_3
      //   55: astore_2
      //   56: aload_3
      //   57: ifnonnull -23 -> 34
      //   60: aconst_null
      //   61: astore_2
      //   62: goto -28 -> 34
      //   65: astore_2
      //   66: aload_2
      //   67: invokevirtual 80	java/lang/Throwable:printStackTrace	()V
      //   70: ldc 82
      //   72: iconst_0
      //   73: anewarray 62	java/lang/Object
      //   76: invokestatic 84	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   79: goto -19 -> 60
      //   82: astore_2
      //   83: aload_0
      //   84: monitorexit
      //   85: aload_2
      //   86: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	87	0	this	a
      //   27	2	1	i	int
      //   33	29	2	localObject1	Object
      //   65	2	2	localThrowable	Throwable
      //   82	4	2	localObject2	Object
      //   53	4	3	localb	com.tencent.beacon.c.a.b
      // Exception table:
      //   from	to	target	type
      //   38	54	65	java/lang/Throwable
      //   2	28	82	finally
      //   38	54	82	finally
      //   66	79	82	finally
    }
    
    public final void a(boolean paramBoolean)
    {
      try
      {
        com.tencent.beacon.d.a.b(" TimeUpUploadDatas.done(), result:%b", new Object[] { Boolean.valueOf(paramBoolean) });
        if ((this.d != null) && (!paramBoolean))
        {
          com.tencent.beacon.d.a.f(" upload failed, save to db", new Object[0]);
          if (!this.g)
          {
            this.f = com.tencent.beacon.a.g.a(this.e, this.d);
            this.d = null;
          }
        }
        if ((paramBoolean) && (this.g))
        {
          Context localContext = this.e;
          d.a().a(108, true);
          com.tencent.beacon.a.a.a(localContext, "HEART_DENGTA", com.tencent.beacon.b.a.g());
          com.tencent.beacon.d.a.a("heartbeat uploaded sucess!", new Object[0]);
        }
        if ((paramBoolean) && (this.f != null)) {
          com.tencent.beacon.a.g.a(this.e, this.f);
        }
        if ((paramBoolean) && (this.f == null) && (this.d != null)) {
          this.d = null;
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.event.j
 * JD-Core Version:    0.7.0.1
 */