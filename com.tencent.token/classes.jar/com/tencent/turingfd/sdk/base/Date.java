package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class Date
  extends break
{
  public static ArrayList<Fig> xb;
  public int yb = 0;
  public ArrayList<Fig> zb = null;
  
  public void a(cy paramcy)
  {
    this.yb = paramcy.a(this.yb, 0, true);
    if (xb == null)
    {
      xb = new ArrayList();
      Fig localFig = new Fig();
      xb.add(localFig);
    }
    this.zb = ((ArrayList)paramcy.a(xb, 1, true));
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.yb, 0);
    paramdb.a(this.zb, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Date
 * JD-Core Version:    0.7.0.1
 */