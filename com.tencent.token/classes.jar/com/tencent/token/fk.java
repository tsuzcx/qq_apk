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

public final class fk
  implements t
{
  private final boolean a;
  
  public fk(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public z a(t.a parama)
  {
    fp localfp = (fp)parama;
    fl localfl = localfp.g();
    okhttp3.internal.connection.f localf = localfp.f();
    Object localObject = (okhttp3.internal.connection.c)localfp.e();
    x localx = localfp.a();
    long l = System.currentTimeMillis();
    localfp.i().c(localfp.h());
    localfl.a(localx);
    localfp.i().a(localfp.h(), localx);
    parama = null;
    if ((fo.c(localx.b())) && (localx.d() != null))
    {
      if ("100-continue".equalsIgnoreCase(localx.a("Expect")))
      {
        localfl.a();
        localfp.i().e(localfp.h());
        parama = localfl.a(true);
      }
      if (parama == null)
      {
        localfp.i().d(localfp.h());
        localObject = new a(localfl.a(localx, localx.d().b()));
        d locald = k.a((okio.p)localObject);
        localx.d().a(locald);
        locald.close();
        localfp.i().a(localfp.h(), ((a)localObject).a);
      }
    }
    for (;;)
    {
      localfl.b();
      localObject = parama;
      if (parama == null)
      {
        localfp.i().e(localfp.h());
        localObject = localfl.a(false);
      }
      parama = ((z.a)localObject).a(localx).a(localf.c().c()).a(l).b(System.currentTimeMillis()).a();
      int j = parama.b();
      int i = j;
      if (j == 100)
      {
        parama = localfl.a(false).a(localx).a(localf.c().c()).a(l).b(System.currentTimeMillis()).a();
        i = parama.b();
      }
      localfp.i().a(localfp.h(), parama);
      if ((this.a) && (i == 101)) {}
      for (parama = parama.f().a(fc.c).a();; parama = parama.f().a(localfl.a(parama)).a())
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
 * Qualified Name:     com.tencent.token.fk
 * JD-Core Version:    0.7.0.1
 */