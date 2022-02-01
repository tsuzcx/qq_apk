package com.tencent.token;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class akb
  implements ajl
{
  private static final alb b = alb.a("connection");
  private static final alb c = alb.a("host");
  private static final alb d = alb.a("keep-alive");
  private static final alb e = alb.a("proxy-connection");
  private static final alb f = alb.a("transfer-encoding");
  private static final alb g = alb.a("te");
  private static final alb h = alb.a("encoding");
  private static final alb i = alb.a("upgrade");
  private static final List<alb> j = aiw.a(new alb[] { b, c, d, e, g, f, h, i, ajy.c, ajy.d, ajy.e, ajy.f });
  private static final List<alb> k = aiw.a(new alb[] { b, c, d, e, g, f, h, i });
  final aji a;
  private final aij.a l;
  private final akc m;
  private ake n;
  private final aim o;
  
  public akb(ail paramail, aij.a parama, aji paramaji, akc paramakc)
  {
    this.l = parama;
    this.a = paramaji;
    this.m = paramakc;
    if (paramail.e.contains(aim.e)) {
      paramail = aim.e;
    } else {
      paramail = aim.d;
    }
    this.o = paramail;
  }
  
  public final aiq.a a(boolean paramBoolean)
  {
    List localList = this.n.c();
    aim localaim = this.o;
    Object localObject2 = new aih.a();
    int i2 = localList.size();
    int i1 = 0;
    Object localObject3 = null;
    Object localObject1;
    while (i1 < i2)
    {
      localObject1 = (ajy)localList.get(i1);
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
            localObject4 = new aih.a();
            localObject1 = null;
          }
        }
      }
      else
      {
        alb localalb = ((ajy)localObject1).g;
        String str = ((ajy)localObject1).h.a();
        if (localalb.equals(ajy.b))
        {
          localObject1 = ajt.a("HTTP/1.1 ".concat(String.valueOf(str)));
          localObject4 = localObject2;
        }
        else
        {
          localObject1 = localObject3;
          localObject4 = localObject2;
          if (!k.contains(localalb))
          {
            aiu.a.a((aih.a)localObject2, localalb.a(), str);
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
      localObject1 = new aiq.a();
      ((aiq.a)localObject1).b = localaim;
      ((aiq.a)localObject1).c = localObject3.b;
      ((aiq.a)localObject1).d = localObject3.c;
      localObject1 = ((aiq.a)localObject1).a(((aih.a)localObject2).a());
      if ((paramBoolean) && (aiu.a.a((aiq.a)localObject1) == 100)) {
        return null;
      }
      return localObject1;
    }
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public final air a(aiq paramaiq)
  {
    return new ajq(paramaiq.a("Content-Type"), ajn.a(paramaiq), alh.a(new a(this.n.g)));
  }
  
  public final aln a(aio paramaio, long paramLong)
  {
    return this.n.d();
  }
  
  public final void a()
  {
    this.m.p.b();
  }
  
  public final void a(aio paramaio)
  {
    if (this.n != null) {
      return;
    }
    Object localObject = paramaio.d;
    int i1 = 0;
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = paramaio.c;
    ArrayList localArrayList = new ArrayList(((aih)localObject).a.length / 2 + 4);
    localArrayList.add(new ajy(ajy.c, paramaio.b));
    localArrayList.add(new ajy(ajy.d, ajr.a(paramaio.a)));
    String str = paramaio.a("Host");
    if (str != null) {
      localArrayList.add(new ajy(ajy.f, str));
    }
    localArrayList.add(new ajy(ajy.e, paramaio.a.a));
    int i2 = ((aih)localObject).a.length / 2;
    while (i1 < i2)
    {
      paramaio = alb.a(((aih)localObject).a(i1).toLowerCase(Locale.US));
      if (!j.contains(paramaio)) {
        localArrayList.add(new ajy(paramaio, ((aih)localObject).b(i1)));
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
    extends ald
  {
    boolean a = false;
    long b = 0L;
    
    a(alo paramalo)
    {
      super();
    }
    
    private void b()
    {
      if (this.a) {
        return;
      }
      this.a = true;
      akb.this.a.a(false, akb.this);
    }
    
    public final long a(aky paramaky, long paramLong)
    {
      try
      {
        paramLong = this.d.a(paramaky, paramLong);
        if (paramLong > 0L) {
          this.b += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramaky)
      {
        b();
        throw paramaky;
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
 * Qualified Name:     com.tencent.token.akb
 * JD-Core Version:    0.7.0.1
 */