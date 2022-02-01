package com.tencent.turingfd.sdk.base;

public final class case
  extends break
{
  public static byte[] Xa = new byte[1];
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
    Xa[0] = 0;
  }
  
  public break a()
  {
    return new case();
  }
  
  public void a(cy paramcy)
  {
    this.Za = paramcy.a(this.Za, 0, true);
    this._a = paramcy.a(this._a, 1, false);
    this.ab = paramcy.a(this.ab, 2, false);
    this.cb = paramcy.a(this.cb, 3, false);
    this.db = paramcy.a(this.db, 4, false);
    this.data = paramcy.a(Xa, 5, false);
    this.eb = ((byte)paramcy.a(Ya, 6, false));
    this.fb = paramcy.a(this.fb, 7, false);
  }
  
  public void a(db paramdb)
  {
    paramdb.a(this.Za, 0);
    int i = this._a;
    if (i != 0) {
      paramdb.a(i, 1);
    }
    i = this.ab;
    if (i != 0) {
      paramdb.a(i, 2);
    }
    paramdb.a(this.cb, 3);
    i = this.db;
    if (i != 0) {
      paramdb.a(i, 4);
    }
    Object localObject = this.data;
    if (localObject != null) {
      paramdb.a((byte[])localObject, 5);
    }
    localObject = this.eb;
    if (localObject != null) {
      paramdb.a((break)localObject, 6);
    }
    i = this.fb;
    if (i != 0) {
      paramdb.a(i, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.case
 * JD-Core Version:    0.7.0.1
 */