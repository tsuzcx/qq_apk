package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;
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
  
  public final void a(afl paramafl)
  {
    this.qb = paramafl.a(this.qb, 0, true);
    this.rb = paramafl.a(this.rb, 1, true);
    this.sb = paramafl.a(this.sb, 2, true);
    this.tb = paramafl.a(this.tb, 3, true);
    this.ub = paramafl.a(this.ub, 4, true);
    this.vb = paramafl.a(this.vb, 5, true);
    if (pb == null)
    {
      pb = new ArrayList();
      pb.add(Long.valueOf(0L));
    }
    this.wb = ((ArrayList)paramafl.a(pb, 6, true));
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.qb, 0);
    paramafo.a(this.rb, 1);
    paramafo.a(this.sb, 2);
    paramafo.a(this.tb, 3);
    paramafo.a(this.ub, 4);
    paramafo.a(this.vb, 5);
    paramafo.a(this.wb, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Virgo
 * JD-Core Version:    0.7.0.1
 */