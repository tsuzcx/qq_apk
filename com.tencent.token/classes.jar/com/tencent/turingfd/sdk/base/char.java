package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;
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
  
  public final void a(afk paramafk)
  {
    this._a = paramafk.a(this._a, 0, false);
    this.ab = paramafk.a(this.ab, 1, false);
    this.data = ((ArrayList)paramafk.a(Xa, 2, false));
  }
  
  public final void a(afn paramafn)
  {
    int i = this._a;
    if (i != 0) {
      paramafn.a(i, 0);
    }
    i = this.ab;
    if (i != 0) {
      paramafn.a(i, 1);
    }
    ArrayList localArrayList = this.data;
    if (localArrayList != null) {
      paramafn.a(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.char
 * JD-Core Version:    0.7.0.1
 */