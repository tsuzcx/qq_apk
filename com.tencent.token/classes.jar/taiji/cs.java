package taiji;

import android.graphics.Rect;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import uilib.doraemon.a;

public class cs
{
  private static final String a = "cs";
  private final List<an> b;
  private final a c;
  private final String d;
  private final long e;
  private final b f;
  private final long g;
  private final String h;
  private final List<cc> i;
  private final aj j;
  private final int k;
  private final int l;
  private final int m;
  private final float n;
  private final float o;
  private final int p;
  private final int q;
  private final ah r;
  private final ai s;
  private final ac t;
  private final List<o<Float>> u;
  private final c v;
  
  private cs(List<an> paramList, a parama, String paramString1, long paramLong1, b paramb, long paramLong2, String paramString2, List<cc> paramList1, aj paramaj, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4, int paramInt5, ah paramah, ai paramai, List<o<Float>> paramList2, c paramc, ac paramac)
  {
    this.b = paramList;
    this.c = parama;
    this.d = paramString1;
    this.e = paramLong1;
    this.f = paramb;
    this.g = paramLong2;
    this.h = paramString2;
    this.i = paramList1;
    this.j = paramaj;
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramInt3;
    this.n = paramFloat1;
    this.o = paramFloat2;
    this.p = paramInt4;
    this.q = paramInt5;
    this.r = paramah;
    this.s = paramai;
    this.u = paramList2;
    this.v = paramc;
    this.t = paramac;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(f());
    localStringBuilder.append("\n");
    Object localObject1 = this.c.a(m());
    Object localObject2;
    if (localObject1 != null)
    {
      for (localObject2 = "\t\tParents: ";; localObject2 = "->")
      {
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(((cs)localObject1).f());
        localObject1 = this.c.a(((cs)localObject1).m());
        if (localObject1 == null) {
          break;
        }
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
    }
    if (!j().isEmpty())
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tMasks: ");
      localStringBuilder.append(j().size());
      localStringBuilder.append("\n");
    }
    if ((r() != 0) && (q() != 0))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tBackground: ");
      localStringBuilder.append(String.format(Locale.US, "%dx%d %X\n", new Object[] { Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p()) }));
    }
    if (!this.b.isEmpty())
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tShapes:\n");
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localStringBuilder.append(paramString);
        localStringBuilder.append("\t\t");
        localStringBuilder.append(localObject2);
        localStringBuilder.append("\n");
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
  
  List<o<Float>> d()
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
  
  List<cc> j()
  {
    return this.i;
  }
  
  public b k()
  {
    return this.f;
  }
  
  c l()
  {
    return this.v;
  }
  
  long m()
  {
    return this.g;
  }
  
  List<an> n()
  {
    return this.b;
  }
  
  aj o()
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
  
  ah s()
  {
    return this.r;
  }
  
  ai t()
  {
    return this.s;
  }
  
  public String toString()
  {
    return a("");
  }
  
  public ac u()
  {
    return this.t;
  }
  
  public static class a
  {
    public static cs a(a parama)
    {
      Rect localRect = parama.b();
      return new cs(Collections.emptyList(), parama, "root", -1L, cs.b.a, -1L, null, Collections.emptyList(), aj.a.a(), 0, 0, 0, 0.0F, 0.0F, localRect.width(), localRect.height(), null, null, Collections.emptyList(), cs.c.a, null, null);
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  static enum c
  {
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.cs
 * JD-Core Version:    0.7.0.1
 */