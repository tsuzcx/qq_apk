package com.tencent.turingfd.sdk.base;

public final class Grapefruit
  extends break
{
  public static Grape Ic;
  public Grape Jc = null;
  public int hc = 0;
  
  public void a(cy paramcy)
  {
    this.hc = paramcy.a(this.hc, 0, true);
    if (Ic == null) {
      Ic = new Grape();
    }
    this.Jc = ((Grape)paramcy.a(Ic, 1, false));
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.hc, 0);
    Grape localGrape = this.Jc;
    if (localGrape != null) {
      paramdb.a(localGrape, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Grapefruit
 * JD-Core Version:    0.7.0.1
 */