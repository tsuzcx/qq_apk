package com.tencent.turingfd.sdk.base;

public final class Durian
  extends float
{
  public static Flat sc;
  public String metaData = "";
  public String tc = "";
  public Flat uc = null;
  
  public void a(dp paramdp)
  {
    this.tc = paramdp.a(0, true);
    this.metaData = paramdp.a(1, false);
    if (sc == null) {
      sc = new Flat();
    }
    this.uc = ((Flat)paramdp.a(sc, 2, false));
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.tc, 0);
    Object localObject = this.metaData;
    if (localObject != null) {
      paramdv.a((String)localObject, 1);
    }
    localObject = this.uc;
    if (localObject != null) {
      paramdv.a((float)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Durian
 * JD-Core Version:    0.7.0.1
 */