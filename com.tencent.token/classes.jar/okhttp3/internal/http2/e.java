package okhttp3.internal.http2;

import com.tencent.token.fa;
import com.tencent.token.fb;
import com.tencent.token.gb;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
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
  private static final ExecutorService s;
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
  
  static
  {
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      r = bool;
      s = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), fb.a("OkHttp Http2Connection", true));
      return;
    }
  }
  
  e(a parama)
  {
    this.h = parama.f;
    this.a = parama.g;
    this.b = parama.e;
    if (parama.g) {}
    for (int i1 = 1;; i1 = 2)
    {
      this.f = i1;
      if (parama.g) {
        this.f += 2;
      }
      if (parama.g) {
        this.k.a(7, 16777216);
      }
      this.d = parama.b;
      this.t = new ScheduledThreadPoolExecutor(1, fb.a(fb.a("OkHttp %s Writer", new Object[] { this.d }), false));
      if (parama.h != 0) {
        this.t.scheduleAtFixedRate(new c(false, 0, 0), parama.h, parama.h, TimeUnit.MILLISECONDS);
      }
      this.u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), fb.a(fb.a("OkHttp %s Push Observer", new Object[] { this.d }), true));
      this.l.a(7, 65535);
      this.l.a(5, 16384);
      this.j = this.l.d();
      this.n = parama.a;
      this.o = new h(parama.d, this.a);
      this.p = new d(new f(parama.c, this.a));
      return;
    }
  }
  
  private void a(fa paramfa)
  {
    try
    {
      if (!d()) {
        this.u.execute(paramfa);
      }
      return;
    }
    finally
    {
      paramfa = finally;
      throw paramfa;
    }
  }
  
  private g b(int paramInt, List<a> paramList, boolean paramBoolean)
  {
    int i1 = 0;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false) {
      synchronized (this.o)
      {
        try
        {
          if (this.f > 1073741823) {
            a(ErrorCode.REFUSED_STREAM);
          }
          if (!this.g) {
            break;
          }
          throw new ConnectionShutdownException();
        }
        finally {}
      }
    }
    int i2 = this.f;
    this.f += 2;
    g localg = new g(i2, this, bool, false, paramList);
    if ((paramBoolean) && (this.j != 0L) && (localg.b != 0L)) {}
    for (;;)
    {
      if (localg.b()) {
        this.c.put(Integer.valueOf(i2), localg);
      }
      if (paramInt == 0) {
        this.o.a(bool, i2, paramInt, paramList);
      }
      for (;;)
      {
        if (i1 != 0) {
          this.o.b();
        }
        return localg;
        if (this.a) {
          throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
        }
        this.o.a(paramInt, i2, paramList);
      }
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
      this.t.execute(new fa("OkHttp Window Update %s stream %d", new Object[] { this.d, Integer.valueOf(paramInt) })
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
            e.a(e.this);
          }
        }
      });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException) {}
  }
  
  /* Error */
  void a(final int paramInt, final List<a> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 134	okhttp3/internal/http2/e:q	Ljava/util/Set;
    //   6: iload_1
    //   7: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 328 2 0
    //   15: ifeq +14 -> 29
    //   18: aload_0
    //   19: iload_1
    //   20: getstatic 297	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   23: invokevirtual 331	okhttp3/internal/http2/e:a	(ILokhttp3/internal/http2/ErrorCode;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 134	okhttp3/internal/http2/e:q	Ljava/util/Set;
    //   33: iload_1
    //   34: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: invokeinterface 334 2 0
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: new 12	okhttp3/internal/http2/e$3
    //   49: dup
    //   50: aload_0
    //   51: ldc_w 336
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 156	okhttp3/internal/http2/e:d	Ljava/lang/String;
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: iload_1
    //   68: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: aastore
    //   72: iload_1
    //   73: aload_2
    //   74: invokespecial 339	okhttp3/internal/http2/e$3:<init>	(Lokhttp3/internal/http2/e;Ljava/lang/String;[Ljava/lang/Object;ILjava/util/List;)V
    //   77: invokespecial 341	okhttp3/internal/http2/e:a	(Lcom/tencent/token/fa;)V
    //   80: return
    //   81: astore_2
    //   82: return
    //   83: astore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_2
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	e
    //   0	88	1	paramInt	int
    //   0	88	2	paramList	List<a>
    // Exception table:
    //   from	to	target	type
    //   45	80	81	java/util/concurrent/RejectedExecutionException
    //   2	28	83	finally
    //   29	45	83	finally
    //   84	86	83	finally
  }
  
  void a(final int paramInt, final List<a> paramList, final boolean paramBoolean)
  {
    try
    {
      a(new fa("OkHttp %s Push Headers[%s]", new Object[] { this.d, Integer.valueOf(paramInt) })
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
      this.t.execute(new fa("OkHttp %s stream %d", new Object[] { this.d, Integer.valueOf(paramInt) })
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
            e.a(e.this);
          }
        }
      });
      return;
    }
    catch (RejectedExecutionException paramErrorCode) {}
  }
  
  void a(final int paramInt1, okio.e parame, final int paramInt2, final boolean paramBoolean)
  {
    final c localc = new c();
    parame.a(paramInt2);
    parame.a(localc, paramInt2);
    if (localc.b() != paramInt2) {
      throw new IOException(localc.b() + " != " + paramInt2);
    }
    a(new fa("OkHttp %s Push Data[%s]", new Object[] { this.d, Integer.valueOf(paramInt1) })
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
  }
  
  public void a(int paramInt, boolean paramBoolean, c paramc, long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      this.o.a(paramBoolean, paramInt, paramc, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i1 = Math.min((int)Math.min(l1, this.j), this.o.c());
        this.j -= i1;
        l1 -= i1;
        h localh = this.o;
        if ((!paramBoolean) || (l1 != 0L)) {
          break label170;
        }
        bool = true;
        localh.a(bool, paramInt, paramc, i1);
        if (l1 <= 0L) {
          break;
        }
        try
        {
          if (this.j > 0L) {
            continue;
          }
          if (!this.c.containsKey(Integer.valueOf(paramInt))) {
            throw new IOException("stream closed");
          }
        }
        catch (InterruptedException paramc)
        {
          Thread.currentThread().interrupt();
          throw new InterruptedIOException();
        }
        wait();
      }
      finally {}
      continue;
      label170:
      boolean bool = false;
    }
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
    int i1;
    synchronized (this.o) {}
  }
  
  /* Error */
  void a(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2)
  {
    // Byte code:
    //   0: getstatic 82	okhttp3/internal/http2/e:r	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 444	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 446	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 447	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 249	okhttp3/internal/http2/e:a	(Lokhttp3/internal/http2/ErrorCode;)V
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 118	okhttp3/internal/http2/e:c	Ljava/util/Map;
    //   34: invokeinterface 450 1 0
    //   39: ifne +177 -> 216
    //   42: aload_0
    //   43: getfield 118	okhttp3/internal/http2/e:c	Ljava/util/Map;
    //   46: invokeinterface 454 1 0
    //   51: aload_0
    //   52: getfield 118	okhttp3/internal/http2/e:c	Ljava/util/Map;
    //   55: invokeinterface 457 1 0
    //   60: anewarray 255	okhttp3/internal/http2/g
    //   63: invokeinterface 463 2 0
    //   68: checkcast 465	[Lokhttp3/internal/http2/g;
    //   71: astore 6
    //   73: aload_0
    //   74: getfield 118	okhttp3/internal/http2/e:c	Ljava/util/Map;
    //   77: invokeinterface 468 1 0
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: astore 5
    //   87: aload 6
    //   89: ifnull +65 -> 154
    //   92: aload 6
    //   94: arraylength
    //   95: istore 4
    //   97: iconst_0
    //   98: istore_3
    //   99: iload_3
    //   100: iload 4
    //   102: if_icmpge +49 -> 151
    //   105: aload 6
    //   107: iload_3
    //   108: aaload
    //   109: astore 5
    //   111: aload 5
    //   113: aload_2
    //   114: invokevirtual 469	okhttp3/internal/http2/g:a	(Lokhttp3/internal/http2/ErrorCode;)V
    //   117: aload_1
    //   118: astore 5
    //   120: iload_3
    //   121: iconst_1
    //   122: iadd
    //   123: istore_3
    //   124: aload 5
    //   126: astore_1
    //   127: goto -28 -> 99
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: astore 7
    //   137: aload_1
    //   138: astore 5
    //   140: aload_1
    //   141: ifnull -21 -> 120
    //   144: aload 7
    //   146: astore 5
    //   148: goto -28 -> 120
    //   151: aload_1
    //   152: astore 5
    //   154: aload_0
    //   155: getfield 209	okhttp3/internal/http2/e:o	Lokhttp3/internal/http2/h;
    //   158: invokevirtual 472	okhttp3/internal/http2/h:close	()V
    //   161: aload 5
    //   163: astore_1
    //   164: aload_0
    //   165: getfield 199	okhttp3/internal/http2/e:n	Ljava/net/Socket;
    //   168: invokevirtual 475	java/net/Socket:close	()V
    //   171: aload_0
    //   172: getfield 168	okhttp3/internal/http2/e:t	Ljava/util/concurrent/ScheduledExecutorService;
    //   175: invokeinterface 478 1 0
    //   180: aload_0
    //   181: getfield 189	okhttp3/internal/http2/e:u	Ljava/util/concurrent/ExecutorService;
    //   184: invokeinterface 479 1 0
    //   189: aload_1
    //   190: ifnull +21 -> 211
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: aload 5
    //   198: ifnull -34 -> 164
    //   201: aload 5
    //   203: astore_1
    //   204: goto -40 -> 164
    //   207: astore_1
    //   208: goto -180 -> 28
    //   211: return
    //   212: astore_1
    //   213: goto -42 -> 171
    //   216: aconst_null
    //   217: astore 6
    //   219: goto -137 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	e
    //   0	222	1	paramErrorCode1	ErrorCode
    //   0	222	2	paramErrorCode2	ErrorCode
    //   98	26	3	i1	int
    //   95	8	4	i2	int
    //   85	117	5	localObject	Object
    //   71	147	6	arrayOfg	g[]
    //   135	10	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   30	82	130	finally
    //   82	84	130	finally
    //   131	133	130	finally
    //   111	117	135	java/io/IOException
    //   154	161	195	java/io/IOException
    //   21	26	207	java/io/IOException
    //   164	171	212	java/io/IOException
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
      f();
    }
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
    a(new fa("OkHttp %s Push Reset[%s]", new Object[] { this.d, Integer.valueOf(paramInt) })
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
    extends fa
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
    extends fa
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
        e.b(e.this).execute(new fa("OkHttp %s ACK Settings", new Object[] { e.this.d })
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
              e.a(e.this);
            }
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
      if (e.this.c(paramInt)) {
        e.this.c(paramInt, paramErrorCode);
      }
      g localg;
      do
      {
        return;
        localg = e.this.b(paramInt);
      } while (localg == null);
      localg.c(paramErrorCode);
    }
    
    public void a(int paramInt, ErrorCode arg2, ByteString paramByteString)
    {
      if (paramByteString.g() > 0) {}
      synchronized (e.this)
      {
        paramByteString = (g[])e.this.c.values().toArray(new g[e.this.c.size()]);
        e.this.g = true;
        int j = paramByteString.length;
        int i = 0;
        if (i < j)
        {
          ??? = paramByteString[i];
          if ((???.a() > paramInt) && (???.c()))
          {
            ???.c(ErrorCode.REFUSED_STREAM);
            e.this.b(???.a());
          }
          i += 1;
        }
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
      if (e.this.c(paramInt1)) {
        e.this.a(paramInt1, paramList, paramBoolean);
      }
      g localg;
      label193:
      do
      {
        return;
        synchronized (e.this)
        {
          localg = e.this.a(paramInt1);
          if (localg != null) {
            break label193;
          }
          if (e.this.g) {
            return;
          }
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
        e.e().execute(new fa("OkHttp %s stream %d", new Object[] { e.this.d, Integer.valueOf(paramInt1) })
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
              gb.c().a(4, "Http2Connection.Listener failure for " + e.this.d, localIOException1);
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
        localg.a(paramList);
      } while (!paramBoolean);
      localg.i();
    }
    
    public void a(boolean paramBoolean, int paramInt1, okio.e parame, int paramInt2)
    {
      if (e.this.c(paramInt1)) {
        e.this.a(paramInt1, parame, paramInt2, paramBoolean);
      }
      g localg;
      do
      {
        return;
        localg = e.this.a(paramInt1);
        if (localg == null)
        {
          e.this.a(paramInt1, ErrorCode.PROTOCOL_ERROR);
          e.this.a(paramInt2);
          parame.h(paramInt2);
          return;
        }
        localg.a(parame, paramInt2);
      } while (!paramBoolean);
      localg.i();
    }
    
    public void a(boolean paramBoolean, k paramk)
    {
      for (;;)
      {
        int i;
        synchronized (e.this)
        {
          i = e.this.l.d();
          if (paramBoolean) {
            e.this.l.a();
          }
          e.this.l.a(paramk);
          a(paramk);
          int j = e.this.l.d();
          if ((j == -1) || (j == i)) {
            break label251;
          }
          l = j - i;
          if (!e.this.m) {
            e.this.m = true;
          }
          if (e.this.c.isEmpty()) {
            break label246;
          }
          paramk = (g[])e.this.c.values().toArray(new g[e.this.c.size()]);
          e.e().execute(new fa("OkHttp %s settings", new Object[] { e.this.d })
          {
            public void c()
            {
              e.this.b.a(e.this);
            }
          });
          if ((paramk == null) || (l == 0L)) {
            break label245;
          }
          j = paramk.length;
          i = 0;
          if (i >= j) {
            break label245;
          }
        }
        synchronized (paramk[i])
        {
          ???.a(l);
          i += 1;
          continue;
          paramk = finally;
          throw paramk;
        }
        label245:
        return;
        label246:
        paramk = null;
        continue;
        label251:
        paramk = null;
        long l = 0L;
      }
    }
    
    /* Error */
    protected void c()
    {
      // Byte code:
      //   0: getstatic 229	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   3: astore_3
      //   4: getstatic 229	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   7: astore 4
      //   9: aload_3
      //   10: astore_2
      //   11: aload_3
      //   12: astore_1
      //   13: aload_0
      //   14: getfield 35	okhttp3/internal/http2/e$d:a	Lokhttp3/internal/http2/f;
      //   17: aload_0
      //   18: invokevirtual 234	okhttp3/internal/http2/f:a	(Lokhttp3/internal/http2/f$b;)V
      //   21: aload_3
      //   22: astore_2
      //   23: aload_3
      //   24: astore_1
      //   25: aload_0
      //   26: getfield 35	okhttp3/internal/http2/e$d:a	Lokhttp3/internal/http2/f;
      //   29: iconst_0
      //   30: aload_0
      //   31: invokevirtual 237	okhttp3/internal/http2/f:a	(ZLokhttp3/internal/http2/f$b;)Z
      //   34: ifne -13 -> 21
      //   37: aload_3
      //   38: astore_2
      //   39: aload_3
      //   40: astore_1
      //   41: getstatic 240	okhttp3/internal/http2/ErrorCode:NO_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   44: astore_3
      //   45: aload_3
      //   46: astore_2
      //   47: aload_3
      //   48: astore_1
      //   49: getstatic 243	okhttp3/internal/http2/ErrorCode:CANCEL	Lokhttp3/internal/http2/ErrorCode;
      //   52: astore 5
      //   54: aload_0
      //   55: getfield 23	okhttp3/internal/http2/e$d:c	Lokhttp3/internal/http2/e;
      //   58: aload_3
      //   59: aload 5
      //   61: invokevirtual 246	okhttp3/internal/http2/e:a	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   64: aload_0
      //   65: getfield 35	okhttp3/internal/http2/e$d:a	Lokhttp3/internal/http2/f;
      //   68: invokestatic 251	com/tencent/token/fb:a	(Ljava/io/Closeable;)V
      //   71: return
      //   72: astore_1
      //   73: aload_2
      //   74: astore_1
      //   75: getstatic 188	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   78: astore_3
      //   79: getstatic 188	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   82: astore_1
      //   83: aload_0
      //   84: getfield 23	okhttp3/internal/http2/e$d:c	Lokhttp3/internal/http2/e;
      //   87: aload_3
      //   88: aload_1
      //   89: invokevirtual 246	okhttp3/internal/http2/e:a	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   92: aload_0
      //   93: getfield 35	okhttp3/internal/http2/e$d:a	Lokhttp3/internal/http2/f;
      //   96: invokestatic 251	com/tencent/token/fb:a	(Ljava/io/Closeable;)V
      //   99: return
      //   100: astore_2
      //   101: aload_1
      //   102: astore_3
      //   103: aload_2
      //   104: astore_1
      //   105: aload_0
      //   106: getfield 23	okhttp3/internal/http2/e$d:c	Lokhttp3/internal/http2/e;
      //   109: aload_3
      //   110: aload 4
      //   112: invokevirtual 246	okhttp3/internal/http2/e:a	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;)V
      //   115: aload_0
      //   116: getfield 35	okhttp3/internal/http2/e$d:a	Lokhttp3/internal/http2/f;
      //   119: invokestatic 251	com/tencent/token/fb:a	(Ljava/io/Closeable;)V
      //   122: aload_1
      //   123: athrow
      //   124: astore_2
      //   125: goto -10 -> 115
      //   128: astore_1
      //   129: goto -24 -> 105
      //   132: astore_1
      //   133: goto -41 -> 92
      //   136: astore_1
      //   137: goto -73 -> 64
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	140	0	this	d
      //   12	37	1	localObject1	Object
      //   72	1	1	localIOException1	IOException
      //   74	49	1	localObject2	Object
      //   128	1	1	localObject3	Object
      //   132	1	1	localIOException2	IOException
      //   136	1	1	localIOException3	IOException
      //   10	64	2	localObject4	Object
      //   100	4	2	localObject5	Object
      //   124	1	2	localIOException4	IOException
      //   3	107	3	localObject6	Object
      //   7	104	4	localErrorCode1	ErrorCode
      //   52	8	5	localErrorCode2	ErrorCode
      // Exception table:
      //   from	to	target	type
      //   13	21	72	java/io/IOException
      //   25	37	72	java/io/IOException
      //   41	45	72	java/io/IOException
      //   49	54	72	java/io/IOException
      //   13	21	100	finally
      //   25	37	100	finally
      //   41	45	100	finally
      //   49	54	100	finally
      //   75	79	100	finally
      //   105	115	124	java/io/IOException
      //   79	83	128	finally
      //   83	92	132	java/io/IOException
      //   54	64	136	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.e
 * JD-Core Version:    0.7.0.1
 */