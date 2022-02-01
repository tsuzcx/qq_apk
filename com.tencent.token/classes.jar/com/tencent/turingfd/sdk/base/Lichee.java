package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

public final class Lichee
  extends break
{
  public int qd = 0;
  public float radius = 0.0F;
  public float rd = 0.0F;
  public float x = 0.0F;
  public float y = 0.0F;
  
  public final void a(afl paramafl)
  {
    this.qd = paramafl.a(this.qd, 0, true);
    this.x = paramafl.a(this.x, 1, true);
    this.y = paramafl.a(this.y, 2, true);
    this.rd = paramafl.a(this.rd, 3, false);
    this.radius = paramafl.a(this.radius, 4, false);
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.qd, 0);
    paramafo.a(this.x, 1);
    paramafo.a(this.y, 2);
    float f = this.rd;
    if (f != 0.0F) {
      paramafo.a(f, 3);
    }
    f = this.radius;
    if (f != 0.0F) {
      paramafo.a(f, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Lichee
 * JD-Core Version:    0.7.0.1
 */