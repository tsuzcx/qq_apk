package com.tencent.turingfd.sdk.base;

public final class int
  extends float
{
  public static byte[] _a = new byte[1];
  public static for ab = new for();
  public int bb = 0;
  public int cb = 0;
  public byte[] data = null;
  public int db = 0;
  public long eb = 0L;
  public int fb = 0;
  public int gb = 0;
  public for hb = null;
  public int ib = 0;
  
  static
  {
    _a[0] = 0;
  }
  
  public float a()
  {
    return new int();
  }
  
  public void a(dp paramdp)
  {
    this.bb = paramdp.a(this.bb, 0, true);
    this.cb = paramdp.a(this.cb, 1, false);
    this.db = paramdp.a(this.db, 2, false);
    this.data = paramdp.a(_a, 3, false);
    this.eb = paramdp.a(this.eb, 4, false);
    this.fb = paramdp.a(this.fb, 5, false);
    this.gb = paramdp.a(this.gb, 6, false);
    this.hb = ((for)paramdp.a(ab, 7, false));
    this.ib = paramdp.a(this.ib, 8, false);
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
    Object localObject = this.data;
    if (localObject != null) {
      paramdv.a((byte[])localObject, 3);
    }
    long l = this.eb;
    if (l != 0L) {
      paramdv.a(l, 4);
    }
    i = this.fb;
    if (i != 0) {
      paramdv.a(i, 5);
    }
    i = this.gb;
    if (i != 0) {
      paramdv.a(i, 6);
    }
    localObject = this.hb;
    if (localObject != null) {
      paramdv.a((float)localObject, 7);
    }
    i = this.ib;
    if (i != 0) {
      paramdv.a(i, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.int
 * JD-Core Version:    0.7.0.1
 */