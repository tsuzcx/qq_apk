package com.tencent.token;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.aa;
import okhttp3.r.a;
import okhttp3.t;
import okhttp3.t.a;
import okhttp3.x;
import okhttp3.z;
import okhttp3.z.a;
import okio.c;
import okio.d;
import okio.e;
import okio.k;
import okio.p;
import okio.q;

public final class fe
  implements t
{
  final fi a;
  
  public fe(fi paramfi)
  {
    this.a = paramfi;
  }
  
  private static okhttp3.r a(okhttp3.r paramr1, okhttp3.r paramr2)
  {
    int j = 0;
    r.a locala = new r.a();
    int k = paramr1.a();
    int i = 0;
    if (i < k)
    {
      String str1 = paramr1.a(i);
      String str2 = paramr1.b(i);
      if (("Warning".equalsIgnoreCase(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((b(str1)) || (!a(str1)) || (paramr2.a(str1) == null)) {
          fa.a.a(locala, str1, str2);
        }
      }
    }
    k = paramr2.a();
    i = j;
    while (i < k)
    {
      paramr1 = paramr2.a(i);
      if ((!b(paramr1)) && (a(paramr1))) {
        fa.a.a(locala, paramr1, paramr2.b(i));
      }
      i += 1;
    }
    return locala.a();
  }
  
  private z a(final ff paramff, z paramz)
  {
    if (paramff == null) {}
    do
    {
      return paramz;
      localObject = paramff.a();
    } while (localObject == null);
    paramff = new q()
    {
      boolean a;
      
      public long a(c paramAnonymousc, long paramAnonymousLong)
      {
        try
        {
          paramAnonymousLong = this.b.a(paramAnonymousc, paramAnonymousLong);
          if (paramAnonymousLong == -1L)
          {
            if (!this.a)
            {
              this.a = true;
              this.d.close();
            }
            return -1L;
          }
        }
        catch (IOException paramAnonymousc)
        {
          if (!this.a)
          {
            this.a = true;
            paramff.b();
          }
          throw paramAnonymousc;
        }
        paramAnonymousc.a(this.d.c(), paramAnonymousc.b() - paramAnonymousLong, paramAnonymousLong);
        this.d.u();
        return paramAnonymousLong;
      }
      
      public okio.r a()
      {
        return this.b.a();
      }
      
      public void close()
      {
        if ((!this.a) && (!fc.a(this, 100, TimeUnit.MILLISECONDS)))
        {
          this.a = true;
          paramff.b();
        }
        this.b.close();
      }
    };
    Object localObject = paramz.a("Content-Type");
    long l = paramz.e().a();
    return paramz.f().a(new fq((String)localObject, l, k.a(paramff))).a();
  }
  
  private static z a(z paramz)
  {
    z localz = paramz;
    if (paramz != null)
    {
      localz = paramz;
      if (paramz.e() != null) {
        localz = paramz.f().a(null).a();
      }
    }
    return localz;
  }
  
  static boolean a(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  static boolean b(String paramString)
  {
    return ("Content-Length".equalsIgnoreCase(paramString)) || ("Content-Encoding".equalsIgnoreCase(paramString)) || ("Content-Type".equalsIgnoreCase(paramString));
  }
  
  public z a(t.a parama)
  {
    z localz1;
    x localx;
    z localz2;
    if (this.a != null)
    {
      localz1 = this.a.a(parama.a());
      fg localfg = new fg.a(System.currentTimeMillis(), parama.a(), localz1).a();
      localx = localfg.a;
      localz2 = localfg.b;
      if (this.a != null) {
        this.a.a(localfg);
      }
      if ((localz1 != null) && (localz2 == null)) {
        fc.a(localz1.e());
      }
      if ((localx != null) || (localz2 != null)) {
        break label163;
      }
      parama = new z.a().a(parama.a()).a(Protocol.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(fc.c).a(-1L).b(System.currentTimeMillis()).a();
    }
    label163:
    label331:
    do
    {
      do
      {
        return parama;
        localz1 = null;
        break;
        if (localx == null) {
          return localz2.f().b(a(localz2)).a();
        }
        try
        {
          parama = parama.a(localx);
          if ((parama == null) && (localz1 != null)) {
            fc.a(localz1.e());
          }
          if (localz2 == null) {
            break label331;
          }
          if (parama.b() == 304)
          {
            localz1 = localz2.f().a(a(localz2.d(), parama.d())).a(parama.i()).b(parama.j()).b(a(localz2)).a(a(parama)).a();
            parama.e().close();
            this.a.a();
            this.a.a(localz2, localz1);
            return localz1;
          }
        }
        finally
        {
          if ((0 == 0) && (localz1 != null)) {
            fc.a(localz1.e());
          }
        }
        fc.a(localz2.e());
        localz1 = parama.f().b(a(localz2)).a(a(parama)).a();
        parama = localz1;
      } while (this.a == null);
      if ((fn.b(localz1)) && (fg.a(localz1, localx))) {
        return a(this.a.a(localz1), localz1);
      }
      parama = localz1;
    } while (!fo.a(localx.b()));
    try
    {
      this.a.b(localx);
      return localz1;
    }
    catch (IOException parama) {}
    return localz1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fe
 * JD-Core Version:    0.7.0.1
 */