package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;

public final class char
  extends break
{
  public static ArrayList<case> Xa = new ArrayList();
  public int _a = 0;
  public int ab = 0;
  public ArrayList<case> data = null;
  
  static
  {
    case localcase = new case();
    Xa.add(localcase);
  }
  
  public break a()
  {
    return new char();
  }
  
  public void a(cy paramcy)
  {
    this._a = paramcy.a(this._a, 0, false);
    this.ab = paramcy.a(this.ab, 1, false);
    this.data = ((ArrayList)paramcy.a(Xa, 2, false));
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
    ArrayList localArrayList = this.data;
    if (localArrayList != null) {
      paramdb.a(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.char
 * JD-Core Version:    0.7.0.1
 */