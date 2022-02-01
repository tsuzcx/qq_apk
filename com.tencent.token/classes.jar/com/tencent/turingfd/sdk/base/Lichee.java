package com.tencent.turingfd.sdk.base;

public final class Lichee
  extends break
{
  public int qd = 0;
  public float radius = 0.0F;
  public float rd = 0.0F;
  public float x = 0.0F;
  public float y = 0.0F;
  
  public void a(cy paramcy)
  {
    this.qd = paramcy.a(this.qd, 0, true);
    this.x = paramcy.a(this.x, 1, true);
    this.y = paramcy.a(this.y, 2, true);
    this.rd = paramcy.a(this.rd, 3, false);
    this.radius = paramcy.a(this.radius, 4, false);
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.qd, 0);
    paramdb.a(this.x, 1);
    paramdb.a(this.y, 2);
    float f = this.rd;
    if (f != 0.0F) {
      paramdb.a(f, 3);
    }
    f = this.radius;
    if (f != 0.0F) {
      paramdb.a(f, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Lichee
 * JD-Core Version:    0.7.0.1
 */