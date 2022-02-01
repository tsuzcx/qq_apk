package com.tencent.turingfd.sdk.qps;

import com.tencent.token.afb;
import com.tencent.token.afd;
import java.util.ArrayList;

public final class Grapefruit
  extends Orion
{
  public static ArrayList<Guava> a;
  public long b = 0L;
  public int c = 0;
  public ArrayList<Guava> d = null;
  
  public final void a(afb paramafb)
  {
    this.b = paramafb.a(this.b, 0, true);
    this.c = paramafb.a(this.c, 1, true);
    if (a == null)
    {
      ArrayList localArrayList = new ArrayList();
      a = localArrayList;
      localArrayList.add(new Guava());
    }
    this.d = ((ArrayList)paramafb.a(a, 2, true));
  }
  
  public final void a(afd paramafd)
  {
    paramafd.a(this.b, 0);
    paramafd.a(this.c, 1);
    paramafd.a(this.d, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Grapefruit
 * JD-Core Version:    0.7.0.1
 */