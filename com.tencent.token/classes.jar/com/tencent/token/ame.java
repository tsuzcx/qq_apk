package com.tencent.token;

import java.util.List;

public final class ame
  implements ale
{
  private final akx a;
  
  public ame(akx paramakx)
  {
    this.a = paramakx;
  }
  
  public final all a(ale.a parama)
  {
    Object localObject1 = parama.a();
    Object localObject2 = ((alj)localObject1).a();
    Object localObject3 = ((alj)localObject1).d;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject4 = ((alk)localObject3).a();
      if (localObject4 != null) {
        ((alj.a)localObject2).a("Content-Type", ((alf)localObject4).toString());
      }
      long l = ((alk)localObject3).b();
      if (l != -1L)
      {
        ((alj.a)localObject2).a("Content-Length", Long.toString(l));
        ((alj.a)localObject2).b("Transfer-Encoding");
      }
      else
      {
        ((alj.a)localObject2).a("Transfer-Encoding", "chunked");
        ((alj.a)localObject2).b("Content-Length");
      }
    }
    localObject3 = ((alj)localObject1).a("Host");
    int j = 0;
    if (localObject3 == null) {
      ((alj.a)localObject2).a("Host", alr.a(((alj)localObject1).a, false));
    }
    if (((alj)localObject1).a("Connection") == null) {
      ((alj.a)localObject2).a("Connection", "Keep-Alive");
    }
    int i;
    if ((((alj)localObject1).a("Accept-Encoding") == null) && (((alj)localObject1).a("Range") == null))
    {
      ((alj.a)localObject2).a("Accept-Encoding", "gzip");
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
        akw localakw = (akw)((List)localObject3).get(j);
        ((StringBuilder)localObject4).append(localakw.a);
        ((StringBuilder)localObject4).append('=');
        ((StringBuilder)localObject4).append(localakw.b);
        j += 1;
      }
      ((alj.a)localObject2).a("Cookie", ((StringBuilder)localObject4).toString());
    }
    if (((alj)localObject1).a("User-Agent") == null) {
      ((alj.a)localObject2).a("User-Agent", "okhttp/3.11.0");
    }
    parama = parama.a(((alj.a)localObject2).a());
    ami.a(this.a, ((alj)localObject1).a, parama.f);
    localObject2 = parama.a();
    ((all.a)localObject2).a = ((alj)localObject1);
    if ((i != 0) && ("gzip".equalsIgnoreCase(parama.a("Content-Encoding"))) && (ami.b(parama)))
    {
      localObject1 = new aoa(parama.g.b());
      ((all.a)localObject2).a(parama.f.a().a("Content-Encoding").a("Content-Length").a());
      ((all.a)localObject2).g = new aml(parama.a("Content-Type"), -1L, aoc.a((aoj)localObject1));
    }
    return ((all.a)localObject2).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ame
 * JD-Core Version:    0.7.0.1
 */