package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;
import java.util.Collection;

public final class Kiwifruit
  extends float
{
  public static Hickory nd;
  public static ArrayList od;
  public static ArrayList pd;
  public Hickory connected = null;
  public int qd = 0;
  public ArrayList rd = null;
  public ArrayList sd = null;
  
  public void a(dp paramdp)
  {
    this.qd = paramdp.a(this.qd, 0, true);
    if (nd == null) {
      nd = new Hickory();
    }
    this.connected = ((Hickory)paramdp.a(nd, 1, false));
    if (od == null)
    {
      od = new ArrayList();
      Hickory localHickory = new Hickory();
      od.add(localHickory);
    }
    this.rd = ((ArrayList)paramdp.a(od, 2, false));
    if (pd == null)
    {
      pd = new ArrayList();
      pd.add("");
    }
    this.sd = ((ArrayList)paramdp.a(pd, 3, false));
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.qd, 0);
    Object localObject = this.connected;
    if (localObject != null) {
      paramdv.a((float)localObject, 1);
    }
    localObject = this.rd;
    if (localObject != null) {
      paramdv.a((Collection)localObject, 2);
    }
    localObject = this.sd;
    if (localObject != null) {
      paramdv.a((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Kiwifruit
 * JD-Core Version:    0.7.0.1
 */