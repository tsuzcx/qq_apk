package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;
import java.util.ArrayList;

public final class Date
  extends break
{
  public static ArrayList<Fig> xb;
  public int yb = 0;
  public ArrayList<Fig> zb = null;
  
  public final void a(afl paramafl)
  {
    this.yb = paramafl.a(this.yb, 0, true);
    if (xb == null)
    {
      xb = new ArrayList();
      Fig localFig = new Fig();
      xb.add(localFig);
    }
    this.zb = ((ArrayList)paramafl.a(xb, 1, true));
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.yb, 0);
    paramafo.a(this.zb, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Date
 * JD-Core Version:    0.7.0.1
 */