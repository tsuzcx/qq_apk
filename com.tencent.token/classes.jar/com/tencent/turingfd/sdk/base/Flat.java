package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class Flat
  extends break
{
  public String sc = "";
  public String tc = "";
  
  public final void a(afk paramafk)
  {
    this.sc = paramafk.a(0, true);
    this.tc = paramafk.a(1, true);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.sc, 0);
    paramafn.a(this.tc, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Flat
 * JD-Core Version:    0.7.0.1
 */