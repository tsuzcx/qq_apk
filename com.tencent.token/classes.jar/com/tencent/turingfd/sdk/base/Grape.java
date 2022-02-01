package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;
import java.util.Collection;

public final class Grape
  extends break
{
  public static ArrayList<Integer> Ac;
  public static ArrayList<Integer> zc;
  public int Bc = 0;
  public float Cc = 0.0F;
  public String Dc = "";
  public String Ec = "";
  public ArrayList<Integer> Fc = null;
  public int Gc = 0;
  public ArrayList<Integer> Hc = null;
  public long Jb = 0L;
  public String Kb = "";
  public String Vb = "";
  public int W = 0;
  
  public void a(cy paramcy)
  {
    this.Kb = paramcy.a(0, true);
    this.Bc = paramcy.a(this.Bc, 1, true);
    this.Cc = paramcy.a(this.Cc, 2, true);
    this.Vb = paramcy.a(3, false);
    this.Dc = paramcy.a(4, false);
    this.Ec = paramcy.a(5, false);
    this.Jb = paramcy.a(this.Jb, 6, false);
    this.W = paramcy.a(this.W, 7, false);
    if (zc == null)
    {
      zc = new ArrayList();
      zc.add(Integer.valueOf(0));
    }
    this.Fc = ((ArrayList)paramcy.a(zc, 8, false));
    this.Gc = paramcy.a(this.Gc, 9, false);
    if (Ac == null)
    {
      Ac = new ArrayList();
      Ac.add(Integer.valueOf(0));
    }
    this.Hc = ((ArrayList)paramcy.a(Ac, 10, false));
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.Kb, 0);
    paramdb.a(this.Bc, 1);
    paramdb.a(this.Cc, 2);
    Object localObject = this.Vb;
    if (localObject != null) {
      paramdb.a((String)localObject, 3);
    }
    localObject = this.Dc;
    if (localObject != null) {
      paramdb.a((String)localObject, 4);
    }
    localObject = this.Ec;
    if (localObject != null) {
      paramdb.a((String)localObject, 5);
    }
    long l = this.Jb;
    if (l != 0L) {
      paramdb.a(l, 6);
    }
    paramdb.a(this.W, 7);
    localObject = this.Fc;
    if (localObject != null) {
      paramdb.a((Collection)localObject, 8);
    }
    int i = this.Gc;
    if (i != 0) {
      paramdb.a(i, 9);
    }
    localObject = this.Hc;
    if (localObject != null) {
      paramdb.a((Collection)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Grape
 * JD-Core Version:    0.7.0.1
 */