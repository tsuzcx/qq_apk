package com.tencent.turingfd.sdk.base;

import com.tencent.token.afk;
import com.tencent.token.afn;

public final class int
  extends break
{
  public static byte[] Xa;
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
    byte[] arrayOfByte = new byte[1];
    Xa = arrayOfByte;
    arrayOfByte[0] = 0;
  }
  
  public final void a(afk paramafk)
  {
    this.Za = paramafk.a(this.Za, 0, true);
    this._a = paramafk.a(this._a, 1, false);
    this.ab = paramafk.a(this.ab, 2, false);
    this.data = paramafk.b(3, false);
    this.bb = paramafk.a(this.bb, 4, false);
    this.cb = paramafk.a(this.cb, 5, false);
    this.db = paramafk.a(this.db, 6, false);
    this.eb = ((for)paramafk.a(Ya, 7, false));
    this.fb = paramafk.a(this.fb, 8, false);
  }
  
  public final void a(afn paramafn)
  {
    paramafn.a(this.Za, 0);
    int i = this._a;
    if (i != 0) {
      paramafn.a(i, 1);
    }
    i = this.ab;
    if (i != 0) {
      paramafn.a(i, 2);
    }
    Object localObject = this.data;
    if (localObject != null) {
      paramafn.a((byte[])localObject, 3);
    }
    long l = this.bb;
    if (l != 0L) {
      paramafn.a(l, 4);
    }
    i = this.cb;
    if (i != 0) {
      paramafn.a(i, 5);
    }
    i = this.db;
    if (i != 0) {
      paramafn.a(i, 6);
    }
    localObject = this.eb;
    if (localObject != null) {
      paramafn.a((break)localObject, 7);
    }
    i = this.fb;
    if (i != 0) {
      paramafn.a(i, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.int
 * JD-Core Version:    0.7.0.1
 */