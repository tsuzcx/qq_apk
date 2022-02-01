package com.tencent.token;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class amw
  implements amg
{
  private static final anw b = anw.a("connection");
  private static final anw c = anw.a("host");
  private static final anw d = anw.a("keep-alive");
  private static final anw e = anw.a("proxy-connection");
  private static final anw f = anw.a("transfer-encoding");
  private static final anw g = anw.a("te");
  private static final anw h = anw.a("encoding");
  private static final anw i = anw.a("upgrade");
  private static final List<anw> j = alr.a(new anw[] { b, c, d, e, g, f, h, i, amt.c, amt.d, amt.e, amt.f });
  private static final List<anw> k = alr.a(new anw[] { b, c, d, e, g, f, h, i });
  final amd a;
  private final ale.a l;
  private final amx m;
  private amz n;
  private final alh o;
  
  public amw(alg paramalg, ale.a parama, amd paramamd, amx paramamx)
  {
    this.l = parama;
    this.a = paramamd;
    this.m = paramamx;
    if (paramalg.e.contains(alh.e)) {
      paramalg = alh.e;
    } else {
      paramalg = alh.d;
    }
    this.o = paramalg;
  }
  
  public final all.a a(boolean paramBoolean)
  {
    List localList = this.n.c();
    alh localalh = this.o;
    Object localObject2 = new alc.a();
    int i2 = localList.size();
    int i1 = 0;
    Object localObject3 = null;
    Object localObject1;
    while (i1 < i2)
    {
      localObject1 = (amt)localList.get(i1);
      Object localObject4;
      if (localObject1 == null)
      {
        localObject1 = localObject3;
        localObject4 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          localObject4 = localObject2;
          if (localObject3.b == 100)
          {
            localObject4 = new alc.a();
            localObject1 = null;
          }
        }
      }
      else
      {
        anw localanw = ((amt)localObject1).g;
        String str = ((amt)localObject1).h.a();
        if (localanw.equals(amt.b))
        {
          localObject1 = amo.a("HTTP/1.1 ".concat(String.valueOf(str)));
          localObject4 = localObject2;
        }
        else
        {
          localObject1 = localObject3;
          localObject4 = localObject2;
          if (!k.contains(localanw))
          {
            alp.a.a((alc.a)localObject2, localanw.a(), str);
            localObject4 = localObject2;
            localObject1 = localObject3;
          }
        }
      }
      i1 += 1;
      localObject3 = localObject1;
      localObject2 = localObject4;
    }
    if (localObject3 != null)
    {
      localObject1 = new all.a();
      ((all.a)localObject1).b = localalh;
      ((all.a)localObject1).c = localObject3.b;
      ((all.a)localObject1).d = localObject3.c;
      localObject1 = ((all.a)localObject1).a(((alc.a)localObject2).a());
      if ((paramBoolean) && (alp.a.a((all.a)localObject1) == 100)) {
        return null;
      }
      return localObject1;
    }
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public final alm a(all paramall)
  {
    return new aml(paramall.a("Content-Type"), ami.a(paramall), aoc.a(new a(this.n.g)));
  }
  
  public final aoi a(alj paramalj, long paramLong)
  {
    return this.n.d();
  }
  
  public final void a()
  {
    this.m.p.b();
  }
  
  public final void a(alj paramalj)
  {
    if (this.n != null) {
      return;
    }
    Object localObject = paramalj.d;
    int i1 = 0;
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = paramalj.c;
    ArrayList localArrayList = new ArrayList(((alc)localObject).a.length / 2 + 4);
    localArrayList.add(new amt(amt.c, paramalj.b));
    localArrayList.add(new amt(amt.d, amm.a(paramalj.a)));
    String str = paramalj.a("Host");
    if (str != null) {
      localArrayList.add(new amt(amt.f, str));
    }
    localArrayList.add(new amt(amt.e, paramalj.a.a));
    int i2 = ((alc)localObject).a.length / 2;
    while (i1 < i2)
    {
      paramalj = anw.a(((alc)localObject).a(i1).toLowerCase(Locale.US));
      if (!j.contains(paramalj)) {
        localArrayList.add(new amt(paramalj, ((alc)localObject).b(i1)));
      }
      i1 += 1;
    }
    this.n = this.m.a(localArrayList, bool);
    this.n.i.a(this.l.c(), TimeUnit.MILLISECONDS);
    this.n.j.a(this.l.d(), TimeUnit.MILLISECONDS);
  }
  
  public final void b()
  {
    this.n.d().close();
  }
  
  final class a
    extends any
  {
    boolean a = false;
    long b = 0L;
    
    a(aoj paramaoj)
    {
      super();
    }
    
    private void b()
    {
      if (this.a) {
        return;
      }
      this.a = true;
      amw.this.a.a(false, amw.this);
    }
    
    public final long a(ant paramant, long paramLong)
    {
      try
      {
        paramLong = this.d.a(paramant, paramLong);
        if (paramLong > 0L) {
          this.b += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramant)
      {
        b();
        throw paramant;
      }
    }
    
    public final void close()
    {
      super.close();
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amw
 * JD-Core Version:    0.7.0.1
 */