package com.tencent.token;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class akd
  implements Closeable
{
  private static final ExecutorService t = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), aix.a("OkHttp Http2Connection", true));
  final boolean a;
  final b b;
  final Map<Integer, akf> c = new LinkedHashMap();
  final String d;
  int e;
  int f;
  boolean g;
  final aki h;
  boolean i;
  long j = 0L;
  long k;
  akj l = new akj();
  final akj m = new akj();
  boolean n = false;
  final Socket o;
  final akg p;
  final d q;
  final Set<Integer> r = new LinkedHashSet();
  private final ScheduledExecutorService u;
  private final ExecutorService v;
  
  akd(a parama)
  {
    this.h = parama.f;
    this.a = parama.g;
    this.b = parama.e;
    int i1;
    if (parama.g) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    this.f = i1;
    if (parama.g) {
      this.f += 2;
    }
    if (parama.g) {
      this.l.a(7, 16777216);
    }
    this.d = parama.b;
    this.u = new ScheduledThreadPoolExecutor(1, aix.a(aix.a("OkHttp %s Writer", new Object[] { this.d }), false));
    if (parama.h != 0) {
      this.u.scheduleAtFixedRate(new c(false, 0, 0), parama.h, parama.h, TimeUnit.MILLISECONDS);
    }
    this.v = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aix.a(aix.a("OkHttp %s Push Observer", new Object[] { this.d }), true));
    this.m.a(7, 65535);
    this.m.a(5, 16384);
    this.k = this.m.b();
    this.o = parama.a;
    this.p = new akg(parama.d, this.a);
    this.q = new d(new ake(parama.c, this.a));
  }
  
  private void a(ajy paramajy)
  {
    synchronized (this.p)
    {
      try
      {
        if (this.g) {
          return;
        }
        this.g = true;
        int i1 = this.e;
        this.p.a(i1, paramajy, aix.a);
        return;
      }
      finally {}
    }
  }
  
  static boolean c(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  public final int a()
  {
    try
    {
      akj localakj = this.m;
      if ((localakj.a & 0x10) != 0)
      {
        int i1 = localakj.b[4];
        return i1;
      }
      return 2147483647;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final akf a(int paramInt)
  {
    try
    {
      akf localakf = (akf)this.c.get(Integer.valueOf(paramInt));
      return localakf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final akf a(List<ajz> paramList, boolean paramBoolean)
  {
    boolean bool = paramBoolean ^ true;
    for (;;)
    {
      synchronized (this.p)
      {
        try
        {
          if (this.f > 1073741823) {
            a(ajy.e);
          }
          if (!this.g)
          {
            int i2 = this.f;
            this.f += 2;
            akf localakf = new akf(i2, this, bool, false, paramList);
            if ((!paramBoolean) || (this.k == 0L)) {
              break label178;
            }
            if (localakf.b == 0L)
            {
              break label178;
              if (localakf.a()) {
                this.c.put(Integer.valueOf(i2), localakf);
              }
              this.p.a(bool, i2, paramList);
              if (i1 != 0) {
                this.p.b();
              }
              return localakf;
            }
          }
          else
          {
            throw new ajx();
          }
        }
        finally {}
      }
      int i1 = 0;
      continue;
      label178:
      i1 = 1;
    }
  }
  
  final void a(final int paramInt, final long paramLong)
  {
    try
    {
      this.u.execute(new aiw("OkHttp Window Update %s stream %d", new Object[] { this.d, Integer.valueOf(paramInt) })
      {
        public final void b()
        {
          try
          {
            akd.this.p.a(paramInt, paramLong);
            return;
          }
          catch (IOException localIOException)
          {
            label19:
            break label19;
          }
          akd.a(akd.this);
        }
      });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException) {}
  }
  
  final void a(final int paramInt, final ajy paramajy)
  {
    try
    {
      this.u.execute(new aiw("OkHttp %s stream %d", new Object[] { this.d, Integer.valueOf(paramInt) })
      {
        public final void b()
        {
          try
          {
            akd.this.b(paramInt, paramajy);
            return;
          }
          catch (IOException localIOException)
          {
            label16:
            break label16;
          }
          akd.a(akd.this);
        }
      });
      return;
    }
    catch (RejectedExecutionException paramajy) {}
  }
  
  /* Error */
  public final void a(int paramInt, boolean paramBoolean, akz paramakz, long paramLong)
  {
    // Byte code:
    //   0: lload 4
    //   2: lstore 8
    //   4: lload 4
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +15 -> 23
    //   11: aload_0
    //   12: getfield 209	com/tencent/token/akd:p	Lcom/tencent/token/akg;
    //   15: iload_2
    //   16: iload_1
    //   17: aload_3
    //   18: iconst_0
    //   19: invokevirtual 314	com/tencent/token/akg:a	(ZILcom/tencent/token/akz;I)V
    //   22: return
    //   23: lload 8
    //   25: lconst_0
    //   26: lcmp
    //   27: ifle +161 -> 188
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 195	com/tencent/token/akd:k	J
    //   36: lconst_0
    //   37: lcmp
    //   38: ifgt +37 -> 75
    //   41: aload_0
    //   42: getfield 118	com/tencent/token/akd:c	Ljava/util/Map;
    //   45: iload_1
    //   46: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: invokeinterface 318 2 0
    //   54: ifeq +10 -> 64
    //   57: aload_0
    //   58: invokevirtual 321	java/lang/Object:wait	()V
    //   61: goto -29 -> 32
    //   64: new 323	java/io/IOException
    //   67: dup
    //   68: ldc_w 325
    //   71: invokespecial 328	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: lload 8
    //   77: aload_0
    //   78: getfield 195	com/tencent/token/akd:k	J
    //   81: invokestatic 334	java/lang/Math:min	(JJ)J
    //   84: l2i
    //   85: aload_0
    //   86: getfield 209	com/tencent/token/akd:p	Lcom/tencent/token/akg;
    //   89: getfield 335	com/tencent/token/akg:a	I
    //   92: invokestatic 338	java/lang/Math:min	(II)I
    //   95: istore 6
    //   97: aload_0
    //   98: getfield 195	com/tencent/token/akd:k	J
    //   101: lstore 4
    //   103: iload 6
    //   105: i2l
    //   106: lstore 10
    //   108: aload_0
    //   109: lload 4
    //   111: lload 10
    //   113: lsub
    //   114: putfield 195	com/tencent/token/akd:k	J
    //   117: aload_0
    //   118: monitorexit
    //   119: lload 8
    //   121: lload 10
    //   123: lsub
    //   124: lstore 8
    //   126: aload_0
    //   127: getfield 209	com/tencent/token/akd:p	Lcom/tencent/token/akg;
    //   130: astore 12
    //   132: iload_2
    //   133: ifeq +16 -> 149
    //   136: lload 8
    //   138: lconst_0
    //   139: lcmp
    //   140: ifne +9 -> 149
    //   143: iconst_1
    //   144: istore 7
    //   146: goto +6 -> 152
    //   149: iconst_0
    //   150: istore 7
    //   152: aload 12
    //   154: iload 7
    //   156: iload_1
    //   157: aload_3
    //   158: iload 6
    //   160: invokevirtual 314	com/tencent/token/akg:a	(ZILcom/tencent/token/akz;I)V
    //   163: goto -140 -> 23
    //   166: astore_3
    //   167: goto +17 -> 184
    //   170: invokestatic 344	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   173: invokevirtual 347	java/lang/Thread:interrupt	()V
    //   176: new 349	java/io/InterruptedIOException
    //   179: dup
    //   180: invokespecial 350	java/io/InterruptedIOException:<init>	()V
    //   183: athrow
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_3
    //   187: athrow
    //   188: return
    //   189: astore_3
    //   190: goto -20 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	akd
    //   0	193	1	paramInt	int
    //   0	193	2	paramBoolean	boolean
    //   0	193	3	paramakz	akz
    //   0	193	4	paramLong	long
    //   95	64	6	i1	int
    //   144	11	7	bool	boolean
    //   2	135	8	l1	long
    //   106	16	10	l2	long
    //   130	23	12	localakg	akg
    // Exception table:
    //   from	to	target	type
    //   32	61	166	finally
    //   64	75	166	finally
    //   75	103	166	finally
    //   108	119	166	finally
    //   170	184	166	finally
    //   184	186	166	finally
    //   32	61	189	java/lang/InterruptedException
    //   64	75	189	java/lang/InterruptedException
  }
  
  final void a(long paramLong)
  {
    try
    {
      this.j += paramLong;
      if (this.j >= this.l.b() / 2)
      {
        a(0, this.j);
        this.j = 0L;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void a(aiw paramaiw)
  {
    try
    {
      if (!d()) {
        this.v.execute(paramaiw);
      }
      return;
    }
    finally
    {
      paramaiw = finally;
      throw paramaiw;
    }
  }
  
  final void a(ajy paramajy1, ajy paramajy2)
  {
    if ((!s) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    akf[] arrayOfakf = null;
    try
    {
      a(paramajy1);
      paramajy1 = null;
    }
    catch (IOException paramajy1) {}
    try
    {
      if (!this.c.isEmpty())
      {
        arrayOfakf = (akf[])this.c.values().toArray(new akf[this.c.size()]);
        this.c.clear();
      }
      Object localObject = paramajy1;
      if (arrayOfakf != null)
      {
        int i2 = arrayOfakf.length;
        int i1 = 0;
        for (;;)
        {
          localObject = paramajy1;
          if (i1 >= i2) {
            break;
          }
          localObject = arrayOfakf[i1];
          try
          {
            ((akf)localObject).a(paramajy2);
            localObject = paramajy1;
          }
          catch (IOException localIOException)
          {
            localObject = paramajy1;
            if (paramajy1 != null) {
              localObject = localIOException;
            }
          }
          i1 += 1;
          paramajy1 = (ajy)localObject;
        }
      }
      try
      {
        this.p.close();
        paramajy1 = (ajy)localObject;
      }
      catch (IOException paramajy2)
      {
        paramajy1 = (ajy)localObject;
        if (localObject == null) {
          paramajy1 = paramajy2;
        }
      }
      try
      {
        this.o.close();
      }
      catch (IOException paramajy1) {}
      this.u.shutdown();
      this.v.shutdown();
      if (paramajy1 == null) {
        return;
      }
      throw paramajy1;
    }
    finally {}
  }
  
  final akf b(int paramInt)
  {
    try
    {
      akf localakf = (akf)this.c.remove(Integer.valueOf(paramInt));
      notifyAll();
      return localakf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void b()
  {
    try
    {
      ajy localajy = ajy.b;
      a(localajy, localajy);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  final void b(int paramInt, ajy paramajy)
  {
    this.p.a(paramInt, paramajy);
  }
  
  public final void c()
  {
    this.p.a();
    this.p.b(this.l);
    int i1 = this.l.b();
    if (i1 != 65535) {
      this.p.a(0, i1 - 65535);
    }
    new Thread(this.q).start();
  }
  
  public final void close()
  {
    a(ajy.a, ajy.f);
  }
  
  public final boolean d()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
  {
    Socket a;
    String b;
    alb c;
    ala d;
    public akd.b e = akd.b.l;
    aki f = aki.a;
    boolean g = true;
    public int h;
    
    public final a a(Socket paramSocket, String paramString, alb paramalb, ala paramala)
    {
      this.a = paramSocket;
      this.b = paramString;
      this.c = paramalb;
      this.d = paramala;
      return this;
    }
    
    public final akd a()
    {
      return new akd(this);
    }
  }
  
  public static abstract class b
  {
    public static final b l = new b()
    {
      public final void a(akf paramAnonymousakf)
      {
        paramAnonymousakf.a(ajy.e);
      }
    };
    
    public void a(akd paramakd) {}
    
    public abstract void a(akf paramakf);
  }
  
  final class c
    extends aiw
  {
    final boolean a;
    final int c;
    final int d;
    
    c(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      super(new Object[] { akd.this.d, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.a = paramBoolean;
      this.c = paramInt1;
      this.d = paramInt2;
    }
    
    public final void b()
    {
      akd localakd = akd.this;
      boolean bool1 = this.a;
      int i = this.c;
      int j = this.d;
      if (!bool1) {
        try
        {
          boolean bool2 = localakd.i;
          localakd.i = true;
          if (bool2)
          {
            localakd.b();
            return;
          }
        }
        finally {}
      }
      try
      {
        localakd.p.a(bool1, i, j);
        return;
      }
      catch (IOException localIOException)
      {
        label75:
        break label75;
      }
      localakd.b();
    }
  }
  
  final class d
    extends aiw
    implements ake.b
  {
    final ake a;
    
    d(ake paramake)
    {
      super(new Object[] { akd.this.d });
      this.a = paramake;
    }
    
    public final void a(int paramInt)
    {
      synchronized (akd.this)
      {
        akf[] arrayOfakf = (akf[])akd.this.c.values().toArray(new akf[akd.this.c.size()]);
        akd.this.g = true;
        int j = arrayOfakf.length;
        int i = 0;
        while (i < j)
        {
          ??? = arrayOfakf[i];
          if ((???.c > paramInt) && (???.b()))
          {
            ???.c(ajy.e);
            akd.this.b(???.c);
          }
          i += 1;
        }
        return;
      }
    }
    
    public final void a(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (akd.this)
        {
          akd localakd = akd.this;
          localakd.k += paramLong;
          akd.this.notifyAll();
          return;
        }
      }
      ??? = akd.this.a(paramInt);
      if (??? != null) {
        try
        {
          ((akf)???).a(paramLong);
          return;
        }
        finally {}
      }
    }
    
    public final void a(int paramInt, ajy paramajy)
    {
      if (akd.c(paramInt))
      {
        localObject = akd.this;
        ((akd)localObject).a(new akd.6((akd)localObject, "OkHttp %s Push Reset[%s]", new Object[] { ((akd)localObject).d, Integer.valueOf(paramInt) }, paramInt, paramajy));
        return;
      }
      Object localObject = akd.this.b(paramInt);
      if (localObject != null) {
        ((akf)localObject).c(paramajy);
      }
    }
    
    public final void a(int paramInt, List<ajz> paramList)
    {
      synchronized (akd.this)
      {
        if (???.r.contains(Integer.valueOf(paramInt)))
        {
          ???.a(paramInt, ajy.b);
          return;
        }
        ???.r.add(Integer.valueOf(paramInt));
      }
    }
    
    public final void a(final akj paramakj)
    {
      int k;
      int j;
      int i;
      synchronized (akd.this)
      {
        k = akd.this.m.b();
        akj localakj = akd.this.m;
        j = 0;
        i = 0;
        if (i < 10)
        {
          if (paramakj.a(i)) {
            localakj.a(i, paramakj.b[i]);
          }
          i += 1;
        }
      }
      try
      {
        akd.b(akd.this).execute(new aiw("OkHttp %s ACK Settings", new Object[] { akd.this.d })
        {
          public final void b()
          {
            try
            {
              akd.this.p.a(paramakj);
              return;
            }
            catch (IOException localIOException)
            {
              label18:
              break label18;
            }
            akd.a(akd.this);
          }
        });
        i = akd.this.m.b();
        paramakj = null;
        if ((i != -1) && (i != k))
        {
          long l2 = i - k;
          if (!akd.this.n) {
            akd.this.n = true;
          }
          l1 = l2;
          if (!akd.this.c.isEmpty())
          {
            paramakj = (akf[])akd.this.c.values().toArray(new akf[akd.this.c.size()]);
            l1 = l2;
          }
          akd.e().execute(new aiw("OkHttp %s settings", new Object[] { akd.this.d })
          {
            public final void b()
            {
              akd.this.b.a(akd.this);
            }
          });
          if ((paramakj != null) && (l1 != 0L))
          {
            k = paramakj.length;
            i = j;
            while (i < k) {
              synchronized (paramakj[i])
              {
                ???.a(l1);
                i += 1;
              }
            }
          }
          return;
          paramakj = finally;
          throw paramakj;
        }
      }
      catch (RejectedExecutionException paramakj)
      {
        for (;;)
        {
          continue;
          long l1 = 0L;
        }
      }
    }
    
    public final void a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean) {
        synchronized (akd.this)
        {
          akd.c(akd.this);
          akd.this.notifyAll();
          return;
        }
      }
      try
      {
        akd.b(akd.this).execute(new akd.c(akd.this, true, paramInt1, paramInt2));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException) {}
    }
    
    public final void a(boolean paramBoolean, int paramInt1, alb paramalb, int paramInt2)
    {
      long l;
      if (akd.c(paramInt1))
      {
        akd localakd = akd.this;
        localObject = new akz();
        l = paramInt2;
        paramalb.a(l);
        paramalb.a((akz)localObject, l);
        if (((akz)localObject).b == l)
        {
          localakd.a(new akd.5(localakd, "OkHttp %s Push Data[%s]", new Object[] { localakd.d, Integer.valueOf(paramInt1) }, paramInt1, (akz)localObject, paramInt2, paramBoolean));
          return;
        }
        paramalb = new StringBuilder();
        paramalb.append(((akz)localObject).b);
        paramalb.append(" != ");
        paramalb.append(paramInt2);
        throw new IOException(paramalb.toString());
      }
      Object localObject = akd.this.a(paramInt1);
      if (localObject == null)
      {
        akd.this.a(paramInt1, ajy.b);
        localObject = akd.this;
        l = paramInt2;
        ((akd)localObject).a(l);
        paramalb.g(l);
        return;
      }
      if ((!akf.l) && (Thread.holdsLock(localObject))) {
        throw new AssertionError();
      }
      ((akf)localObject).g.a(paramalb, paramInt2);
      if (paramBoolean) {
        ((akf)localObject).e();
      }
    }
    
    public final void a(boolean paramBoolean, int paramInt, final List<ajz> paramList)
    {
      boolean bool2 = akd.c(paramInt);
      boolean bool1 = true;
      if (bool2) {
        ??? = akd.this;
      }
      for (;;)
      {
        akf localakf;
        try
        {
          ((akd)???).a(new akd.4((akd)???, "OkHttp %s Push Headers[%s]", new Object[] { ((akd)???).d, Integer.valueOf(paramInt) }, paramInt, paramList, paramBoolean));
          return;
        }
        catch (RejectedExecutionException paramList) {}
        synchronized (akd.this)
        {
          localakf = akd.this.a(paramInt);
          if (localakf == null)
          {
            if (akd.this.g) {
              return;
            }
            if (paramInt <= akd.this.e) {
              return;
            }
            if (paramInt % 2 == akd.this.f % 2) {
              return;
            }
            paramList = new akf(paramInt, akd.this, false, paramBoolean, paramList);
            akd.this.e = paramInt;
            akd.this.c.put(Integer.valueOf(paramInt), paramList);
            akd.e().execute(new aiw("OkHttp %s stream %d", new Object[] { akd.this.d, Integer.valueOf(paramInt) })
            {
              public final void b()
              {
                try
                {
                  akd.this.b.a(paramList);
                  return;
                }
                catch (IOException localIOException1)
                {
                  akr localakr = akr.c();
                  StringBuilder localStringBuilder = new StringBuilder("Http2Connection.Listener failure for ");
                  localStringBuilder.append(akd.this.d);
                  localakr.a(4, localStringBuilder.toString(), localIOException1);
                  try
                  {
                    paramList.a(ajy.b);
                    return;
                  }
                  catch (IOException localIOException2) {}
                }
              }
            });
            return;
          }
          if ((!akf.l) && (Thread.holdsLock(localakf))) {
            throw new AssertionError();
          }
          try
          {
            localakf.f = true;
            if (localakf.e == null)
            {
              localakf.e = paramList;
              bool1 = localakf.a();
              localakf.notifyAll();
            }
            else
            {
              ??? = new ArrayList();
              ((List)???).addAll(localakf.e);
              ((List)???).add(null);
              ((List)???).addAll(paramList);
              localakf.e = ((List)???);
            }
            if (!bool1) {
              localakf.d.b(localakf.c);
            }
            if (paramBoolean) {
              localakf.e();
            }
            return;
          }
          finally {}
        }
      }
    }
    
    /* Error */
    public final void b()
    {
      // Byte code:
      //   0: getstatic 318	com/tencent/token/ajy:c	Lcom/tencent/token/ajy;
      //   3: astore_3
      //   4: getstatic 318	com/tencent/token/ajy:c	Lcom/tencent/token/ajy;
      //   7: astore 5
      //   9: aload_3
      //   10: astore_1
      //   11: aload_3
      //   12: astore_2
      //   13: aload_0
      //   14: getfield 35	com/tencent/token/akd$d:a	Lcom/tencent/token/ake;
      //   17: astore 4
      //   19: aload_3
      //   20: astore_1
      //   21: aload_3
      //   22: astore_2
      //   23: aload 4
      //   25: getfield 322	com/tencent/token/ake:c	Z
      //   28: ifeq +35 -> 63
      //   31: aload_3
      //   32: astore_1
      //   33: aload_3
      //   34: astore_2
      //   35: aload 4
      //   37: iconst_1
      //   38: aload_0
      //   39: invokevirtual 325	com/tencent/token/ake:a	(ZLcom/tencent/token/ake$b;)Z
      //   42: ifeq +6 -> 48
      //   45: goto +100 -> 145
      //   48: aload_3
      //   49: astore_1
      //   50: aload_3
      //   51: astore_2
      //   52: ldc_w 327
      //   55: iconst_0
      //   56: anewarray 27	java/lang/Object
      //   59: invokestatic 332	com/tencent/token/akb:b	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;
      //   62: athrow
      //   63: aload_3
      //   64: astore_1
      //   65: aload_3
      //   66: astore_2
      //   67: aload 4
      //   69: getfield 335	com/tencent/token/ake:b	Lcom/tencent/token/alb;
      //   72: getstatic 338	com/tencent/token/akb:a	Lcom/tencent/token/alc;
      //   75: invokevirtual 342	com/tencent/token/alc:g	()I
      //   78: i2l
      //   79: invokeinterface 345 3 0
      //   84: astore 4
      //   86: aload_3
      //   87: astore_1
      //   88: aload_3
      //   89: astore_2
      //   90: getstatic 348	com/tencent/token/ake:a	Ljava/util/logging/Logger;
      //   93: getstatic 354	java/util/logging/Level:FINE	Ljava/util/logging/Level;
      //   96: invokevirtual 360	java/util/logging/Logger:isLoggable	(Ljava/util/logging/Level;)Z
      //   99: ifeq +31 -> 130
      //   102: aload_3
      //   103: astore_1
      //   104: aload_3
      //   105: astore_2
      //   106: getstatic 348	com/tencent/token/ake:a	Ljava/util/logging/Logger;
      //   109: ldc_w 362
      //   112: iconst_1
      //   113: anewarray 27	java/lang/Object
      //   116: dup
      //   117: iconst_0
      //   118: aload 4
      //   120: invokevirtual 364	com/tencent/token/alc:e	()Ljava/lang/String;
      //   123: aastore
      //   124: invokestatic 369	com/tencent/token/aix:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   127: invokevirtual 372	java/util/logging/Logger:fine	(Ljava/lang/String;)V
      //   130: aload_3
      //   131: astore_1
      //   132: aload_3
      //   133: astore_2
      //   134: getstatic 338	com/tencent/token/akb:a	Lcom/tencent/token/alc;
      //   137: aload 4
      //   139: invokevirtual 375	com/tencent/token/alc:equals	(Ljava/lang/Object;)Z
      //   142: ifeq +58 -> 200
      //   145: aload_3
      //   146: astore_1
      //   147: aload_3
      //   148: astore_2
      //   149: aload_0
      //   150: getfield 35	com/tencent/token/akd$d:a	Lcom/tencent/token/ake;
      //   153: iconst_0
      //   154: aload_0
      //   155: invokevirtual 325	com/tencent/token/ake:a	(ZLcom/tencent/token/ake$b;)Z
      //   158: ifne -13 -> 145
      //   161: aload_3
      //   162: astore_1
      //   163: aload_3
      //   164: astore_2
      //   165: getstatic 377	com/tencent/token/ajy:a	Lcom/tencent/token/ajy;
      //   168: astore_3
      //   169: aload_3
      //   170: astore_1
      //   171: aload_3
      //   172: astore_2
      //   173: getstatic 379	com/tencent/token/ajy:f	Lcom/tencent/token/ajy;
      //   176: astore 4
      //   178: aload_0
      //   179: getfield 23	com/tencent/token/akd$d:c	Lcom/tencent/token/akd;
      //   182: astore_2
      //   183: aload 4
      //   185: astore_1
      //   186: aload_2
      //   187: aload_3
      //   188: aload_1
      //   189: invokevirtual 382	com/tencent/token/akd:a	(Lcom/tencent/token/ajy;Lcom/tencent/token/ajy;)V
      //   192: aload_0
      //   193: getfield 35	com/tencent/token/akd$d:a	Lcom/tencent/token/ake;
      //   196: invokestatic 385	com/tencent/token/aix:a	(Ljava/io/Closeable;)V
      //   199: return
      //   200: aload_3
      //   201: astore_1
      //   202: aload_3
      //   203: astore_2
      //   204: ldc_w 387
      //   207: iconst_1
      //   208: anewarray 27	java/lang/Object
      //   211: dup
      //   212: iconst_0
      //   213: aload 4
      //   215: invokevirtual 389	com/tencent/token/alc:a	()Ljava/lang/String;
      //   218: aastore
      //   219: invokestatic 332	com/tencent/token/akb:b	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/IOException;
      //   222: athrow
      //   223: astore_2
      //   224: goto +29 -> 253
      //   227: aload_2
      //   228: astore_1
      //   229: getstatic 132	com/tencent/token/ajy:b	Lcom/tencent/token/ajy;
      //   232: astore_3
      //   233: aload_3
      //   234: astore_1
      //   235: getstatic 132	com/tencent/token/ajy:b	Lcom/tencent/token/ajy;
      //   238: astore_2
      //   239: aload_0
      //   240: getfield 23	com/tencent/token/akd$d:c	Lcom/tencent/token/akd;
      //   243: astore 4
      //   245: aload_2
      //   246: astore_1
      //   247: aload 4
      //   249: astore_2
      //   250: goto -64 -> 186
      //   253: aload_0
      //   254: getfield 23	com/tencent/token/akd$d:c	Lcom/tencent/token/akd;
      //   257: aload_1
      //   258: aload 5
      //   260: invokevirtual 382	com/tencent/token/akd:a	(Lcom/tencent/token/ajy;Lcom/tencent/token/ajy;)V
      //   263: aload_0
      //   264: getfield 35	com/tencent/token/akd$d:a	Lcom/tencent/token/ake;
      //   267: invokestatic 385	com/tencent/token/aix:a	(Ljava/io/Closeable;)V
      //   270: aload_2
      //   271: athrow
      //   272: astore_1
      //   273: goto -46 -> 227
      //   276: astore_1
      //   277: goto -85 -> 192
      //   280: astore_1
      //   281: goto -18 -> 263
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	284	0	this	d
      //   10	248	1	localObject1	Object
      //   272	1	1	localIOException1	IOException
      //   276	1	1	localIOException2	IOException
      //   280	1	1	localIOException3	IOException
      //   12	192	2	localObject2	Object
      //   223	5	2	localObject3	Object
      //   238	33	2	localObject4	Object
      //   3	231	3	localajy1	ajy
      //   17	231	4	localObject5	Object
      //   7	252	5	localajy2	ajy
      // Exception table:
      //   from	to	target	type
      //   13	19	223	finally
      //   23	31	223	finally
      //   35	45	223	finally
      //   52	63	223	finally
      //   67	86	223	finally
      //   90	102	223	finally
      //   106	130	223	finally
      //   134	145	223	finally
      //   149	161	223	finally
      //   165	169	223	finally
      //   173	178	223	finally
      //   204	223	223	finally
      //   229	233	223	finally
      //   235	239	223	finally
      //   13	19	272	java/io/IOException
      //   23	31	272	java/io/IOException
      //   35	45	272	java/io/IOException
      //   52	63	272	java/io/IOException
      //   67	86	272	java/io/IOException
      //   90	102	272	java/io/IOException
      //   106	130	272	java/io/IOException
      //   134	145	272	java/io/IOException
      //   149	161	272	java/io/IOException
      //   165	169	272	java/io/IOException
      //   173	178	272	java/io/IOException
      //   204	223	272	java/io/IOException
      //   178	183	276	java/io/IOException
      //   186	192	276	java/io/IOException
      //   239	245	276	java/io/IOException
      //   253	263	280	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akd
 * JD-Core Version:    0.7.0.1
 */