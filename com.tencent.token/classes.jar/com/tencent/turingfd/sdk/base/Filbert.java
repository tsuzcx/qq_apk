package com.tencent.turingfd.sdk.base;

public final class Filbert
  extends float
{
  public int xc = 0;
  public long yc = 0L;
  public long zc = 0L;
  
  public void a(dp paramdp)
  {
    this.xc = paramdp.a(this.xc, 0, true);
    this.yc = paramdp.a(this.yc, 1, false);
    this.zc = paramdp.a(this.zc, 2, false);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.xc, 0);
    long l = this.yc;
    if (l != 0L) {
      paramdv.a(l, 1);
    }
    l = this.zc;
    if (l != 0L) {
      paramdv.a(l, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Filbert
 * JD-Core Version:    0.7.0.1
 */