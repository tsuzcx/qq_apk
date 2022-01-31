package com.tencent.component.network.module.common.a;

public final class d
{
  private byte[] a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public d(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.b = 0;
    this.c = this.a.length;
    this.d = -1;
    this.e = -1;
  }
  
  private void c(int paramInt)
    throws j
  {
    if (paramInt > h()) {
      throw new j("end of input");
    }
  }
  
  private int h()
  {
    return this.c - this.b;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > this.a.length - this.b) {
      throw new IllegalArgumentException("cannot set active region past end of input");
    }
    this.c = (this.b + paramInt);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt)
    throws j
  {
    c(paramInt);
    System.arraycopy(this.a, this.b, paramArrayOfByte, 0, paramInt);
    this.b += paramInt;
  }
  
  public final void b()
  {
    this.d = this.b;
    this.e = this.c;
  }
  
  public final void b(int paramInt)
  {
    if (paramInt >= this.a.length) {
      throw new IllegalArgumentException("cannot jump past end of input");
    }
    this.b = paramInt;
    this.c = this.a.length;
  }
  
  public final void c()
  {
    if (this.d < 0) {
      throw new IllegalStateException("no previous state");
    }
    this.b = this.d;
    this.c = this.e;
    this.d = -1;
    this.e = -1;
  }
  
  public final int d()
    throws j
  {
    c(1);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public final int e()
    throws j
  {
    c(2);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.a;
    int j = this.b;
    this.b = (j + 1);
    return ((i & 0xFF) << 8) + (arrayOfByte[j] & 0xFF);
  }
  
  public final long f()
    throws j
  {
    c(4);
    byte[] arrayOfByte = this.a;
    int i = this.b;
    this.b = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.a;
    int j = this.b;
    this.b = (j + 1);
    j = arrayOfByte[j];
    arrayOfByte = this.a;
    int k = this.b;
    this.b = (k + 1);
    k = arrayOfByte[k];
    arrayOfByte = this.a;
    int m = this.b;
    this.b = (m + 1);
    m = arrayOfByte[m];
    long l = i & 0xFF;
    return ((j & 0xFF) << 16) + (l << 24) + ((k & 0xFF) << 8) + (m & 0xFF);
  }
  
  public final byte[] g()
  {
    int i = h();
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.a, this.b, arrayOfByte, 0, i);
    this.b = (i + this.b);
    this.c = (this.a.length - 1);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.d
 * JD-Core Version:    0.7.0.1
 */