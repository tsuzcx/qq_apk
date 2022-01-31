package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class Cumquat
  extends float
{
  public static ArrayList Ab;
  public int Bb = 0;
  public ArrayList Cb = null;
  
  public void a(dp paramdp)
  {
    this.Bb = paramdp.a(this.Bb, 0, true);
    if (Ab == null)
    {
      Ab = new ArrayList();
      Dew localDew = new Dew();
      Ab.add(localDew);
    }
    this.Cb = ((ArrayList)paramdp.a(Ab, 1, true));
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.Bb, 0);
    paramdv.a(this.Cb, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Cumquat
 * JD-Core Version:    0.7.0.1
 */