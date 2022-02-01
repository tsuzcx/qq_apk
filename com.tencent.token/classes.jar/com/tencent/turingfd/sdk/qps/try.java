package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;
import java.util.ArrayList;
import java.util.Collection;

public final class try
  extends final
{
  public static do a = new do();
  public static ArrayList<new> b;
  public int c = 0;
  public int d = 0;
  public int e = 5;
  public do f = null;
  public ArrayList<new> g = null;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    b = localArrayList;
    localArrayList.add(new new());
  }
  
  public final void a(agd paramagd)
  {
    this.c = paramagd.a(this.c, 0, false);
    this.d = paramagd.a(this.d, 1, false);
    this.e = paramagd.a(this.e, 2, false);
    this.f = ((do)paramagd.a(a, 3, false));
    this.g = ((ArrayList)paramagd.a(b, 4, false));
  }
  
  public final void a(age paramage)
  {
    int i = this.c;
    if (i != 0) {
      paramage.a(i, 0);
    }
    i = this.d;
    if (i != 0) {
      paramage.a(i, 1);
    }
    i = this.e;
    if (i != 1) {
      paramage.a(i, 2);
    }
    Object localObject = this.f;
    if (localObject != null) {
      paramage.a((final)localObject, 3);
    }
    localObject = this.g;
    if (localObject != null) {
      paramage.a((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.try
 * JD-Core Version:    0.7.0.1
 */