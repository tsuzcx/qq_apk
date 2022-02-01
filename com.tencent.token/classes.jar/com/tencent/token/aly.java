package com.tencent.token;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class aly
  implements ali
{
  private static final amy b = amy.a("connection");
  private static final amy c = amy.a("host");
  private static final amy d = amy.a("keep-alive");
  private static final amy e = amy.a("proxy-connection");
  private static final amy f = amy.a("transfer-encoding");
  private static final amy g = amy.a("te");
  private static final amy h = amy.a("encoding");
  private static final amy i = amy.a("upgrade");
  private static final List<amy> j = akt.a(new amy[] { b, c, d, e, g, f, h, i, alv.c, alv.d, alv.e, alv.f });
  private static final List<amy> k = akt.a(new amy[] { b, c, d, e, g, f, h, i });
  final alf a;
  private final akg.a l;
  private final alz m;
  private amb n;
  private final akj o;
  
  public aly(aki paramaki, akg.a parama, alf paramalf, alz paramalz)
  {
    this.l = parama;
    this.a = paramalf;
    this.m = paramalz;
    if (paramaki.e.contains(akj.e)) {
      paramaki = akj.e;
    } else {
      paramaki = akj.d;
    }
    this.o = paramaki;
  }
  
  public final akn.a a(boolean paramBoolean)
  {
    List localList = this.n.c();
    akj localakj = this.o;
    Object localObject2 = new ake.a();
    int i2 = localList.size();
    int i1 = 0;
    Object localObject3 = null;
    Object localObject1;
    while (i1 < i2)
    {
      localObject1 = (alv)localList.get(i1);
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
            localObject4 = new ake.a();
            localObject1 = null;
          }
        }
      }
      else
      {
        amy localamy = ((alv)localObject1).g;
        String str = ((alv)localObject1).h.a();
        if (localamy.equals(alv.b))
        {
          localObject1 = alq.a("HTTP/1.1 ".concat(String.valueOf(str)));
          localObject4 = localObject2;
        }
        else
        {
          localObject1 = localObject3;
          localObject4 = localObject2;
          if (!k.contains(localamy))
          {
            akr.a.a((ake.a)localObject2, localamy.a(), str);
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
      localObject1 = new akn.a();
      ((akn.a)localObject1).b = localakj;
      ((akn.a)localObject1).c = localObject3.b;
      ((akn.a)localObject1).d = localObject3.c;
      localObject1 = ((akn.a)localObject1).a(((ake.a)localObject2).a());
      if ((paramBoolean) && (akr.a.a((akn.a)localObject1) == 100)) {
        return null;
      }
      return localObject1;
    }
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public final ako a(akn paramakn)
  {
    return new aln(paramakn.a("Content-Type"), alk.a(paramakn), ane.a(new a(this.n.g)));
  }
  
  public final ank a(akl paramakl, long paramLong)
  {
    return this.n.d();
  }
  
  public final void a()
  {
    this.m.p.b();
  }
  
  public final void a(akl paramakl)
  {
    if (this.n != null) {
      return;
    }
    Object localObject = paramakl.d;
    int i1 = 0;
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = paramakl.c;
    ArrayList localArrayList = new ArrayList(((ake)localObject).a.length / 2 + 4);
    localArrayList.add(new alv(alv.c, paramakl.b));
    localArrayList.add(new alv(alv.d, alo.a(paramakl.a)));
    String str = paramakl.a("Host");
    if (str != null) {
      localArrayList.add(new alv(alv.f, str));
    }
    localArrayList.add(new alv(alv.e, paramakl.a.a));
    int i2 = ((ake)localObject).a.length / 2;
    while (i1 < i2)
    {
      paramakl = amy.a(((ake)localObject).a(i1).toLowerCase(Locale.US));
      if (!j.contains(paramakl)) {
        localArrayList.add(new alv(paramakl, ((ake)localObject).b(i1)));
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
    extends ana
  {
    boolean a = false;
    long b = 0L;
    
    a(anl paramanl)
    {
      super();
    }
    
    private void b()
    {
      if (this.a) {
        return;
      }
      this.a = true;
      aly.this.a.a(false, aly.this);
    }
    
    public final long a(amv paramamv, long paramLong)
    {
      try
      {
        paramLong = this.d.a(paramamv, paramLong);
        if (paramLong > 0L) {
          this.b += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramamv)
      {
        b();
        throw paramamv;
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
 * Qualified Name:     com.tencent.token.aly
 * JD-Core Version:    0.7.0.1
 */