package com.tencent.turingfd.sdk.base;

public final class Betelnut
  extends float
{
  public static byte[] wb;
  public byte[] xb = null;
  public String yb = "";
  
  public void a(dp paramdp)
  {
    if (wb == null)
    {
      wb = new byte[1];
      wb[0] = 0;
    }
    this.xb = paramdp.a(wb, 0, false);
    this.yb = paramdp.a(1, false);
  }
  
  public void a(dv paramdv)
  {
    Object localObject = this.xb;
    if (localObject != null) {
      paramdv.a((byte[])localObject, 0);
    }
    localObject = this.yb;
    if (localObject != null) {
      paramdv.a((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Betelnut
 * JD-Core Version:    0.7.0.1
 */