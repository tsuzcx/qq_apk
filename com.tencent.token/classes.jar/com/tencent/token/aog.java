package com.tencent.token;

import javax.annotation.Nullable;

final class aog
{
  @Nullable
  static aof a;
  static long b;
  
  static aof a()
  {
    try
    {
      if (a != null)
      {
        aof localaof = a;
        a = localaof.f;
        localaof.f = null;
        b -= 8192L;
        return localaof;
      }
      return new aof();
    }
    finally {}
  }
  
  static void a(aof paramaof)
  {
    if ((paramaof.f == null) && (paramaof.g == null))
    {
      if (paramaof.d) {
        return;
      }
      try
      {
        if (b + 8192L > 65536L) {
          return;
        }
        b += 8192L;
        paramaof.f = a;
        paramaof.c = 0;
        paramaof.b = 0;
        a = paramaof;
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aog
 * JD-Core Version:    0.7.0.1
 */