package com.tencent.token;

import java.util.List;

public final class alg
  implements akg
{
  private final ajz a;
  
  public alg(ajz paramajz)
  {
    this.a = paramajz;
  }
  
  public final akn a(akg.a parama)
  {
    Object localObject1 = parama.a();
    Object localObject2 = ((akl)localObject1).a();
    Object localObject3 = ((akl)localObject1).d;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject4 = ((akm)localObject3).a();
      if (localObject4 != null) {
        ((akl.a)localObject2).a("Content-Type", ((akh)localObject4).toString());
      }
      long l = ((akm)localObject3).b();
      if (l != -1L)
      {
        ((akl.a)localObject2).a("Content-Length", Long.toString(l));
        ((akl.a)localObject2).b("Transfer-Encoding");
      }
      else
      {
        ((akl.a)localObject2).a("Transfer-Encoding", "chunked");
        ((akl.a)localObject2).b("Content-Length");
      }
    }
    localObject3 = ((akl)localObject1).a("Host");
    int j = 0;
    if (localObject3 == null) {
      ((akl.a)localObject2).a("Host", akt.a(((akl)localObject1).a, false));
    }
    if (((akl)localObject1).a("Connection") == null) {
      ((akl.a)localObject2).a("Connection", "Keep-Alive");
    }
    int i;
    if ((((akl)localObject1).a("Accept-Encoding") == null) && (((akl)localObject1).a("Range") == null))
    {
      ((akl.a)localObject2).a("Accept-Encoding", "gzip");
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
        ajy localajy = (ajy)((List)localObject3).get(j);
        ((StringBuilder)localObject4).append(localajy.a);
        ((StringBuilder)localObject4).append('=');
        ((StringBuilder)localObject4).append(localajy.b);
        j += 1;
      }
      ((akl.a)localObject2).a("Cookie", ((StringBuilder)localObject4).toString());
    }
    if (((akl)localObject1).a("User-Agent") == null) {
      ((akl.a)localObject2).a("User-Agent", "okhttp/3.11.0");
    }
    parama = parama.a(((akl.a)localObject2).a());
    alk.a(this.a, ((akl)localObject1).a, parama.f);
    localObject2 = parama.a();
    ((akn.a)localObject2).a = ((akl)localObject1);
    if ((i != 0) && ("gzip".equalsIgnoreCase(parama.a("Content-Encoding"))) && (alk.b(parama)))
    {
      localObject1 = new anc(parama.g.b());
      ((akn.a)localObject2).a(parama.f.a().a("Content-Encoding").a("Content-Length").a());
      ((akn.a)localObject2).g = new aln(parama.a("Content-Type"), -1L, ane.a((anl)localObject1));
    }
    return ((akn.a)localObject2).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alg
 * JD-Core Version:    0.7.0.1
 */