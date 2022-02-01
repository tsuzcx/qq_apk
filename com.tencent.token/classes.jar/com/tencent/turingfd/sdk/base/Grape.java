package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;
import java.util.ArrayList;
import java.util.Collection;

public final class Grape
  extends break
{
  public static ArrayList<Integer> Ac;
  public static ArrayList<Integer> zc;
  public int Bc = 0;
  public float Cc = 0.0F;
  public String Dc = "";
  public String Ec = "";
  public ArrayList<Integer> Fc = null;
  public int Gc = 0;
  public ArrayList<Integer> Hc = null;
  public long Jb = 0L;
  public String Kb = "";
  public String Vb = "";
  public int W = 0;
  
  public final void a(afk paramafk)
  {
    this.Kb = paramafk.a(0, true);
    this.Bc = paramafk.a(this.Bc, 1, true);
    this.Cc = paramafk.a(this.Cc, 2, true);
    this.Vb = paramafk.a(3, false);
    this.Dc = paramafk.a(4, false);
    this.Ec = paramafk.a(5, false);
    this.Jb = paramafk.a(this.Jb, 6, false);
    this.W = paramafk.a(this.W, 7, false);
    if (zc == null)
    {
      zc = new ArrayList();
      zc.add(Integer.valueOf(0));
    }
    this.Fc = ((ArrayList)paramafk.a(zc, 8, false));
    this.Gc = paramafk.a(this.Gc, 9, false);
    if (Ac == null)
    {
      Ac = new ArrayList();
      Ac.add(Integer.valueOf(0));
    }
    this.Hc = ((ArrayList)paramafk.a(Ac, 10, false));
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.Kb, 0);
    paramafn.a(this.Bc, 1);
    paramafn.a(this.Cc, 2);
    Object localObject = this.Vb;
    if (localObject != null) {
      paramafn.a((String)localObject, 3);
    }
    localObject = this.Dc;
    if (localObject != null) {
      paramafn.a((String)localObject, 4);
    }
    localObject = this.Ec;
    if (localObject != null) {
      paramafn.a((String)localObject, 5);
    }
    long l = this.Jb;
    if (l != 0L) {
      paramafn.a(l, 6);
    }
    paramafn.a(this.W, 7);
    localObject = this.Fc;
    if (localObject != null) {
      paramafn.a((Collection)localObject, 8);
    }
    int i = this.Gc;
    if (i != 0) {
      paramafn.a(i, 9);
    }
    localObject = this.Hc;
    if (localObject != null) {
      paramafn.a((Collection)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Grape
 * JD-Core Version:    0.7.0.1
 */