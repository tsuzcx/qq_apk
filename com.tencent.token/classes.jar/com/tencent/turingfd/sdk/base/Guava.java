package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;
import java.util.ArrayList;

public final class Guava
  extends break
{
  public static ArrayList<Herbaceous> Kc;
  public static ArrayList<Lemon> Lc;
  public long Mc = 0L;
  public ArrayList<Herbaceous> Nc = null;
  public double Oc = 0.0D;
  public double Pc = 0.0D;
  public ArrayList<Lemon> Qc = null;
  public int action = 0;
  public int oc = 0;
  
  public final void a(afl paramafl)
  {
    this.Mc = paramafl.a(this.Mc, 0, true);
    Object localObject;
    if (Kc == null)
    {
      Kc = new ArrayList();
      localObject = new Herbaceous();
      Kc.add(localObject);
    }
    this.Nc = ((ArrayList)paramafl.a(Kc, 1, true));
    this.oc = paramafl.a(this.oc, 2, false);
    this.action = paramafl.a(this.action, 3, false);
    this.Oc = paramafl.a(this.Oc, 4, false);
    this.Pc = paramafl.a(this.Pc, 5, false);
    if (Lc == null)
    {
      Lc = new ArrayList();
      localObject = new Lemon();
      Lc.add(localObject);
    }
    this.Qc = ((ArrayList)paramafl.a(Lc, 6, false));
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.Mc, 0);
    paramafo.a(this.Nc, 1);
    int i = this.oc;
    if (i != 0) {
      paramafo.a(i, 2);
    }
    i = this.action;
    if (i != 0) {
      paramafo.a(i, 3);
    }
    double d = this.Oc;
    if (d != 0.0D) {
      paramafo.a(d, 4);
    }
    d = this.Pc;
    if (d != 0.0D) {
      paramafo.a(d, 5);
    }
    ArrayList localArrayList = this.Qc;
    if (localArrayList != null) {
      paramafo.a(localArrayList, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.Guava
 * JD-Core Version:    0.7.0.1
 */