package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

public final class Fig
  extends break
{
  public int mc = 0;
  public long nc = 0L;
  public int oc = 0;
  
  public final void a(afl paramafl)
  {
    this.mc = paramafl.a(this.mc, 0, true);
    this.nc = paramafl.a(this.nc, 1, true);
    this.oc = paramafl.a(this.oc, 2, true);
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.mc, 0);
    paramafo.a(this.nc, 1);
    paramafo.a(this.oc, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Fig
 * JD-Core Version:    0.7.0.1
 */