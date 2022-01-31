package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Grapefruit
  extends float
{
  public static Map Uc;
  public long Vc = 0L;
  public Map Wc = null;
  public int Xc = 0;
  public int Yc = 0;
  public int Zc = 0;
  public int _c = 0;
  public int ad = 0;
  
  public void a(dp paramdp)
  {
    this.Vc = paramdp.a(this.Vc, 0, true);
    if (Uc == null)
    {
      Uc = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Grape());
      Uc.put(Integer.valueOf(0), localArrayList);
    }
    this.Wc = ((Map)paramdp.a(Uc, 1, true));
    this.Xc = paramdp.a(this.Xc, 2, false);
    this.Yc = paramdp.a(this.Yc, 3, false);
    this.Zc = paramdp.a(this.Zc, 4, false);
    this._c = paramdp.a(this._c, 5, false);
    this.ad = paramdp.a(this.ad, 6, false);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.Vc, 0);
    paramdv.a(this.Wc, 1);
    paramdv.a(this.Xc, 2);
    paramdv.a(this.Yc, 3);
    paramdv.a(this.Zc, 4);
    paramdv.a(this._c, 5);
    int i = this.ad;
    if (i != 0) {
      paramdv.a(i, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Grapefruit
 * JD-Core Version:    0.7.0.1
 */