package com.tencent.feedback.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class L
  extends j
  implements Cloneable
{
  private static Map<String, String> A;
  private static Map<String, String> t;
  private static J u;
  private static I v;
  private static ArrayList<I> w;
  private static ArrayList<I> x;
  private static ArrayList<K> y;
  private static Map<String, String> z;
  public String a = "";
  public long b = 0L;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public Map<String, String> h = null;
  public String i = "";
  public int j = 0;
  public String k = "";
  public String l = "";
  public ArrayList<I> m = null;
  public ArrayList<I> n = null;
  public ArrayList<K> o = null;
  public Map<String, String> p = null;
  private J q = null;
  private I r = null;
  private Map<String, String> s = null;
  
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
    Object localObject = this.d;
    if (localObject != null) {
      parami.a((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      parami.a((String)localObject, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      parami.a((String)localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      parami.a((String)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      parami.a((Map)localObject, 7);
    }
    localObject = this.i;
    if (localObject != null) {
      parami.a((String)localObject, 8);
    }
    localObject = this.q;
    if (localObject != null) {
      parami.a((j)localObject, 9);
    }
    parami.a(this.j, 10);
    localObject = this.k;
    if (localObject != null) {
      parami.a((String)localObject, 11);
    }
    localObject = this.l;
    if (localObject != null) {
      parami.a((String)localObject, 12);
    }
    localObject = this.r;
    if (localObject != null) {
      parami.a((j)localObject, 13);
    }
    localObject = this.m;
    if (localObject != null) {
      parami.a((Collection)localObject, 14);
    }
    localObject = this.n;
    if (localObject != null) {
      parami.a((Collection)localObject, 15);
    }
    localObject = this.o;
    if (localObject != null) {
      parami.a((Collection)localObject, 16);
    }
    localObject = this.p;
    if (localObject != null) {
      parami.a((Map)localObject, 17);
    }
    localObject = this.s;
    if (localObject != null) {
      parami.a((Map)localObject, 18);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.L
 * JD-Core Version:    0.7.0.1
 */