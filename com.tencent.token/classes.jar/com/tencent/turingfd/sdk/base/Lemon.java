package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class Lemon
  extends break
{
  public static ArrayList<Lichee> nd;
  public int duration = 0;
  public long od = 0L;
  public ArrayList<Lichee> pd = null;
  
  public void a(cy paramcy)
  {
    this.od = paramcy.a(this.od, 0, true);
    this.duration = paramcy.a(this.duration, 1, true);
    if (nd == null)
    {
      nd = new ArrayList();
      Lichee localLichee = new Lichee();
      nd.add(localLichee);
    }
    this.pd = ((ArrayList)paramcy.a(nd, 2, true));
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.od, 0);
    paramdb.a(this.duration, 1);
    paramdb.a(this.pd, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Lemon
 * JD-Core Version:    0.7.0.1
 */