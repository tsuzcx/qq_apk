package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;
import java.util.ArrayList;
import java.util.Collection;

public final class Dew
  extends break
{
  public static ArrayList<Guava> Ab;
  public static Filbert Bb;
  public static Foxnut Cb;
  public static Date Db;
  public static ArrayList<Flat> Eb;
  public static ArrayList<Durian> Fb;
  public static Mandarin Gb;
  public static Longan Hb;
  public static byte[] Ib;
  public String H = "";
  public String I = "";
  public long Jb = 0L;
  public String Kb = "";
  public ArrayList<Guava> Lb = null;
  public int Mb = 0;
  public int Nb = 0;
  public int Ob = 0;
  public String Pb = "";
  public String Qb = "";
  public String Rb = "";
  public String S = "";
  public String Sb = "";
  public int Tb = 0;
  public int Ub = 0;
  public String Vb = "";
  public int W = 0;
  public String Wb = "";
  public String Xb = "";
  public int Yb = 0;
  public Filbert Zb = null;
  public Foxnut _b = null;
  public Date ac = null;
  public int bc = 0;
  public ArrayList<Flat> cc = null;
  public ArrayList<Durian> dc = null;
  public Mandarin ec = null;
  public Longan fc = null;
  public byte[] gc = null;
  
  public final void a(afk paramafk)
  {
    this.Jb = paramafk.a(this.Jb, 0, true);
    this.Kb = paramafk.a(1, true);
    Object localObject;
    if (Ab == null)
    {
      Ab = new ArrayList();
      localObject = new Guava();
      Ab.add(localObject);
    }
    this.Lb = ((ArrayList)paramafk.a(Ab, 2, true));
    this.Mb = paramafk.a(this.Mb, 3, true);
    this.S = paramafk.a(4, true);
    this.Nb = paramafk.a(this.Nb, 5, true);
    this.Ob = paramafk.a(this.Ob, 6, true);
    this.Pb = paramafk.a(7, true);
    this.H = paramafk.a(8, false);
    this.I = paramafk.a(9, false);
    this.Qb = paramafk.a(10, false);
    this.Rb = paramafk.a(11, false);
    this.Sb = paramafk.a(12, false);
    this.Tb = paramafk.a(this.Tb, 13, false);
    this.Ub = paramafk.a(this.Ub, 14, false);
    this.Vb = paramafk.a(15, false);
    this.W = paramafk.a(this.W, 16, false);
    this.Wb = paramafk.a(17, false);
    this.Xb = paramafk.a(18, false);
    this.Yb = paramafk.a(this.Yb, 19, false);
    if (Bb == null) {
      Bb = new Filbert();
    }
    this.Zb = ((Filbert)paramafk.a(Bb, 20, false));
    if (Cb == null) {
      Cb = new Foxnut();
    }
    this._b = ((Foxnut)paramafk.a(Cb, 21, false));
    if (Db == null) {
      Db = new Date();
    }
    this.ac = ((Date)paramafk.a(Db, 22, false));
    this.bc = paramafk.a(this.bc, 23, false);
    if (Eb == null)
    {
      Eb = new ArrayList();
      localObject = new Flat();
      Eb.add(localObject);
    }
    this.cc = ((ArrayList)paramafk.a(Eb, 24, false));
    if (Fb == null)
    {
      Fb = new ArrayList();
      localObject = new Durian();
      Fb.add(localObject);
    }
    this.dc = ((ArrayList)paramafk.a(Fb, 25, false));
    if (Gb == null) {
      Gb = new Mandarin();
    }
    this.ec = ((Mandarin)paramafk.a(Gb, 26, false));
    if (Hb == null) {
      Hb = new Longan();
    }
    this.fc = ((Longan)paramafk.a(Hb, 27, false));
    if (Ib == null)
    {
      localObject = new byte[1];
      Ib = (byte[])localObject;
      localObject[0] = 0;
    }
    this.gc = paramafk.b(28, false);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.Jb, 0);
    paramafn.a(this.Kb, 1);
    paramafn.a(this.Lb, 2);
    paramafn.a(this.Mb, 3);
    paramafn.a(this.S, 4);
    paramafn.a(this.Nb, 5);
    paramafn.a(this.Ob, 6);
    paramafn.a(this.Pb, 7);
    Object localObject = this.H;
    if (localObject != null) {
      paramafn.a((String)localObject, 8);
    }
    localObject = this.I;
    if (localObject != null) {
      paramafn.a((String)localObject, 9);
    }
    localObject = this.Qb;
    if (localObject != null) {
      paramafn.a((String)localObject, 10);
    }
    localObject = this.Rb;
    if (localObject != null) {
      paramafn.a((String)localObject, 11);
    }
    localObject = this.Sb;
    if (localObject != null) {
      paramafn.a((String)localObject, 12);
    }
    int i = this.Tb;
    if (i != 0) {
      paramafn.a(i, 13);
    }
    i = this.Ub;
    if (i != 0) {
      paramafn.a(i, 14);
    }
    localObject = this.Vb;
    if (localObject != null) {
      paramafn.a((String)localObject, 15);
    }
    paramafn.a(this.W, 16);
    localObject = this.Wb;
    if (localObject != null) {
      paramafn.a((String)localObject, 17);
    }
    localObject = this.Xb;
    if (localObject != null) {
      paramafn.a((String)localObject, 18);
    }
    i = this.Yb;
    if (i != 0) {
      paramafn.a(i, 19);
    }
    localObject = this.Zb;
    if (localObject != null) {
      paramafn.a((break)localObject, 20);
    }
    localObject = this._b;
    if (localObject != null) {
      paramafn.a((break)localObject, 21);
    }
    localObject = this.ac;
    if (localObject != null) {
      paramafn.a((break)localObject, 22);
    }
    i = this.bc;
    if (i != 0) {
      paramafn.a(i, 23);
    }
    localObject = this.cc;
    if (localObject != null) {
      paramafn.a((Collection)localObject, 24);
    }
    localObject = this.dc;
    if (localObject != null) {
      paramafn.a((Collection)localObject, 25);
    }
    localObject = this.ec;
    if (localObject != null) {
      paramafn.a((break)localObject, 26);
    }
    localObject = this.fc;
    if (localObject != null) {
      paramafn.a((break)localObject, 27);
    }
    localObject = this.gc;
    if (localObject != null) {
      paramafn.a((byte[])localObject, 28);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Dew
 * JD-Core Version:    0.7.0.1
 */