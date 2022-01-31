package com.tencent.turingfd.sdk.base;

public final class Ginkgo
  extends float
{
  public static Foxnut Kc;
  public Foxnut Lc = null;
  public int kc = 0;
  
  public void a(dp paramdp)
  {
    this.kc = paramdp.a(this.kc, 0, true);
    if (Kc == null) {
      Kc = new Foxnut();
    }
    this.Lc = ((Foxnut)paramdp.a(Kc, 1, false));
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.kc, 0);
    Foxnut localFoxnut = this.Lc;
    if (localFoxnut != null) {
      paramdv.a(localFoxnut, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Ginkgo
 * JD-Core Version:    0.7.0.1
 */