package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class Virgo
  extends break
{
  public static ArrayList<Long> pb;
  public int qb = 0;
  public long rb = 0L;
  public long sb = 0L;
  public int tb = 0;
  public int ub = 0;
  public int vb = 0;
  public ArrayList<Long> wb = null;
  
  public void a(cy paramcy)
  {
    this.qb = paramcy.a(this.qb, 0, true);
    this.rb = paramcy.a(this.rb, 1, true);
    this.sb = paramcy.a(this.sb, 2, true);
    this.tb = paramcy.a(this.tb, 3, true);
    this.ub = paramcy.a(this.ub, 4, true);
    this.vb = paramcy.a(this.vb, 5, true);
    if (pb == null)
    {
      pb = new ArrayList();
      pb.add(Long.valueOf(0L));
    }
    this.wb = ((ArrayList)paramcy.a(pb, 6, true));
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.qb, 0);
    paramdb.a(this.rb, 1);
    paramdb.a(this.sb, 2);
    paramdb.a(this.tb, 3);
    paramdb.a(this.ub, 4);
    paramdb.a(this.vb, 5);
    paramdb.a(this.wb, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Virgo
 * JD-Core Version:    0.7.0.1
 */