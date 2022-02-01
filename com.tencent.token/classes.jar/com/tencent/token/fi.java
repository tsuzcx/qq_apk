package com.tencent.token;

import java.util.List;
import okhttp3.aa;
import okhttp3.l;
import okhttp3.m;
import okhttp3.r;
import okhttp3.r.a;
import okhttp3.t;
import okhttp3.t.a;
import okhttp3.u;
import okhttp3.x;
import okhttp3.x.a;
import okhttp3.y;
import okhttp3.z;
import okhttp3.z.a;
import okio.i;
import okio.k;
import okio.q;

public final class fi
  implements t
{
  private final m a;
  
  public fi(m paramm)
  {
    this.a = paramm;
  }
  
  private String a(List<l> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append("; ");
      }
      l locall = (l)paramList.get(i);
      localStringBuilder.append(locall.a()).append('=').append(locall.b());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public z a(t.a parama)
  {
    int j = 0;
    Object localObject1 = parama.a();
    Object localObject2 = ((x)localObject1).e();
    Object localObject3 = ((x)localObject1).d();
    if (localObject3 != null)
    {
      u localu = ((y)localObject3).a();
      if (localu != null) {
        ((x.a)localObject2).a("Content-Type", localu.toString());
      }
      long l = ((y)localObject3).b();
      if (l == -1L) {
        break label374;
      }
      ((x.a)localObject2).a("Content-Length", Long.toString(l));
      ((x.a)localObject2).b("Transfer-Encoding");
    }
    for (;;)
    {
      if (((x)localObject1).a("Host") == null) {
        ((x.a)localObject2).a("Host", fb.a(((x)localObject1).a(), false));
      }
      if (((x)localObject1).a("Connection") == null) {
        ((x.a)localObject2).a("Connection", "Keep-Alive");
      }
      int i = j;
      if (((x)localObject1).a("Accept-Encoding") == null)
      {
        i = j;
        if (((x)localObject1).a("Range") == null)
        {
          i = 1;
          ((x.a)localObject2).a("Accept-Encoding", "gzip");
        }
      }
      localObject3 = this.a.a(((x)localObject1).a());
      if (!((List)localObject3).isEmpty()) {
        ((x.a)localObject2).a("Cookie", a((List)localObject3));
      }
      if (((x)localObject1).a("User-Agent") == null) {
        ((x.a)localObject2).a("User-Agent", fc.a());
      }
      parama = parama.a(((x.a)localObject2).a());
      fm.a(this.a, ((x)localObject1).a(), parama.d());
      localObject1 = parama.f().a((x)localObject1);
      if ((i != 0) && ("gzip".equalsIgnoreCase(parama.a("Content-Encoding"))) && (fm.b(parama)))
      {
        localObject2 = new i(parama.e().c());
        ((z.a)localObject1).a(parama.d().b().b("Content-Encoding").b("Content-Length").a());
        ((z.a)localObject1).a(new fp(parama.a("Content-Type"), -1L, k.a((q)localObject2)));
      }
      return ((z.a)localObject1).a();
      label374:
      ((x.a)localObject2).a("Transfer-Encoding", "chunked");
      ((x.a)localObject2).b("Content-Length");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fi
 * JD-Core Version:    0.7.0.1
 */