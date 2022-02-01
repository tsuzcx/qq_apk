package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class Foxnut
  extends break
{
  public int uc = 0;
  public long vc = 0L;
  public long wc = 0L;
  
  public final void a(afk paramafk)
  {
    this.uc = paramafk.a(this.uc, 0, true);
    this.vc = paramafk.a(this.vc, 1, false);
    this.wc = paramafk.a(this.wc, 2, false);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.uc, 0);
    long l = this.vc;
    if (l != 0L) {
      paramafn.a(l, 1);
    }
    l = this.wc;
    if (l != 0L) {
      paramafn.a(l, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Foxnut
 * JD-Core Version:    0.7.0.1
 */