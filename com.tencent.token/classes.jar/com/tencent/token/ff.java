package com.tencent.token;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.d;
import okhttp3.r;
import okhttp3.r.a;
import okhttp3.s;
import okhttp3.x;
import okhttp3.x.a;
import okhttp3.z;
import okhttp3.z.a;

public final class ff
{
  @Nullable
  public final x a;
  @Nullable
  public final z b;
  
  ff(x paramx, z paramz)
  {
    this.a = paramx;
    this.b = paramz;
  }
  
  public static boolean a(z paramz, x paramx)
  {
    switch (paramz.b())
    {
    }
    do
    {
      return false;
    } while (((paramz.a("Expires") == null) && (paramz.h().c() == -1) && (!paramz.h().e()) && (!paramz.h().d())) || (paramz.h().b()) || (paramx.f().b()));
    return true;
  }
  
  public static class a
  {
    final long a;
    final x b;
    final z c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l = -1;
    
    public a(long paramLong, x paramx, z paramz)
    {
      this.a = paramLong;
      this.b = paramx;
      this.c = paramz;
      if (paramz != null)
      {
        this.i = paramz.i();
        this.j = paramz.j();
        paramx = paramz.d();
        int m = 0;
        int n = paramx.a();
        if (m < n)
        {
          paramz = paramx.a(m);
          String str = paramx.b(m);
          if ("Date".equalsIgnoreCase(paramz))
          {
            this.d = fl.a(str);
            this.e = str;
          }
          for (;;)
          {
            m += 1;
            break;
            if ("Expires".equalsIgnoreCase(paramz))
            {
              this.h = fl.a(str);
            }
            else if ("Last-Modified".equalsIgnoreCase(paramz))
            {
              this.f = fl.a(str);
              this.g = str;
            }
            else if ("ETag".equalsIgnoreCase(paramz))
            {
              this.k = str;
            }
            else if ("Age".equalsIgnoreCase(paramz))
            {
              this.l = fm.b(str, -1);
            }
          }
        }
      }
    }
    
    private static boolean a(x paramx)
    {
      return (paramx.a("If-Modified-Since") != null) || (paramx.a("If-None-Match") != null);
    }
    
    private ff b()
    {
      long l4 = 0L;
      if (this.c == null) {
        return new ff(this.b, null);
      }
      if ((this.b.g()) && (this.c.c() == null)) {
        return new ff(this.b, null);
      }
      if (!ff.a(this.c, this.b)) {
        return new ff(this.b, null);
      }
      Object localObject1 = this.b.f();
      if ((((d)localObject1).a()) || (a(this.b))) {
        return new ff(this.b, null);
      }
      Object localObject2 = this.c.h();
      if (((d)localObject2).j()) {
        return new ff(null, this.c);
      }
      long l5 = d();
      long l2 = c();
      long l1 = l2;
      if (((d)localObject1).c() != -1) {
        l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(((d)localObject1).c()));
      }
      if (((d)localObject1).h() != -1) {}
      for (l2 = TimeUnit.SECONDS.toMillis(((d)localObject1).h());; l2 = 0L)
      {
        long l3 = l4;
        if (!((d)localObject2).f())
        {
          l3 = l4;
          if (((d)localObject1).g() != -1) {
            l3 = TimeUnit.SECONDS.toMillis(((d)localObject1).g());
          }
        }
        if ((!((d)localObject2).a()) && (l5 + l2 < l3 + l1))
        {
          localObject1 = this.c.f();
          if (l2 + l5 >= l1) {
            ((z.a)localObject1).a("Warning", "110 HttpURLConnection \"Response is stale\"");
          }
          if ((l5 > 86400000L) && (e())) {
            ((z.a)localObject1).a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
          }
          return new ff(null, ((z.a)localObject1).a());
        }
        if (this.k != null)
        {
          localObject2 = "If-None-Match";
          localObject1 = this.k;
        }
        for (;;)
        {
          r.a locala = this.b.c().b();
          ez.a.a(locala, (String)localObject2, (String)localObject1);
          return new ff(this.b.e().a(locala.a()).a(), this.c);
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
        return new ff(this.b, null);
      }
    }
    
    private long c()
    {
      long l2 = 0L;
      d locald = this.c.h();
      if (locald.c() != -1) {
        l1 = TimeUnit.SECONDS.toMillis(locald.c());
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
    
    public ff a()
    {
      ff localff2 = b();
      ff localff1 = localff2;
      if (localff2.a != null)
      {
        localff1 = localff2;
        if (this.b.f().i()) {
          localff1 = new ff(null, null);
        }
      }
      return localff1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ff
 * JD-Core Version:    0.7.0.1
 */