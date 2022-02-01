package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class do
  extends break
{
  public String A = "";
  public int B = 0;
  public int C = 0;
  public long D = 0L;
  public int F = 0;
  public String G = "";
  public int s = 2;
  public int t = 0;
  public String u = "";
  public String v = "";
  
  public final void a(afk paramafk)
  {
    this.s = paramafk.a(this.s, 0, true);
    this.t = paramafk.a(this.t, 1, true);
    this.u = paramafk.a(2, false);
    this.v = paramafk.a(3, false);
    this.A = paramafk.a(4, false);
    this.B = paramafk.a(this.B, 5, false);
    this.C = paramafk.a(this.C, 6, false);
    this.D = paramafk.a(this.D, 7, false);
    this.F = paramafk.a(this.F, 8, false);
    this.G = paramafk.a(9, false);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.s, 0);
    paramafn.a(this.t, 1);
    String str = this.u;
    if (str != null) {
      paramafn.a(str, 2);
    }
    str = this.v;
    if (str != null) {
      paramafn.a(str, 3);
    }
    str = this.A;
    if (str != null) {
      paramafn.a(str, 4);
    }
    int i = this.B;
    if (i != 0) {
      paramafn.a(i, 5);
    }
    i = this.C;
    if (i != 0) {
      paramafn.a(i, 6);
    }
    long l = this.D;
    if (l != 0L) {
      paramafn.a(l, 7);
    }
    i = this.F;
    if (i != 0) {
      paramafn.a(i, 8);
    }
    str = this.G;
    if (str != null) {
      paramafn.a(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.do
 * JD-Core Version:    0.7.0.1
 */