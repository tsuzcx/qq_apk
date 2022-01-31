package com.tencent.turingfd.sdk.base;

public final class Hickory
  extends float
{
  public String kd = "";
  public String ld = "";
  public int md = 0;
  
  public void a(dp paramdp)
  {
    this.kd = paramdp.a(0, true);
    this.ld = paramdp.a(1, true);
    this.md = paramdp.a(this.md, 2, true);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.kd, 0);
    paramdv.a(this.ld, 1);
    paramdv.a(this.md, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Hickory
 * JD-Core Version:    0.7.0.1
 */