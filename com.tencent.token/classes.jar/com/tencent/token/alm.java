package com.tencent.token;

import javax.annotation.Nullable;

final class alm
{
  @Nullable
  static all a;
  static long b;
  
  static all a()
  {
    try
    {
      if (a != null)
      {
        all localall = a;
        a = localall.f;
        localall.f = null;
        b -= 8192L;
        return localall;
      }
      return new all();
    }
    finally {}
  }
  
  static void a(all paramall)
  {
    if ((paramall.f == null) && (paramall.g == null))
    {
      if (paramall.d) {
        return;
      }
      try
      {
        if (b + 8192L > 65536L) {
          return;
        }
        b += 8192L;
        paramall.f = a;
        paramall.c = 0;
        paramall.b = 0;
        a = paramall;
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alm
 * JD-Core Version:    0.7.0.1
 */