package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;
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
  
  public final void a(afl paramafl)
  {
    this._a = paramafl.a(this._a, 0, false);
    this.ab = paramafl.a(this.ab, 1, false);
    this.data = ((ArrayList)paramafl.a(Xa, 2, false));
  }
  
  public final void a(afo paramafo)
  {
    int i = this._a;
    if (i != 0) {
      paramafo.a(i, 0);
    }
    i = this.ab;
    if (i != 0) {
      paramafo.a(i, 1);
    }
    ArrayList localArrayList = this.data;
    if (localArrayList != null) {
      paramafo.a(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.char
 * JD-Core Version:    0.7.0.1
 */