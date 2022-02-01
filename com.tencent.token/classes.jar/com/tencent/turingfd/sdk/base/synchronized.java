package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class synchronized
  extends break
{
  public String A = "";
  public int ob = 0;
  
  public final void a(afk paramafk)
  {
    this.A = paramafk.a(0, false);
    this.ob = paramafk.a(this.ob, 1, false);
  }
  
  public final void a(afn paramafn)
  {
    String str = this.A;
    if (str != null) {
      paramafn.a(str, 0);
    }
    int i = this.ob;
    if (i != 0) {
      paramafn.a(i, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.synchronized
 * JD-Core Version:    0.7.0.1
 */