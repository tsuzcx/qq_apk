package com.tencent.token;

import java.util.List;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.ah;
import okhttp3.ai;
import okhttp3.aj;
import okhttp3.ap;
import okhttp3.aq;
import okhttp3.ar;
import okhttp3.at;
import okhttp3.au;
import okhttp3.av;
import okhttp3.s;
import okhttp3.t;
import okio.m;
import okio.o;
import okio.y;

public final class ha
  implements ah
{
  private final t a;
  
  public ha(t paramt)
  {
    this.a = paramt;
  }
  
  private String a(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append("; ");
      }
      s locals = (s)paramList.get(i);
      localStringBuilder.append(locals.a()).append('=').append(locals.b());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public at a(ai paramai)
  {
    int j = 0;
    Object localObject1 = paramai.a();
    Object localObject2 = ((ap)localObject1).e();
    Object localObject3 = ((ap)localObject1).d();
    if (localObject3 != null)
    {
      aj localaj = ((ar)localObject3).a();
      if (localaj != null) {
        ((aq)localObject2).a("Content-Type", localaj.toString());
      }
      long l = ((ar)localObject3).b();
      if (l == -1L) {
        break label374;
      }
      ((aq)localObject2).a("Content-Length", Long.toString(l));
      ((aq)localObject2).b("Transfer-Encoding");
    }
    for (;;)
    {
      if (((ap)localObject1).a("Host") == null) {
        ((aq)localObject2).a("Host", gn.a(((ap)localObject1).a(), false));
      }
      if (((ap)localObject1).a("Connection") == null) {
        ((aq)localObject2).a("Connection", "Keep-Alive");
      }
      int i = j;
      if (((ap)localObject1).a("Accept-Encoding") == null)
      {
        i = j;
        if (((ap)localObject1).a("Range") == null)
        {
          i = 1;
          ((aq)localObject2).a("Accept-Encoding", "gzip");
        }
      }
      localObject3 = this.a.a(((ap)localObject1).a());
      if (!((List)localObject3).isEmpty()) {
        ((aq)localObject2).a("Cookie", a((List)localObject3));
      }
      if (((ap)localObject1).a("User-Agent") == null) {
        ((aq)localObject2).a("User-Agent", gq.a());
      }
      paramai = paramai.a(((aq)localObject2).a());
      hg.a(this.a, ((ap)localObject1).a(), paramai.d());
      localObject1 = paramai.f().a((ap)localObject1);
      if ((i != 0) && ("gzip".equalsIgnoreCase(paramai.a("Content-Encoding"))) && (hg.b(paramai)))
      {
        localObject2 = new m(paramai.e().c());
        ((au)localObject1).a(paramai.d().b().b("Content-Encoding").b("Content-Length").a());
        ((au)localObject1).a(new hj(paramai.a("Content-Type"), -1L, o.a((y)localObject2)));
      }
      return ((au)localObject1).a();
      label374:
      ((aq)localObject2).a("Transfer-Encoding", "chunked");
      ((aq)localObject2).b("Content-Length");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ha
 * JD-Core Version:    0.7.0.1
 */