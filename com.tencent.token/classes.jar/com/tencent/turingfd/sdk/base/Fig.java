package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class Fig
  extends break
{
  public int mc = 0;
  public long nc = 0L;
  public int oc = 0;
  
  public final void a(afk paramafk)
  {
    this.mc = paramafk.a(this.mc, 0, true);
    this.nc = paramafk.a(this.nc, 1, true);
    this.oc = paramafk.a(this.oc, 2, true);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.mc, 0);
    paramafn.a(this.nc, 1);
    paramafn.a(this.oc, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Fig
 * JD-Core Version:    0.7.0.1
 */