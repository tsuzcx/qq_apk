package com.tencent.token.core.push;

import com.tencent.token.cj;
import com.tencent.token.global.g;

public class c
{
  public static long d;
  public static byte[] k = new byte[16];
  public short a;
  public short b;
  public long c;
  public short e;
  public short f;
  public short g;
  public long h;
  public byte i;
  public byte j;
  public byte[] l = null;
  
  public c() {}
  
  public c(short paramShort, byte paramByte1, byte paramByte2)
  {
    this.b = paramShort;
    this.i = paramByte1;
    this.j = paramByte2;
  }
  
  public byte[] a()
  {
    if ((this.l != null) && (this.l.length > 0)) {}
    for (int m = this.l.length;; m = 0)
    {
      this.a = ((short)(m + 41 + 1));
      g.a("socket req msg total len: " + this.a);
      this.h = System.currentTimeMillis();
      byte[] arrayOfByte = new byte[this.a];
      arrayOfByte[0] = 2;
      cj.a(arrayOfByte, 1, this.a);
      cj.a(arrayOfByte, 3, this.b);
      cj.a(arrayOfByte, 5, this.c);
      cj.a(arrayOfByte, 9, d);
      cj.a(arrayOfByte, 13, this.e);
      cj.a(arrayOfByte, 15, this.f);
      cj.a(arrayOfByte, 17, this.g);
      cj.a(arrayOfByte, 19, this.h);
      arrayOfByte[23] = this.i;
      arrayOfByte[24] = this.j;
      cj.a(arrayOfByte, 25, k, 0, k.length);
      int n = k.length + 25;
      if (m > 0)
      {
        cj.a(arrayOfByte, n, this.l, 0, m);
        m += n;
      }
      for (;;)
      {
        arrayOfByte[m] = 3;
        return arrayOfByte;
        m = n;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.c
 * JD-Core Version:    0.7.0.1
 */