package taiji;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import uilib.doraemon.a;

public class cs
{
  private static final String a = cs.class.getSimpleName();
  private final List b;
  private final a c;
  private final String d;
  private final long e;
  private final cs.b f;
  private final long g;
  private final String h;
  private final List i;
  private final as j;
  private final int k;
  private final int l;
  private final int m;
  private final float n;
  private final float o;
  private final int p;
  private final int q;
  private final aq r;
  private final ar s;
  private final af t;
  private final List u;
  private final cs.c v;
  
  private cs(List paramList1, a parama, String paramString1, long paramLong1, cs.b paramb, long paramLong2, String paramString2, List paramList2, as paramas, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, int paramInt5, aq paramaq, ar paramar, List paramList3, cs.c paramc, af paramaf)
  {
    this.b = paramList1;
    this.c = parama;
    this.d = paramString1;
    this.e = paramLong1;
    this.f = paramb;
    this.g = paramLong2;
    this.h = paramString2;
    this.i = paramList2;
    this.j = paramas;
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramInt3;
    this.n = paramFloat1;
    this.o = paramFloat2;
    this.p = paramInt4;
    this.q = paramInt5;
    this.r = paramaq;
    this.s = paramar;
    this.u = paramList3;
    this.v = paramc;
    this.t = paramaf;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append(f()).append("\n");
    Object localObject1 = this.c.a(m());
    if (localObject1 != null)
    {
      localStringBuilder.append("\t\tParents: ").append(((cs)localObject1).f());
      for (localObject1 = this.c.a(((cs)localObject1).m()); localObject1 != null; localObject1 = this.c.a(((cs)localObject1).m())) {
        localStringBuilder.append("->").append(((cs)localObject1).f());
      }
      localStringBuilder.append(paramString).append("\n");
    }
    if (!j().isEmpty()) {
      localStringBuilder.append(paramString).append("\tMasks: ").append(j().size()).append("\n");
    }
    if ((r() != 0) && (q() != 0)) {
      localStringBuilder.append(paramString).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", new Object[] { Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p()) }));
    }
    if (!this.b.isEmpty())
    {
      localStringBuilder.append(paramString).append("\tShapes:\n");
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        localStringBuilder.append(paramString).append("\t\t").append(localObject2).append("\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  a a()
  {
    return this.c;
  }
  
  float b()
  {
    return this.n;
  }
  
  float c()
  {
    return this.o;
  }
  
  List d()
  {
    return this.u;
  }
  
  public long e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.d;
  }
  
  String g()
  {
    return this.h;
  }
  
  int h()
  {
    return this.p;
  }
  
  int i()
  {
    return this.q;
  }
  
  List j()
  {
    return this.i;
  }
  
  public cs.b k()
  {
    return this.f;
  }
  
  cs.c l()
  {
    return this.v;
  }
  
  long m()
  {
    return this.g;
  }
  
  List n()
  {
    return this.b;
  }
  
  as o()
  {
    return this.j;
  }
  
  int p()
  {
    return this.m;
  }
  
  int q()
  {
    return this.l;
  }
  
  int r()
  {
    return this.k;
  }
  
  aq s()
  {
    return this.r;
  }
  
  ar t()
  {
    return this.s;
  }
  
  public String toString()
  {
    return a("");
  }
  
  public af u()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.cs
 * JD-Core Version:    0.7.0.1
 */