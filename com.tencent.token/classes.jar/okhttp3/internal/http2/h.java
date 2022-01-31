package okhttp3.internal.http2;

import com.tencent.token.gm;
import com.tencent.token.gn;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
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
import okio.f;

public final class h
  implements Closeable
{
  private static final ExecutorService s;
  final boolean a;
  final p b;
  final Map c = new LinkedHashMap();
  final String d;
  int e;
  int f;
  boolean g;
  final ag h;
  long i = 0L;
  long j;
  ai k = new ai();
  final ai l = new ai();
  boolean m = false;
  final Socket n;
  final ad o;
  final s p;
  final Set q = new LinkedHashSet();
  private final ScheduledExecutorService t;
  private final ExecutorService u;
  private boolean v;
  
  static
  {
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      r = bool;
      s = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), gn.a("OkHttp Http2Connection", true));
      return;
    }
  }
  
  h(o paramo)
  {
    this.h = paramo.f;
    this.a = paramo.g;
    this.b = paramo.e;
    if (paramo.g) {}
    for (int i1 = 1;; i1 = 2)
    {
      this.f = i1;
      if (paramo.g) {
        this.f += 2;
      }
      if (paramo.g) {
        this.k.a(7, 16777216);
      }
      this.d = paramo.b;
      this.t = new ScheduledThreadPoolExecutor(1, gn.a(gn.a("OkHttp %s Writer", new Object[] { this.d }), false));
      if (paramo.h != 0) {
        this.t.scheduleAtFixedRate(new r(this, false, 0, 0), paramo.h, paramo.h, TimeUnit.MILLISECONDS);
      }
      this.u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), gn.a(gn.a("OkHttp %s Push Observer", new Object[] { this.d }), true));
      this.l.a(7, 65535);
      this.l.a(5, 16384);
      this.j = this.l.d();
      this.n = paramo.a;
      this.o = new ad(paramo.d, this.a);
      this.p = new s(this, new w(paramo.c, this.a));
      return;
    }
  }
  
  private void a(gm paramgm)
  {
    try
    {
      if (!d()) {
        this.u.execute(paramgm);
      }
      return;
    }
    finally
    {
      paramgm = finally;
      throw paramgm;
    }
  }
  
  private z b(int paramInt, List paramList, boolean paramBoolean)
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
    z localz = new z(i2, this, bool, false, paramList);
    if ((paramBoolean) && (this.j != 0L) && (localz.b != 0L)) {}
    for (;;)
    {
      if (localz.b()) {
        this.c.put(Integer.valueOf(i2), localz);
      }
      if (paramInt == 0) {
        this.o.a(bool, i2, paramInt, paramList);
      }
      for (;;)
      {
        if (i1 != 0) {
          this.o.b();
        }
        return localz;
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
  
  z a(int paramInt)
  {
    try
    {
      z localz = (z)this.c.get(Integer.valueOf(paramInt));
      return localz;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public z a(List paramList, boolean paramBoolean)
  {
    return b(0, paramList, paramBoolean);
  }
  
  void a(int paramInt, long paramLong)
  {
    try
    {
      this.t.execute(new j(this, "OkHttp Window Update %s stream %d", new Object[] { this.d, Integer.valueOf(paramInt) }, paramInt, paramLong));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException) {}
  }
  
  /* Error */
  void a(int paramInt, List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 104	okhttp3/internal/http2/h:q	Ljava/util/Set;
    //   6: iload_1
    //   7: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 303 2 0
    //   15: ifeq +14 -> 29
    //   18: aload_0
    //   19: iload_1
    //   20: getstatic 271	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
    //   23: invokevirtual 306	okhttp3/internal/http2/h:a	(ILokhttp3/internal/http2/ErrorCode;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield 104	okhttp3/internal/http2/h:q	Ljava/util/Set;
    //   33: iload_1
    //   34: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: invokeinterface 309 2 0
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: new 311	okhttp3/internal/http2/k
    //   49: dup
    //   50: aload_0
    //   51: ldc_w 313
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: getfield 128	okhttp3/internal/http2/h:d	Ljava/lang/String;
    //   64: aastore
    //   65: dup
    //   66: iconst_1
    //   67: iload_1
    //   68: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: aastore
    //   72: iload_1
    //   73: aload_2
    //   74: invokespecial 316	okhttp3/internal/http2/k:<init>	(Lokhttp3/internal/http2/h;Ljava/lang/String;[Ljava/lang/Object;ILjava/util/List;)V
    //   77: invokespecial 318	okhttp3/internal/http2/h:a	(Lcom/tencent/token/gm;)V
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
    //   0	88	0	this	h
    //   0	88	1	paramInt	int
    //   0	88	2	paramList	List
    // Exception table:
    //   from	to	target	type
    //   45	80	81	java/util/concurrent/RejectedExecutionException
    //   2	28	83	finally
    //   29	45	83	finally
    //   84	86	83	finally
  }
  
  void a(int paramInt, List paramList, boolean paramBoolean)
  {
    try
    {
      a(new l(this, "OkHttp %s Push Headers[%s]", new Object[] { this.d, Integer.valueOf(paramInt) }, paramInt, paramList, paramBoolean));
      return;
    }
    catch (RejectedExecutionException paramList) {}
  }
  
  void a(int paramInt, ErrorCode paramErrorCode)
  {
    try
    {
      this.t.execute(new i(this, "OkHttp %s stream %d", new Object[] { this.d, Integer.valueOf(paramInt) }, paramInt, paramErrorCode));
      return;
    }
    catch (RejectedExecutionException paramErrorCode) {}
  }
  
  void a(int paramInt1, okio.i parami, int paramInt2, boolean paramBoolean)
  {
    f localf = new f();
    parami.a(paramInt2);
    parami.a(localf, paramInt2);
    if (localf.b() != paramInt2) {
      throw new IOException(localf.b() + " != " + paramInt2);
    }
    a(new m(this, "OkHttp %s Push Data[%s]", new Object[] { this.d, Integer.valueOf(paramInt1) }, paramInt1, localf, paramInt2, paramBoolean));
  }
  
  public void a(int paramInt, boolean paramBoolean, f paramf, long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      this.o.a(paramBoolean, paramInt, paramf, 0);
      return;
    }
    for (;;)
    {
      try
      {
        int i1 = Math.min((int)Math.min(l1, this.j), this.o.c());
        this.j -= i1;
        l1 -= i1;
        ad localad = this.o;
        if ((!paramBoolean) || (l1 != 0L)) {
          break label170;
        }
        bool = true;
        localad.a(bool, paramInt, paramf, i1);
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
        catch (InterruptedException paramf)
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
    //   0: getstatic 52	okhttp3/internal/http2/h:r	Z
    //   3: ifne +18 -> 21
    //   6: aload_0
    //   7: invokestatic 425	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   10: ifeq +11 -> 21
    //   13: new 427	java/lang/AssertionError
    //   16: dup
    //   17: invokespecial 428	java/lang/AssertionError:<init>	()V
    //   20: athrow
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 225	okhttp3/internal/http2/h:a	(Lokhttp3/internal/http2/ErrorCode;)V
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_0
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 88	okhttp3/internal/http2/h:c	Ljava/util/Map;
    //   34: invokeinterface 431 1 0
    //   39: ifne +177 -> 216
    //   42: aload_0
    //   43: getfield 88	okhttp3/internal/http2/h:c	Ljava/util/Map;
    //   46: invokeinterface 435 1 0
    //   51: aload_0
    //   52: getfield 88	okhttp3/internal/http2/h:c	Ljava/util/Map;
    //   55: invokeinterface 438 1 0
    //   60: anewarray 231	okhttp3/internal/http2/z
    //   63: invokeinterface 444 2 0
    //   68: checkcast 446	[Lokhttp3/internal/http2/z;
    //   71: astore 6
    //   73: aload_0
    //   74: getfield 88	okhttp3/internal/http2/h:c	Ljava/util/Map;
    //   77: invokeinterface 449 1 0
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
    //   114: invokevirtual 450	okhttp3/internal/http2/z:a	(Lokhttp3/internal/http2/ErrorCode;)V
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
    //   155: getfield 183	okhttp3/internal/http2/h:o	Lokhttp3/internal/http2/ad;
    //   158: invokevirtual 453	okhttp3/internal/http2/ad:close	()V
    //   161: aload 5
    //   163: astore_1
    //   164: aload_0
    //   165: getfield 173	okhttp3/internal/http2/h:n	Ljava/net/Socket;
    //   168: invokevirtual 456	java/net/Socket:close	()V
    //   171: aload_0
    //   172: getfield 140	okhttp3/internal/http2/h:t	Ljava/util/concurrent/ScheduledExecutorService;
    //   175: invokeinterface 459 1 0
    //   180: aload_0
    //   181: getfield 163	okhttp3/internal/http2/h:u	Ljava/util/concurrent/ExecutorService;
    //   184: invokeinterface 460 1 0
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
    //   0	222	0	this	h
    //   0	222	1	paramErrorCode1	ErrorCode
    //   0	222	2	paramErrorCode2	ErrorCode
    //   98	26	3	i1	int
    //   95	8	4	i2	int
    //   85	117	5	localObject	Object
    //   71	147	6	arrayOfz	z[]
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
  
  z b(int paramInt)
  {
    try
    {
      z localz = (z)this.c.remove(Integer.valueOf(paramInt));
      notifyAll();
      return localz;
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
  
  void c(int paramInt, ErrorCode paramErrorCode)
  {
    a(new n(this, "OkHttp %s Push Reset[%s]", new Object[] { this.d, Integer.valueOf(paramInt) }, paramInt, paramErrorCode));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.h
 * JD-Core Version:    0.7.0.1
 */