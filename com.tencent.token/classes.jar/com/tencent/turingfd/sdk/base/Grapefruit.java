package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

public final class Grapefruit
  extends break
{
  public static Grape Ic;
  public Grape Jc = null;
  public int hc = 0;
  
  public final void a(afl paramafl)
  {
    this.hc = paramafl.a(this.hc, 0, true);
    if (Ic == null) {
      Ic = new Grape();
    }
    this.Jc = ((Grape)paramafl.a(Ic, 1, false));
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.hc, 0);
    Grape localGrape = this.Jc;
    if (localGrape != null) {
      paramafo.a(localGrape, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Grapefruit
 * JD-Core Version:    0.7.0.1
 */