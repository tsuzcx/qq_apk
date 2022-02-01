package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;
import java.util.ArrayList;

public final class this
  extends final
{
  public static ArrayList<goto> a;
  public int b = 0;
  public int c = 0;
  public ArrayList<goto> d = null;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add(new goto());
  }
  
  public final void a(agd paramagd)
  {
    this.b = paramagd.a(this.b, 0, false);
    this.c = paramagd.a(this.c, 1, false);
    this.d = ((ArrayList)paramagd.a(a, 2, false));
  }
  
  public final void a(age paramage)
  {
    int i = this.b;
    if (i != 0) {
      paramage.a(i, 0);
    }
    i = this.c;
    if (i != 0) {
      paramage.a(i, 1);
    }
    ArrayList localArrayList = this.d;
    if (localArrayList != null) {
      paramage.a(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.this
 * JD-Core Version:    0.7.0.1
 */