package com.tencent.token;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class akc
  implements ajm
{
  private static final alc b = alc.a("connection");
  private static final alc c = alc.a("host");
  private static final alc d = alc.a("keep-alive");
  private static final alc e = alc.a("proxy-connection");
  private static final alc f = alc.a("transfer-encoding");
  private static final alc g = alc.a("te");
  private static final alc h = alc.a("encoding");
  private static final alc i = alc.a("upgrade");
  private static final List<alc> j = aix.a(new alc[] { b, c, d, e, g, f, h, i, ajz.c, ajz.d, ajz.e, ajz.f });
  private static final List<alc> k = aix.a(new alc[] { b, c, d, e, g, f, h, i });
  final ajj a;
  private final aik.a l;
  private final akd m;
  private akf n;
  private final ain o;
  
  public akc(aim paramaim, aik.a parama, ajj paramajj, akd paramakd)
  {
    this.l = parama;
    this.a = paramajj;
    this.m = paramakd;
    if (paramaim.e.contains(ain.e)) {
      paramaim = ain.e;
    } else {
      paramaim = ain.d;
    }
    this.o = paramaim;
  }
  
  public final air.a a(boolean paramBoolean)
  {
    List localList = this.n.c();
    ain localain = this.o;
    Object localObject2 = new aii.a();
    int i2 = localList.size();
    int i1 = 0;
    Object localObject3 = null;
    Object localObject1;
    while (i1 < i2)
    {
      localObject1 = (ajz)localList.get(i1);
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
            localObject4 = new aii.a();
            localObject1 = null;
          }
        }
      }
      else
      {
        alc localalc = ((ajz)localObject1).g;
        String str = ((ajz)localObject1).h.a();
        if (localalc.equals(ajz.b))
        {
          localObject1 = aju.a("HTTP/1.1 ".concat(String.valueOf(str)));
          localObject4 = localObject2;
        }
        else
        {
          localObject1 = localObject3;
          localObject4 = localObject2;
          if (!k.contains(localalc))
          {
            aiv.a.a((aii.a)localObject2, localalc.a(), str);
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
      localObject1 = new air.a();
      ((air.a)localObject1).b = localain;
      ((air.a)localObject1).c = localObject3.b;
      ((air.a)localObject1).d = localObject3.c;
      localObject1 = ((air.a)localObject1).a(((aii.a)localObject2).a());
      if ((paramBoolean) && (aiv.a.a((air.a)localObject1) == 100)) {
        return null;
      }
      return localObject1;
    }
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public final ais a(air paramair)
  {
    return new ajr(paramair.a("Content-Type"), ajo.a(paramair), ali.a(new a(this.n.g)));
  }
  
  public final alo a(aip paramaip, long paramLong)
  {
    return this.n.d();
  }
  
  public final void a()
  {
    this.m.p.b();
  }
  
  public final void a(aip paramaip)
  {
    if (this.n != null) {
      return;
    }
    Object localObject = paramaip.d;
    int i1 = 0;
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = paramaip.c;
    ArrayList localArrayList = new ArrayList(((aii)localObject).a.length / 2 + 4);
    localArrayList.add(new ajz(ajz.c, paramaip.b));
    localArrayList.add(new ajz(ajz.d, ajs.a(paramaip.a)));
    String str = paramaip.a("Host");
    if (str != null) {
      localArrayList.add(new ajz(ajz.f, str));
    }
    localArrayList.add(new ajz(ajz.e, paramaip.a.a));
    int i2 = ((aii)localObject).a.length / 2;
    while (i1 < i2)
    {
      paramaip = alc.a(((aii)localObject).a(i1).toLowerCase(Locale.US));
      if (!j.contains(paramaip)) {
        localArrayList.add(new ajz(paramaip, ((aii)localObject).b(i1)));
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
    extends ale
  {
    boolean a = false;
    long b = 0L;
    
    a(alp paramalp)
    {
      super();
    }
    
    private void b()
    {
      if (this.a) {
        return;
      }
      this.a = true;
      akc.this.a.a(false, akc.this);
    }
    
    public final long a(akz paramakz, long paramLong)
    {
      try
      {
        paramLong = this.d.a(paramakz, paramLong);
        if (paramLong > 0L) {
          this.b += paramLong;
        }
        return paramLong;
      }
      catch (IOException paramakz)
      {
        b();
        throw paramakz;
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
 * Qualified Name:     com.tencent.token.akc
 * JD-Core Version:    0.7.0.1
 */