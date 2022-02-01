package com.tencent.turingfd.sdk.base;

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
  
  public break a()
  {
    return new do();
  }
  
  public void a(cy paramcy)
  {
    this.s = paramcy.a(this.s, 0, true);
    this.t = paramcy.a(this.t, 1, true);
    this.u = paramcy.a(2, false);
    this.v = paramcy.a(3, false);
    this.A = paramcy.a(4, false);
    this.B = paramcy.a(this.B, 5, false);
    this.C = paramcy.a(this.C, 6, false);
    this.D = paramcy.a(this.D, 7, false);
    this.F = paramcy.a(this.F, 8, false);
    this.G = paramcy.a(9, false);
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.s, 0);
    paramdb.a(this.t, 1);
    String str = this.u;
    if (str != null) {
      paramdb.a(str, 2);
    }
    str = this.v;
    if (str != null) {
      paramdb.a(str, 3);
    }
    str = this.A;
    if (str != null) {
      paramdb.a(str, 4);
    }
    int i = this.B;
    if (i != 0) {
      paramdb.a(i, 5);
    }
    i = this.C;
    if (i != 0) {
      paramdb.a(i, 6);
    }
    long l = this.D;
    if (l != 0L) {
      paramdb.a(l, 7);
    }
    i = this.F;
    if (i != 0) {
      paramdb.a(i, 8);
    }
    str = this.G;
    if (str != null) {
      paramdb.a(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.do
 * JD-Core Version:    0.7.0.1
 */