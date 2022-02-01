package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class Guava
  extends break
{
  public static ArrayList<Herbaceous> Kc;
  public static ArrayList<Lemon> Lc;
  public long Mc = 0L;
  public ArrayList<Herbaceous> Nc = null;
  public double Oc = 0.0D;
  public double Pc = 0.0D;
  public ArrayList<Lemon> Qc = null;
  public int action = 0;
  public int oc = 0;
  
  public void a(cy paramcy)
  {
    this.Mc = paramcy.a(this.Mc, 0, true);
    Object localObject;
    if (Kc == null)
    {
      Kc = new ArrayList();
      localObject = new Herbaceous();
      Kc.add(localObject);
    }
    this.Nc = ((ArrayList)paramcy.a(Kc, 1, true));
    this.oc = paramcy.a(this.oc, 2, false);
    this.action = paramcy.a(this.action, 3, false);
    this.Oc = paramcy.a(this.Oc, 4, false);
    this.Pc = paramcy.a(this.Pc, 5, false);
    if (Lc == null)
    {
      Lc = new ArrayList();
      localObject = new Lemon();
      Lc.add(localObject);
    }
    this.Qc = ((ArrayList)paramcy.a(Lc, 6, false));
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.Mc, 0);
    paramdb.a(this.Nc, 1);
    int i = this.oc;
    if (i != 0) {
      paramdb.a(i, 2);
    }
    i = this.action;
    if (i != 0) {
      paramdb.a(i, 3);
    }
    double d = this.Oc;
    if (d != 0.0D) {
      paramdb.a(d, 4);
    }
    d = this.Pc;
    if (d != 0.0D) {
      paramdb.a(d, 5);
    }
    ArrayList localArrayList = this.Qc;
    if (localArrayList != null) {
      paramdb.a(localArrayList, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Guava
 * JD-Core Version:    0.7.0.1
 */