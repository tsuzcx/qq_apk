package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

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
  
  public final void a(afl paramafl)
  {
    this.s = paramafl.a(this.s, 0, true);
    this.t = paramafl.a(this.t, 1, true);
    this.u = paramafl.a(2, false);
    this.v = paramafl.a(3, false);
    this.A = paramafl.a(4, false);
    this.B = paramafl.a(this.B, 5, false);
    this.C = paramafl.a(this.C, 6, false);
    this.D = paramafl.a(this.D, 7, false);
    this.F = paramafl.a(this.F, 8, false);
    this.G = paramafl.a(9, false);
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.s, 0);
    paramafo.a(this.t, 1);
    String str = this.u;
    if (str != null) {
      paramafo.a(str, 2);
    }
    str = this.v;
    if (str != null) {
      paramafo.a(str, 3);
    }
    str = this.A;
    if (str != null) {
      paramafo.a(str, 4);
    }
    int i = this.B;
    if (i != 0) {
      paramafo.a(i, 5);
    }
    i = this.C;
    if (i != 0) {
      paramafo.a(i, 6);
    }
    long l = this.D;
    if (l != 0L) {
      paramafo.a(l, 7);
    }
    i = this.F;
    if (i != 0) {
      paramafo.a(i, 8);
    }
    str = this.G;
    if (str != null) {
      paramafo.a(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.do
 * JD-Core Version:    0.7.0.1
 */