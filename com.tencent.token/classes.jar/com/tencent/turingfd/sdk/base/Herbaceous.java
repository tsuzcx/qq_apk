package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class Herbaceous
  extends float
{
  public static ArrayList hd;
  public ArrayList jd = null;
  public int kc = 0;
  
  public void a(dp paramdp)
  {
    this.kc = paramdp.a(this.kc, 0, true);
    if (hd == null)
    {
      hd = new ArrayList();
      hd.add("");
    }
    this.jd = ((ArrayList)paramdp.a(hd, 1, false));
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.kc, 0);
    ArrayList localArrayList = this.jd;
    if (localArrayList != null) {
      paramdv.a(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Herbaceous
 * JD-Core Version:    0.7.0.1
 */