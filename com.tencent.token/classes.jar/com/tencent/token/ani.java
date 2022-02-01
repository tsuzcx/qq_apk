package com.tencent.token;

import javax.annotation.Nullable;

final class ani
{
  @Nullable
  static anh a;
  static long b;
  
  static anh a()
  {
    try
    {
      if (a != null)
      {
        anh localanh = a;
        a = localanh.f;
        localanh.f = null;
        b -= 8192L;
        return localanh;
      }
      return new anh();
    }
    finally {}
  }
  
  static void a(anh paramanh)
  {
    if ((paramanh.f == null) && (paramanh.g == null))
    {
      if (paramanh.d) {
        return;
      }
      try
      {
        if (b + 8192L > 65536L) {
          return;
        }
        b += 8192L;
        paramanh.f = a;
        paramanh.c = 0;
        paramanh.b = 0;
        a = paramanh;
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ani
 * JD-Core Version:    0.7.0.1
 */