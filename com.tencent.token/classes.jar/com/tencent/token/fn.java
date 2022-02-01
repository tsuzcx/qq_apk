package com.tencent.token;

import java.net.ProtocolException;
import okhttp3.aa;
import okhttp3.t;
import okhttp3.t.a;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;
import okhttp3.z.a;
import okio.d;
import okio.k;

public final class fn
  implements t
{
  private final boolean a;
  
  public fn(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public z a(t.a parama)
  {
    fs localfs = (fs)parama;
    fo localfo = localfs.g();
    okhttp3.internal.connection.f localf = localfs.f();
    okhttp3.internal.connection.c localc = (okhttp3.internal.connection.c)localfs.e();
    x localx = localfs.a();
    long l = System.currentTimeMillis();
    localfs.i().c(localfs.h());
    localfo.a(localx);
    localfs.i().a(localfs.h(), localx);
    boolean bool = fr.c(localx.b());
    d locald = null;
    Object localObject = null;
    parama = locald;
    if (bool)
    {
      parama = locald;
      if (localx.d() != null)
      {
        if ("100-continue".equalsIgnoreCase(localx.a("Expect")))
        {
          localfo.a();
          localfs.i().e(localfs.h());
          localObject = localfo.a(true);
        }
        if (localObject == null)
        {
          localfs.i().d(localfs.h());
          parama = new a(localfo.a(localx, localx.d().b()));
          locald = k.a(parama);
          localx.d().a(locald);
          locald.close();
          localfs.i().a(localfs.h(), parama.a);
          parama = (t.a)localObject;
        }
        else
        {
          parama = (t.a)localObject;
          if (!localc.d())
          {
            localf.e();
            parama = (t.a)localObject;
          }
        }
      }
    }
    localfo.b();
    localObject = parama;
    if (parama == null)
    {
      localfs.i().e(localfs.h());
      localObject = localfo.a(false);
    }
    parama = ((z.a)localObject).a(localx).a(localf.c().c()).a(l).b(System.currentTimeMillis()).a();
    int j = parama.b();
    int i = j;
    if (j == 100)
    {
      parama = localfo.a(false).a(localx).a(localf.c().c()).a(l).b(System.currentTimeMillis()).a();
      i = parama.b();
    }
    localfs.i().a(localfs.h(), parama);
    if ((this.a) && (i == 101)) {
      parama = parama.f().a(ff.c).a();
    } else {
      parama = parama.f().a(localfo.a(parama)).a();
    }
    if (("close".equalsIgnoreCase(parama.a().a("Connection"))) || ("close".equalsIgnoreCase(parama.a("Connection")))) {
      localf.e();
    }
    if (((i != 204) && (i != 205)) || (parama.e().a() <= 0L)) {
      return parama;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HTTP ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" had non-zero Content-Length: ");
    ((StringBuilder)localObject).append(parama.e().a());
    throw new ProtocolException(((StringBuilder)localObject).toString());
  }
  
  static final class a
    extends okio.f
  {
    long a;
    
    a(okio.p paramp)
    {
      super();
    }
    
    public void a_(okio.c paramc, long paramLong)
    {
      super.a_(paramc, paramLong);
      this.a += paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fn
 * JD-Core Version:    0.7.0.1
 */