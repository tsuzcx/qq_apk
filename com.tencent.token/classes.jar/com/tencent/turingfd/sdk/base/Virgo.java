package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;
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
  
  public final void a(afk paramafk)
  {
    this.qb = paramafk.a(this.qb, 0, true);
    this.rb = paramafk.a(this.rb, 1, true);
    this.sb = paramafk.a(this.sb, 2, true);
    this.tb = paramafk.a(this.tb, 3, true);
    this.ub = paramafk.a(this.ub, 4, true);
    this.vb = paramafk.a(this.vb, 5, true);
    if (pb == null)
    {
      pb = new ArrayList();
      pb.add(Long.valueOf(0L));
    }
    this.wb = ((ArrayList)paramafk.a(pb, 6, true));
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.qb, 0);
    paramafn.a(this.rb, 1);
    paramafn.a(this.sb, 2);
    paramafn.a(this.tb, 3);
    paramafn.a(this.ub, 4);
    paramafn.a(this.vb, 5);
    paramafn.a(this.wb, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Virgo
 * JD-Core Version:    0.7.0.1
 */