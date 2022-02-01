package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;

public final class Date
  extends final
{
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  
  public final void a(agd paramagd)
  {
    this.a = paramagd.a(this.a, 0, true);
    this.b = paramagd.a(this.b, 1, false);
    this.c = paramagd.a(this.c, 2, false);
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.a, 0);
    long l = this.b;
    if (l != 0L) {
      paramage.a(l, 1);
    }
    l = this.c;
    if (l != 0L) {
      paramage.a(l, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Date
 * JD-Core Version:    0.7.0.1
 */