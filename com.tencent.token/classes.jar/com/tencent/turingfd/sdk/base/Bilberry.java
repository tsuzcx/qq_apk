package com.tencent.turingfd.sdk.base;

public final class Bilberry
  extends float
{
  public String D = "";
  public int zb = 0;
  
  public void a(dp paramdp)
  {
    this.D = paramdp.a(0, false);
    this.zb = paramdp.a(this.zb, 1, false);
  }
  
  public void a(dv paramdv)
  {
    String str = this.D;
    if (str != null) {
      paramdv.a(str, 0);
    }
    int i = this.zb;
    if (i != 0) {
      paramdv.a(i, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Bilberry
 * JD-Core Version:    0.7.0.1
 */