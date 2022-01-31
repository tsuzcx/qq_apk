package com.tencent.turingfd.sdk.base;

public final class Dew
  extends float
{
  public int pc = 0;
  public long qc = 0L;
  public int rc = 0;
  
  public void a(dp paramdp)
  {
    this.pc = paramdp.a(this.pc, 0, true);
    this.qc = paramdp.a(this.qc, 1, true);
    this.rc = paramdp.a(this.rc, 2, true);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.pc, 0);
    paramdv.a(this.qc, 1);
    paramdv.a(this.rc, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Dew
 * JD-Core Version:    0.7.0.1
 */