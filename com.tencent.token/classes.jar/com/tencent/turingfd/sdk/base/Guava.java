package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class Guava
  extends float
{
  public static ArrayList bd;
  public long cd = 0L;
  public ArrayList dd = null;
  public int duration = 0;
  
  public void a(dp paramdp)
  {
    this.cd = paramdp.a(this.cd, 0, true);
    this.duration = paramdp.a(this.duration, 1, true);
    if (bd == null)
    {
      bd = new ArrayList();
      Haw localHaw = new Haw();
      bd.add(localHaw);
    }
    this.dd = ((ArrayList)paramdp.a(bd, 2, true));
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.cd, 0);
    paramdv.a(this.duration, 1);
    paramdv.a(this.dd, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Guava
 * JD-Core Version:    0.7.0.1
 */