package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;
import java.util.ArrayList;
import java.util.Collection;

public final class Herbaceous
  extends final
{
  public static Haw a;
  public static ArrayList<Haw> b;
  public static ArrayList<String> c;
  public int d = 0;
  public Haw e = null;
  public ArrayList<Haw> f = null;
  public ArrayList<String> g = null;
  
  public final void a(agd paramagd)
  {
    this.d = paramagd.a(this.d, 0, true);
    if (a == null) {
      a = new Haw();
    }
    this.e = ((Haw)paramagd.a(a, 1, false));
    ArrayList localArrayList;
    if (b == null)
    {
      localArrayList = new ArrayList();
      b = localArrayList;
      localArrayList.add(new Haw());
    }
    this.f = ((ArrayList)paramagd.a(b, 2, false));
    if (c == null)
    {
      localArrayList = new ArrayList();
      c = localArrayList;
      localArrayList.add("");
    }
    this.g = ((ArrayList)paramagd.a(c, 3, false));
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.d, 0);
    Object localObject = this.e;
    if (localObject != null) {
      paramage.a((final)localObject, 1);
    }
    localObject = this.f;
    if (localObject != null) {
      paramage.a((Collection)localObject, 2);
    }
    localObject = this.g;
    if (localObject != null) {
      paramage.a((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Herbaceous
 * JD-Core Version:    0.7.0.1
 */