package com.tencent.turingfd.sdk.qps;

import com.tencent.token.afb;
import com.tencent.token.afd;

public final class Guava
  extends Orion
{
  public int a = 0;
  public float b = 0.0F;
  public float c = 0.0F;
  public float d = 0.0F;
  public float e = 0.0F;
  
  public final void a(afb paramafb)
  {
    this.a = paramafb.a(this.a, 0, true);
    this.b = paramafb.a(this.b, 1, true);
    this.c = paramafb.a(this.c, 2, true);
    this.d = paramafb.a(this.d, 3, false);
    this.e = paramafb.a(this.e, 4, false);
  }
  
  public final void a(afd paramafd)
  {
    paramafd.a(this.a, 0);
    paramafd.a(this.b, 1);
    paramafd.a(this.c, 2);
    float f = this.d;
    if (f != 0.0F) {
      paramafd.a(f, 3);
    }
    f = this.e;
    if (f != 0.0F) {
      paramafd.a(f, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Guava
 * JD-Core Version:    0.7.0.1
 */