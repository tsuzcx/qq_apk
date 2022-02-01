package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;
import java.util.ArrayList;

public final class Lemon
  extends break
{
  public static ArrayList<Lichee> nd;
  public int duration = 0;
  public long od = 0L;
  public ArrayList<Lichee> pd = null;
  
  public final void a(afk paramafk)
  {
    this.od = paramafk.a(this.od, 0, true);
    this.duration = paramafk.a(this.duration, 1, true);
    if (nd == null)
    {
      nd = new ArrayList();
      Lichee localLichee = new Lichee();
      nd.add(localLichee);
    }
    this.pd = ((ArrayList)paramafk.a(nd, 2, true));
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.od, 0);
    paramafn.a(this.duration, 1);
    paramafn.a(this.pd, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Lemon
 * JD-Core Version:    0.7.0.1
 */