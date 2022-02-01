package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;
import java.util.ArrayList;

public final class Longan
  extends break
{
  public static ArrayList<String> sd;
  public int hc = 0;
  public ArrayList<String> td = null;
  
  public final void a(afl paramafl)
  {
    this.hc = paramafl.a(this.hc, 0, true);
    if (sd == null)
    {
      ArrayList localArrayList = new ArrayList();
      sd = localArrayList;
      localArrayList.add("");
    }
    this.td = ((ArrayList)paramafl.a(sd, 1, false));
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.hc, 0);
    ArrayList localArrayList = this.td;
    if (localArrayList != null) {
      paramafo.a(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Longan
 * JD-Core Version:    0.7.0.1
 */