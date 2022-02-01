package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;
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
  
  public final void a(afk paramafk)
  {
    this.Tc = paramafk.a(this.Tc, 0, true);
    if (Sc == null)
    {
      Sc = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Haw());
      Sc.put(Integer.valueOf(0), localArrayList);
    }
    this.Uc = ((Map)paramafk.a(Sc, 1, true));
    this.Vc = paramafk.a(this.Vc, 2, false);
    this.Wc = paramafk.a(this.Wc, 3, false);
    this.Xc = paramafk.a(this.Xc, 4, false);
    this.Yc = paramafk.a(this.Yc, 5, false);
    this.Zc = paramafk.a(this.Zc, 6, false);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.Tc, 0);
    paramafn.a(this.Uc, 1);
    paramafn.a(this.Vc, 2);
    paramafn.a(this.Wc, 3);
    paramafn.a(this.Xc, 4);
    paramafn.a(this.Yc, 5);
    int i = this.Zc;
    if (i != 0) {
      paramafn.a(i, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Herbaceous
 * JD-Core Version:    0.7.0.1
 */