package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

public final class Flat
  extends break
{
  public String sc = "";
  public String tc = "";
  
  public final void a(afl paramafl)
  {
    this.sc = paramafl.a(0, true);
    this.tc = paramafl.a(1, true);
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.sc, 0);
    paramafo.a(this.tc, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Flat
 * JD-Core Version:    0.7.0.1
 */