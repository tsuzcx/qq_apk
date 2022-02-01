package com.tencent.token;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class aku
  implements akg
{
  final aky a;
  
  public aku(aky paramaky)
  {
    this.a = paramaky;
  }
  
  private static ake a(ake paramake1, ake paramake2)
  {
    ake.a locala = new ake.a();
    int k = paramake1.a.length / 2;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      String str1 = paramake1.a(i);
      String str2 = paramake1.b(i);
      if (((!"Warning".equalsIgnoreCase(str1)) || (!str2.startsWith("1"))) && ((b(str1)) || (!a(str1)) || (paramake2.a(str1) == null))) {
        akr.a.a(locala, str1, str2);
      }
      i += 1;
    }
    k = paramake2.a.length / 2;
    i = j;
    while (i < k)
    {
      paramake1 = paramake2.a(i);
      if ((!b(paramake1)) && (a(paramake1))) {
        akr.a.a(locala, paramake1, paramake2.b(i));
      }
      i += 1;
    }
    return locala.a();
  }
  
  private static akn a(akn paramakn)
  {
    if ((paramakn != null) && (paramakn.g != null))
    {
      paramakn = paramakn.a();
      paramakn.g = null;
      return paramakn.a();
    }
    return paramakn;
  }
  
  private static boolean a(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  private static boolean b(String paramString)
  {
    return ("Content-Length".equalsIgnoreCase(paramString)) || ("Content-Encoding".equalsIgnoreCase(paramString)) || ("Content-Type".equalsIgnoreCase(paramString));
  }
  
  public final akn a(akg.a parama)
  {
    Object localObject1 = this.a;
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = ((aky)localObject1).a();
    } else {
      localObject2 = null;
    }
    akw.a locala = new akw.a(System.currentTimeMillis(), parama.a(), (akn)localObject2);
    long l1;
    if (locala.c == null)
    {
      localObject1 = new akw(locala.b, null);
    }
    else if ((locala.b.a.b()) && (locala.c.e == null))
    {
      localObject1 = new akw(locala.b, null);
    }
    else if (!akw.a(locala.c, locala.b))
    {
      localObject1 = new akw(locala.b, null);
    }
    else
    {
      localObject3 = locala.b.b();
      if (!((ajr)localObject3).c)
      {
        localObject1 = locala.b;
        int i;
        if ((((akl)localObject1).a("If-Modified-Since") == null) && (((akl)localObject1).a("If-None-Match") == null)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          Object localObject4 = locala.c.b();
          if (((ajr)localObject4).l)
          {
            localObject1 = new akw(null, locala.c);
            break label946;
          }
          localObject1 = locala.d;
          long l4 = 0L;
          if (localObject1 != null) {
            l1 = Math.max(0L, locala.j - locala.d.getTime());
          } else {
            l1 = 0L;
          }
          long l2 = l1;
          if (locala.l != -1) {
            l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(locala.l));
          }
          long l5 = l2 + (locala.j - locala.i) + (locala.a - locala.j);
          localObject1 = locala.c.b();
          if (((ajr)localObject1).e != -1)
          {
            l1 = TimeUnit.SECONDS.toMillis(((ajr)localObject1).e);
          }
          else if (locala.h != null)
          {
            if (locala.d != null) {
              l1 = locala.d.getTime();
            } else {
              l1 = locala.j;
            }
            l1 = locala.h.getTime() - l1;
            if (l1 <= 0L) {
              l1 = 0L;
            }
          }
          else
          {
            if (locala.f != null)
            {
              localObject1 = locala.c.a.a;
              if (((akf)localObject1).d == null)
              {
                localObject1 = null;
              }
              else
              {
                StringBuilder localStringBuilder = new StringBuilder();
                akf.b(localStringBuilder, ((akf)localObject1).d);
                localObject1 = localStringBuilder.toString();
              }
              if (localObject1 == null)
              {
                if (locala.d != null) {
                  l1 = locala.d.getTime();
                } else {
                  l1 = locala.i;
                }
                l1 -= locala.f.getTime();
                if (l1 > 0L)
                {
                  l1 /= 10L;
                  break label563;
                }
                l1 = 0L;
                break label563;
              }
            }
            l1 = 0L;
          }
          label563:
          l2 = l1;
          if (((ajr)localObject3).e != -1) {
            l2 = Math.min(l1, TimeUnit.SECONDS.toMillis(((ajr)localObject3).e));
          }
          if (((ajr)localObject3).j != -1) {
            l1 = TimeUnit.SECONDS.toMillis(((ajr)localObject3).j);
          } else {
            l1 = 0L;
          }
          long l3 = l4;
          if (!((ajr)localObject4).h)
          {
            l3 = l4;
            if (((ajr)localObject3).i != -1) {
              l3 = TimeUnit.SECONDS.toMillis(((ajr)localObject3).i);
            }
          }
          if (!((ajr)localObject4).c)
          {
            l1 += l5;
            if (l1 < l3 + l2)
            {
              localObject1 = locala.c.a();
              if (l1 >= l2) {
                ((akn.a)localObject1).a("Warning", "110 HttpURLConnection \"Response is stale\"");
              }
              if (l5 > 86400000L)
              {
                if ((locala.c.b().e == -1) && (locala.h == null)) {
                  i = 1;
                } else {
                  i = 0;
                }
                if (i != 0) {
                  ((akn.a)localObject1).a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
              }
              localObject1 = new akw(null, ((akn.a)localObject1).a());
              break label946;
            }
          }
          if (locala.k != null)
          {
            localObject1 = "If-None-Match";
            localObject3 = locala.k;
          }
          else if (locala.f != null)
          {
            localObject1 = "If-Modified-Since";
            localObject3 = locala.g;
          }
          else
          {
            if (locala.d == null) {
              break label913;
            }
            localObject1 = "If-Modified-Since";
            localObject3 = locala.e;
          }
          localObject4 = locala.b.c.a();
          akr.a.a((ake.a)localObject4, (String)localObject1, (String)localObject3);
          localObject1 = locala.b.a();
          ((akl.a)localObject1).c = ((ake.a)localObject4).a().a();
          localObject1 = new akw(((akl.a)localObject1).a(), locala.c);
          break label946;
          label913:
          localObject1 = new akw(locala.b, null);
          break label946;
        }
      }
      localObject1 = new akw(locala.b, null);
    }
    label946:
    Object localObject3 = localObject1;
    if (((akw)localObject1).a != null)
    {
      localObject3 = localObject1;
      if (locala.b.b().k) {
        localObject3 = new akw(null, null);
      }
    }
    localObject1 = ((akw)localObject3).a;
    localObject3 = ((akw)localObject3).b;
    if ((localObject2 != null) && (localObject3 == null)) {
      akt.a(((akn)localObject2).g);
    }
    if ((localObject1 == null) && (localObject3 == null))
    {
      localObject1 = new akn.a();
      ((akn.a)localObject1).a = parama.a();
      ((akn.a)localObject1).b = akj.b;
      ((akn.a)localObject1).c = 504;
      ((akn.a)localObject1).d = "Unsatisfiable Request (only-if-cached)";
      ((akn.a)localObject1).g = akt.c;
      ((akn.a)localObject1).k = -1L;
      ((akn.a)localObject1).l = System.currentTimeMillis();
      return ((akn.a)localObject1).a();
    }
    if (localObject1 == null) {
      return ((akn)localObject3).a().b(a((akn)localObject3)).a();
    }
    try
    {
      parama = parama.a((akl)localObject1);
      if ((parama == null) && (localObject2 != null)) {
        akt.a(((akn)localObject2).g);
      }
      if (localObject3 != null)
      {
        if (parama.c == 304)
        {
          localObject1 = ((akn)localObject3).a().a(a(((akn)localObject3).f, parama.f));
          ((akn.a)localObject1).k = parama.k;
          ((akn.a)localObject1).l = parama.l;
          localObject1 = ((akn.a)localObject1).b(a((akn)localObject3)).a(a(parama)).a();
          parama.g.close();
          return localObject1;
        }
        akt.a(((akn)localObject3).g);
      }
      parama = parama.a().b(a((akn)localObject3)).a(a(parama)).a();
      if (this.a != null)
      {
        if ((alk.b(parama)) && (akw.a(parama, (akl)localObject1)))
        {
          localObject1 = this.a.b();
          if (localObject1 == null) {
            return parama;
          }
          localObject2 = ((akv)localObject1).a();
          if (localObject2 == null) {
            return parama;
          }
          localObject1 = new anl()
          {
            boolean a;
            
            public final long a(amv paramAnonymousamv, long paramAnonymousLong)
            {
              try
              {
                paramAnonymousLong = this.b.a(paramAnonymousamv, paramAnonymousLong);
                if (paramAnonymousLong == -1L)
                {
                  if (!this.a)
                  {
                    this.a = true;
                    this.d.close();
                  }
                  return -1L;
                }
                paramAnonymousamv.a(this.d.b(), paramAnonymousamv.b - paramAnonymousLong, paramAnonymousLong);
                this.d.r();
                return paramAnonymousLong;
              }
              catch (IOException paramAnonymousamv)
              {
                if (!this.a) {
                  this.a = true;
                }
                throw paramAnonymousamv;
              }
            }
            
            public final anm a()
            {
              return this.b.a();
            }
            
            public final void close()
            {
              if ((!this.a) && (!akt.a(this, TimeUnit.MILLISECONDS))) {
                this.a = true;
              }
              this.b.close();
            }
          };
          localObject2 = parama.a("Content-Type");
          l1 = parama.g.a();
          parama = parama.a();
          parama.g = new aln((String)localObject2, l1, ane.a((anl)localObject1));
          return parama.a();
        }
        localObject1 = ((akl)localObject1).b;
        if ((!((String)localObject1).equals("POST")) && (!((String)localObject1).equals("PATCH")) && (!((String)localObject1).equals("PUT")) && (!((String)localObject1).equals("DELETE"))) {
          ((String)localObject1).equals("MOVE");
        }
      }
      return parama;
    }
    finally
    {
      if (localObject2 != null) {
        akt.a(((akn)localObject2).g);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aku
 * JD-Core Version:    0.7.0.1
 */