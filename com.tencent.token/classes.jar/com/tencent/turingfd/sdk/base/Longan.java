package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class Longan
  extends break
{
  public static ArrayList<String> sd;
  public int hc = 0;
  public ArrayList<String> td = null;
  
  public void a(cy paramcy)
  {
    this.hc = paramcy.a(this.hc, 0, true);
    if (sd == null)
    {
      sd = new ArrayList();
      sd.add("");
    }
    this.td = ((ArrayList)paramcy.a(sd, 1, false));
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.hc, 0);
    ArrayList localArrayList = this.td;
    if (localArrayList != null) {
      paramdb.a(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Longan
 * JD-Core Version:    0.7.0.1
 */