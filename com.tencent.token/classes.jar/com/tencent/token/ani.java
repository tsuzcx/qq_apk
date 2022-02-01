package com.tencent.token;

import android.graphics.Rect;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ani
{
  private static final String v = "ani";
  final List<amz> a;
  final ast b;
  final String c;
  final long d;
  final b e;
  final long f;
  final String g;
  final List<anb> h;
  final amv i;
  final int j;
  final int k;
  final int l;
  final float m;
  final float n;
  final int o;
  final int p;
  final amt q;
  final amu r;
  final amo s;
  final List<alz<Float>> t;
  final int u;
  
  private ani(List<amz> paramList, ast paramast, String paramString, b paramb, List<anb> paramList1, amv paramamv, int paramInt1, int paramInt2, List<alz<Float>> paramList2, int paramInt3)
  {
    this.a = paramList;
    this.b = paramast;
    this.c = paramString;
    this.d = -1L;
    this.e = paramb;
    this.f = -1L;
    this.g = null;
    this.h = paramList1;
    this.i = paramamv;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.m = 0.0F;
    this.n = 0.0F;
    this.o = paramInt1;
    this.p = paramInt2;
    this.q = null;
    this.r = null;
    this.t = paramList2;
    this.u = paramInt3;
    this.s = null;
  }
  
  public final String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    Object localObject1 = this.b.a(this.f);
    if (localObject1 != null)
    {
      localStringBuilder.append("\t\tParents: ");
      localStringBuilder.append(((ani)localObject1).c);
      for (localObject1 = this.b.a(((ani)localObject1).f); localObject1 != null; localObject1 = this.b.a(((ani)localObject1).f))
      {
        localStringBuilder.append("->");
        localStringBuilder.append(((ani)localObject1).c);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n");
    }
    if (!this.h.isEmpty())
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tMasks: ");
      localStringBuilder.append(this.h.size());
      localStringBuilder.append("\n");
    }
    if ((this.j != 0) && (this.k != 0))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tBackground: ");
      localStringBuilder.append(String.format(Locale.US, "%dx%d %X\n", new Object[] { Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l) }));
    }
    if (!this.a.isEmpty())
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("\tShapes:\n");
      localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        localStringBuilder.append(paramString);
        localStringBuilder.append("\t\t");
        localStringBuilder.append(localObject2);
        localStringBuilder.append("\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return a("");
  }
  
  public static final class a
  {
    public static ani a(ast paramast)
    {
      Rect localRect = paramast.g;
      return new ani(Collections.emptyList(), paramast, "root", ani.b.a, Collections.emptyList(), new amv(new amq(), new amq(), new amr((byte)0), amo.a.a(), new amp((byte)0), amo.a.a(), amo.a.a(), (byte)0), localRect.width(), localRect.height(), Collections.emptyList(), ani.c.a, (byte)0);
    }
  }
  
  public static enum b
  {
    private b() {}
  }
  
  static enum c
  {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    
    public static int[] a()
    {
      return (int[])e.clone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ani
 * JD-Core Version:    0.7.0.1
 */