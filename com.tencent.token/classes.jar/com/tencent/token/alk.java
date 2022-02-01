package com.tencent.token;

import javax.annotation.Nullable;

final class alk
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  alk f;
  alk g;
  
  alk()
  {
    this.a = new byte[8192];
    this.e = true;
    this.d = false;
  }
  
  alk(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = true;
    this.e = false;
  }
  
  final alk a()
  {
    this.d = true;
    return new alk(this.a, this.b, this.c);
  }
  
  public final alk a(alk paramalk)
  {
    paramalk.g = this;
    paramalk.f = this.f;
    this.f.g = paramalk;
    this.f = paramalk;
    return paramalk;
  }
  
  public final void a(alk paramalk, int paramInt)
  {
    if (paramalk.e)
    {
      int i = paramalk.c;
      if (i + paramInt > 8192) {
        if (!paramalk.d)
        {
          int j = paramalk.b;
          if (i + paramInt - j <= 8192)
          {
            byte[] arrayOfByte = paramalk.a;
            System.arraycopy(arrayOfByte, j, arrayOfByte, 0, i - j);
            paramalk.c -= paramalk.b;
            paramalk.b = 0;
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
      System.arraycopy(this.a, this.b, paramalk.a, paramalk.c, paramInt);
      paramalk.c += paramInt;
      this.b += paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  @Nullable
  public final alk b()
  {
    alk localalk1 = this.f;
    if (localalk1 == this) {
      localalk1 = null;
    }
    alk localalk2 = this.g;
    localalk2.f = this.f;
    this.f.g = localalk2;
    this.f = null;
    this.g = null;
    return localalk1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alk
 * JD-Core Version:    0.7.0.1
 */