package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;
import java.util.ArrayList;

public final class Guava
  extends final
{
  public static ArrayList<String> a;
  public int b = 0;
  public ArrayList<String> c = null;
  
  public final void a(agd paramagd)
  {
    this.b = paramagd.a(this.b, 0, true);
    if (a == null)
    {
      ArrayList localArrayList = new ArrayList();
      a = localArrayList;
      localArrayList.add("");
    }
    this.c = ((ArrayList)paramagd.a(a, 1, false));
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.b, 0);
    ArrayList localArrayList = this.c;
    if (localArrayList != null) {
      paramage.a(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Guava
 * JD-Core Version:    0.7.0.1
 */