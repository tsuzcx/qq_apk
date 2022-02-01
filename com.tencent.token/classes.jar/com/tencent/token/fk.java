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
    okhttp3.internal.connection.c localc = (okhttp3.internal.connection.c)localfp.e();
    x localx = localfp.a();
    long l = System.currentTimeMillis();
    localfp.i().c(localfp.h());
    localfl.a(localx);
    localfp.i().a(localfp.h(), localx);
    boolean bool = fo.c(localx.b());
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
          localfl.a();
          localfp.i().e(localfp.h());
          localObject = localfl.a(true);
        }
        if (localObject == null)
        {
          localfp.i().d(localfp.h());
          parama = new a(localfl.a(localx, localx.d().b()));
          locald = k.a(parama);
          localx.d().a(locald);
          locald.close();
          localfp.i().a(localfp.h(), parama.a);
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
    if ((this.a) && (i == 101)) {
      parama = parama.f().a(fc.c).a();
    } else {
      parama = parama.f().a(localfl.a(parama)).a();
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
 * Qualified Name:     com.tencent.token.fk
 * JD-Core Version:    0.7.0.1
 */