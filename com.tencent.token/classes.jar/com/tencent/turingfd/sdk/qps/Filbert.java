package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;
import java.util.ArrayList;

public final class Filbert
  extends final
{
  public static ArrayList<Foxnut> a;
  public static ArrayList<Grape> b;
  public long c = 0L;
  public ArrayList<Foxnut> d = null;
  public int e = 0;
  public int f = 0;
  public double g = 0.0D;
  public double h = 0.0D;
  public ArrayList<Grape> i = null;
  
  public final void a(agd paramagd)
  {
    this.c = paramagd.a(this.c, 0, true);
    ArrayList localArrayList;
    if (a == null)
    {
      localArrayList = new ArrayList();
      a = localArrayList;
      localArrayList.add(new Foxnut());
    }
    this.d = ((ArrayList)paramagd.a(a, 1, true));
    this.e = paramagd.a(this.e, 2, false);
    this.f = paramagd.a(this.f, 3, false);
    this.g = paramagd.a(this.g, 4, false);
    this.h = paramagd.a(this.h, 5, false);
    if (b == null)
    {
      localArrayList = new ArrayList();
      b = localArrayList;
      localArrayList.add(new Grape());
    }
    this.i = ((ArrayList)paramagd.a(b, 6, false));
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.c, 0);
    paramage.a(this.d, 1);
    int j = this.e;
    if (j != 0) {
      paramage.a(j, 2);
    }
    j = this.f;
    if (j != 0) {
      paramage.a(j, 3);
    }
    double d1 = this.g;
    if (d1 != 0.0D) {
      paramage.a(d1, 4);
    }
    d1 = this.h;
    if (d1 != 0.0D) {
      paramage.a(d1, 5);
    }
    ArrayList localArrayList = this.i;
    if (localArrayList != null) {
      paramage.a(localArrayList, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Filbert
 * JD-Core Version:    0.7.0.1
 */