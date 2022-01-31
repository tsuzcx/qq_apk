package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;
import java.util.Collection;

public final class Foxnut
  extends float
{
  public static ArrayList Bc;
  public static ArrayList Cc;
  public int Dc = 0;
  public float Ec = 0.0F;
  public String Fc = "";
  public String Gc = "";
  public ArrayList Hc = null;
  public int Ic = 0;
  public ArrayList Jc = null;
  public long Mb = 0L;
  public String Nb = "";
  public String Yb = "";
  public int ca = 0;
  
  public void a(dp paramdp)
  {
    this.Nb = paramdp.a(0, true);
    this.Dc = paramdp.a(this.Dc, 1, true);
    this.Ec = paramdp.a(this.Ec, 2, true);
    this.Yb = paramdp.a(3, false);
    this.Fc = paramdp.a(4, false);
    this.Gc = paramdp.a(5, false);
    this.Mb = paramdp.a(this.Mb, 6, false);
    this.ca = paramdp.a(this.ca, 7, false);
    if (Bc == null)
    {
      Bc = new ArrayList();
      Bc.add(Integer.valueOf(0));
    }
    this.Hc = ((ArrayList)paramdp.a(Bc, 8, false));
    this.Ic = paramdp.a(this.Ic, 9, false);
    if (Cc == null)
    {
      Cc = new ArrayList();
      Cc.add(Integer.valueOf(0));
    }
    this.Jc = ((ArrayList)paramdp.a(Cc, 10, false));
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.Nb, 0);
    paramdv.a(this.Dc, 1);
    paramdv.a(this.Ec, 2);
    Object localObject = this.Yb;
    if (localObject != null) {
      paramdv.a((String)localObject, 3);
    }
    localObject = this.Fc;
    if (localObject != null) {
      paramdv.a((String)localObject, 4);
    }
    localObject = this.Gc;
    if (localObject != null) {
      paramdv.a((String)localObject, 5);
    }
    long l = this.Mb;
    if (l != 0L) {
      paramdv.a(l, 6);
    }
    paramdv.a(this.ca, 7);
    localObject = this.Hc;
    if (localObject != null) {
      paramdv.a((Collection)localObject, 8);
    }
    int i = this.Ic;
    if (i != 0) {
      paramdv.a(i, 9);
    }
    localObject = this.Jc;
    if (localObject != null) {
      paramdv.a((Collection)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Foxnut
 * JD-Core Version:    0.7.0.1
 */