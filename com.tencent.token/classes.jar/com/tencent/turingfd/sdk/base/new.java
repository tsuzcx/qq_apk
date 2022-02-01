package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;
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
  
  public final void a(afl paramafl)
  {
    this._a = paramafl.a(this._a, 0, false);
    this.ab = paramafl.a(this.ab, 1, false);
    this.ib = paramafl.a(this.ib, 2, false);
    this.jb = ((do)paramafl.a(gb, 3, false));
    this.kb = ((ArrayList)paramafl.a(hb, 4, false));
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
    i = this.ib;
    if (i != 1) {
      paramafo.a(i, 2);
    }
    Object localObject = this.jb;
    if (localObject != null) {
      paramafo.a((break)localObject, 3);
    }
    localObject = this.kb;
    if (localObject != null) {
      paramafo.a((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.new
 * JD-Core Version:    0.7.0.1
 */