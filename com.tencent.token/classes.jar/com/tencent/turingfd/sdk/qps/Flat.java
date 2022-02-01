package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;

public final class Flat
  extends final
{
  public long a = 0L;
  public float b = 0.0F;
  public float c = 0.0F;
  public float d = 0.0F;
  
  public final void a(agd paramagd)
  {
    this.a = paramagd.a(this.a, 0, true);
    this.b = paramagd.a(this.b, 1, true);
    this.c = paramagd.a(this.c, 2, true);
    this.d = paramagd.a(this.d, 3, true);
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.a, 0);
    paramage.a(this.b, 1);
    paramage.a(this.c, 2);
    paramage.a(this.d, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Flat
 * JD-Core Version:    0.7.0.1
 */