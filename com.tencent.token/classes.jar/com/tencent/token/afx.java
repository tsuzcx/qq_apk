package com.tencent.token;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class afx
  extends agr
{
  public afx(a parama)
  {
    this.c = parama.a;
    this.e = parama.b;
    this.r = parama.c;
    this.s = parama.d;
    this.i = parama.f;
    this.h = parama.e;
    this.j = parama.g;
    this.k = parama.h;
    this.l = parama.j;
    this.d = parama.i;
    this.f = parama.k;
    this.m = parama.l;
    this.g = parama.m;
    this.p = parama.n;
    this.n = parama.p;
    this.o = parama.q;
    this.q = parama.r;
    this.b = parama.s;
    this.a = new b(parama.t);
  }
  
  public static a a(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public final int a()
  {
    if (ags.d.get()) {
      return 0;
    }
    ags.b();
    synchronized (ags.c)
    {
      if (this.d > 0)
      {
        new StringBuilder("c : ").append(this.d);
        agh.a = this.d;
      }
      if (ags.b.get())
      {
        ags.a(this);
        return 0;
      }
      if (ags.d.get()) {
        return 0;
      }
      ags.d.set(true);
      System.currentTimeMillis();
      int i = ags.c(this);
      if (i != 0)
      {
        ags.b.set(false);
        return i;
      }
      if (agh.a == 0)
      {
        ags.b.set(false);
        return -10018;
      }
      ags.b(this);
      ags.a(this);
      ags.b.set(true);
      ags.d.set(false);
      return 0;
    }
  }
  
  public static final class a
  {
    public Context a;
    public String b = "";
    public int c = 5000;
    public int d = 3;
    public String e = "";
    public String f = "";
    public int g = 0;
    public String h = "";
    public int i = 0;
    public Map<Integer, String> j = new HashMap();
    public boolean k = true;
    public String l = "";
    public String m = "";
    public boolean n = true;
    public String o = "turingfd.cert";
    public boolean p = true;
    public boolean q = false;
    public boolean r = true;
    public adp s;
    public adq t;
    
    public a(Context paramContext)
    {
      this.a = paramContext.getApplicationContext();
    }
    
    public final a a()
    {
      this.i = 105678;
      return this;
    }
    
    public final a a(int paramInt)
    {
      this.g = paramInt;
      return this;
    }
    
    public final a a(adp paramadp)
    {
      this.s = paramadp;
      return this;
    }
    
    public final a a(String paramString)
    {
      this.b = paramString;
      return this;
    }
    
    public final a b(String paramString)
    {
      this.h = paramString;
      return this;
    }
    
    public final afx b()
    {
      return new afx(this);
    }
    
    public final a c(String paramString)
    {
      this.f = paramString;
      return this;
    }
  }
  
  public final class b
    implements agk
  {
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afx
 * JD-Core Version:    0.7.0.1
 */