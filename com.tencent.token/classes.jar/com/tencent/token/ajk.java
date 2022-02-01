package com.tencent.token;

import java.util.List;

public final class ajk
  implements aik
{
  private final aid a;
  
  public ajk(aid paramaid)
  {
    this.a = paramaid;
  }
  
  public final air a(aik.a parama)
  {
    Object localObject1 = parama.a();
    Object localObject2 = ((aip)localObject1).a();
    Object localObject3 = ((aip)localObject1).d;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject4 = ((aiq)localObject3).a();
      if (localObject4 != null) {
        ((aip.a)localObject2).a("Content-Type", ((ail)localObject4).toString());
      }
      long l = ((aiq)localObject3).b();
      if (l != -1L)
      {
        ((aip.a)localObject2).a("Content-Length", Long.toString(l));
        ((aip.a)localObject2).b("Transfer-Encoding");
      }
      else
      {
        ((aip.a)localObject2).a("Transfer-Encoding", "chunked");
        ((aip.a)localObject2).b("Content-Length");
      }
    }
    localObject3 = ((aip)localObject1).a("Host");
    int j = 0;
    if (localObject3 == null) {
      ((aip.a)localObject2).a("Host", aix.a(((aip)localObject1).a, false));
    }
    if (((aip)localObject1).a("Connection") == null) {
      ((aip.a)localObject2).a("Connection", "Keep-Alive");
    }
    int i;
    if ((((aip)localObject1).a("Accept-Encoding") == null) && (((aip)localObject1).a("Range") == null))
    {
      ((aip.a)localObject2).a("Accept-Encoding", "gzip");
      i = 1;
    }
    else
    {
      i = 0;
    }
    localObject3 = this.a.a();
    if (!((List)localObject3).isEmpty())
    {
      localObject4 = new StringBuilder();
      int k = ((List)localObject3).size();
      while (j < k)
      {
        if (j > 0) {
          ((StringBuilder)localObject4).append("; ");
        }
        aic localaic = (aic)((List)localObject3).get(j);
        ((StringBuilder)localObject4).append(localaic.a);
        ((StringBuilder)localObject4).append('=');
        ((StringBuilder)localObject4).append(localaic.b);
        j += 1;
      }
      ((aip.a)localObject2).a("Cookie", ((StringBuilder)localObject4).toString());
    }
    if (((aip)localObject1).a("User-Agent") == null) {
      ((aip.a)localObject2).a("User-Agent", "okhttp/3.11.0");
    }
    parama = parama.a(((aip.a)localObject2).a());
    ajo.a(this.a, ((aip)localObject1).a, parama.f);
    localObject2 = parama.a();
    ((air.a)localObject2).a = ((aip)localObject1);
    if ((i != 0) && ("gzip".equalsIgnoreCase(parama.a("Content-Encoding"))) && (ajo.b(parama)))
    {
      localObject1 = new alg(parama.g.b());
      ((air.a)localObject2).a(parama.f.a().a("Content-Encoding").a("Content-Length").a());
      ((air.a)localObject2).g = new ajr(parama.a("Content-Type"), -1L, ali.a((alp)localObject1));
    }
    return ((air.a)localObject2).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajk
 * JD-Core Version:    0.7.0.1
 */