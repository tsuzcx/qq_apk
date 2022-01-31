package com.tencent.turingfd.sdk.base;

public final class do
  extends float
{
  public int A = 0;
  public String B = "";
  public String C = "";
  public String D = "";
  public int F = 0;
  public int G = 0;
  public long H = 0L;
  public int I = 0;
  public String J = "";
  public int v = 2;
  
  public float a()
  {
    return new do();
  }
  
  public void a(dp paramdp)
  {
    this.v = paramdp.a(this.v, 0, true);
    this.A = paramdp.a(this.A, 1, true);
    this.B = paramdp.a(2, false);
    this.C = paramdp.a(3, false);
    this.D = paramdp.a(4, false);
    this.F = paramdp.a(this.F, 5, false);
    this.G = paramdp.a(this.G, 6, false);
    this.H = paramdp.a(this.H, 7, false);
    this.I = paramdp.a(this.I, 8, false);
    this.J = paramdp.a(9, false);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.v, 0);
    paramdv.a(this.A, 1);
    String str = this.B;
    if (str != null) {
      paramdv.a(str, 2);
    }
    str = this.C;
    if (str != null) {
      paramdv.a(str, 3);
    }
    str = this.D;
    if (str != null) {
      paramdv.a(str, 4);
    }
    int i = this.F;
    if (i != 0) {
      paramdv.a(i, 5);
    }
    i = this.G;
    if (i != 0) {
      paramdv.a(i, 6);
    }
    long l = this.H;
    if (l != 0L) {
      paramdv.a(l, 7);
    }
    i = this.I;
    if (i != 0) {
      paramdv.a(i, 8);
    }
    str = this.J;
    if (str != null) {
      paramdv.a(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.do
 * JD-Core Version:    0.7.0.1
 */