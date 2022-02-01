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

public final class fj
{
  @Nullable
  public final x a;
  @Nullable
  public final z b;
  
  fj(x paramx, z paramz)
  {
    this.a = paramx;
    this.b = paramz;
  }
  
  public static boolean a(z paramz, x paramx)
  {
    int i = paramz.b();
    boolean bool2 = false;
    switch (i)
    {
    default: 
      return false;
    case 302: 
    case 307: 
      if ((paramz.a("Expires") == null) && (paramz.h().c() == -1) && (!paramz.h().e()) && (!paramz.h().d())) {
        break;
      }
    case 200: 
    case 203: 
    case 204: 
    case 300: 
    case 301: 
    case 308: 
    case 404: 
    case 405: 
    case 410: 
    case 414: 
    case 501: 
      boolean bool1 = bool2;
      if (!paramz.h().b())
      {
        bool1 = bool2;
        if (!paramx.f().b()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
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
        while (m < n)
        {
          paramz = paramx.a(m);
          String str = paramx.b(m);
          if ("Date".equalsIgnoreCase(paramz))
          {
            this.d = fp.a(str);
            this.e = str;
          }
          else if ("Expires".equalsIgnoreCase(paramz))
          {
            this.h = fp.a(str);
          }
          else if ("Last-Modified".equalsIgnoreCase(paramz))
          {
            this.f = fp.a(str);
            this.g = str;
          }
          else if ("ETag".equalsIgnoreCase(paramz))
          {
            this.k = str;
          }
          else if ("Age".equalsIgnoreCase(paramz))
          {
            this.l = fq.b(str, -1);
          }
          m += 1;
        }
      }
    }
    
    private static boolean a(x paramx)
    {
      return (paramx.a("If-Modified-Since") != null) || (paramx.a("If-None-Match") != null);
    }
    
    private fj b()
    {
      if (this.c == null) {
        return new fj(this.b, null);
      }
      if ((this.b.g()) && (this.c.c() == null)) {
        return new fj(this.b, null);
      }
      if (!fj.a(this.c, this.b)) {
        return new fj(this.b, null);
      }
      Object localObject1 = this.b.f();
      if ((!((d)localObject1).a()) && (!a(this.b)))
      {
        Object localObject2 = this.c.h();
        if (((d)localObject2).j()) {
          return new fj(null, this.c);
        }
        long l5 = d();
        long l2 = c();
        long l1 = l2;
        if (((d)localObject1).c() != -1) {
          l1 = Math.min(l2, TimeUnit.SECONDS.toMillis(((d)localObject1).c()));
        }
        int m = ((d)localObject1).h();
        long l4 = 0L;
        if (m != -1) {
          l2 = TimeUnit.SECONDS.toMillis(((d)localObject1).h());
        } else {
          l2 = 0L;
        }
        long l3 = l4;
        if (!((d)localObject2).f())
        {
          l3 = l4;
          if (((d)localObject1).g() != -1) {
            l3 = TimeUnit.SECONDS.toMillis(((d)localObject1).g());
          }
        }
        if (!((d)localObject2).a())
        {
          l2 += l5;
          if (l2 < l3 + l1)
          {
            localObject1 = this.c.f();
            if (l2 >= l1) {
              ((z.a)localObject1).a("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if ((l5 > 86400000L) && (e())) {
              ((z.a)localObject1).a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return new fj(null, ((z.a)localObject1).a());
          }
        }
        localObject1 = this.k;
        if (localObject1 != null)
        {
          localObject2 = "If-None-Match";
        }
        else if (this.f != null)
        {
          localObject2 = "If-Modified-Since";
          localObject1 = this.g;
        }
        else
        {
          if (this.d == null) {
            break label455;
          }
          localObject2 = "If-Modified-Since";
          localObject1 = this.e;
        }
        r.a locala = this.b.c().b();
        fd.a.a(locala, (String)localObject2, (String)localObject1);
        return new fj(this.b.e().a(locala.a()).a(), this.c);
        label455:
        return new fj(this.b, null);
      }
      return new fj(this.b, null);
    }
    
    private long c()
    {
      Object localObject = this.c.h();
      if (((d)localObject).c() != -1) {
        return TimeUnit.SECONDS.toMillis(((d)localObject).c());
      }
      localObject = this.h;
      long l1 = 0L;
      long l2;
      if (localObject != null)
      {
        localObject = this.d;
        if (localObject != null) {
          l2 = ((Date)localObject).getTime();
        } else {
          l2 = this.j;
        }
        l2 = this.h.getTime() - l2;
        if (l2 > 0L) {
          l1 = l2;
        }
        return l1;
      }
      if ((this.f != null) && (this.c.a().a().k() == null))
      {
        localObject = this.d;
        if (localObject != null) {
          l2 = ((Date)localObject).getTime();
        } else {
          l2 = this.i;
        }
        l2 -= this.f.getTime();
        if (l2 > 0L) {
          l1 = l2 / 10L;
        }
        return l1;
      }
      return 0L;
    }
    
    private long d()
    {
      Date localDate = this.d;
      long l1 = 0L;
      if (localDate != null) {
        l1 = Math.max(0L, this.j - localDate.getTime());
      }
      long l2 = l1;
      if (this.l != -1) {
        l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.l));
      }
      l1 = this.j;
      return l2 + (l1 - this.i) + (this.a - l1);
    }
    
    private boolean e()
    {
      return (this.c.h().c() == -1) && (this.h == null);
    }
    
    public fj a()
    {
      fj localfj = b();
      if ((localfj.a != null) && (this.b.f().i())) {
        return new fj(null, null);
      }
      return localfj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fj
 * JD-Core Version:    0.7.0.1
 */