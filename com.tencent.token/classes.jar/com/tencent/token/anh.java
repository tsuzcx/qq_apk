package com.tencent.token;

import javax.annotation.Nullable;

final class anh
{
  final byte[] a;
  int b;
  int c;
  boolean d;
  boolean e;
  anh f;
  anh g;
  
  anh()
  {
    this.a = new byte[8192];
    this.e = true;
    this.d = false;
  }
  
  anh(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = true;
    this.e = false;
  }
  
  final anh a()
  {
    this.d = true;
    return new anh(this.a, this.b, this.c);
  }
  
  public final anh a(anh paramanh)
  {
    paramanh.g = this;
    paramanh.f = this.f;
    this.f.g = paramanh;
    this.f = paramanh;
    return paramanh;
  }
  
  public final void a(anh paramanh, int paramInt)
  {
    if (paramanh.e)
    {
      int i = paramanh.c;
      if (i + paramInt > 8192) {
        if (!paramanh.d)
        {
          int j = paramanh.b;
          if (i + paramInt - j <= 8192)
          {
            byte[] arrayOfByte = paramanh.a;
            System.arraycopy(arrayOfByte, j, arrayOfByte, 0, i - j);
            paramanh.c -= paramanh.b;
            paramanh.b = 0;
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
      System.arraycopy(this.a, this.b, paramanh.a, paramanh.c, paramInt);
      paramanh.c += paramInt;
      this.b += paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  @Nullable
  public final anh b()
  {
    anh localanh1 = this.f;
    if (localanh1 == this) {
      localanh1 = null;
    }
    anh localanh2 = this.g;
    localanh2.f = this.f;
    this.f.g = localanh2;
    this.f = null;
    this.g = null;
    return localanh1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.anh
 * JD-Core Version:    0.7.0.1
 */