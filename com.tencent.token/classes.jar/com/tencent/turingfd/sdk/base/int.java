package com.tencent.turingfd.sdk.base;

public final class int
  extends break
{
  public static byte[] Xa = new byte[1];
  public static for Ya = new for();
  public int Za = 0;
  public int _a = 0;
  public int ab = 0;
  public long bb = 0L;
  public int cb = 0;
  public byte[] data = null;
  public int db = 0;
  public for eb = null;
  public int fb = 0;
  
  static
  {
    Xa[0] = 0;
  }
  
  public break a()
  {
    return new int();
  }
  
  public void a(cy paramcy)
  {
    this.Za = paramcy.a(this.Za, 0, true);
    this._a = paramcy.a(this._a, 1, false);
    this.ab = paramcy.a(this.ab, 2, false);
    this.data = paramcy.a(Xa, 3, false);
    this.bb = paramcy.a(this.bb, 4, false);
    this.cb = paramcy.a(this.cb, 5, false);
    this.db = paramcy.a(this.db, 6, false);
    this.eb = ((for)paramcy.a(Ya, 7, false));
    this.fb = paramcy.a(this.fb, 8, false);
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
    Object localObject = this.data;
    if (localObject != null) {
      paramdb.a((byte[])localObject, 3);
    }
    long l = this.bb;
    if (l != 0L) {
      paramdb.a(l, 4);
    }
    i = this.cb;
    if (i != 0) {
      paramdb.a(i, 5);
    }
    i = this.db;
    if (i != 0) {
      paramdb.a(i, 6);
    }
    localObject = this.eb;
    if (localObject != null) {
      paramdb.a((break)localObject, 7);
    }
    i = this.fb;
    if (i != 0) {
      paramdb.a(i, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.int
 * JD-Core Version:    0.7.0.1
 */