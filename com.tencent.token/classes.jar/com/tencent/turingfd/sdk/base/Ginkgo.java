package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class Ginkgo
  extends break
{
  public String Nb = "";
  public String S = "";
  public String version = "";
  public int xc = 0;
  public String yc = "";
  
  public final void a(afk paramafk)
  {
    this.Nb = paramafk.a(0, true);
    this.xc = paramafk.a(this.xc, 1, true);
    this.version = paramafk.a(2, true);
    this.S = paramafk.a(3, true);
    this.yc = paramafk.a(4, false);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.Nb, 0);
    paramafn.a(this.xc, 1);
    paramafn.a(this.version, 2);
    paramafn.a(this.S, 3);
    String str = this.yc;
    if (str != null) {
      paramafn.a(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Ginkgo
 * JD-Core Version:    0.7.0.1
 */