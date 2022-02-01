package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class Grapefruit
  extends break
{
  public static Grape Ic;
  public Grape Jc = null;
  public int hc = 0;
  
  public final void a(afk paramafk)
  {
    this.hc = paramafk.a(this.hc, 0, true);
    if (Ic == null) {
      Ic = new Grape();
    }
    this.Jc = ((Grape)paramafk.a(Ic, 1, false));
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.hc, 0);
    Grape localGrape = this.Jc;
    if (localGrape != null) {
      paramafn.a(localGrape, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Grapefruit
 * JD-Core Version:    0.7.0.1
 */