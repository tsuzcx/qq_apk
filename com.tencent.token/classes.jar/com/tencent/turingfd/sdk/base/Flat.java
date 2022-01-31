package com.tencent.turingfd.sdk.base;

public final class Flat
  extends float
{
  public int Ac = 0;
  public String Qb = "";
  public String aa = "";
  public String version = "";
  
  public void a(dp paramdp)
  {
    this.Qb = paramdp.a(0, true);
    this.Ac = paramdp.a(this.Ac, 1, true);
    this.version = paramdp.a(2, true);
    this.aa = paramdp.a(3, true);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.Qb, 0);
    paramdv.a(this.Ac, 1);
    paramdv.a(this.version, 2);
    paramdv.a(this.aa, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Flat
 * JD-Core Version:    0.7.0.1
 */