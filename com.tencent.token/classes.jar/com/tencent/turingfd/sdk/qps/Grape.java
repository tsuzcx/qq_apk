package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;
import java.util.ArrayList;

public final class Grape
  extends final
{
  public static ArrayList<Grapefruit> a;
  public long b = 0L;
  public int c = 0;
  public ArrayList<Grapefruit> d = null;
  
  public final void a(agd paramagd)
  {
    this.b = paramagd.a(this.b, 0, true);
    this.c = paramagd.a(this.c, 1, true);
    if (a == null)
    {
      ArrayList localArrayList = new ArrayList();
      a = localArrayList;
      localArrayList.add(new Grapefruit());
    }
    this.d = ((ArrayList)paramagd.a(a, 2, true));
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.b, 0);
    paramage.a(this.c, 1);
    paramage.a(this.d, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Grape
 * JD-Core Version:    0.7.0.1
 */