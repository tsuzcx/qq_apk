package okhttp3.internal.connection;

import com.tencent.token.gl;
import com.tencent.token.gn;
import com.tencent.token.hd;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.List;
import okhttp3.a;
import okhttp3.ax;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.n;
import okhttp3.o;
import okhttp3.y;

public final class g
{
  public final a a;
  public final okhttp3.g b;
  public final y c;
  private f e;
  private ax f;
  private final o g;
  private final Object h;
  private final e i;
  private int j;
  private c k;
  private boolean l;
  private boolean m;
  private boolean n;
  private hd o;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  public g(o paramo, a parama, okhttp3.g paramg, y paramy, Object paramObject)
  {
    this.g = paramo;
    this.a = parama;
    this.b = paramg;
    this.c = paramy;
    this.i = new e(parama, h(), paramg, paramy);
    this.h = paramObject;
  }
  
  private Socket a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject2 = null;
    if ((!d) && (!Thread.holdsLock(this.g))) {
      throw new AssertionError();
    }
    if (paramBoolean3) {
      this.o = null;
    }
    if (paramBoolean2) {
      this.m = true;
    }
    Object localObject1 = localObject2;
    if (this.k != null)
    {
      if (paramBoolean1) {
        this.k.a = true;
      }
      localObject1 = localObject2;
      if (this.o == null) {
        if (!this.m)
        {
          localObject1 = localObject2;
          if (!this.k.a) {}
        }
        else
        {
          b(this.k);
          if (!this.k.d.isEmpty()) {
            break label167;
          }
          this.k.e = System.nanoTime();
          if (!gl.a.a(this.g, this.k)) {
            break label167;
          }
        }
      }
    }
    label167:
    for (localObject1 = this.k.b();; localObject1 = null)
    {
      this.k = null;
      return localObject1;
    }
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i2 = 0;
    Object localObject6 = null;
    ax localax = null;
    synchronized (this.g)
    {
      if (this.m) {
        throw new IllegalStateException("released");
      }
    }
    if (this.o != null) {
      throw new IllegalStateException("codec != null");
    }
    if (this.n) {
      throw new IOException("Canceled");
    }
    Object localObject2 = this.k;
    Socket localSocket = g();
    if (this.k != null)
    {
      localObject6 = this.k;
      localObject2 = null;
    }
    ??? = localObject2;
    if (!this.l) {
      ??? = null;
    }
    Object localObject7 = localObject6;
    localObject2 = localax;
    int i1 = i2;
    if (localObject6 == null)
    {
      gl.a.a(this.g, this.a, this, null);
      if (this.k == null) {
        break label225;
      }
      i1 = 1;
      localObject7 = this.k;
      localObject2 = localax;
    }
    for (;;)
    {
      gn.a(localSocket);
      if (??? != null) {
        this.c.b(this.b, (n)???);
      }
      if (i1 != 0) {
        this.c.a(this.b, (n)localObject7);
      }
      if (localObject7 == null) {
        break;
      }
      return localObject7;
      label225:
      localObject2 = this.f;
      localObject7 = localObject6;
      i1 = i2;
    }
    int i3 = 0;
    i2 = i3;
    if (localObject2 == null) {
      if (this.e != null)
      {
        i2 = i3;
        if (this.e.a()) {}
      }
      else
      {
        i2 = 1;
        this.e = this.i.b();
      }
    }
    synchronized (this.g)
    {
      if (this.n) {
        throw new IOException("Canceled");
      }
    }
    if (i2 != 0)
    {
      localObject6 = this.e.c();
      i3 = ((List)localObject6).size();
      i2 = 0;
      if (i2 < i3)
      {
        localax = (ax)((List)localObject6).get(i2);
        gl.a.a(this.g, this.a, this, localax);
        if (this.k != null)
        {
          i1 = 1;
          localObject6 = this.k;
          this.f = localax;
        }
      }
    }
    for (;;)
    {
      Object localObject4;
      if (i1 == 0)
      {
        if (localObject3 != null) {
          break label623;
        }
        localObject4 = this.e.b();
      }
      label623:
      for (;;)
      {
        this.f = ((ax)localObject4);
        this.j = 0;
        localObject6 = new c(this.g, (ax)localObject4);
        a((c)localObject6, false);
        if (i1 != 0)
        {
          this.c.a(this.b, (n)localObject6);
          return localObject6;
          i2 += 1;
          break;
        }
        ((c)localObject6).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, this.b, this.c);
        h().b(((c)localObject6).a());
        localObject7 = null;
        synchronized (this.g)
        {
          this.l = true;
          gl.a.b(this.g, (c)localObject6);
          localObject4 = localObject6;
          if (((c)localObject6).d())
          {
            localObject7 = gl.a.a(this.g, this.a, this);
            localObject4 = this.k;
          }
          gn.a((Socket)localObject7);
          this.c.a(this.b, (n)localObject4);
          return localObject4;
        }
      }
      localObject6 = localObject7;
    }
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      c localc1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.g)
      {
        if (localc1.b == 0) {
          return localc1;
        }
        if (!localc1.a(paramBoolean2)) {
          e();
        }
      }
    }
    return localc2;
  }
  
  private void b(c paramc)
  {
    int i2 = paramc.d.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((Reference)paramc.d.get(i1)).get() == this)
      {
        paramc.d.remove(i1);
        return;
      }
      i1 += 1;
    }
    throw new IllegalStateException();
  }
  
  private Socket g()
  {
    if ((!d) && (!Thread.holdsLock(this.g))) {
      throw new AssertionError();
    }
    c localc = this.k;
    if ((localc != null) && (localc.a)) {
      return a(false, false, true);
    }
    return null;
  }
  
  private d h()
  {
    return gl.a.a(this.g);
  }
  
  public hd a()
  {
    synchronized (this.g)
    {
      hd localhd = this.o;
      return localhd;
    }
  }
  
  /* Error */
  public hd a(okhttp3.ak arg1, okhttp3.ai paramai, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 236 1 0
    //   6: istore 4
    //   8: aload_2
    //   9: invokeinterface 238 1 0
    //   14: istore 5
    //   16: aload_2
    //   17: invokeinterface 240 1 0
    //   22: istore 6
    //   24: aload_1
    //   25: invokevirtual 243	okhttp3/ak:d	()I
    //   28: istore 7
    //   30: aload_1
    //   31: invokevirtual 246	okhttp3/ak:s	()Z
    //   34: istore 8
    //   36: aload_0
    //   37: iload 4
    //   39: iload 5
    //   41: iload 6
    //   43: iload 7
    //   45: iload 8
    //   47: iload_3
    //   48: invokespecial 248	okhttp3/internal/connection/g:a	(IIIIZZ)Lokhttp3/internal/connection/c;
    //   51: aload_1
    //   52: aload_2
    //   53: aload_0
    //   54: invokevirtual 251	okhttp3/internal/connection/c:a	(Lokhttp3/ak;Lokhttp3/ai;Lokhttp3/internal/connection/g;)Lcom/tencent/token/hd;
    //   57: astore_2
    //   58: aload_0
    //   59: getfield 48	okhttp3/internal/connection/g:g	Lokhttp3/o;
    //   62: astore_1
    //   63: aload_1
    //   64: monitorenter
    //   65: aload_0
    //   66: aload_2
    //   67: putfield 78	okhttp3/internal/connection/g:o	Lcom/tencent/token/hd;
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: areturn
    //   74: astore_2
    //   75: aload_1
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    //   79: astore_1
    //   80: new 253	okhttp3/internal/connection/RouteException
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 256	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	g
    //   0	89	2	paramai	okhttp3.ai
    //   0	89	3	paramBoolean	boolean
    //   6	32	4	i1	int
    //   14	26	5	i2	int
    //   22	20	6	i3	int
    //   28	16	7	i4	int
    //   34	12	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   65	72	74	finally
    //   75	77	74	finally
    //   36	65	79	java/io/IOException
    //   77	79	79	java/io/IOException
  }
  
  public Socket a(c paramc)
  {
    if ((!d) && (!Thread.holdsLock(this.g))) {
      throw new AssertionError();
    }
    if ((this.o != null) || (this.k.d.size() != 1)) {
      throw new IllegalStateException();
    }
    Reference localReference = (Reference)this.k.d.get(0);
    Socket localSocket = a(true, false, false);
    this.k = paramc;
    paramc.d.add(localReference);
    return localSocket;
  }
  
  public void a(IOException paramIOException)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    for (;;)
    {
      synchronized (this.g)
      {
        if ((paramIOException instanceof StreamResetException))
        {
          paramIOException = ((StreamResetException)paramIOException).errorCode;
          if (paramIOException == ErrorCode.REFUSED_STREAM)
          {
            this.j += 1;
            if (this.j <= 1) {
              break label209;
            }
            this.f = null;
            break label211;
            paramIOException = this.k;
            Socket localSocket = a(bool1, false, true);
            if ((this.k != null) || (!this.l)) {
              break label214;
            }
            gn.a(localSocket);
            if (paramIOException != null) {
              this.c.b(this.b, paramIOException);
            }
            return;
          }
          if (paramIOException == ErrorCode.CANCEL) {
            break label209;
          }
          this.f = null;
        }
      }
      bool1 = bool2;
      if (this.k != null) {
        if (this.k.d())
        {
          bool1 = bool2;
          if (!(paramIOException instanceof ConnectionShutdownException)) {}
        }
        else
        {
          if (this.k.b == 0)
          {
            if ((this.f != null) && (paramIOException != null)) {
              this.i.a(this.f, paramIOException);
            }
            this.f = null;
          }
          bool1 = true;
          continue;
          label209:
          bool1 = false;
          label211:
          continue;
          label214:
          paramIOException = null;
        }
      }
    }
  }
  
  public void a(c paramc, boolean paramBoolean)
  {
    if ((!d) && (!Thread.holdsLock(this.g))) {
      throw new AssertionError();
    }
    if (this.k != null) {
      throw new IllegalStateException();
    }
    this.k = paramc;
    this.l = paramBoolean;
    paramc.d.add(new h(this, this.h));
  }
  
  /* Error */
  public void a(boolean paramBoolean, hd paramhd, long paramLong, IOException paramIOException)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	okhttp3/internal/connection/g:c	Lokhttp3/y;
    //   4: aload_0
    //   5: getfield 52	okhttp3/internal/connection/g:b	Lokhttp3/g;
    //   8: lload_3
    //   9: invokevirtual 288	okhttp3/y:b	(Lokhttp3/g;J)V
    //   12: aload_0
    //   13: getfield 48	okhttp3/internal/connection/g:g	Lokhttp3/o;
    //   16: astore 6
    //   18: aload 6
    //   20: monitorenter
    //   21: aload_2
    //   22: ifnull +11 -> 33
    //   25: aload_2
    //   26: aload_0
    //   27: getfield 78	okhttp3/internal/connection/g:o	Lcom/tencent/token/hd;
    //   30: if_acmpeq +50 -> 80
    //   33: new 120	java/lang/IllegalStateException
    //   36: dup
    //   37: new 290	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 293
    //   47: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 78	okhttp3/internal/connection/g:o	Lcom/tencent/token/hd;
    //   54: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: ldc_w 302
    //   60: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_2
    //   64: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokespecial 125	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   73: athrow
    //   74: astore_2
    //   75: aload 6
    //   77: monitorexit
    //   78: aload_2
    //   79: athrow
    //   80: iload_1
    //   81: ifne +18 -> 99
    //   84: aload_0
    //   85: getfield 82	okhttp3/internal/connection/g:k	Lokhttp3/internal/connection/c;
    //   88: astore_2
    //   89: aload_2
    //   90: aload_2
    //   91: getfield 211	okhttp3/internal/connection/c:b	I
    //   94: iconst_1
    //   95: iadd
    //   96: putfield 211	okhttp3/internal/connection/c:b	I
    //   99: aload_0
    //   100: getfield 82	okhttp3/internal/connection/g:k	Lokhttp3/internal/connection/c;
    //   103: astore_2
    //   104: aload_0
    //   105: iload_1
    //   106: iconst_0
    //   107: iconst_1
    //   108: invokespecial 227	okhttp3/internal/connection/g:a	(ZZZ)Ljava/net/Socket;
    //   111: astore 7
    //   113: aload_0
    //   114: getfield 82	okhttp3/internal/connection/g:k	Lokhttp3/internal/connection/c;
    //   117: ifnull +5 -> 122
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 80	okhttp3/internal/connection/g:m	Z
    //   126: istore_1
    //   127: aload 6
    //   129: monitorexit
    //   130: aload 7
    //   132: invokestatic 146	com/tencent/token/gn:a	(Ljava/net/Socket;)V
    //   135: aload_2
    //   136: ifnull +15 -> 151
    //   139: aload_0
    //   140: getfield 54	okhttp3/internal/connection/g:c	Lokhttp3/y;
    //   143: aload_0
    //   144: getfield 52	okhttp3/internal/connection/g:b	Lokhttp3/g;
    //   147: aload_2
    //   148: invokevirtual 151	okhttp3/y:b	(Lokhttp3/g;Lokhttp3/n;)V
    //   151: aload 5
    //   153: ifnull +17 -> 170
    //   156: aload_0
    //   157: getfield 54	okhttp3/internal/connection/g:c	Lokhttp3/y;
    //   160: aload_0
    //   161: getfield 52	okhttp3/internal/connection/g:b	Lokhttp3/g;
    //   164: aload 5
    //   166: invokevirtual 309	okhttp3/y:a	(Lokhttp3/g;Ljava/io/IOException;)V
    //   169: return
    //   170: iload_1
    //   171: ifeq -2 -> 169
    //   174: aload_0
    //   175: getfield 54	okhttp3/internal/connection/g:c	Lokhttp3/y;
    //   178: aload_0
    //   179: getfield 52	okhttp3/internal/connection/g:b	Lokhttp3/g;
    //   182: invokevirtual 312	okhttp3/y:g	(Lokhttp3/g;)V
    //   185: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	g
    //   0	186	1	paramBoolean	boolean
    //   0	186	2	paramhd	hd
    //   0	186	3	paramLong	long
    //   0	186	5	paramIOException	IOException
    //   16	112	6	localo	o
    //   111	20	7	localSocket	Socket
    // Exception table:
    //   from	to	target	type
    //   25	33	74	finally
    //   33	74	74	finally
    //   75	78	74	finally
    //   84	99	74	finally
    //   99	113	74	finally
    //   113	120	74	finally
    //   122	130	74	finally
  }
  
  public ax b()
  {
    return this.f;
  }
  
  public c c()
  {
    try
    {
      c localc = this.k;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    synchronized (this.g)
    {
      c localc = this.k;
      Socket localSocket = a(false, true, false);
      if (this.k != null) {
        localc = null;
      }
      gn.a(localSocket);
      if (localc != null)
      {
        this.c.b(this.b, localc);
        this.c.g(this.b);
      }
      return;
    }
  }
  
  public void e()
  {
    synchronized (this.g)
    {
      c localc = this.k;
      Socket localSocket = a(true, false, false);
      if (this.k != null) {
        localc = null;
      }
      gn.a(localSocket);
      if (localc != null) {
        this.c.b(this.b, localc);
      }
      return;
    }
  }
  
  public boolean f()
  {
    return (this.f != null) || ((this.e != null) && (this.e.a())) || (this.i.a());
  }
  
  public String toString()
  {
    c localc = c();
    if (localc != null) {
      return localc.toString();
    }
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.g
 * JD-Core Version:    0.7.0.1
 */