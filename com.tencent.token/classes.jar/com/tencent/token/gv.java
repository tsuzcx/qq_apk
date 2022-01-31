package com.tencent.token;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.af;
import okhttp3.ap;
import okhttp3.aq;
import okhttp3.at;
import okhttp3.au;
import okhttp3.e;

public class gv
{
  final long a;
  final ap b;
  final at c;
  private Date d;
  private String e;
  private Date f;
  private String g;
  private Date h;
  private long i;
  private long j;
  private String k;
  private int l = -1;
  
  public gv(long paramLong, ap paramap, at paramat)
  {
    this.a = paramLong;
    this.b = paramap;
    this.c = paramat;
    if (paramat != null)
    {
      this.i = paramat.i();
      this.j = paramat.j();
      paramap = paramat.d();
      int m = 0;
      int n = paramap.a();
      if (m < n)
      {
        paramat = paramap.a(m);
        String str = paramap.b(m);
        if ("Date".equalsIgnoreCase(paramat))
        {
          this.d = he.a(str);
          this.e = str;
        }
        for (;;)
        {
          m += 1;
          break;
          if ("Expires".equalsIgnoreCase(paramat))
          {
            this.h = he.a(str);
          }
          else if ("Last-Modified".equalsIgnoreCase(paramat))
          {
            this.f = he.a(str);
            this.g = str;
          }
          else if ("ETag".equalsIgnoreCase(paramat))
          {
            this.k = str;
          }
          else if ("Age".equalsIgnoreCase(paramat))
          {
            this.l = hg.b(str, -1);
          }
        }
      }
    }
  }
  
  private static boolean a(ap paramap)
  {
    return (paramap.a("If-Modified-Since") != null) || (paramap.a("If-None-Match") != null);
  }
  
  private gu b()
  {
    long l4 = 0L;
    if (this.c == null) {
      return new gu(this.b, null);
    }
    if ((this.b.g()) && (this.c.c() == null)) {
      return new gu(this.b, null);
    }
    if (!gu.a(this.c, this.b)) {
      return new gu(this.b, null);
    }
    Object localObject1 = this.b.f();
    if ((((e)localObject1).a()) || (a(this.b))) {
      return new gu(this.b, null);
    }
    Object localObject2 = this.c.h();
    if (((e)localObject2).j()) {
      return new gu(null, this.c);
    }
    long l5 = d();
    long l2 = c();
    long l1 = l2;
    if (((e)localObject1).c() != -1) {
      l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(((e)localObject1).c()));
    }
    if (((e)localObject1).h() != -1) {}
    for (l2 = TimeUnit.SECONDS.toMillis(((e)localObject1).h());; l2 = 0L)
    {
      long l3 = l4;
      if (!((e)localObject2).f())
      {
        l3 = l4;
        if (((e)localObject1).g() != -1) {
          l3 = TimeUnit.SECONDS.toMillis(((e)localObject1).g());
        }
      }
      if ((!((e)localObject2).a()) && (l5 + l2 < l3 + l1))
      {
        localObject1 = this.c.f();
        if (l2 + l5 >= l1) {
          ((au)localObject1).a("Warning", "110 HttpURLConnection \"Response is stale\"");
        }
        if ((l5 > 86400000L) && (e())) {
          ((au)localObject1).a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        }
        return new gu(null, ((au)localObject1).a());
      }
      if (this.k != null)
      {
        localObject2 = "If-None-Match";
        localObject1 = this.k;
      }
      for (;;)
      {
        ae localae = this.b.c().b();
        gl.a.a(localae, (String)localObject2, (String)localObject1);
        return new gu(this.b.e().a(localae.a()).a(), this.c);
        if (this.f != null)
        {
          localObject2 = "If-Modified-Since";
          localObject1 = this.g;
        }
        else
        {
          if (this.d == null) {
            break;
          }
          localObject2 = "If-Modified-Since";
          localObject1 = this.e;
        }
      }
      return new gu(this.b, null);
    }
  }
  
  private long c()
  {
    long l2 = 0L;
    e locale = this.c.h();
    if (locale.c() != -1) {
      l1 = TimeUnit.SECONDS.toMillis(locale.c());
    }
    label83:
    do
    {
      do
      {
        return l1;
        if (this.h != null)
        {
          if (this.d != null)
          {
            l1 = this.d.getTime();
            l1 = this.h.getTime() - l1;
            if (l1 <= 0L) {
              break label83;
            }
          }
          for (;;)
          {
            return l1;
            l1 = this.j;
            break;
            l1 = 0L;
          }
        }
        l1 = l2;
      } while (this.f == null);
      l1 = l2;
    } while (this.c.a().a().k() != null);
    if (this.d != null) {}
    for (long l1 = this.d.getTime();; l1 = this.i)
    {
      long l3 = l1 - this.f.getTime();
      l1 = l2;
      if (l3 <= 0L) {
        break;
      }
      return l3 / 10L;
    }
  }
  
  private long d()
  {
    long l1 = 0L;
    if (this.d != null) {
      l1 = Math.max(0L, this.j - this.d.getTime());
    }
    long l2 = l1;
    if (this.l != -1) {
      l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.l));
    }
    return l2 + (this.j - this.i) + (this.a - this.j);
  }
  
  private boolean e()
  {
    return (this.c.h().c() == -1) && (this.h == null);
  }
  
  public gu a()
  {
    gu localgu2 = b();
    gu localgu1 = localgu2;
    if (localgu2.a != null)
    {
      localgu1 = localgu2;
      if (this.b.f().i()) {
        localgu1 = new gu(null, null);
      }
    }
    return localgu1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gv
 * JD-Core Version:    0.7.0.1
 */