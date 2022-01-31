package com.tencent.feedback.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class L
  extends j
  implements Cloneable
{
  private static Map A;
  private static Map t;
  private static J u;
  private static I v;
  private static ArrayList w;
  private static ArrayList x;
  private static ArrayList y;
  private static Map z;
  public String a = "";
  public long b = 0L;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public Map h = null;
  public String i = "";
  public int j = 0;
  public String k = "";
  public String l = "";
  public ArrayList m = null;
  public ArrayList n = null;
  public ArrayList o = null;
  public Map p = null;
  private J q = null;
  private I r = null;
  private Map s = null;
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.a(this.b, 1, true);
    this.c = paramh.b(2, true);
    this.d = paramh.b(3, false);
    this.e = paramh.b(4, false);
    this.f = paramh.b(5, false);
    this.g = paramh.b(6, false);
    if (t == null)
    {
      t = new HashMap();
      t.put("", "");
    }
    this.h = ((Map)paramh.a(t, 7, false));
    this.i = paramh.b(8, false);
    if (u == null) {
      u = new J();
    }
    this.q = ((J)paramh.a(u, 9, false));
    this.j = paramh.a(this.j, 10, false);
    this.k = paramh.b(11, false);
    this.l = paramh.b(12, false);
    if (v == null) {
      v = new I();
    }
    this.r = ((I)paramh.a(v, 13, false));
    Object localObject;
    if (w == null)
    {
      w = new ArrayList();
      localObject = new I();
      w.add(localObject);
    }
    this.m = ((ArrayList)paramh.a(w, 14, false));
    if (x == null)
    {
      x = new ArrayList();
      localObject = new I();
      x.add(localObject);
    }
    this.n = ((ArrayList)paramh.a(x, 15, false));
    if (y == null)
    {
      y = new ArrayList();
      localObject = new K();
      y.add(localObject);
    }
    this.o = ((ArrayList)paramh.a(y, 16, false));
    if (z == null)
    {
      z = new HashMap();
      z.put("", "");
    }
    this.p = ((Map)paramh.a(z, 17, false));
    if (A == null)
    {
      A = new HashMap();
      A.put("", "");
    }
    this.s = ((Map)paramh.a(A, 18, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
    if (this.d != null) {
      parami.a(this.d, 3);
    }
    if (this.e != null) {
      parami.a(this.e, 4);
    }
    if (this.f != null) {
      parami.a(this.f, 5);
    }
    if (this.g != null) {
      parami.a(this.g, 6);
    }
    if (this.h != null) {
      parami.a(this.h, 7);
    }
    if (this.i != null) {
      parami.a(this.i, 8);
    }
    if (this.q != null) {
      parami.a(this.q, 9);
    }
    parami.a(this.j, 10);
    if (this.k != null) {
      parami.a(this.k, 11);
    }
    if (this.l != null) {
      parami.a(this.l, 12);
    }
    if (this.r != null) {
      parami.a(this.r, 13);
    }
    if (this.m != null) {
      parami.a(this.m, 14);
    }
    if (this.n != null) {
      parami.a(this.n, 15);
    }
    if (this.o != null) {
      parami.a(this.o, 16);
    }
    if (this.p != null) {
      parami.a(this.p, 17);
    }
    if (this.s != null) {
      parami.a(this.s, 18);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.L
 * JD-Core Version:    0.7.0.1
 */