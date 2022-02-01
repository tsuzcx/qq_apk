package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Herbaceous
  extends break
{
  public static Map<Integer, ArrayList<Haw>> Sc;
  public long Tc = 0L;
  public Map<Integer, ArrayList<Haw>> Uc = null;
  public int Vc = 0;
  public int Wc = 0;
  public int Xc = 0;
  public int Yc = 0;
  public int Zc = 0;
  
  public void a(cy paramcy)
  {
    this.Tc = paramcy.a(this.Tc, 0, true);
    if (Sc == null)
    {
      Sc = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Haw());
      Sc.put(Integer.valueOf(0), localArrayList);
    }
    this.Uc = ((Map)paramcy.a(Sc, 1, true));
    this.Vc = paramcy.a(this.Vc, 2, false);
    this.Wc = paramcy.a(this.Wc, 3, false);
    this.Xc = paramcy.a(this.Xc, 4, false);
    this.Yc = paramcy.a(this.Yc, 5, false);
    this.Zc = paramcy.a(this.Zc, 6, false);
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.Tc, 0);
    paramdb.a(this.Uc, 1);
    paramdb.a(this.Vc, 2);
    paramdb.a(this.Wc, 3);
    paramdb.a(this.Xc, 4);
    paramdb.a(this.Yc, 5);
    int i = this.Zc;
    if (i != 0) {
      paramdb.a(i, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Herbaceous
 * JD-Core Version:    0.7.0.1
 */