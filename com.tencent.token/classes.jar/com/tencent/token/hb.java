package com.tencent.token;

import java.net.ProtocolException;
import okhttp3.ah;
import okhttp3.ai;
import okhttp3.ap;
import okhttp3.ar;
import okhttp3.at;
import okhttp3.au;
import okhttp3.av;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.g;
import okhttp3.y;
import okio.h;
import okio.o;
import okio.x;

public final class hb
  implements ah
{
  private final boolean a;
  
  public hb(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public at a(ai paramai)
  {
    hi localhi = (hi)paramai;
    hd localhd = localhi.g();
    g localg = localhi.f();
    Object localObject = (c)localhi.e();
    ap localap = localhi.a();
    long l = System.currentTimeMillis();
    localhi.i().c(localhi.h());
    localhd.a(localap);
    localhi.i().a(localhi.h(), localap);
    paramai = null;
    if ((hh.c(localap.b())) && (localap.d() != null))
    {
      if ("100-continue".equalsIgnoreCase(localap.a("Expect")))
      {
        localhd.a();
        localhi.i().e(localhi.h());
        paramai = localhd.a(true);
      }
      if (paramai == null)
      {
        localhi.i().d(localhi.h());
        localObject = new hc(localhd.a(localap, localap.d().b()));
        h localh = o.a((x)localObject);
        localap.d().a(localh);
        localh.close();
        localhi.i().a(localhi.h(), ((hc)localObject).a);
      }
    }
    for (;;)
    {
      localhd.b();
      localObject = paramai;
      if (paramai == null)
      {
        localhi.i().e(localhi.h());
        localObject = localhd.a(false);
      }
      paramai = ((au)localObject).a(localap).a(localg.c().c()).a(l).b(System.currentTimeMillis()).a();
      int j = paramai.b();
      int i = j;
      if (j == 100)
      {
        paramai = localhd.a(false).a(localap).a(localg.c().c()).a(l).b(System.currentTimeMillis()).a();
        i = paramai.b();
      }
      localhi.i().a(localhi.h(), paramai);
      if ((this.a) && (i == 101)) {}
      for (paramai = paramai.f().a(gn.c).a();; paramai = paramai.f().a(localhd.a(paramai)).a())
      {
        if (("close".equalsIgnoreCase(paramai.a().a("Connection"))) || ("close".equalsIgnoreCase(paramai.a("Connection")))) {
          localg.e();
        }
        if (((i != 204) && (i != 205)) || (paramai.e().a() <= 0L)) {
          break label539;
        }
        throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + paramai.e().a());
        if (!((c)localObject).d()) {
          localg.e();
        }
        break;
      }
      label539:
      return paramai;
      paramai = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hb
 * JD-Core Version:    0.7.0.1
 */