package com.tencent.turingfd.sdk.base;

public final class case
  extends float
{
  public static byte[] _a = new byte[1];
  public static byte ab = new byte();
  public int bb = 0;
  public int cb = 0;
  public byte[] data = null;
  public int db = 0;
  public int fb = 0;
  public int gb = 0;
  public byte hb = null;
  public int ib = 0;
  
  static
  {
    _a[0] = 0;
  }
  
  public float a()
  {
    return new case();
  }
  
  public void a(dp paramdp)
  {
    this.bb = paramdp.a(this.bb, 0, true);
    this.cb = paramdp.a(this.cb, 1, false);
    this.db = paramdp.a(this.db, 2, false);
    this.fb = paramdp.a(this.fb, 3, false);
    this.gb = paramdp.a(this.gb, 4, false);
    this.data = paramdp.a(_a, 5, false);
    this.hb = ((byte)paramdp.a(ab, 6, false));
    this.ib = paramdp.a(this.ib, 7, false);
  }
  
  public void a(dv paramdv)
  {
    paramdv.a(this.bb, 0);
    int i = this.cb;
    if (i != 0) {
      paramdv.a(i, 1);
    }
    i = this.db;
    if (i != 0) {
      paramdv.a(i, 2);
    }
    paramdv.a(this.fb, 3);
    i = this.gb;
    if (i != 0) {
      paramdv.a(i, 4);
    }
    Object localObject = this.data;
    if (localObject != null) {
      paramdv.a((byte[])localObject, 5);
    }
    localObject = this.hb;
    if (localObject != null) {
      paramdv.a((float)localObject, 6);
    }
    i = this.ib;
    if (i != 0) {
      paramdv.a(i, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.case
 * JD-Core Version:    0.7.0.1
 */