package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class Centaurus
  extends float
{
  public static ArrayList ob;
  public int pb = 0;
  public long qb = 0L;
  public long rb = 0L;
  public int sb = 0;
  public int tb = 0;
  public int ub = 0;
  public ArrayList vb = null;
  
  public void a(dp paramdp)
  {
    this.pb = paramdp.a(this.pb, 0, true);
    this.qb = paramdp.a(this.qb, 1, true);
    this.rb = paramdp.a(this.rb, 2, true);
    this.sb = paramdp.a(this.sb, 3, true);
    this.tb = paramdp.a(this.tb, 4, true);
    this.ub = paramdp.a(this.ub, 5, true);
    if (ob == null)
    {
      ob = new ArrayList();
      ob.add(Long.valueOf(0L));
    }
    this.vb = ((ArrayList)paramdp.a(ob, 6, true));
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.pb, 0);
    paramdv.a(this.qb, 1);
    paramdv.a(this.rb, 2);
    paramdv.a(this.sb, 3);
    paramdv.a(this.tb, 4);
    paramdv.a(this.ub, 5);
    paramdv.a(this.vb, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Centaurus
 * JD-Core Version:    0.7.0.1
 */