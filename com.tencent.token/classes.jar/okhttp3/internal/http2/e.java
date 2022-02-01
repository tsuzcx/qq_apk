package okhttp3.internal.http2;

import com.tencent.token.fb;
import com.tencent.token.fc;
import com.tencent.token.gc;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
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
import okio.ByteString;
import okio.c;
import okio.d;

public final class e
  implements Closeable
{
  private static final ExecutorService s = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), fc.a("OkHttp Http2Connection", true));
  final boolean a;
  final b b;
  final Map<Integer, g> c = new LinkedHashMap();
  final String d;
  int e;
  int f;
  boolean g;
  final j h;
  long i = 0L;
  long j;
  k k = new k();
  final k l = new k();
  boolean m = false;
  final Socket n;
  final h o;
  final d p;
  final Set<Integer> q = new LinkedHashSet();
  private final ScheduledExecutorService t;
  private final ExecutorService u;
  private boolean v;
  
  e(a parama)
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
      this.k.a(7, 16777216);
    }
    this.d = parama.b;
    this.t = new ScheduledThreadPoolExecutor(1, fc.a(fc.a("OkHttp %s Writer", new Object[] { this.d }), false));
    if (parama.h != 0) {
      this.t.scheduleAtFixedRate(new c(false, 0, 0), parama.h, parama.h, TimeUnit.MILLISECONDS);
    }
    this.u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), fc.a(fc.a("OkHttp %s Push Observer", new Object[] { this.d }), true));
    this.l.a(7, 65535);
    this.l.a(5, 16384);
    this.j = this.l.d();
    this.n = parama.a;
    this.o = new h(parama.d, this.a);
    this.p = new d(new f(parama.c, this.a));
  }
  
  private void a(fb paramfb)
  {
    try
    {
      if (!d()) {
        this.u.execute(paramfb);
      }
      return;
    }
    finally
    {
      paramfb = finally;
      throw paramfb;
    }
  }
  
  private g b(int paramInt, List<a> paramList, boolean paramBoolean)
  {
    boolean bool = paramBoolean ^ true;
    for (;;)
    {
      synchronized (this.o)
      {
        try
        {
          if (this.f > 1073741823) {
            a(ErrorCode.REFUSED_STREAM);
          }
          if (!this.g)
          {
            int i2 = this.f;
            this.f += 2;
            g localg = new g(i2, this, bool, false, paramList);
            if ((!paramBoolean) || (this.j == 0L)) {
              break label216;
            }
            if (localg.b == 0L)
            {
              break label216;
              if (localg.b()) {
                this.c.put(Integer.valueOf(i2), localg);
              }
              if (paramInt == 0)
              {
                this.o.a(bool, i2, paramInt, paramList);
              }
              else
              {
                if (this.a) {
                  continue;
                }
                this.o.a(paramInt, i2, paramList);
              }
              if (i1 != 0) {
                this.o.b();
              }
              return localg;
              throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
          }
          else
          {
            throw new ConnectionShutdownException();
          }
        }
        finally {}
      }
      int i1 = 0;
      continue;
      label216:
      i1 = 1;
    }
  }
  
  private void f()
  {
    try
    {
      a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public int a()
  {
    try
    {
      int i1 = this.l.c(2147483647);
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  g a(int paramInt)
  {
    try
    {
      g localg = (g)this.c.get(Integer.valueOf(paramInt));
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public g a(List<a> paramList, boolean paramBoolean)
  {
    return b(0, paramList, paramBoolean);
  }
  
  void a(final int paramInt, final long paramLong)
  {
    try
    {
      this.t.execute(new fb("OkHttp Window Update %s stream %d", new Object[] { this.d, Integer.valueOf(paramInt) })
      {
        public void c()
        {
          try
          {
            e.this.o.a(paramInt, paramLong);
            return;
          }
          catch (IOException localIOException)
          {
            label19:
            break label19;
          }
          e.a(e.this);
        }
      });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException) {}
  }
  
  void a(final int paramInt, final List<a> paramList)
  {
    try
    {
      if (this.q.contains(Integer.valueOf(paramInt)))
      {
        a(paramInt, ErrorCode.PROTOCOL_ERROR);
        return;
      }
      this.q.add(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      try
      {
        a(new fb("OkHttp %s Push Request[%s]", new Object[] { this.d, Integer.valueOf(paramInt) })
        {
          public void c()
          {
            if (e.this.h.a(paramInt, paramList)) {}
            try
            {
              e.this.o.a(paramInt, ErrorCode.CANCEL);
              synchronized (e.this)
              {
                e.this.q.remove(Integer.valueOf(paramInt));
                return;
              }
              return;
            }
            catch (IOException localIOException) {}
          }
        });
        return;
      }
      catch (RejectedExecutionException paramList) {}
      paramList = finally;
    }
  }
  
  void a(final int paramInt, final List<a> paramList, final boolean paramBoolean)
  {
    try
    {
      a(new fb("OkHttp %s Push Headers[%s]", new Object[] { this.d, Integer.valueOf(paramInt) })
      {
        public void c()
        {
          boolean bool = e.this.h.a(paramInt, paramList, paramBoolean);
          if (bool) {}
          try
          {
            e.this.o.a(paramInt, ErrorCode.CANCEL);
            if ((bool) || (paramBoolean)) {
              synchronized (e.this)
              {
                e.this.q.remove(Integer.valueOf(paramInt));
                return;
              }
            }
            return;
          }
          catch (IOException localIOException) {}
        }
      });
      return;
    }
    catch (RejectedExecutionException paramList) {}
  }
  
  void a(final int paramInt, final ErrorCode paramErrorCode)
  {
    try
    {
      this.t.execute(new fb("OkHttp %s stream %d", new Object[] { this.d, Integer.valueOf(paramInt) })
      {
        public void c()
        {
          try
          {
            e.this.b(paramInt, paramErrorCode);
            return;
          }
          catch (IOException localIOException)
          {
            label16:
            break label16;
          }
          e.a(e.this);
        }
      });
      return;
    }
    catch (RejectedExecutionException paramErrorCode) {}
  }
  
  void a(final int paramInt1, okio.e parame, final int paramInt2, final boolean paramBoolean)
  {
    final c localc = new c();
    long l1 = paramInt2;
    parame.a(l1);
    parame.a(localc, l1);
    if (localc.b() == l1)
    {
      a(new fb("OkHttp %s Push Data[%s]", new Object[] { this.d, Integer.valueOf(paramInt1) })
      {
        public void c()
        {
          try
          {
            boolean bool = e.this.h.a(paramInt1, localc, paramInt2, paramBoolean);
            if (bool) {
              e.this.o.a(paramInt1, ErrorCode.CANCEL);
            }
            if ((bool) || (paramBoolean)) {
              synchronized (e.this)
              {
                e.this.q.remove(Integer.valueOf(paramInt1));
                return;
              }
            }
            return;
          }
          catch (IOException localIOException) {}
        }
      });
      return;
    }
    parame = new StringBuilder();
    parame.append(localc.b());
    parame.append(" != ");
    parame.append(paramInt2);
    throw new IOException(parame.toString());
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean, c paramc, long paramLong)
  {
    // Byte code:
    //   0: lload 4
    //   2: lstore 8
    //   4: lload 4
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +15 -> 23
    //   11: aload_0
    //   12: getfield 209	okhttp3/internal/http2/e:o	Lokhttp3/internal/http2/h;
    //   15: iload_2
    //   16: iload_1
    //   17: aload_3
    //   18: iconst_0
    //   19: invokevirtual 400	okhttp3/internal/http2/h:a	(ZILokio/c;I)V
    //   22: return
    //   23: lload 8
    //   25: lconst_0
    //   26: lcmp
    //   27: ifle +161 -> 188
    //   30: aload_0
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 195	okhttp3/internal/http2/e:j	J
    //   36: lconst_0
    //   37: lcmp
    //   38: ifgt +37 -> 75
    //   41: aload_0
    //   42: getfield 118	okhttp3/internal/http2/e:c	Ljava/util/Map;
    //   45: iload_1
    //   46: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: invokeinterface 403 2 0
    //   54: ifeq +10 -> 64
    //   57: aload_0
    //   58: invokevirtual 406	java/lang/Object:wait	()V
    //   61: goto -29 -> 32
    //   64: new 294	java/io/IOException
    //   67: dup
    //   68: ldc_w 408
    //   71: invokespecial 394	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: lload 8
    //   77: aload_0
    //   78: getfield 195	okhttp3/internal/http2/e:j	J
    //   81: invokestatic 414	java/lang/Math:min	(JJ)J
    //   84: l2i
    //   85: aload_0
    //   86: getfield 209	okhttp3/internal/http2/e:o	Lokhttp3/internal/http2/h;
    //   89: invokevirtual 416	okhttp3/internal/http2/h:c	()I
    //   92: invokestatic 419	java/lang/Math:min	(II)I
    //   95: istore 6
    //   97: aload_0
    //   98: getfield 195	okhttp3/internal/http2/e:j	J
    //   101: lstore 4
    //   103: iload 6
    //   105: i2l
    //   106: lstore 10
    //   108: aload_0
    //   109: lload 4
    //   111: lload 10
    //   113: lsub
    //   114: putfield 195	okhttp3/internal/http2/e:j	J
    //   117: aload_0
    //   118: monitorexit
    //   119: lload 8
    //   121: lload 10
    //   123: lsub
    //   124: lstore 8
    //   126: aload_0
    //   127: getfield 209	okhttp3/internal/http2/e:o	Lokhttp3/internal/http2/h;
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
    //   160: invokevirtual 400	okhttp3/internal/http2/h:a	(ZILokio/c;I)V
    //   163: goto -140 -> 23
    //   166: astore_3
    //   167: goto +17 -> 184
    //   170: invokestatic 425	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   173: invokevirtual 428	java/lang/Thread:interrupt	()V
    //   176: new 430	java/io/InterruptedIOException
    //   179: dup
    //   180: invokespecial 431	java/io/InterruptedIOException:<init>	()V
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
    //   0	193	0	this	e
    //   0	193	1	paramInt	int
    //   0	193	2	paramBoolean	boolean
    //   0	193	3	paramc	c
    //   0	193	4	paramLong	long
    //   95	64	6	i1	int
    //   144	11	7	bool	boolean
    //   2	135	8	l1	long
    //   106	16	10	l2	long
    //   130	23	12	localh	h
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
  
  void a(long paramLong)
  {
    try
    {
      this.i += paramLong;
      if (this.i >= this.k.d() / 2)
      {
        a(0, this.i);
        this.i = 0L;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(ErrorCode paramErrorCode)
  {
    synchronized (this.o)
    {
      try
      {
        if (this.g) {
          return;
        }
        this.g = true;
        int i1 = this.e;
        this.o.a(i1, paramErrorCode, fc.a);
        return;
      }
      finally {}
    }
  }
  
  void a(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
  {
    if ((!r) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    g[] arrayOfg = null;
    try
    {
      a(paramErrorCode1);
      paramErrorCode1 = null;
    }
    catch (IOException paramErrorCode1) {}
    try
    {
      if (!this.c.isEmpty())
      {
        arrayOfg = (g[])this.c.values().toArray(new g[this.c.size()]);
        this.c.clear();
      }
      Object localObject = paramErrorCode1;
      if (arrayOfg != null)
      {
        int i2 = arrayOfg.length;
        int i1 = 0;
        for (;;)
        {
          localObject = paramErrorCode1;
          if (i1 >= i2) {
            break;
          }
          localObject = arrayOfg[i1];
          try
          {
            ((g)localObject).a(paramErrorCode2);
            localObject = paramErrorCode1;
          }
          catch (IOException localIOException)
          {
            localObject = paramErrorCode1;
            if (paramErrorCode1 != null) {
              localObject = localIOException;
            }
          }
          i1 += 1;
          paramErrorCode1 = (ErrorCode)localObject;
        }
      }
      try
      {
        this.o.close();
        paramErrorCode1 = (ErrorCode)localObject;
      }
      catch (IOException paramErrorCode2)
      {
        paramErrorCode1 = (ErrorCode)localObject;
        if (localObject == null) {
          paramErrorCode1 = paramErrorCode2;
        }
      }
      try
      {
        this.n.close();
      }
      catch (IOException paramErrorCode1) {}
      this.t.shutdown();
      this.u.shutdown();
      if (paramErrorCode1 == null) {
        return;
      }
      throw paramErrorCode1;
    }
    finally {}
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.o.a();
      this.o.b(this.k);
      int i1 = this.k.d();
      if (i1 != 65535) {
        this.o.a(0, i1 - 65535);
      }
    }
    new Thread(this.p).start();
  }
  
  void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!paramBoolean) {
      try
      {
        boolean bool = this.v;
        this.v = true;
        if (bool)
        {
          f();
          return;
        }
      }
      finally {}
    }
    try
    {
      this.o.a(paramBoolean, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      label47:
      break label47;
    }
    f();
  }
  
  g b(int paramInt)
  {
    try
    {
      g localg = (g)this.c.remove(Integer.valueOf(paramInt));
      notifyAll();
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    this.o.b();
  }
  
  void b(int paramInt, ErrorCode paramErrorCode)
  {
    this.o.a(paramInt, paramErrorCode);
  }
  
  public void c()
  {
    a(true);
  }
  
  void c(final int paramInt, final ErrorCode paramErrorCode)
  {
    a(new fb("OkHttp %s Push Reset[%s]", new Object[] { this.d, Integer.valueOf(paramInt) })
    {
      public void c()
      {
        e.this.h.a(paramInt, paramErrorCode);
        synchronized (e.this)
        {
          e.this.q.remove(Integer.valueOf(paramInt));
          return;
        }
      }
    });
  }
  
  boolean c(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  public void close()
  {
    a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  public boolean d()
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
  
  public static class a
  {
    Socket a;
    String b;
    okio.e c;
    d d;
    e.b e = e.b.f;
    j f = j.a;
    boolean g;
    int h;
    
    public a(boolean paramBoolean)
    {
      this.g = paramBoolean;
    }
    
    public a a(int paramInt)
    {
      this.h = paramInt;
      return this;
    }
    
    public a a(Socket paramSocket, String paramString, okio.e parame, d paramd)
    {
      this.a = paramSocket;
      this.b = paramString;
      this.c = parame;
      this.d = paramd;
      return this;
    }
    
    public a a(e.b paramb)
    {
      this.e = paramb;
      return this;
    }
    
    public e a()
    {
      return new e(this);
    }
  }
  
  public static abstract class b
  {
    public static final b f = new b()
    {
      public void a(g paramAnonymousg)
      {
        paramAnonymousg.a(ErrorCode.REFUSED_STREAM);
      }
    };
    
    public void a(e parame) {}
    
    public abstract void a(g paramg);
  }
  
  final class c
    extends fb
  {
    final boolean a;
    final int c;
    final int d;
    
    c(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      super(new Object[] { e.this.d, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.a = paramBoolean;
      this.c = paramInt1;
      this.d = paramInt2;
    }
    
    public void c()
    {
      e.this.a(this.a, this.c, this.d);
    }
  }
  
  class d
    extends fb
    implements f.b
  {
    final f a;
    
    d(f paramf)
    {
      super(new Object[] { e.this.d });
      this.a = paramf;
    }
    
    private void a(final k paramk)
    {
      try
      {
        e.b(e.this).execute(new fb("OkHttp %s ACK Settings", new Object[] { e.this.d })
        {
          public void c()
          {
            try
            {
              e.this.o.a(paramk);
              return;
            }
            catch (IOException localIOException)
            {
              label18:
              break label18;
            }
            e.a(e.this);
          }
        });
        return;
      }
      catch (RejectedExecutionException paramk) {}
    }
    
    public void a() {}
    
    public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void a(int paramInt1, int paramInt2, List<a> paramList)
    {
      e.this.a(paramInt2, paramList);
    }
    
    public void a(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (e.this)
        {
          e locale = e.this;
          locale.j += paramLong;
          e.this.notifyAll();
          return;
        }
      }
      ??? = e.this.a(paramInt);
      if (??? != null) {
        try
        {
          ((g)???).a(paramLong);
          return;
        }
        finally {}
      }
    }
    
    public void a(int paramInt, ErrorCode paramErrorCode)
    {
      if (e.this.c(paramInt))
      {
        e.this.c(paramInt, paramErrorCode);
        return;
      }
      g localg = e.this.b(paramInt);
      if (localg != null) {
        localg.c(paramErrorCode);
      }
    }
    
    public void a(int paramInt, ErrorCode arg2, ByteString paramByteString)
    {
      paramByteString.g();
      synchronized (e.this)
      {
        paramByteString = (g[])e.this.c.values().toArray(new g[e.this.c.size()]);
        e.this.g = true;
        int j = paramByteString.length;
        int i = 0;
        while (i < j)
        {
          ??? = paramByteString[i];
          if ((???.a() > paramInt) && (???.c()))
          {
            ???.c(ErrorCode.REFUSED_STREAM);
            e.this.b(???.a());
          }
          i += 1;
        }
        return;
      }
    }
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2)
    {
      if (paramBoolean) {
        synchronized (e.this)
        {
          e.a(e.this, false);
          e.this.notifyAll();
          return;
        }
      }
      try
      {
        e.b(e.this).execute(new e.c(e.this, true, paramInt1, paramInt2));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException) {}
    }
    
    public void a(boolean paramBoolean, int paramInt1, int paramInt2, final List<a> paramList)
    {
      if (e.this.c(paramInt1))
      {
        e.this.a(paramInt1, paramList, paramBoolean);
        return;
      }
      synchronized (e.this)
      {
        g localg = e.this.a(paramInt1);
        if (localg == null)
        {
          if (e.this.g) {
            return;
          }
          if (paramInt1 <= e.this.e) {
            return;
          }
          if (paramInt1 % 2 == e.this.f % 2) {
            return;
          }
          paramList = new g(paramInt1, e.this, false, paramBoolean, paramList);
          e.this.e = paramInt1;
          e.this.c.put(Integer.valueOf(paramInt1), paramList);
          e.e().execute(new fb("OkHttp %s stream %d", new Object[] { e.this.d, Integer.valueOf(paramInt1) })
          {
            public void c()
            {
              try
              {
                e.this.b.a(paramList);
                return;
              }
              catch (IOException localIOException1)
              {
                gc localgc = gc.c();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Http2Connection.Listener failure for ");
                localStringBuilder.append(e.this.d);
                localgc.a(4, localStringBuilder.toString(), localIOException1);
                try
                {
                  paramList.a(ErrorCode.PROTOCOL_ERROR);
                  return;
                }
                catch (IOException localIOException2) {}
              }
            }
          });
          return;
        }
        localg.a(paramList);
        if (paramBoolean) {
          localg.i();
        }
        return;
      }
    }
    
    public void a(boolean paramBoolean, int paramInt1, okio.e parame, int paramInt2)
    {
      if (e.this.c(paramInt1))
      {
        e.this.a(paramInt1, parame, paramInt2, paramBoolean);
        return;
      }
      Object localObject = e.this.a(paramInt1);
      if (localObject == null)
      {
        e.this.a(paramInt1, ErrorCode.PROTOCOL_ERROR);
        localObject = e.this;
        long l = paramInt2;
        ((e)localObject).a(l);
        parame.h(l);
        return;
      }
      ((g)localObject).a(parame, paramInt2);
      if (paramBoolean) {
        ((g)localObject).i();
      }
    }
    
    public void a(boolean paramBoolean, k paramk)
    {
      for (;;)
      {
        synchronized (e.this)
        {
          int i = e.this.l.d();
          if (paramBoolean) {
            e.this.l.a();
          }
          e.this.l.a(paramk);
          a(paramk);
          int j = e.this.l.d();
          paramk = null;
          if ((j != -1) && (j != i))
          {
            long l2 = j - i;
            if (!e.this.m) {
              e.this.m = true;
            }
            l1 = l2;
            if (!e.this.c.isEmpty())
            {
              paramk = (g[])e.this.c.values().toArray(new g[e.this.c.size()]);
              l1 = l2;
            }
            ExecutorService localExecutorService = e.e();
            String str = e.this.d;
            i = 0;
            localExecutorService.execute(new fb("OkHttp %s settings", new Object[] { str })
            {
              public void c()
              {
                e.this.b.a(e.this);
              }
            });
            if ((paramk != null) && (l1 != 0L))
            {
              j = paramk.length;
              if (i < j) {
                synchronized (paramk[i])
                {
                  ???.a(l1);
                  i += 1;
                }
              }
            }
            return;
          }
        }
        long l1 = 0L;
      }
    }
    
    /* Error */
    protected void c()
    {
      // Byte code:
      //   0: getstatic 229	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   3: astore_3
      //   4: getstatic 229	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   7: astore 5
      //   9: aload_3
      //   10: astore_1
      //   11: aload_3
      //   12: astore_2
      //   13: aload_0
      //   14: getfield 35	okhttp3/internal/http2/e$d:a	Lokhttp3/internal/http2/f;
      //   17: aload_0
      //   18: invokevirtual 234	okhttp3/internal/http2/f:a	(Lokhttp3/internal/http2/f$b;)V
      //   21: aload_3
      //   22: astore_1
      //   23: aload_3
      //   24: astore_2
      //   25: aload_0
      //   26: getfield 35	okhttp3/internal/http2/e$d:a	Lokhttp3/internal/http2/f;
      //   29: iconst_0
      //   30: aload_0
      //   31: invokevirtual 237	okhttp3/internal/http2/f:a	(ZLokhttp3/internal/http2/f$b;)Z
      //   34: ifeq +6 -> 40
      //   37: goto -16 -> 21
      //   40: aload_3
      //   41: astore_1
      //   42: aload_3
      //   43: astore_2
      //   44: getstatic 240	okhttp3/internal/http2/ErrorCode:NO_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   47: astore_3
      //   48: aload_3
      //   49: astore_1
      //   50: aload_3
      //   51: astore_2
      //   52: getstatic 243	okhttp3/internal/http2/ErrorCode:CANCEL	Lokhttp3/internal/http2/ErrorCode;
      //   55: astore 4
      //   57: aload_0
      //   58: getfield 23	okhttp3/internal/http2/e$d:c	Lokhttp3/internal/http2/e;
      //   61: astore 5
      //   63: aload_3
      //   64: astore_2
      //   65: aload 4
      //   67: astore_1
      //   68: aload 5
      //   70: astore_3
      //   71: goto +28 -> 99
      //   74: astore_2
      //   75: goto +38 -> 113
      //   78: aload_2
      //   79: astore_1
      //   80: getstatic 188	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   83: astore_2
      //   84: aload_2
      //   85: astore_1
      //   86: getstatic 188	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   89: astore 4
      //   91: aload_0
      //   92: getfield 23	okhttp3/internal/http2/e$d:c	Lokhttp3/internal/http2/e;
      //   95: astore_3
      //   96: aload 4
      //   98: astore_1
      //   99: aload_3
      //   100: aload_2
      //   101: aload_1
      //   102: invokevirtual 246	okhttp3/internal/http2/e:a	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   105: aload_0
      //   106: getfield 35	okhttp3/internal/http2/e$d:a	Lokhttp3/internal/http2/f;
      //   109: invokestatic 251	com/tencent/token/fc:a	(Ljava/io/Closeable;)V
      //   112: return
      //   113: aload_0
      //   114: getfield 23	okhttp3/internal/http2/e$d:c	Lokhttp3/internal/http2/e;
      //   117: aload_1
      //   118: aload 5
      //   120: invokevirtual 246	okhttp3/internal/http2/e:a	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   123: aload_0
      //   124: getfield 35	okhttp3/internal/http2/e$d:a	Lokhttp3/internal/http2/f;
      //   127: invokestatic 251	com/tencent/token/fc:a	(Ljava/io/Closeable;)V
      //   130: aload_2
      //   131: athrow
      //   132: astore_1
      //   133: goto -55 -> 78
      //   136: astore_1
      //   137: goto -32 -> 105
      //   140: astore_1
      //   141: goto -18 -> 123
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	144	0	this	d
      //   10	108	1	localObject1	Object
      //   132	1	1	localIOException1	IOException
      //   136	1	1	localIOException2	IOException
      //   140	1	1	localIOException3	IOException
      //   12	53	2	localObject2	Object
      //   74	5	2	localObject3	Object
      //   83	48	2	localErrorCode1	ErrorCode
      //   3	97	3	localObject4	Object
      //   55	42	4	localErrorCode2	ErrorCode
      //   7	112	5	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   13	21	74	finally
      //   25	37	74	finally
      //   44	48	74	finally
      //   52	57	74	finally
      //   80	84	74	finally
      //   86	91	74	finally
      //   13	21	132	java/io/IOException
      //   25	37	132	java/io/IOException
      //   44	48	132	java/io/IOException
      //   52	57	132	java/io/IOException
      //   57	63	136	java/io/IOException
      //   91	96	136	java/io/IOException
      //   99	105	136	java/io/IOException
      //   113	123	140	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.e
 * JD-Core Version:    0.7.0.1
 */