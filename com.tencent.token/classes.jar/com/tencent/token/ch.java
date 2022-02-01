package com.tencent.token;

import com.tencent.token.global.c;

public class ch
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
    byte[] arrayOfByte1 = this.r.getBytes();
    int i3 = arrayOfByte1.length;
    if ((this.f != null) && (this.f.length > 0)) {}
    for (int i1 = this.f.length;; i1 = 0)
    {
      int i2 = this.t.length + 92 + i1 + 32 + 1;
      this.h = ((short)i2);
      byte[] arrayOfByte2 = new byte[i2];
      arrayOfByte2[0] = 2;
      ci.a(arrayOfByte2, 1, this.g);
      ci.a(arrayOfByte2, 5, this.h);
      arrayOfByte2[7] = this.i;
      ci.a(arrayOfByte2, 8, this.j);
      ci.a(arrayOfByte2, 10, this.k);
      ci.a(arrayOfByte2, 12, this.l);
      ci.a(arrayOfByte2, 16, this.m);
      ci.a(arrayOfByte2, 20, this.n);
      ci.a(arrayOfByte2, 22, this.o);
      ci.a(arrayOfByte2, 24, this.p);
      ci.a(arrayOfByte2, 26, this.q);
      byte[] arrayOfByte3 = new byte[64];
      if (i3 > 0)
      {
        i2 = i3;
        if (i3 > 64) {
          i2 = 64;
        }
        ci.a(arrayOfByte3, 0, arrayOfByte1, 0, i2);
      }
      ci.a(arrayOfByte2, 28, arrayOfByte3, 0, 64);
      ci.a(arrayOfByte2, 92, this.t, 0, this.t.length);
      i2 = this.t.length + 92;
      if (i1 > 0)
      {
        ci.a(arrayOfByte2, i2, this.f, 0, i1);
        i1 += i2;
      }
      for (;;)
      {
        ci.a(arrayOfByte2, i1, this.s, 0, this.s.length);
        arrayOfByte2[(i1 + this.s.length)] = 3;
        return arrayOfByte2;
        i1 = i2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ch
 * JD-Core Version:    0.7.0.1
 */