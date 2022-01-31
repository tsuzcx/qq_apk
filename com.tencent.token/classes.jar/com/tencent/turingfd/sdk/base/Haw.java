package com.tencent.turingfd.sdk.base;

public final class Haw
  extends float
{
  public int ed = 0;
  public float gd = 0.0F;
  public float radius = 0.0F;
  public float x = 0.0F;
  public float y = 0.0F;
  
  public void a(dp paramdp)
  {
    this.ed = paramdp.a(this.ed, 0, true);
    this.x = paramdp.a(this.x, 1, true);
    this.y = paramdp.a(this.y, 2, true);
    this.gd = paramdp.a(this.gd, 3, false);
    this.radius = paramdp.a(this.radius, 4, false);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.ed, 0);
    paramdv.a(this.x, 1);
    paramdv.a(this.y, 2);
    float f = this.gd;
    if (f != 0.0F) {
      paramdv.a(f, 3);
    }
    f = this.radius;
    if (f != 0.0F) {
      paramdv.a(f, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Haw
 * JD-Core Version:    0.7.0.1
 */