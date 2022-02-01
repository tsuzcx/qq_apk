package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

public final class Ginkgo
  extends break
{
  public String Nb = "";
  public String S = "";
  public String version = "";
  public int xc = 0;
  public String yc = "";
  
  public final void a(afl paramafl)
  {
    this.Nb = paramafl.a(0, true);
    this.xc = paramafl.a(this.xc, 1, true);
    this.version = paramafl.a(2, true);
    this.S = paramafl.a(3, true);
    this.yc = paramafl.a(4, false);
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.Nb, 0);
    paramafo.a(this.xc, 1);
    paramafo.a(this.version, 2);
    paramafo.a(this.S, 3);
    String str = this.yc;
    if (str != null) {
      paramafo.a(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Ginkgo
 * JD-Core Version:    0.7.0.1
 */