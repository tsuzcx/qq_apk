package com.tencent.token.core.push;

import com.tencent.token.ck;
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
    Object localObject = this.l;
    int m;
    if ((localObject != null) && (localObject.length > 0)) {
      m = localObject.length;
    } else {
      m = 0;
    }
    this.a = ((short)(m + 41 + 1));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("socket req msg total len: ");
    ((StringBuilder)localObject).append(this.a);
    g.a(((StringBuilder)localObject).toString());
    this.h = System.currentTimeMillis();
    short s = this.a;
    localObject = new byte[s];
    localObject[0] = 2;
    ck.a((byte[])localObject, 1, s);
    ck.a((byte[])localObject, 3, this.b);
    ck.a((byte[])localObject, 5, this.c);
    ck.a((byte[])localObject, 9, d);
    ck.a((byte[])localObject, 13, this.e);
    ck.a((byte[])localObject, 15, this.f);
    ck.a((byte[])localObject, 17, this.g);
    ck.a((byte[])localObject, 19, this.h);
    localObject[23] = this.i;
    localObject[24] = this.j;
    byte[] arrayOfByte = k;
    ck.a((byte[])localObject, 25, arrayOfByte, 0, arrayOfByte.length);
    int i1 = 25 + k.length;
    int n = i1;
    if (m > 0)
    {
      ck.a((byte[])localObject, i1, this.l, 0, m);
      n = i1 + m;
    }
    localObject[n] = 3;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.push.c
 * JD-Core Version:    0.7.0.1
 */