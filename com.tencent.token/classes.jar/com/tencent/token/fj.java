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

public final class fj
  implements t
{
  private final boolean a;
  
  public fj(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public z a(t.a parama)
  {
    fo localfo = (fo)parama;
    fk localfk = localfo.g();
    okhttp3.internal.connection.f localf = localfo.f();
    Object localObject = (okhttp3.internal.connection.c)localfo.e();
    x localx = localfo.a();
    long l = System.currentTimeMillis();
    localfo.i().c(localfo.h());
    localfk.a(localx);
    localfo.i().a(localfo.h(), localx);
    parama = null;
    if ((fn.c(localx.b())) && (localx.d() != null))
    {
      if ("100-continue".equalsIgnoreCase(localx.a("Expect")))
      {
        localfk.a();
        localfo.i().e(localfo.h());
        parama = localfk.a(true);
      }
      if (parama == null)
      {
        localfo.i().d(localfo.h());
        localObject = new a(localfk.a(localx, localx.d().b()));
        d locald = k.a((okio.p)localObject);
        localx.d().a(locald);
        locald.close();
        localfo.i().a(localfo.h(), ((a)localObject).a);
      }
    }
    for (;;)
    {
      localfk.b();
      localObject = parama;
      if (parama == null)
      {
        localfo.i().e(localfo.h());
        localObject = localfk.a(false);
      }
      parama = ((z.a)localObject).a(localx).a(localf.c().c()).a(l).b(System.currentTimeMillis()).a();
      int j = parama.b();
      int i = j;
      if (j == 100)
      {
        parama = localfk.a(false).a(localx).a(localf.c().c()).a(l).b(System.currentTimeMillis()).a();
        i = parama.b();
      }
      localfo.i().a(localfo.h(), parama);
      if ((this.a) && (i == 101)) {}
      for (parama = parama.f().a(fb.c).a();; parama = parama.f().a(localfk.a(parama)).a())
      {
        if (("close".equalsIgnoreCase(parama.a().a("Connection"))) || ("close".equalsIgnoreCase(parama.a("Connection")))) {
          localf.e();
        }
        if (((i != 204) && (i != 205)) || (parama.e().a() <= 0L)) {
          break label539;
        }
        throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + parama.e().a());
        if (!((okhttp3.internal.connection.c)localObject).d()) {
          localf.e();
        }
        break;
      }
      label539:
      return parama;
      parama = null;
    }
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
 * Qualified Name:     com.tencent.token.fj
 * JD-Core Version:    0.7.0.1
 */