package com.tencent.token;

import javax.annotation.Nullable;

final class aof
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  aof f;
  aof g;
  
  aof()
  {
    this.a = new byte[8192];
    this.e = true;
    this.d = false;
  }
  
  aof(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = true;
    this.e = false;
  }
  
  final aof a()
  {
    this.d = true;
    return new aof(this.a, this.b, this.c);
  }
  
  public final aof a(aof paramaof)
  {
    paramaof.g = this;
    paramaof.f = this.f;
    this.f.g = paramaof;
    this.f = paramaof;
    return paramaof;
  }
  
  public final void a(aof paramaof, int paramInt)
  {
    if (paramaof.e)
    {
      int i = paramaof.c;
      if (i + paramInt > 8192) {
        if (!paramaof.d)
        {
          int j = paramaof.b;
          if (i + paramInt - j <= 8192)
          {
            byte[] arrayOfByte = paramaof.a;
            System.arraycopy(arrayOfByte, j, arrayOfByte, 0, i - j);
            paramaof.c -= paramaof.b;
            paramaof.b = 0;
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
      System.arraycopy(this.a, this.b, paramaof.a, paramaof.c, paramInt);
      paramaof.c += paramInt;
      this.b += paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  @Nullable
  public final aof b()
  {
    aof localaof1 = this.f;
    if (localaof1 == this) {
      localaof1 = null;
    }
    aof localaof2 = this.g;
    localaof2.f = this.f;
    this.f.g = localaof2;
    this.f = null;
    this.g = null;
    return localaof1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aof
 * JD-Core Version:    0.7.0.1
 */