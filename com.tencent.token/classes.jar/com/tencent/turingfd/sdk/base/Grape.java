package com.tencent.turingfd.sdk.base;

public final class Grape
  extends float
{
  public long Tc = 0L;
  public float x = 0.0F;
  public float y = 0.0F;
  public float z = 0.0F;
  
  public void a(dp paramdp)
  {
    this.Tc = paramdp.a(this.Tc, 0, true);
    this.x = paramdp.a(this.x, 1, true);
    this.y = paramdp.a(this.y, 2, true);
    this.z = paramdp.a(this.z, 3, true);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.Tc, 0);
    paramdv.a(this.x, 1);
    paramdv.a(this.y, 2);
    paramdv.a(this.z, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Grape
 * JD-Core Version:    0.7.0.1
 */