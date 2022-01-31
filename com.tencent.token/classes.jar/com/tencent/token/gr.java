package com.tencent.token;

import java.io.IOException;
import okhttp3.Protocol;
import okhttp3.ad;
import okhttp3.ae;
import okhttp3.ah;
import okhttp3.ai;
import okhttp3.ap;
import okhttp3.at;
import okhttp3.au;
import okhttp3.av;
import okio.o;
import okio.x;

public final class gr
  implements ah
{
  final gz a;
  
  public gr(gz paramgz)
  {
    this.a = paramgz;
  }
  
  private static ad a(ad paramad1, ad paramad2)
  {
    int j = 0;
    ae localae = new ae();
    int k = paramad1.a();
    int i = 0;
    if (i < k)
    {
      String str1 = paramad1.a(i);
      String str2 = paramad1.b(i);
      if (("Warning".equalsIgnoreCase(str1)) && (str2.startsWith("1"))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((b(str1)) || (!a(str1)) || (paramad2.a(str1) == null)) {
          gl.a.a(localae, str1, str2);
        }
      }
    }
    k = paramad2.a();
    i = j;
    while (i < k)
    {
      paramad1 = paramad2.a(i);
      if ((!b(paramad1)) && (a(paramad1))) {
        gl.a.a(localae, paramad1, paramad2.b(i));
      }
      i += 1;
    }
    return localae.a();
  }
  
  private at a(gt paramgt, at paramat)
  {
    if (paramgt == null) {}
    do
    {
      return paramat;
      localObject = paramgt.a();
    } while (localObject == null);
    paramgt = new gs(this, paramat.e().c(), paramgt, o.a((x)localObject));
    Object localObject = paramat.a("Content-Type");
    long l = paramat.e().a();
    return paramat.f().a(new hj((String)localObject, l, o.a(paramgt))).a();
  }
  
  private static at a(at paramat)
  {
    at localat = paramat;
    if (paramat != null)
    {
      localat = paramat;
      if (paramat.e() != null) {
        localat = paramat.f().a(null).a();
      }
    }
    return localat;
  }
  
  static boolean a(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  static boolean b(String paramString)
  {
    return ("Content-Length".equalsIgnoreCase(paramString)) || ("Content-Encoding".equalsIgnoreCase(paramString)) || ("Content-Type".equalsIgnoreCase(paramString));
  }
  
  public at a(ai paramai)
  {
    at localat1;
    ap localap;
    at localat2;
    if (this.a != null)
    {
      localat1 = this.a.a(paramai.a());
      gu localgu = new gv(System.currentTimeMillis(), paramai.a(), localat1).a();
      localap = localgu.a;
      localat2 = localgu.b;
      if (this.a != null) {
        this.a.a(localgu);
      }
      if ((localat1 != null) && (localat2 == null)) {
        gn.a(localat1.e());
      }
      if ((localap != null) || (localat2 != null)) {
        break label163;
      }
      paramai = new au().a(paramai.a()).a(Protocol.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(gn.c).a(-1L).b(System.currentTimeMillis()).a();
    }
    label163:
    label331:
    do
    {
      do
      {
        return paramai;
        localat1 = null;
        break;
        if (localap == null) {
          return localat2.f().b(a(localat2)).a();
        }
        try
        {
          paramai = paramai.a(localap);
          if ((paramai == null) && (localat1 != null)) {
            gn.a(localat1.e());
          }
          if (localat2 == null) {
            break label331;
          }
          if (paramai.b() == 304)
          {
            localat1 = localat2.f().a(a(localat2.d(), paramai.d())).a(paramai.i()).b(paramai.j()).b(a(localat2)).a(a(paramai)).a();
            paramai.e().close();
            this.a.a();
            this.a.a(localat2, localat1);
            return localat1;
          }
        }
        finally
        {
          if ((0 == 0) && (localat1 != null)) {
            gn.a(localat1.e());
          }
        }
        gn.a(localat2.e());
        localat1 = paramai.f().b(a(localat2)).a(a(paramai)).a();
        paramai = localat1;
      } while (this.a == null);
      if ((hg.b(localat1)) && (gu.a(localat1, localap))) {
        return a(this.a.a(localat1), localat1);
      }
      paramai = localat1;
    } while (!hh.a(localap.b()));
    try
    {
      this.a.b(localap);
      return localat1;
    }
    catch (IOException paramai) {}
    return localat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gr
 * JD-Core Version:    0.7.0.1
 */