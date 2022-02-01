package com.tencent.turingfd.sdk.qps;

import com.tencent.token.agd;
import com.tencent.token.age;

public final class goto
  extends final
{
  public static byte[] a;
  public static else b = new else();
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public byte[] h = null;
  public else i = null;
  public int j = 0;
  
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
    this.f = paramagd.a(this.f, 3, false);
    this.g = paramagd.a(this.g, 4, false);
    this.h = paramagd.b(5, false);
    this.i = ((else)paramagd.a(b, 6, false));
    this.j = paramagd.a(this.j, 7, false);
  }
  
  public final void a(age paramage)
  {
    paramage.a(this.c, 0);
    int k = this.d;
    if (k != 0) {
      paramage.a(k, 1);
    }
    k = this.e;
    if (k != 0) {
      paramage.a(k, 2);
    }
    paramage.a(this.f, 3);
    k = this.g;
    if (k != 0) {
      paramage.a(k, 4);
    }
    Object localObject = this.h;
    if (localObject != null) {
      paramage.a((byte[])localObject, 5);
    }
    localObject = this.i;
    if (localObject != null) {
      paramage.a((final)localObject, 6);
    }
    k = this.j;
    if (k != 0) {
      paramage.a(k, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.goto
 * JD-Core Version:    0.7.0.1
 */