package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;
import java.util.Collection;

public final class Damson
  extends float
{
  public static ArrayList Db;
  public static Durian Eb;
  public static Filbert Fb;
  public static Cumquat Gb;
  public static ArrayList Hb;
  public static ArrayList Ib;
  public static Kiwifruit Jb;
  public static Herbaceous Kb;
  public static byte[] Lb;
  public String K = "";
  public long Mb = 0L;
  public String Nb = "";
  public ArrayList Ob = null;
  public int Pb = 0;
  public String Q = "";
  public int Qb = 0;
  public int Rb = 0;
  public String Sb = "";
  public String Tb = "";
  public String Ub = "";
  public String Vb = "";
  public int Wb = 0;
  public int Xb = 0;
  public String Yb = "";
  public String Zb = "";
  public String _b = "";
  public String aa = "";
  public int ac = 0;
  public Durian bc = null;
  public int ca = 0;
  public Filbert cc = null;
  public Cumquat dc = null;
  public int ec = 0;
  public ArrayList fc = null;
  public ArrayList gc = null;
  public Kiwifruit hc = null;
  public Herbaceous ic = null;
  public byte[] jc = null;
  
  public void a(dp paramdp)
  {
    this.Mb = paramdp.a(this.Mb, 0, true);
    this.Nb = paramdp.a(1, true);
    Object localObject;
    if (Db == null)
    {
      Db = new ArrayList();
      localObject = new Gooseberry();
      Db.add(localObject);
    }
    this.Ob = ((ArrayList)paramdp.a(Db, 2, true));
    this.Pb = paramdp.a(this.Pb, 3, true);
    this.aa = paramdp.a(4, true);
    this.Qb = paramdp.a(this.Qb, 5, true);
    this.Rb = paramdp.a(this.Rb, 6, true);
    this.Sb = paramdp.a(7, true);
    this.K = paramdp.a(8, false);
    this.Q = paramdp.a(9, false);
    this.Tb = paramdp.a(10, false);
    this.Ub = paramdp.a(11, false);
    this.Vb = paramdp.a(12, false);
    this.Wb = paramdp.a(this.Wb, 13, false);
    this.Xb = paramdp.a(this.Xb, 14, false);
    this.Yb = paramdp.a(15, false);
    this.ca = paramdp.a(this.ca, 16, false);
    this.Zb = paramdp.a(17, false);
    this._b = paramdp.a(18, false);
    this.ac = paramdp.a(this.ac, 19, false);
    if (Eb == null) {
      Eb = new Durian();
    }
    this.bc = ((Durian)paramdp.a(Eb, 20, false));
    if (Fb == null) {
      Fb = new Filbert();
    }
    this.cc = ((Filbert)paramdp.a(Fb, 21, false));
    if (Gb == null) {
      Gb = new Cumquat();
    }
    this.dc = ((Cumquat)paramdp.a(Gb, 22, false));
    this.ec = paramdp.a(this.ec, 23, false);
    if (Hb == null)
    {
      Hb = new ArrayList();
      localObject = new Fig();
      Hb.add(localObject);
    }
    this.fc = ((ArrayList)paramdp.a(Hb, 24, false));
    if (Ib == null)
    {
      Ib = new ArrayList();
      localObject = new Date();
      Ib.add(localObject);
    }
    this.gc = ((ArrayList)paramdp.a(Ib, 25, false));
    if (Jb == null) {
      Jb = new Kiwifruit();
    }
    this.hc = ((Kiwifruit)paramdp.a(Jb, 26, false));
    if (Kb == null) {
      Kb = new Herbaceous();
    }
    this.ic = ((Herbaceous)paramdp.a(Kb, 27, false));
    if (Lb == null)
    {
      Lb = new byte[1];
      Lb[0] = 0;
    }
    this.jc = paramdp.a(Lb, 28, false);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.Mb, 0);
    paramdv.a(this.Nb, 1);
    paramdv.a(this.Ob, 2);
    paramdv.a(this.Pb, 3);
    paramdv.a(this.aa, 4);
    paramdv.a(this.Qb, 5);
    paramdv.a(this.Rb, 6);
    paramdv.a(this.Sb, 7);
    Object localObject = this.K;
    if (localObject != null) {
      paramdv.a((String)localObject, 8);
    }
    localObject = this.Q;
    if (localObject != null) {
      paramdv.a((String)localObject, 9);
    }
    localObject = this.Tb;
    if (localObject != null) {
      paramdv.a((String)localObject, 10);
    }
    localObject = this.Ub;
    if (localObject != null) {
      paramdv.a((String)localObject, 11);
    }
    localObject = this.Vb;
    if (localObject != null) {
      paramdv.a((String)localObject, 12);
    }
    int i = this.Wb;
    if (i != 0) {
      paramdv.a(i, 13);
    }
    i = this.Xb;
    if (i != 0) {
      paramdv.a(i, 14);
    }
    localObject = this.Yb;
    if (localObject != null) {
      paramdv.a((String)localObject, 15);
    }
    paramdv.a(this.ca, 16);
    localObject = this.Zb;
    if (localObject != null) {
      paramdv.a((String)localObject, 17);
    }
    localObject = this._b;
    if (localObject != null) {
      paramdv.a((String)localObject, 18);
    }
    i = this.ac;
    if (i != 0) {
      paramdv.a(i, 19);
    }
    localObject = this.bc;
    if (localObject != null) {
      paramdv.a((float)localObject, 20);
    }
    localObject = this.cc;
    if (localObject != null) {
      paramdv.a((float)localObject, 21);
    }
    localObject = this.dc;
    if (localObject != null) {
      paramdv.a((float)localObject, 22);
    }
    i = this.ec;
    if (i != 0) {
      paramdv.a(i, 23);
    }
    localObject = this.fc;
    if (localObject != null) {
      paramdv.a((Collection)localObject, 24);
    }
    localObject = this.gc;
    if (localObject != null) {
      paramdv.a((Collection)localObject, 25);
    }
    localObject = this.hc;
    if (localObject != null) {
      paramdv.a((float)localObject, 26);
    }
    localObject = this.ic;
    if (localObject != null) {
      paramdv.a((float)localObject, 27);
    }
    localObject = this.jc;
    if (localObject != null) {
      paramdv.a((byte[])localObject, 28);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Damson
 * JD-Core Version:    0.7.0.1
 */