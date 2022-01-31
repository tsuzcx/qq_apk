package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class Gooseberry
  extends float
{
  public static ArrayList Mc;
  public static ArrayList Nc;
  public long Oc = 0L;
  public ArrayList Pc = null;
  public double Qc = 0.0D;
  public double Rc = 0.0D;
  public ArrayList Sc = null;
  public int action = 0;
  public int rc = 0;
  
  public void a(dp paramdp)
  {
    this.Oc = paramdp.a(this.Oc, 0, true);
    Object localObject;
    if (Mc == null)
    {
      Mc = new ArrayList();
      localObject = new Grapefruit();
      Mc.add(localObject);
    }
    this.Pc = ((ArrayList)paramdp.a(Mc, 1, true));
    this.rc = paramdp.a(this.rc, 2, false);
    this.action = paramdp.a(this.action, 3, false);
    this.Qc = paramdp.a(this.Qc, 4, false);
    this.Rc = paramdp.a(this.Rc, 5, false);
    if (Nc == null)
    {
      Nc = new ArrayList();
      localObject = new Guava();
      Nc.add(localObject);
    }
    this.Sc = ((ArrayList)paramdp.a(Nc, 6, false));
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.Oc, 0);
    paramdv.a(this.Pc, 1);
    int i = this.rc;
    if (i != 0) {
      paramdv.a(i, 2);
    }
    i = this.action;
    if (i != 0) {
      paramdv.a(i, 3);
    }
    double d = this.Qc;
    if (d != 0.0D) {
      paramdv.a(d, 4);
    }
    d = this.Rc;
    if (d != 0.0D) {
      paramdv.a(d, 5);
    }
    ArrayList localArrayList = this.Sc;
    if (localArrayList != null) {
      paramdv.a(localArrayList, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Gooseberry
 * JD-Core Version:    0.7.0.1
 */