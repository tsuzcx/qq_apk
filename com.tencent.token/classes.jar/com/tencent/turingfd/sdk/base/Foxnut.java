package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

public final class Foxnut
  extends break
{
  public int uc = 0;
  public long vc = 0L;
  public long wc = 0L;
  
  public final void a(afl paramafl)
  {
    this.uc = paramafl.a(this.uc, 0, true);
    this.vc = paramafl.a(this.vc, 1, false);
    this.wc = paramafl.a(this.wc, 2, false);
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.uc, 0);
    long l = this.vc;
    if (l != 0L) {
      paramafo.a(l, 1);
    }
    l = this.wc;
    if (l != 0L) {
      paramafo.a(l, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Foxnut
 * JD-Core Version:    0.7.0.1
 */