package com.tencent.turingfd.sdk.base;

public final class Fig
  extends float
{
  public String vc = "";
  public String wc = "";
  
  public void a(dp paramdp)
  {
    this.vc = paramdp.a(0, true);
    this.wc = paramdp.a(1, true);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.vc, 0);
    paramdv.a(this.wc, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Fig
 * JD-Core Version:    0.7.0.1
 */