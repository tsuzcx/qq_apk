package com.tencent.token;

import java.util.List;

public final class ajj
  implements aij
{
  private final aic a;
  
  public ajj(aic paramaic)
  {
    this.a = paramaic;
  }
  
  public final aiq a(aij.a parama)
  {
    Object localObject1 = parama.a();
    Object localObject2 = ((aio)localObject1).a();
    Object localObject3 = ((aio)localObject1).d;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject4 = ((aip)localObject3).a();
      if (localObject4 != null) {
        ((aio.a)localObject2).a("Content-Type", ((aik)localObject4).toString());
      }
      long l = ((aip)localObject3).b();
      if (l != -1L)
      {
        ((aio.a)localObject2).a("Content-Length", Long.toString(l));
        ((aio.a)localObject2).b("Transfer-Encoding");
      }
      else
      {
        ((aio.a)localObject2).a("Transfer-Encoding", "chunked");
        ((aio.a)localObject2).b("Content-Length");
      }
    }
    localObject3 = ((aio)localObject1).a("Host");
    int j = 0;
    if (localObject3 == null) {
      ((aio.a)localObject2).a("Host", aiw.a(((aio)localObject1).a, false));
    }
    if (((aio)localObject1).a("Connection") == null) {
      ((aio.a)localObject2).a("Connection", "Keep-Alive");
    }
    int i;
    if ((((aio)localObject1).a("Accept-Encoding") == null) && (((aio)localObject1).a("Range") == null))
    {
      ((aio.a)localObject2).a("Accept-Encoding", "gzip");
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
        aib localaib = (aib)((List)localObject3).get(j);
        ((StringBuilder)localObject4).append(localaib.a);
        ((StringBuilder)localObject4).append('=');
        ((StringBuilder)localObject4).append(localaib.b);
        j += 1;
      }
      ((aio.a)localObject2).a("Cookie", ((StringBuilder)localObject4).toString());
    }
    if (((aio)localObject1).a("User-Agent") == null) {
      ((aio.a)localObject2).a("User-Agent", "okhttp/3.11.0");
    }
    parama = parama.a(((aio.a)localObject2).a());
    ajn.a(this.a, ((aio)localObject1).a, parama.f);
    localObject2 = parama.a();
    ((aiq.a)localObject2).a = ((aio)localObject1);
    if ((i != 0) && ("gzip".equalsIgnoreCase(parama.a("Content-Encoding"))) && (ajn.b(parama)))
    {
      localObject1 = new alf(parama.g.b());
      ((aiq.a)localObject2).a(parama.f.a().a("Content-Encoding").a("Content-Length").a());
      ((aiq.a)localObject2).g = new ajq(parama.a("Content-Type"), -1L, alh.a((alo)localObject1));
    }
    return ((aiq.a)localObject2).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajj
 * JD-Core Version:    0.7.0.1
 */