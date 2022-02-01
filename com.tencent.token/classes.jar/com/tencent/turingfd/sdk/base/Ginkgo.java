package com.tencent.turingfd.sdk.base;

public final class Ginkgo
  extends break
{
  public String Nb = "";
  public String S = "";
  public String version = "";
  public int xc = 0;
  public String yc = "";
  
  public void a(cy paramcy)
  {
    this.Nb = paramcy.a(0, true);
    this.xc = paramcy.a(this.xc, 1, true);
    this.version = paramcy.a(2, true);
    this.S = paramcy.a(3, true);
    this.yc = paramcy.a(4, false);
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.Nb, 0);
    paramdb.a(this.xc, 1);
    paramdb.a(this.version, 2);
    paramdb.a(this.S, 3);
    String str = this.yc;
    if (str != null) {
      paramdb.a(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Ginkgo
 * JD-Core Version:    0.7.0.1
 */