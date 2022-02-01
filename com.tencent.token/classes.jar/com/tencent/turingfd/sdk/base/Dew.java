package com.tencent.turingfd.sdk.base;

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
  
  public void a(cy paramcy)
  {
    this.Jb = paramcy.a(this.Jb, 0, true);
    this.Kb = paramcy.a(1, true);
    Object localObject;
    if (Ab == null)
    {
      Ab = new ArrayList();
      localObject = new Guava();
      Ab.add(localObject);
    }
    this.Lb = ((ArrayList)paramcy.a(Ab, 2, true));
    this.Mb = paramcy.a(this.Mb, 3, true);
    this.S = paramcy.a(4, true);
    this.Nb = paramcy.a(this.Nb, 5, true);
    this.Ob = paramcy.a(this.Ob, 6, true);
    this.Pb = paramcy.a(7, true);
    this.H = paramcy.a(8, false);
    this.I = paramcy.a(9, false);
    this.Qb = paramcy.a(10, false);
    this.Rb = paramcy.a(11, false);
    this.Sb = paramcy.a(12, false);
    this.Tb = paramcy.a(this.Tb, 13, false);
    this.Ub = paramcy.a(this.Ub, 14, false);
    this.Vb = paramcy.a(15, false);
    this.W = paramcy.a(this.W, 16, false);
    this.Wb = paramcy.a(17, false);
    this.Xb = paramcy.a(18, false);
    this.Yb = paramcy.a(this.Yb, 19, false);
    if (Bb == null) {
      Bb = new Filbert();
    }
    this.Zb = ((Filbert)paramcy.a(Bb, 20, false));
    if (Cb == null) {
      Cb = new Foxnut();
    }
    this._b = ((Foxnut)paramcy.a(Cb, 21, false));
    if (Db == null) {
      Db = new Date();
    }
    this.ac = ((Date)paramcy.a(Db, 22, false));
    this.bc = paramcy.a(this.bc, 23, false);
    if (Eb == null)
    {
      Eb = new ArrayList();
      localObject = new Flat();
      Eb.add(localObject);
    }
    this.cc = ((ArrayList)paramcy.a(Eb, 24, false));
    if (Fb == null)
    {
      Fb = new ArrayList();
      localObject = new Durian();
      Fb.add(localObject);
    }
    this.dc = ((ArrayList)paramcy.a(Fb, 25, false));
    if (Gb == null) {
      Gb = new Mandarin();
    }
    this.ec = ((Mandarin)paramcy.a(Gb, 26, false));
    if (Hb == null) {
      Hb = new Longan();
    }
    this.fc = ((Longan)paramcy.a(Hb, 27, false));
    if (Ib == null)
    {
      Ib = new byte[1];
      Ib[0] = 0;
    }
    this.gc = paramcy.a(Ib, 28, false);
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.Jb, 0);
    paramdb.a(this.Kb, 1);
    paramdb.a(this.Lb, 2);
    paramdb.a(this.Mb, 3);
    paramdb.a(this.S, 4);
    paramdb.a(this.Nb, 5);
    paramdb.a(this.Ob, 6);
    paramdb.a(this.Pb, 7);
    Object localObject = this.H;
    if (localObject != null) {
      paramdb.a((String)localObject, 8);
    }
    localObject = this.I;
    if (localObject != null) {
      paramdb.a((String)localObject, 9);
    }
    localObject = this.Qb;
    if (localObject != null) {
      paramdb.a((String)localObject, 10);
    }
    localObject = this.Rb;
    if (localObject != null) {
      paramdb.a((String)localObject, 11);
    }
    localObject = this.Sb;
    if (localObject != null) {
      paramdb.a((String)localObject, 12);
    }
    int i = this.Tb;
    if (i != 0) {
      paramdb.a(i, 13);
    }
    i = this.Ub;
    if (i != 0) {
      paramdb.a(i, 14);
    }
    localObject = this.Vb;
    if (localObject != null) {
      paramdb.a((String)localObject, 15);
    }
    paramdb.a(this.W, 16);
    localObject = this.Wb;
    if (localObject != null) {
      paramdb.a((String)localObject, 17);
    }
    localObject = this.Xb;
    if (localObject != null) {
      paramdb.a((String)localObject, 18);
    }
    i = this.Yb;
    if (i != 0) {
      paramdb.a(i, 19);
    }
    localObject = this.Zb;
    if (localObject != null) {
      paramdb.a((break)localObject, 20);
    }
    localObject = this._b;
    if (localObject != null) {
      paramdb.a((break)localObject, 21);
    }
    localObject = this.ac;
    if (localObject != null) {
      paramdb.a((break)localObject, 22);
    }
    i = this.bc;
    if (i != 0) {
      paramdb.a(i, 23);
    }
    localObject = this.cc;
    if (localObject != null) {
      paramdb.a((Collection)localObject, 24);
    }
    localObject = this.dc;
    if (localObject != null) {
      paramdb.a((Collection)localObject, 25);
    }
    localObject = this.ec;
    if (localObject != null) {
      paramdb.a((break)localObject, 26);
    }
    localObject = this.fc;
    if (localObject != null) {
      paramdb.a((break)localObject, 27);
    }
    localObject = this.gc;
    if (localObject != null) {
      paramdb.a((byte[])localObject, 28);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Dew
 * JD-Core Version:    0.7.0.1
 */