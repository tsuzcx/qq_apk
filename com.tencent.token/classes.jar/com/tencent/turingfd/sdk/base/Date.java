package com.tencent.turingfd.sdk.base;

public final class Date
  extends float
{
  public int kc = 0;
  public int lc = 0;
  public int mc = 0;
  public int nc = 0;
  public int oc = 0;
  
  public void a(dp paramdp)
  {
    this.kc = paramdp.a(this.kc, 0, true);
    this.lc = paramdp.a(this.lc, 1, true);
    this.mc = paramdp.a(this.mc, 2, true);
    this.nc = paramdp.a(this.nc, 3, true);
    this.oc = paramdp.a(this.oc, 4, true);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.kc, 0);
    paramdv.a(this.lc, 1);
    paramdv.a(this.mc, 2);
    paramdv.a(this.nc, 3);
    paramdv.a(this.oc, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Date
 * JD-Core Version:    0.7.0.1
 */