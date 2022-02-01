package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;
import java.util.ArrayList;

public final class Lemon
  extends break
{
  public static ArrayList<Lichee> nd;
  public int duration = 0;
  public long od = 0L;
  public ArrayList<Lichee> pd = null;
  
  public final void a(afl paramafl)
  {
    this.od = paramafl.a(this.od, 0, true);
    this.duration = paramafl.a(this.duration, 1, true);
    if (nd == null)
    {
      nd = new ArrayList();
      Lichee localLichee = new Lichee();
      nd.add(localLichee);
    }
    this.pd = ((ArrayList)paramafl.a(nd, 2, true));
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.od, 0);
    paramafo.a(this.duration, 1);
    paramafo.a(this.pd, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Lemon
 * JD-Core Version:    0.7.0.1
 */