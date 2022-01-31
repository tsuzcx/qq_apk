package com.tencent.token.core.push;

import com.tencent.token.ap;
import com.tencent.token.global.e;

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
  
  public c(short paramShort, byte paramByte)
  {
    this.b = paramShort;
    this.i = paramByte;
    this.j = 0;
  }
  
  public final byte[] a()
  {
    if ((this.l != null) && (this.l.length > 0)) {}
    for (int m = this.l.length;; m = 0)
    {
      this.a = ((short)(m + 41 + 1));
      e.a("socket req msg total len: " + this.a);
      this.h = System.currentTimeMillis();
      byte[] arrayOfByte = new byte[this.a];
      arrayOfByte[0] = 2;
      int n = this.a;
      arrayOfByte[1] = ((byte)(n >> 8));
      arrayOfByte[2] = ((byte)n);
      n = this.b;
      arrayOfByte[3] = ((byte)(n >> 8));
      arrayOfByte[4] = ((byte)n);
      ap.a(arrayOfByte, 5, this.c);
      ap.a(arrayOfByte, 9, d);
      n = this.e;
      arrayOfByte[13] = ((byte)(n >> 8));
      arrayOfByte[14] = ((byte)n);
      n = this.f;
      arrayOfByte[15] = ((byte)(n >> 8));
      arrayOfByte[16] = ((byte)n);
      n = this.g;
      arrayOfByte[17] = ((byte)(n >> 8));
      arrayOfByte[18] = ((byte)n);
      ap.a(arrayOfByte, 19, this.h);
      arrayOfByte[23] = this.i;
      arrayOfByte[24] = this.j;
      System.arraycopy(k, 0, arrayOfByte, 25, k.length);
      n = k.length + 25;
      if (m > 0)
      {
        System.arraycopy(this.l, 0, arrayOfByte, n, m);
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