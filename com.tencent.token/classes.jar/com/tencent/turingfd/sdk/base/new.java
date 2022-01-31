package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;
import java.util.Collection;

public final class new
  extends float
{
  public static do jb = new do();
  public static ArrayList kb = new ArrayList();
  public int cb = 0;
  public int db = 0;
  public int lb = 5;
  public do mb = null;
  public ArrayList nb = null;
  
  static
  {
    int localint = new int();
    kb.add(localint);
  }
  
  public float a()
  {
    return new new();
  }
  
  public void a(dp paramdp)
  {
    this.cb = paramdp.a(this.cb, 0, false);
    this.db = paramdp.a(this.db, 1, false);
    this.lb = paramdp.a(this.lb, 2, false);
    this.mb = ((do)paramdp.a(jb, 3, false));
    this.nb = ((ArrayList)paramdp.a(kb, 4, false));
  }
  
  public void a(dv paramdv)
  {
    int i = this.cb;
    if (i != 0) {
      paramdv.a(i, 0);
    }
    i = this.db;
    if (i != 0) {
      paramdv.a(i, 1);
    }
    i = this.lb;
    if (i != 1) {
      paramdv.a(i, 2);
    }
    Object localObject = this.mb;
    if (localObject != null) {
      paramdv.a((float)localObject, 3);
    }
    localObject = this.nb;
    if (localObject != null) {
      paramdv.a((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.new
 * JD-Core Version:    0.7.0.1
 */