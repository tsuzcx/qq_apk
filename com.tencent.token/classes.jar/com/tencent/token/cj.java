package com.tencent.token;

import com.tencent.token.global.c;

public class cj
{
  public byte[] f = null;
  public long g;
  public short h;
  public byte i = 1;
  public short j = 0;
  public short k = 0;
  public int l;
  public int m;
  public short n;
  public short o = c.b();
  public short p = c.c();
  public short q = c.d();
  public String r = "";
  public byte[] s = new byte[32];
  public byte[] t = new byte[32];
  
  public void a(long paramLong, int paramInt1, int paramInt2, short paramShort)
  {
    this.g = paramLong;
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramShort;
  }
  
  public byte[] a()
  {
    this.o = c.b();
    this.p = c.c();
    this.q = c.d();
    byte[] arrayOfByte2 = this.r.getBytes();
    int i3 = arrayOfByte2.length;
    byte[] arrayOfByte1 = this.f;
    int i1;
    if ((arrayOfByte1 != null) && (arrayOfByte1.length > 0)) {
      i1 = arrayOfByte1.length;
    } else {
      i1 = 0;
    }
    int i2 = this.t.length + 92 + i1 + 32 + 1;
    this.h = ((short)i2);
    arrayOfByte1 = new byte[i2];
    arrayOfByte1[0] = 2;
    ck.a(arrayOfByte1, 1, this.g);
    ck.a(arrayOfByte1, 5, this.h);
    arrayOfByte1[7] = this.i;
    ck.a(arrayOfByte1, 8, this.j);
    ck.a(arrayOfByte1, 10, this.k);
    ck.a(arrayOfByte1, 12, this.l);
    ck.a(arrayOfByte1, 16, this.m);
    ck.a(arrayOfByte1, 20, this.n);
    ck.a(arrayOfByte1, 22, this.o);
    ck.a(arrayOfByte1, 24, this.p);
    ck.a(arrayOfByte1, 26, this.q);
    byte[] arrayOfByte3 = new byte[64];
    if (i3 > 0)
    {
      i2 = i3;
      if (i3 > 64) {
        i2 = 64;
      }
      ck.a(arrayOfByte3, 0, arrayOfByte2, 0, i2);
    }
    ck.a(arrayOfByte1, 28, arrayOfByte3, 0, 64);
    arrayOfByte2 = this.t;
    ck.a(arrayOfByte1, 92, arrayOfByte2, 0, arrayOfByte2.length);
    i3 = 92 + this.t.length;
    i2 = i3;
    if (i1 > 0)
    {
      ck.a(arrayOfByte1, i3, this.f, 0, i1);
      i2 = i3 + i1;
    }
    arrayOfByte2 = this.s;
    ck.a(arrayOfByte1, i2, arrayOfByte2, 0, arrayOfByte2.length);
    arrayOfByte1[(i2 + this.s.length)] = 3;
    return arrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cj
 * JD-Core Version:    0.7.0.1
 */