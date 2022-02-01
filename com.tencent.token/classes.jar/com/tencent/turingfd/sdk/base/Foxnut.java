package com.tencent.turingfd.sdk.base;

public final class Foxnut
  extends break
{
  public int uc = 0;
  public long vc = 0L;
  public long wc = 0L;
  
  public void a(cy paramcy)
  {
    this.uc = paramcy.a(this.uc, 0, true);
    this.vc = paramcy.a(this.vc, 1, false);
    this.wc = paramcy.a(this.wc, 2, false);
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.uc, 0);
    long l = this.vc;
    if (l != 0L) {
      paramdb.a(l, 1);
    }
    l = this.wc;
    if (l != 0L) {
      paramdb.a(l, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Foxnut
 * JD-Core Version:    0.7.0.1
 */