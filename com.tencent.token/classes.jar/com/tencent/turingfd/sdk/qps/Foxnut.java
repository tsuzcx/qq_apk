package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Foxnut
  extends final
{
  public static Map<Integer, ArrayList<Flat>> a;
  public long b = 0L;
  public Map<Integer, ArrayList<Flat>> c = null;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  
  public final void a(agd paramagd)
  {
    this.b = paramagd.a(this.b, 0, true);
    if (a == null)
    {
      a = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Flat());
      a.put(Integer.valueOf(0), localArrayList);
    }
    this.c = ((Map)paramagd.a(a, 1, true));
    this.d = paramagd.a(this.d, 2, false);
    this.e = paramagd.a(this.e, 3, false);
    this.f = paramagd.a(this.f, 4, false);
    this.g = paramagd.a(this.g, 5, false);
    this.h = paramagd.a(this.h, 6, false);
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.b, 0);
    paramage.a(this.c, 1);
    paramage.a(this.d, 2);
    paramage.a(this.e, 3);
    paramage.a(this.f, 4);
    paramage.a(this.g, 5);
    int i = this.h;
    if (i != 0) {
      paramage.a(i, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Foxnut
 * JD-Core Version:    0.7.0.1
 */