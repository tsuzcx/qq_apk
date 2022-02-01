package com.tencent.token;

import javax.annotation.Nullable;

final class all
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  all f;
  all g;
  
  all()
  {
    this.a = new byte[8192];
    this.e = true;
    this.d = false;
  }
  
  all(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = true;
    this.e = false;
  }
  
  final all a()
  {
    this.d = true;
    return new all(this.a, this.b, this.c);
  }
  
  public final all a(all paramall)
  {
    paramall.g = this;
    paramall.f = this.f;
    this.f.g = paramall;
    this.f = paramall;
    return paramall;
  }
  
  public final void a(all paramall, int paramInt)
  {
    if (paramall.e)
    {
      int i = paramall.c;
      if (i + paramInt > 8192) {
        if (!paramall.d)
        {
          int j = paramall.b;
          if (i + paramInt - j <= 8192)
          {
            byte[] arrayOfByte = paramall.a;
            System.arraycopy(arrayOfByte, j, arrayOfByte, 0, i - j);
            paramall.c -= paramall.b;
            paramall.b = 0;
          }
          else
          {
            throw new IllegalArgumentException();
          }
        }
        else
        {
          throw new IllegalArgumentException();
        }
      }
      System.arraycopy(this.a, this.b, paramall.a, paramall.c, paramInt);
      paramall.c += paramInt;
      this.b += paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  @Nullable
  public final all b()
  {
    all localall1 = this.f;
    if (localall1 == this) {
      localall1 = null;
    }
    all localall2 = this.g;
    localall2.f = this.f;
    this.f.g = localall2;
    this.f = null;
    this.g = null;
    return localall1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.all
 * JD-Core Version:    0.7.0.1
 */