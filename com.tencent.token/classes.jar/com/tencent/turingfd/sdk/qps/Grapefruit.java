package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;

public final class Grapefruit
  extends final
{
  public int a = 0;
  public float b = 0.0F;
  public float c = 0.0F;
  public float d = 0.0F;
  public float e = 0.0F;
  
  public final void a(agd paramagd)
  {
    this.a = paramagd.a(this.a, 0, true);
    this.b = paramagd.a(this.b, 1, true);
    this.c = paramagd.a(this.c, 2, true);
    this.d = paramagd.a(this.d, 3, false);
    this.e = paramagd.a(this.e, 4, false);
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.a, 0);
    paramage.a(this.b, 1);
    paramage.a(this.c, 2);
    float f = this.d;
    if (f != 0.0F) {
      paramage.a(f, 3);
    }
    f = this.e;
    if (f != 0.0F) {
      paramage.a(f, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Grapefruit
 * JD-Core Version:    0.7.0.1
 */