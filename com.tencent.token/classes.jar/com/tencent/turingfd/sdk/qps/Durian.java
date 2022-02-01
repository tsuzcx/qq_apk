package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;
import java.util.ArrayList;
import java.util.Collection;

public final class Durian
  extends final
{
  public static ArrayList<Integer> a;
  public static ArrayList<Integer> b;
  public String c = "";
  public int d = 0;
  public float e = 0.0F;
  public String f = "";
  public String g = "";
  public String h = "";
  public long i = 0L;
  public int j = 0;
  public ArrayList<Integer> k = null;
  public int l = 0;
  public ArrayList<Integer> m = null;
  
  public final void a(agd paramagd)
  {
    this.c = paramagd.a(0, true);
    this.d = paramagd.a(this.d, 1, true);
    this.e = paramagd.a(this.e, 2, true);
    this.f = paramagd.a(3, false);
    this.g = paramagd.a(4, false);
    this.h = paramagd.a(5, false);
    this.i = paramagd.a(this.i, 6, false);
    this.j = paramagd.a(this.j, 7, false);
    if (a == null)
    {
      a = new ArrayList();
      a.add(Integer.valueOf(0));
    }
    this.k = ((ArrayList)paramagd.a(a, 8, false));
    this.l = paramagd.a(this.l, 9, false);
    if (b == null)
    {
      b = new ArrayList();
      b.add(Integer.valueOf(0));
    }
    this.m = ((ArrayList)paramagd.a(b, 10, false));
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.c, 0);
    paramage.a(this.d, 1);
    paramage.a(this.e, 2);
    Object localObject = this.f;
    if (localObject != null) {
      paramage.a((String)localObject, 3);
    }
    localObject = this.g;
    if (localObject != null) {
      paramage.a((String)localObject, 4);
    }
    localObject = this.h;
    if (localObject != null) {
      paramage.a((String)localObject, 5);
    }
    long l1 = this.i;
    if (l1 != 0L) {
      paramage.a(l1, 6);
    }
    paramage.a(this.j, 7);
    localObject = this.k;
    if (localObject != null) {
      paramage.a((Collection)localObject, 8);
    }
    int n = this.l;
    if (n != 0) {
      paramage.a(n, 9);
    }
    localObject = this.m;
    if (localObject != null) {
      paramage.a((Collection)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Durian
 * JD-Core Version:    0.7.0.1
 */