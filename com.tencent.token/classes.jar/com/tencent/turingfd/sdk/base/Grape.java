package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;
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
  
  public final void a(afl paramafl)
  {
    this.Kb = paramafl.a(0, true);
    this.Bc = paramafl.a(this.Bc, 1, true);
    this.Cc = paramafl.a(this.Cc, 2, true);
    this.Vb = paramafl.a(3, false);
    this.Dc = paramafl.a(4, false);
    this.Ec = paramafl.a(5, false);
    this.Jb = paramafl.a(this.Jb, 6, false);
    this.W = paramafl.a(this.W, 7, false);
    if (zc == null)
    {
      zc = new ArrayList();
      zc.add(Integer.valueOf(0));
    }
    this.Fc = ((ArrayList)paramafl.a(zc, 8, false));
    this.Gc = paramafl.a(this.Gc, 9, false);
    if (Ac == null)
    {
      Ac = new ArrayList();
      Ac.add(Integer.valueOf(0));
    }
    this.Hc = ((ArrayList)paramafl.a(Ac, 10, false));
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.Kb, 0);
    paramafo.a(this.Bc, 1);
    paramafo.a(this.Cc, 2);
    Object localObject = this.Vb;
    if (localObject != null) {
      paramafo.a((String)localObject, 3);
    }
    localObject = this.Dc;
    if (localObject != null) {
      paramafo.a((String)localObject, 4);
    }
    localObject = this.Ec;
    if (localObject != null) {
      paramafo.a((String)localObject, 5);
    }
    long l = this.Jb;
    if (l != 0L) {
      paramafo.a(l, 6);
    }
    paramafo.a(this.W, 7);
    localObject = this.Fc;
    if (localObject != null) {
      paramafo.a((Collection)localObject, 8);
    }
    int i = this.Gc;
    if (i != 0) {
      paramafo.a(i, 9);
    }
    localObject = this.Hc;
    if (localObject != null) {
      paramafo.a((Collection)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Grape
 * JD-Core Version:    0.7.0.1
 */