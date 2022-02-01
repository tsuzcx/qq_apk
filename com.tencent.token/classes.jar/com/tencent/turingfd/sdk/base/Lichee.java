package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class Lichee
  extends break
{
  public int qd = 0;
  public float radius = 0.0F;
  public float rd = 0.0F;
  public float x = 0.0F;
  public float y = 0.0F;
  
  public final void a(afk paramafk)
  {
    this.qd = paramafk.a(this.qd, 0, true);
    this.x = paramafk.a(this.x, 1, true);
    this.y = paramafk.a(this.y, 2, true);
    this.rd = paramafk.a(this.rd, 3, false);
    this.radius = paramafk.a(this.radius, 4, false);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.qd, 0);
    paramafn.a(this.x, 1);
    paramafn.a(this.y, 2);
    float f = this.rd;
    if (f != 0.0F) {
      paramafn.a(f, 3);
    }
    f = this.radius;
    if (f != 0.0F) {
      paramafn.a(f, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Lichee
 * JD-Core Version:    0.7.0.1
 */