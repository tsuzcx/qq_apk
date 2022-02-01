package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;
import java.util.Collection;

public final class new
  extends break
{
  public static do gb = new do();
  public static ArrayList<int> hb = new ArrayList();
  public int _a = 0;
  public int ab = 0;
  public int ib = 5;
  public do jb = null;
  public ArrayList<int> kb = null;
  
  static
  {
    int localint = new int();
    hb.add(localint);
  }
  
  public break a()
  {
    return new new();
  }
  
  public void a(cy paramcy)
  {
    this._a = paramcy.a(this._a, 0, false);
    this.ab = paramcy.a(this.ab, 1, false);
    this.ib = paramcy.a(this.ib, 2, false);
    this.jb = ((do)paramcy.a(gb, 3, false));
    this.kb = ((ArrayList)paramcy.a(hb, 4, false));
  }
  
  public void a(db paramdb)
  {
    int i = this._a;
    if (i != 0) {
      paramdb.a(i, 0);
    }
    i = this.ab;
    if (i != 0) {
      paramdb.a(i, 1);
    }
    i = this.ib;
    if (i != 1) {
      paramdb.a(i, 2);
    }
    Object localObject = this.jb;
    if (localObject != null) {
      paramdb.a((break)localObject, 3);
    }
    localObject = this.kb;
    if (localObject != null) {
      paramdb.a((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.new
 * JD-Core Version:    0.7.0.1
 */