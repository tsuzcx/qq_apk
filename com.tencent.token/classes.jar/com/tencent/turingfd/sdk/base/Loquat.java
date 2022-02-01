package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class Loquat
  extends break
{
  public String ud = "";
  public String vd = "";
  public int wd = 0;
  
  public final void a(afk paramafk)
  {
    this.ud = paramafk.a(0, true);
    this.vd = paramafk.a(1, true);
    this.wd = paramafk.a(this.wd, 2, true);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.ud, 0);
    paramafn.a(this.vd, 1);
    paramafn.a(this.wd, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Loquat
 * JD-Core Version:    0.7.0.1
 */