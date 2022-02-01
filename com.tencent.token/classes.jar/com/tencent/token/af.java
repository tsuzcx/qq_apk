package com.tencent.token;

import com.tencent.halley.common.h;
import com.tencent.halley.downloader.c.d.a;
import com.tencent.halley.downloader.c.d.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class af
{
  public boolean a;
  public long b;
  public long c;
  public int d = 0;
  private List e = new ArrayList();
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((a)localIterator.next());
      localStringBuilder.append(";");
    }
    return localStringBuilder.toString();
  }
  
  public final void a(a parama)
  {
    if (this.e.size() < 20) {
      this.e.add(parama);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (this.a) {}
    for (int i = 0;; i = 1)
    {
      localStringBuilder1.append(i).append(",");
      localStringBuilder1.append(this.b).append(",");
      localStringBuilder1.append(this.c).append(",");
      localStringBuilder1.append(this.d).append(";");
      return localStringBuilder1.toString();
    }
  }
  
  public static final class a
  {
    public boolean a;
    public String b = "";
    public long c;
    public long d;
    public int e;
    public String f = "";
    public String g = "";
    public long h = -1L;
    public String i = "";
    public String j = "";
    public String k = "";
    public String l = "";
    public String m = "";
    public int n = -1;
    public int o = -1;
    public String p = "";
    public long q;
    public String r = "";
    public String s = "";
    private int t;
    private int u;
    private int v;
    
    public a(int paramInt, a parama)
    {
      this.t = paramInt;
      this.u = parama.c;
      this.v = parama.b.ordinal();
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(this.t);
      localStringBuilder1.append(",").append(this.u);
      localStringBuilder1.append(",").append(this.v);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(",");
      if (this.a) {}
      for (int i1 = 1;; i1 = 0)
      {
        localStringBuilder2.append(i1);
        localStringBuilder1.append(",").append(h.b(this.b));
        localStringBuilder1.append(",").append(this.c);
        localStringBuilder1.append(",").append(this.d);
        localStringBuilder1.append(",").append(this.e);
        localStringBuilder1.append(",").append(h.b(this.f));
        localStringBuilder1.append(",").append(this.g);
        localStringBuilder1.append(",").append(this.h);
        localStringBuilder1.append(",").append(h.b(this.i));
        localStringBuilder1.append(",").append(this.j);
        localStringBuilder1.append(",").append(h.b("[" + this.k + "]"));
        localStringBuilder1.append(",").append(h.b(this.l));
        localStringBuilder1.append(",").append(h.b("[" + this.m + "]"));
        localStringBuilder1.append(",").append(this.n);
        localStringBuilder1.append(",").append(this.o);
        localStringBuilder1.append(",").append(h.b(this.p));
        localStringBuilder1.append(",").append(this.q);
        localStringBuilder1.append(",").append(this.r);
        localStringBuilder1.append(",").append(this.s);
        return localStringBuilder1.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.af
 * JD-Core Version:    0.7.0.1
 */