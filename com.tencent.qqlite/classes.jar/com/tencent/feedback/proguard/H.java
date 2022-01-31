package com.tencent.feedback.proguard;

import java.util.ArrayList;

public final class H
  extends j
{
  private static G A;
  private static ArrayList<E> B;
  private static ArrayList<K> C;
  private static ArrayList<F> x;
  private static J y;
  private static L z;
  public String a = "";
  public String b = "";
  public String c = "";
  public long d = 0L;
  public ArrayList<F> e = null;
  public String f = "";
  public String g = "";
  public String h = "";
  public J i = null;
  public L j = null;
  public G k = null;
  public ArrayList<E> l = null;
  public long m = 0L;
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public ArrayList<K> s = null;
  public String t = "";
  private String u = "";
  private String v = "";
  private String w = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.b(1, false);
    this.c = paramh.b(2, false);
    this.d = paramh.a(this.d, 3, true);
    Object localObject;
    if (x == null)
    {
      x = new ArrayList();
      localObject = new F();
      x.add(localObject);
    }
    this.e = ((ArrayList)paramh.a(x, 4, true));
    this.f = paramh.b(5, false);
    this.g = paramh.b(6, false);
    this.h = paramh.b(7, false);
    if (y == null) {
      y = new J();
    }
    this.i = ((J)paramh.a(y, 8, false));
    if (z == null) {
      z = new L();
    }
    this.j = ((L)paramh.a(z, 9, false));
    if (A == null) {
      A = new G();
    }
    this.k = ((G)paramh.a(A, 10, false));
    this.u = paramh.b(11, false);
    if (B == null)
    {
      B = new ArrayList();
      localObject = new E();
      B.add(localObject);
    }
    this.l = ((ArrayList)paramh.a(B, 12, false));
    this.m = paramh.a(this.m, 13, false);
    this.n = paramh.b(14, false);
    this.o = paramh.b(15, false);
    this.p = paramh.b(16, false);
    this.q = paramh.b(17, false);
    this.r = paramh.b(18, false);
    this.v = paramh.b(19, false);
    this.w = paramh.b(20, false);
    if (C == null)
    {
      C = new ArrayList();
      localObject = new K();
      C.add(localObject);
    }
    this.s = ((ArrayList)paramh.a(C, 21, false));
    this.t = paramh.b(22, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    if (this.b != null) {
      parami.a(this.b, 1);
    }
    if (this.c != null) {
      parami.a(this.c, 2);
    }
    parami.a(this.d, 3);
    parami.a(this.e, 4);
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
    if (this.j != null) {
      parami.a(this.j, 9);
    }
    if (this.k != null) {
      parami.a(this.k, 10);
    }
    if (this.u != null) {
      parami.a(this.u, 11);
    }
    if (this.l != null) {
      parami.a(this.l, 12);
    }
    parami.a(this.m, 13);
    if (this.n != null) {
      parami.a(this.n, 14);
    }
    if (this.o != null) {
      parami.a(this.o, 15);
    }
    if (this.p != null) {
      parami.a(this.p, 16);
    }
    if (this.q != null) {
      parami.a(this.q, 17);
    }
    if (this.r != null) {
      parami.a(this.r, 18);
    }
    if (this.v != null) {
      parami.a(this.v, 19);
    }
    if (this.w != null) {
      parami.a(this.w, 20);
    }
    if (this.s != null) {
      parami.a(this.s, 21);
    }
    if (this.t != null) {
      parami.a(this.t, 22);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.H
 * JD-Core Version:    0.7.0.1
 */