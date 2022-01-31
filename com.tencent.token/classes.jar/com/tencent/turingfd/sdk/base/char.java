package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class char
  extends float
{
  public static ArrayList _a = new ArrayList();
  public int cb = 0;
  public ArrayList data = null;
  public int db = 0;
  
  static
  {
    case localcase = new case();
    _a.add(localcase);
  }
  
  public float a()
  {
    return new char();
  }
  
  public void a(dp paramdp)
  {
    this.cb = paramdp.a(this.cb, 0, false);
    this.db = paramdp.a(this.db, 1, false);
    this.data = ((ArrayList)paramdp.a(_a, 2, false));
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
    ArrayList localArrayList = this.data;
    if (localArrayList != null) {
      paramdv.a(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.char
 * JD-Core Version:    0.7.0.1
 */