package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;
import java.util.ArrayList;

public final class Longan
  extends break
{
  public static ArrayList<String> sd;
  public int hc = 0;
  public ArrayList<String> td = null;
  
  public final void a(afk paramafk)
  {
    this.hc = paramafk.a(this.hc, 0, true);
    if (sd == null)
    {
      ArrayList localArrayList = new ArrayList();
      sd = localArrayList;
      localArrayList.add("");
    }
    this.td = ((ArrayList)paramafk.a(sd, 1, false));
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.hc, 0);
    ArrayList localArrayList = this.td;
    if (localArrayList != null) {
      paramafn.a(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Longan
 * JD-Core Version:    0.7.0.1
 */