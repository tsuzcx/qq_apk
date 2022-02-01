package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;

public final class new
  extends final
{
  public static byte[] a;
  public static for b = new for();
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public byte[] f = null;
  public long g = 0L;
  public int h = 0;
  public int i = 0;
  public for j = null;
  public int k = 0;
  
  static
  {
    byte[] arrayOfByte = new byte[1];
    a = arrayOfByte;
    arrayOfByte[0] = 0;
  }
  
  public final void a(agd paramagd)
  {
    this.c = paramagd.a(this.c, 0, true);
    this.d = paramagd.a(this.d, 1, false);
    this.e = paramagd.a(this.e, 2, false);
    this.f = paramagd.b(3, false);
    this.g = paramagd.a(this.g, 4, false);
    this.h = paramagd.a(this.h, 5, false);
    this.i = paramagd.a(this.i, 6, false);
    this.j = ((for)paramagd.a(b, 7, false));
    this.k = paramagd.a(this.k, 8, false);
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.c, 0);
    int m = this.d;
    if (m != 0) {
      paramage.a(m, 1);
    }
    m = this.e;
    if (m != 0) {
      paramage.a(m, 2);
    }
    Object localObject = this.f;
    if (localObject != null) {
      paramage.a((byte[])localObject, 3);
    }
    long l = this.g;
    if (l != 0L) {
      paramage.a(l, 4);
    }
    m = this.h;
    if (m != 0) {
      paramage.a(m, 5);
    }
    m = this.i;
    if (m != 0) {
      paramage.a(m, 6);
    }
    localObject = this.j;
    if (localObject != null) {
      paramage.a((final)localObject, 7);
    }
    m = this.k;
    if (m != 0) {
      paramage.a(m, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.new
 * JD-Core Version:    0.7.0.1
 */