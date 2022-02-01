package com.tencent.token;

public class xi
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
  
  public xi() {}
  
  public xi(short paramShort, byte paramByte)
  {
    this.b = paramShort;
    this.i = paramByte;
    this.j = 0;
  }
  
  public final byte[] a()
  {
    Object localObject = this.l;
    int m;
    if ((localObject != null) && (localObject.length > 0)) {
      m = localObject.length;
    } else {
      m = 0;
    }
    this.a = ((short)(m + 41 + 1));
    localObject = new StringBuilder("socket req msg total len: ");
    ((StringBuilder)localObject).append(this.a);
    xv.a(((StringBuilder)localObject).toString());
    this.h = System.currentTimeMillis();
    short s = this.a;
    localObject = new byte[s];
    localObject[0] = 2;
    tl.a((byte[])localObject, 1, s);
    tl.a((byte[])localObject, 3, this.b);
    tl.a((byte[])localObject, 5, this.c);
    tl.a((byte[])localObject, 9, d);
    tl.a((byte[])localObject, 13, this.e);
    tl.a((byte[])localObject, 15, this.f);
    tl.a((byte[])localObject, 17, this.g);
    tl.a((byte[])localObject, 19, this.h);
    localObject[23] = this.i;
    localObject[24] = this.j;
    byte[] arrayOfByte = k;
    tl.a((byte[])localObject, 25, arrayOfByte, 0, arrayOfByte.length);
    int i1 = k.length + 25;
    int n = i1;
    if (m > 0)
    {
      tl.a((byte[])localObject, i1, this.l, 0, m);
      n = i1 + m;
    }
    localObject[n] = 3;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xi
 * JD-Core Version:    0.7.0.1
 */