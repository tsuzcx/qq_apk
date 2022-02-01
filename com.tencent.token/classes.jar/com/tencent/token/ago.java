package com.tencent.token;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ago
  extends afu
{
  public ago(a parama)
  {
    this.d = parama.a;
    this.f = parama.b;
    this.t = parama.c;
    this.u = parama.d;
    this.j = parama.f;
    this.i = parama.e;
    this.k = parama.g;
    this.l = parama.h;
    this.m = parama.k;
    this.e = parama.i;
    this.g = parama.l;
    this.n = parama.m;
    this.h = parama.n;
    this.q = parama.o;
    this.o = parama.q;
    this.p = parama.r;
    this.s = parama.s;
    this.b = parama.t;
    this.r = parama.j;
    this.c = parama.u;
  }
  
  public static a a(Context paramContext, aen paramaen)
  {
    return new a(paramContext, paramaen);
  }
  
  public final int a()
  {
    afw.e = this;
    if (afw.d.get()) {
      return 0;
    }
    afw.b();
    synchronized (afw.c)
    {
      if (this.e > 0)
      {
        new StringBuilder("c : ").append(this.e);
        agb.a = this.e;
      }
      if (afw.b.get())
      {
        afw.a(this);
        return 0;
      }
      if (afw.d.get()) {
        return 0;
      }
      afw.d.set(true);
      System.currentTimeMillis();
      int i = afw.b(this);
      if (i != 0)
      {
        afw.b.set(false);
        return i;
      }
      i = afw.c(this);
      if (i != 0)
      {
        afw.b.set(false);
        return i;
      }
      if (agb.a == 0)
      {
        afw.b.set(false);
        return -10018;
      }
      afw.a(this);
      afw.b.set(true);
      afw.d.set(false);
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
    public boolean j = true;
    public Map<Integer, String> k = new HashMap();
    public boolean l = true;
    public String m = "";
    public String n = "";
    public boolean o = true;
    public String p = "turingfd.cert";
    public boolean q = true;
    public boolean r = false;
    public boolean s = true;
    public aen t;
    public aem u;
    
    public a(Context paramContext, aen paramaen)
    {
      this.a = paramContext.getApplicationContext();
      this.t = paramaen;
    }
    
    public final ago a()
    {
      return new ago(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ago
 * JD-Core Version:    0.7.0.1
 */