package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;
import okio.c;
import okio.p;
import okio.q;
import okio.r;

public final class g
{
  long a = 0L;
  long b;
  final int c;
  final e d;
  final a e;
  final c f = new c();
  final c g = new c();
  ErrorCode h = null;
  private final List<a> j;
  private List<a> k;
  private boolean l;
  private final b m;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      return;
    }
  }
  
  g(int paramInt, e parame, boolean paramBoolean1, boolean paramBoolean2, List<a> paramList)
  {
    if (parame == null) {
      throw new NullPointerException("connection == null");
    }
    if (paramList == null) {
      throw new NullPointerException("requestHeaders == null");
    }
    this.c = paramInt;
    this.d = parame;
    this.b = parame.l.d();
    this.m = new b(parame.k.d());
    this.e = new a();
    this.m.b = paramBoolean2;
    this.e.b = paramBoolean1;
    this.j = paramList;
  }
  
  private boolean d(ErrorCode paramErrorCode)
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      if (this.h != null) {
        return false;
      }
      if ((this.m.b) && (this.e.b)) {
        return false;
      }
    }
    finally {}
    this.h = paramErrorCode;
    notifyAll();
    this.d.b(this.c);
    return true;
  }
  
  public int a()
  {
    return this.c;
  }
  
  void a(long paramLong)
  {
    this.b += paramLong;
    if (paramLong > 0L) {
      notifyAll();
    }
  }
  
  /* Error */
  void a(List<a> paramList)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: getstatic 43	okhttp3/internal/http2/g:i	Z
    //   5: ifne +18 -> 23
    //   8: aload_0
    //   9: invokestatic 108	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   12: ifeq +11 -> 23
    //   15: new 110	java/lang/AssertionError
    //   18: dup
    //   19: invokespecial 111	java/lang/AssertionError:<init>	()V
    //   22: athrow
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: iconst_1
    //   27: putfield 121	okhttp3/internal/http2/g:l	Z
    //   30: aload_0
    //   31: getfield 123	okhttp3/internal/http2/g:k	Ljava/util/List;
    //   34: ifnonnull +36 -> 70
    //   37: aload_0
    //   38: aload_1
    //   39: putfield 123	okhttp3/internal/http2/g:k	Ljava/util/List;
    //   42: aload_0
    //   43: invokevirtual 125	okhttp3/internal/http2/g:b	()Z
    //   46: istore_2
    //   47: aload_0
    //   48: invokevirtual 114	java/lang/Object:notifyAll	()V
    //   51: aload_0
    //   52: monitorexit
    //   53: iload_2
    //   54: ifne +15 -> 69
    //   57: aload_0
    //   58: getfield 72	okhttp3/internal/http2/g:d	Lokhttp3/internal/http2/e;
    //   61: aload_0
    //   62: getfield 70	okhttp3/internal/http2/g:c	I
    //   65: invokevirtual 117	okhttp3/internal/http2/e:b	(I)Lokhttp3/internal/http2/g;
    //   68: pop
    //   69: return
    //   70: new 127	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 128	java/util/ArrayList:<init>	()V
    //   77: astore_3
    //   78: aload_3
    //   79: aload_0
    //   80: getfield 123	okhttp3/internal/http2/g:k	Ljava/util/List;
    //   83: invokeinterface 134 2 0
    //   88: pop
    //   89: aload_3
    //   90: aconst_null
    //   91: invokeinterface 137 2 0
    //   96: pop
    //   97: aload_3
    //   98: aload_1
    //   99: invokeinterface 134 2 0
    //   104: pop
    //   105: aload_0
    //   106: aload_3
    //   107: putfield 123	okhttp3/internal/http2/g:k	Ljava/util/List;
    //   110: goto -59 -> 51
    //   113: astore_1
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	g
    //   0	118	1	paramList	List<a>
    //   1	53	2	bool	boolean
    //   77	30	3	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   25	51	113	finally
    //   51	53	113	finally
    //   70	110	113	finally
    //   114	116	113	finally
  }
  
  public void a(ErrorCode paramErrorCode)
  {
    if (!d(paramErrorCode)) {
      return;
    }
    this.d.b(this.c, paramErrorCode);
  }
  
  void a(okio.e parame, int paramInt)
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    this.m.a(parame, paramInt);
  }
  
  public void b(ErrorCode paramErrorCode)
  {
    if (!d(paramErrorCode)) {
      return;
    }
    this.d.a(this.c, paramErrorCode);
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 59	okhttp3/internal/http2/g:h	Lokhttp3/internal/http2/ErrorCode;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 91	okhttp3/internal/http2/g:m	Lokhttp3/internal/http2/g$b;
    //   21: getfield 96	okhttp3/internal/http2/g$b:b	Z
    //   24: ifne +13 -> 37
    //   27: aload_0
    //   28: getfield 91	okhttp3/internal/http2/g:m	Lokhttp3/internal/http2/g$b;
    //   31: getfield 152	okhttp3/internal/http2/g$b:a	Z
    //   34: ifeq +32 -> 66
    //   37: aload_0
    //   38: getfield 94	okhttp3/internal/http2/g:e	Lokhttp3/internal/http2/g$a;
    //   41: getfield 97	okhttp3/internal/http2/g$a:b	Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: getfield 94	okhttp3/internal/http2/g:e	Lokhttp3/internal/http2/g$a;
    //   51: getfield 153	okhttp3/internal/http2/g$a:a	Z
    //   54: ifeq +12 -> 66
    //   57: aload_0
    //   58: getfield 121	okhttp3/internal/http2/g:l	Z
    //   61: istore_2
    //   62: iload_2
    //   63: ifne -50 -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -55 -> 13
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	g
    //   1	67	1	bool1	boolean
    //   61	2	2	bool2	boolean
    //   8	2	3	localErrorCode	ErrorCode
    //   71	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  void c(ErrorCode paramErrorCode)
  {
    try
    {
      if (this.h == null)
      {
        this.h = paramErrorCode;
        notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public boolean c()
  {
    if ((this.c & 0x1) == 1) {}
    for (int n = 1; this.d.a == n; n = 0) {
      return true;
    }
    return false;
  }
  
  public List<a> d()
  {
    try
    {
      if (!c()) {
        throw new IllegalStateException("servers cannot read response headers");
      }
    }
    finally {}
    this.f.c();
    try
    {
      while ((this.k == null) && (this.h == null)) {
        l();
      }
      localList = this.k;
    }
    finally
    {
      this.f.b();
    }
    List localList;
    if (localList != null)
    {
      this.k = null;
      return localList;
    }
    throw new StreamResetException(this.h);
  }
  
  public r e()
  {
    return this.f;
  }
  
  public r f()
  {
    return this.g;
  }
  
  public q g()
  {
    return this.m;
  }
  
  public p h()
  {
    try
    {
      if ((!this.l) && (!c())) {
        throw new IllegalStateException("reply before requesting the sink");
      }
    }
    finally {}
    return this.e;
  }
  
  void i()
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    try
    {
      this.m.b = true;
      boolean bool = b();
      notifyAll();
      if (!bool) {
        this.d.b(this.c);
      }
      return;
    }
    finally {}
  }
  
  void j()
  {
    if ((!i) && (Thread.holdsLock(this))) {
      throw new AssertionError();
    }
    for (;;)
    {
      try
      {
        boolean bool;
        if ((!this.m.b) && (this.m.a))
        {
          if (this.e.b) {
            break label112;
          }
          if (this.e.a)
          {
            break label112;
            bool = b();
            if (n == 0) {
              break label95;
            }
            a(ErrorCode.CANCEL);
            return;
          }
        }
        n = 0;
        continue;
        if (bool) {
          continue;
        }
      }
      finally {}
      label95:
      this.d.b(this.c);
      return;
      label112:
      int n = 1;
    }
  }
  
  void k()
  {
    if (this.e.a) {
      throw new IOException("stream closed");
    }
    if (this.e.b) {
      throw new IOException("stream finished");
    }
    if (this.h != null) {
      throw new StreamResetException(this.h);
    }
  }
  
  void l()
  {
    try
    {
      wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      throw new InterruptedIOException();
    }
  }
  
  final class a
    implements p
  {
    boolean a;
    boolean b;
    private final c e = new c();
    
    static
    {
      if (!g.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        c = bool;
        return;
      }
    }
    
    a() {}
    
    /* Error */
    private void a(boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   4: astore 5
      //   6: aload 5
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   13: getfield 43	okhttp3/internal/http2/g:g	Lokhttp3/internal/http2/g$c;
      //   16: invokevirtual 47	okhttp3/internal/http2/g$c:c	()V
      //   19: aload_0
      //   20: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   23: getfield 50	okhttp3/internal/http2/g:b	J
      //   26: lconst_0
      //   27: lcmp
      //   28: ifgt +60 -> 88
      //   31: aload_0
      //   32: getfield 52	okhttp3/internal/http2/g$a:b	Z
      //   35: ifne +53 -> 88
      //   38: aload_0
      //   39: getfield 54	okhttp3/internal/http2/g$a:a	Z
      //   42: ifne +46 -> 88
      //   45: aload_0
      //   46: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   49: getfield 58	okhttp3/internal/http2/g:h	Lokhttp3/internal/http2/ErrorCode;
      //   52: ifnonnull +36 -> 88
      //   55: aload_0
      //   56: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   59: invokevirtual 61	okhttp3/internal/http2/g:l	()V
      //   62: goto -43 -> 19
      //   65: astore 6
      //   67: aload_0
      //   68: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   71: getfield 43	okhttp3/internal/http2/g:g	Lokhttp3/internal/http2/g$c;
      //   74: invokevirtual 63	okhttp3/internal/http2/g$c:b	()V
      //   77: aload 6
      //   79: athrow
      //   80: astore 6
      //   82: aload 5
      //   84: monitorexit
      //   85: aload 6
      //   87: athrow
      //   88: aload_0
      //   89: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   92: getfield 43	okhttp3/internal/http2/g:g	Lokhttp3/internal/http2/g$c;
      //   95: invokevirtual 63	okhttp3/internal/http2/g$c:b	()V
      //   98: aload_0
      //   99: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   102: invokevirtual 66	okhttp3/internal/http2/g:k	()V
      //   105: aload_0
      //   106: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   109: getfield 50	okhttp3/internal/http2/g:b	J
      //   112: aload_0
      //   113: getfield 38	okhttp3/internal/http2/g$a:e	Lokio/c;
      //   116: invokevirtual 69	okio/c:b	()J
      //   119: invokestatic 75	java/lang/Math:min	(JJ)J
      //   122: lstore_3
      //   123: aload_0
      //   124: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   127: astore 6
      //   129: aload 6
      //   131: aload 6
      //   133: getfield 50	okhttp3/internal/http2/g:b	J
      //   136: lload_3
      //   137: lsub
      //   138: putfield 50	okhttp3/internal/http2/g:b	J
      //   141: aload 5
      //   143: monitorexit
      //   144: aload_0
      //   145: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   148: getfield 43	okhttp3/internal/http2/g:g	Lokhttp3/internal/http2/g$c;
      //   151: invokevirtual 47	okhttp3/internal/http2/g$c:c	()V
      //   154: aload_0
      //   155: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   158: getfield 78	okhttp3/internal/http2/g:d	Lokhttp3/internal/http2/e;
      //   161: astore 5
      //   163: aload_0
      //   164: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   167: getfield 81	okhttp3/internal/http2/g:c	I
      //   170: istore_2
      //   171: iload_1
      //   172: ifeq +40 -> 212
      //   175: lload_3
      //   176: aload_0
      //   177: getfield 38	okhttp3/internal/http2/g$a:e	Lokio/c;
      //   180: invokevirtual 69	okio/c:b	()J
      //   183: lcmp
      //   184: ifne +28 -> 212
      //   187: iconst_1
      //   188: istore_1
      //   189: aload 5
      //   191: iload_2
      //   192: iload_1
      //   193: aload_0
      //   194: getfield 38	okhttp3/internal/http2/g$a:e	Lokio/c;
      //   197: lload_3
      //   198: invokevirtual 86	okhttp3/internal/http2/e:a	(IZLokio/c;J)V
      //   201: aload_0
      //   202: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   205: getfield 43	okhttp3/internal/http2/g:g	Lokhttp3/internal/http2/g$c;
      //   208: invokevirtual 63	okhttp3/internal/http2/g$c:b	()V
      //   211: return
      //   212: iconst_0
      //   213: istore_1
      //   214: goto -25 -> 189
      //   217: astore 5
      //   219: aload_0
      //   220: getfield 31	okhttp3/internal/http2/g$a:d	Lokhttp3/internal/http2/g;
      //   223: getfield 43	okhttp3/internal/http2/g:g	Lokhttp3/internal/http2/g$c;
      //   226: invokevirtual 63	okhttp3/internal/http2/g$c:b	()V
      //   229: aload 5
      //   231: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	232	0	this	a
      //   0	232	1	paramBoolean	boolean
      //   170	22	2	i	int
      //   122	76	3	l	long
      //   4	186	5	localObject1	Object
      //   217	13	5	localObject2	Object
      //   65	13	6	localObject3	Object
      //   80	6	6	localObject4	Object
      //   127	5	6	localg	g
      // Exception table:
      //   from	to	target	type
      //   19	62	65	finally
      //   9	19	80	finally
      //   67	80	80	finally
      //   82	85	80	finally
      //   88	144	80	finally
      //   154	171	217	finally
      //   175	187	217	finally
      //   189	201	217	finally
    }
    
    public r a()
    {
      return g.this.g;
    }
    
    public void a_(c paramc, long paramLong)
    {
      if ((!c) && (Thread.holdsLock(g.this))) {
        throw new AssertionError();
      }
      this.e.a_(paramc, paramLong);
      while (this.e.b() >= 16384L) {
        a(false);
      }
    }
    
    public void close()
    {
      if ((!c) && (Thread.holdsLock(g.this))) {
        throw new AssertionError();
      }
      synchronized (g.this)
      {
        if (this.a) {
          return;
        }
        if (g.this.e.b) {
          break label113;
        }
        if (this.e.b() > 0L)
        {
          if (this.e.b() <= 0L) {
            break label113;
          }
          a(true);
        }
      }
      g.this.d.a(g.this.c, true, null, 0L);
      label113:
      synchronized (g.this)
      {
        this.a = true;
        g.this.d.b();
        g.this.j();
        return;
      }
    }
    
    public void flush()
    {
      if ((!c) && (Thread.holdsLock(g.this))) {
        throw new AssertionError();
      }
      synchronized (g.this)
      {
        g.this.k();
        if (this.e.b() > 0L)
        {
          a(false);
          g.this.d.b();
        }
      }
    }
  }
  
  private final class b
    implements q
  {
    boolean a;
    boolean b;
    private final c e = new c();
    private final c f = new c();
    private final long g;
    
    static
    {
      if (!g.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        c = bool;
        return;
      }
    }
    
    b(long paramLong)
    {
      this.g = paramLong;
    }
    
    private void a(long paramLong)
    {
      if ((!c) && (Thread.holdsLock(g.this))) {
        throw new AssertionError();
      }
      g.this.d.a(paramLong);
    }
    
    private void b()
    {
      g.this.f.c();
      try
      {
        if (this.f.b() == 0L) {
          if ((!this.b) && (!this.a) && (g.this.h == null)) {
            g.this.l();
          }
        }
        return;
      }
      finally
      {
        g.this.f.b();
      }
    }
    
    public long a(c paramc, long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      }
      synchronized (g.this)
      {
        b();
        if (this.a) {
          throw new IOException("stream closed");
        }
      }
      ErrorCode localErrorCode = g.this.h;
      if (this.f.b() > 0L)
      {
        paramLong = this.f.a(paramc, Math.min(paramLong, this.f.b()));
        paramc = g.this;
        paramc.a += paramLong;
      }
      for (;;)
      {
        if ((localErrorCode == null) && (g.this.a >= g.this.d.k.d() / 2))
        {
          g.this.d.a(g.this.c, g.this.a);
          g.this.a = 0L;
        }
        if (paramLong != -1L)
        {
          a(paramLong);
          return paramLong;
        }
        if (localErrorCode != null) {
          throw new StreamResetException(localErrorCode);
        }
        return -1L;
        paramLong = -1L;
      }
    }
    
    public r a()
    {
      return g.this.f;
    }
    
    void a(okio.e parame, long paramLong)
    {
      long l = paramLong;
      if (!c)
      {
        l = paramLong;
        if (Thread.holdsLock(g.this)) {
          throw new AssertionError();
        }
      }
      for (;;)
      {
        l -= paramLong;
        synchronized (g.this)
        {
          if (this.f.b() == 0L)
          {
            i = 1;
            this.f.a(this.e);
            if (i != 0) {
              g.this.notifyAll();
            }
            if (l > 0L) {}
            boolean bool;
            synchronized (g.this)
            {
              bool = this.b;
              if (this.f.b() + l > this.g)
              {
                i = 1;
                if (i != 0)
                {
                  parame.h(l);
                  g.this.b(ErrorCode.FLOW_CONTROL_ERROR);
                }
              }
              else
              {
                i = 0;
              }
            }
            if (bool)
            {
              parame.h(l);
              return;
            }
            paramLong = parame.a(this.e, l);
            if (paramLong != -1L) {
              continue;
            }
            throw new EOFException();
          }
          int i = 0;
        }
      }
    }
    
    public void close()
    {
      synchronized (g.this)
      {
        this.a = true;
        long l = this.f.b();
        this.f.r();
        g.this.notifyAll();
        if (l > 0L) {
          a(l);
        }
        g.this.j();
        return;
      }
    }
  }
  
  class c
    extends okio.a
  {
    c() {}
    
    protected IOException a(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause(paramIOException);
      }
      return localSocketTimeoutException;
    }
    
    protected void a()
    {
      g.this.b(ErrorCode.CANCEL);
    }
    
    public void b()
    {
      if (b_()) {
        throw a(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.g
 * JD-Core Version:    0.7.0.1
 */