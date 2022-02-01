package com.tencent.turingfd.sdk.base;

import com.tencent.token.afl;
import com.tencent.token.afo;

public final class case
  extends break
{
  public static byte[] Xa;
  public static byte Ya = new byte();
  public int Za = 0;
  public int _a = 0;
  public int ab = 0;
  public int cb = 0;
  public byte[] data = null;
  public int db = 0;
  public byte eb = null;
  public int fb = 0;
  
  static
  {
    byte[] arrayOfByte = new byte[1];
    Xa = arrayOfByte;
    arrayOfByte[0] = 0;
  }
  
  public final void a(afl paramafl)
  {
    this.Za = paramafl.a(this.Za, 0, true);
    this._a = paramafl.a(this._a, 1, false);
    this.ab = paramafl.a(this.ab, 2, false);
    this.cb = paramafl.a(this.cb, 3, false);
    this.db = paramafl.a(this.db, 4, false);
    this.data = paramafl.b(5, false);
    this.eb = ((byte)paramafl.a(Ya, 6, false));
    this.fb = paramafl.a(this.fb, 7, false);
  }
  
  public final void a(afo paramafo)
  {
    paramafo.a(this.Za, 0);
    int i = this._a;
    if (i != 0) {
      paramafo.a(i, 1);
    }
    i = this.ab;
    if (i != 0) {
      paramafo.a(i, 2);
    }
    paramafo.a(this.cb, 3);
    i = this.db;
    if (i != 0) {
      paramafo.a(i, 4);
    }
    Object localObject = this.data;
    if (localObject != null) {
      paramafo.a((byte[])localObject, 5);
    }
    localObject = this.eb;
    if (localObject != null) {
      paramafo.a((break)localObject, 6);
    }
    i = this.fb;
    if (i != 0) {
      paramafo.a(i, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.case
 * JD-Core Version:    0.7.0.1
 */