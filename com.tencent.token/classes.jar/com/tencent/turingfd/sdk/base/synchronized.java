package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

public final class synchronized
  extends break
{
  public String A = "";
  public int ob = 0;
  
  public final void a(afl paramafl)
  {
    this.A = paramafl.a(0, false);
    this.ob = paramafl.a(this.ob, 1, false);
  }
  
  public final void a(afo paramafo)
  {
    String str = this.A;
    if (str != null) {
      paramafo.a(str, 0);
    }
    int i = this.ob;
    if (i != 0) {
      paramafo.a(i, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.synchronized
 * JD-Core Version:    0.7.0.1
 */