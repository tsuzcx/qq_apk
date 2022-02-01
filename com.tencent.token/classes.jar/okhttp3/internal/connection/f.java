package okhttp3.internal.connection;

import com.tencent.token.fd;
import com.tencent.token.ff;
import com.tencent.token.fo;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.a;
import okhttp3.ab;
import okhttp3.i;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.j;
import okhttp3.p;

public final class f
{
  public final a a;
  public final okhttp3.e b;
  public final p c;
  private e.a e;
  private ab f;
  private final j g;
  private final Object h;
  private final e i;
  private int j;
  private c k;
  private boolean l;
  private boolean m;
  private boolean n;
  private fo o;
  
  public f(j paramj, a parama, okhttp3.e parame, p paramp, Object paramObject)
  {
    this.g = paramj;
    this.a = parama;
    this.b = parame;
    this.c = paramp;
    this.i = new e(parama, h(), parame, paramp);
    this.h = paramObject;
  }
  
  private Socket a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!d) && (!Thread.holdsLock(this.g))) {
      throw new AssertionError();
    }
    if (paramBoolean3) {
      this.o = null;
    }
    if (paramBoolean2) {
      this.m = true;
    }
    Object localObject = this.k;
    if (localObject != null)
    {
      if (paramBoolean1) {
        ((c)localObject).a = true;
      }
      if ((this.o == null) && ((this.m) || (this.k.a)))
      {
        b(this.k);
        if (this.k.d.isEmpty())
        {
          this.k.e = System.nanoTime();
          if (fd.a.a(this.g, this.k))
          {
            localObject = this.k.b();
            break label155;
          }
        }
        localObject = null;
        label155:
        this.k = null;
        return localObject;
      }
    }
    return null;
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    for (;;)
    {
      int i3;
      synchronized (this.g)
      {
        if (!this.m)
        {
          if (this.o == null)
          {
            if (!this.n)
            {
              localObject6 = this.k;
              Object localObject9 = g();
              Object localObject1 = this.k;
              Object localObject8 = null;
              if (localObject1 != null)
              {
                localObject1 = this.k;
                localObject6 = null;
                Object localObject7 = localObject6;
                if (!this.l) {
                  localObject7 = null;
                }
                if (localObject1 != null) {
                  break label631;
                }
                fd.a.a(this.g, this.a, this, null);
                if (this.k != null)
                {
                  localObject1 = this.k;
                  localObject6 = null;
                  i1 = 1;
                }
                else
                {
                  localObject6 = this.f;
                  i1 = 0;
                }
                ff.a((Socket)localObject9);
                if (localObject7 != null) {
                  this.c.b(this.b, (i)localObject7);
                }
                if (i1 != 0) {
                  this.c.a(this.b, (i)localObject1);
                }
                if (localObject1 != null) {
                  return localObject1;
                }
                if (localObject6 == null)
                {
                  localObject7 = this.e;
                  if ((localObject7 == null) || (!((e.a)localObject7).a()))
                  {
                    this.e = this.i.b();
                    i3 = 1;
                    continue;
                  }
                }
                i3 = 0;
                synchronized (this.g)
                {
                  if (!this.n)
                  {
                    int i2 = i1;
                    localObject7 = localObject1;
                    if (i3 != 0)
                    {
                      localObject9 = this.e.c();
                      int i4 = ((List)localObject9).size();
                      i3 = 0;
                      i2 = i1;
                      localObject7 = localObject1;
                      if (i3 < i4)
                      {
                        ab localab = (ab)((List)localObject9).get(i3);
                        fd.a.a(this.g, this.a, this, localab);
                        if (this.k == null) {
                          break label640;
                        }
                        localObject7 = this.k;
                        this.f = localab;
                        i2 = 1;
                      }
                    }
                    localObject1 = localObject7;
                    if (i2 == 0)
                    {
                      localObject1 = localObject6;
                      if (localObject6 == null) {
                        localObject1 = this.e.b();
                      }
                      this.f = ((ab)localObject1);
                      this.j = 0;
                      localObject1 = new c(this.g, (ab)localObject1);
                      a((c)localObject1, false);
                    }
                    if (i2 != 0)
                    {
                      this.c.a(this.b, (i)localObject1);
                      return localObject1;
                    }
                    ((c)localObject1).a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, this.b, this.c);
                    h().b(((c)localObject1).a());
                    synchronized (this.g)
                    {
                      this.l = true;
                      fd.a.b(this.g, (c)localObject1);
                      localObject7 = localObject8;
                      localObject6 = localObject1;
                      if (((c)localObject1).d())
                      {
                        localObject7 = fd.a.a(this.g, this.a, this);
                        localObject6 = this.k;
                      }
                      ff.a((Socket)localObject7);
                      this.c.a(this.b, (i)localObject6);
                      return localObject6;
                    }
                  }
                  throw new IOException("Canceled");
                }
              }
            }
            else
            {
              throw new IOException("Canceled");
            }
          }
          else {
            throw new IllegalStateException("codec != null");
          }
        }
        else {
          throw new IllegalStateException("released");
        }
      }
      Object localObject5 = null;
      continue;
      label631:
      Object localObject6 = null;
      int i1 = 0;
      continue;
      label640:
      i3 += 1;
    }
  }
  
  private c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      c localc = a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1);
      synchronized (this.g)
      {
        if (localc.b == 0) {
          return localc;
        }
        if (!localc.a(paramBoolean2))
        {
          e();
          continue;
        }
        return localc;
      }
    }
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
    return fd.a.a(this.g);
  }
  
  public fo a()
  {
    synchronized (this.g)
    {
      fo localfo = this.o;
      return localfo;
    }
  }
  
  /* Error */
  public fo a(okhttp3.v arg1, okhttp3.t.a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 238 1 0
    //   6: istore 4
    //   8: aload_2
    //   9: invokeinterface 240 1 0
    //   14: istore 5
    //   16: aload_2
    //   17: invokeinterface 242 1 0
    //   22: istore 6
    //   24: aload_1
    //   25: invokevirtual 245	okhttp3/v:d	()I
    //   28: istore 7
    //   30: aload_1
    //   31: invokevirtual 248	okhttp3/v:s	()Z
    //   34: istore 8
    //   36: aload_0
    //   37: iload 4
    //   39: iload 5
    //   41: iload 6
    //   43: iload 7
    //   45: iload 8
    //   47: iload_3
    //   48: invokespecial 250	okhttp3/internal/connection/f:a	(IIIIZZ)Lokhttp3/internal/connection/c;
    //   51: aload_1
    //   52: aload_2
    //   53: aload_0
    //   54: invokevirtual 253	okhttp3/internal/connection/c:a	(Lokhttp3/v;Lokhttp3/t$a;Lokhttp3/internal/connection/f;)Lcom/tencent/token/fo;
    //   57: astore_2
    //   58: aload_0
    //   59: getfield 50	okhttp3/internal/connection/f:g	Lokhttp3/j;
    //   62: astore_1
    //   63: aload_1
    //   64: monitorenter
    //   65: aload_0
    //   66: aload_2
    //   67: putfield 80	okhttp3/internal/connection/f:o	Lcom/tencent/token/fo;
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
    //   80: new 255	okhttp3/internal/connection/RouteException
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 258	okhttp3/internal/connection/RouteException:<init>	(Ljava/io/IOException;)V
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	f
    //   0	89	2	parama	okhttp3.t.a
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
    if ((this.o == null) && (this.k.d.size() == 1))
    {
      Reference localReference = (Reference)this.k.d.get(0);
      Socket localSocket = a(true, false, false);
      this.k = paramc;
      paramc.d.add(localReference);
      return localSocket;
    }
    throw new IllegalStateException();
  }
  
  public void a(IOException paramIOException)
  {
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
              break label199;
            }
            this.f = null;
            bool = true;
          }
          else
          {
            if (paramIOException == ErrorCode.CANCEL) {
              break label199;
            }
            this.f = null;
            bool = true;
          }
        }
        else
        {
          if ((this.k == null) || ((this.k.d()) && (!(paramIOException instanceof ConnectionShutdownException)))) {
            break label209;
          }
          if (this.k.b != 0) {
            break label204;
          }
          if ((this.f != null) && (paramIOException != null)) {
            this.i.a(this.f, paramIOException);
          }
          this.f = null;
          break label204;
        }
        paramIOException = this.k;
        Socket localSocket = a(bool, false, true);
        if ((this.k != null) || (!this.l)) {
          break label214;
        }
        ff.a(localSocket);
        if (paramIOException != null) {
          this.c.b(this.b, paramIOException);
        }
        return;
      }
      label199:
      boolean bool = false;
      continue;
      label204:
      bool = true;
      continue;
      label209:
      bool = false;
      continue;
      label214:
      paramIOException = null;
    }
  }
  
  public void a(c paramc, boolean paramBoolean)
  {
    if ((!d) && (!Thread.holdsLock(this.g))) {
      throw new AssertionError();
    }
    if (this.k == null)
    {
      this.k = paramc;
      this.l = paramBoolean;
      paramc.d.add(new a(this, this.h));
      return;
    }
    throw new IllegalStateException();
  }
  
  public void a(boolean paramBoolean, fo paramfo, long paramLong, IOException paramIOException)
  {
    this.c.b(this.b, paramLong);
    j localj = this.g;
    if (paramfo != null) {}
    try
    {
      if (paramfo == this.o)
      {
        if (!paramBoolean)
        {
          paramfo = this.k;
          paramfo.b += 1;
        }
        paramfo = this.k;
        Socket localSocket = a(paramBoolean, false, true);
        if (this.k != null) {
          paramfo = null;
        }
        paramBoolean = this.m;
        ff.a(localSocket);
        if (paramfo != null) {
          this.c.b(this.b, paramfo);
        }
        if (paramIOException != null)
        {
          this.c.a(this.b, paramIOException);
          return;
        }
        if (paramBoolean) {
          this.c.g(this.b);
        }
        return;
      }
      paramIOException = new StringBuilder();
      paramIOException.append("expected ");
      paramIOException.append(this.o);
      paramIOException.append(" but was ");
      paramIOException.append(paramfo);
      throw new IllegalStateException(paramIOException.toString());
    }
    finally {}
  }
  
  public ab b()
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
      ff.a(localSocket);
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
      ff.a(localSocket);
      if (localc != null) {
        this.c.b(this.b, localc);
      }
      return;
    }
  }
  
  public boolean f()
  {
    if (this.f == null)
    {
      e.a locala = this.e;
      if (((locala == null) || (!locala.a())) && (!this.i.a())) {
        return false;
      }
    }
    return true;
  }
  
  public String toString()
  {
    c localc = c();
    if (localc != null) {
      return localc.toString();
    }
    return this.a.toString();
  }
  
  public static final class a
    extends WeakReference<f>
  {
    public final Object a;
    
    a(f paramf, Object paramObject)
    {
      super();
      this.a = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.f
 * JD-Core Version:    0.7.0.1
 */