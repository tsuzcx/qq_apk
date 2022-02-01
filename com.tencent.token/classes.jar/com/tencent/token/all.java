package com.tencent.token;

import javax.annotation.Nullable;

final class all
{
  @Nullable
  static alk a;
  static long b;
  
  static alk a()
  {
    try
    {
      if (a != null)
      {
        alk localalk = a;
        a = localalk.f;
        localalk.f = null;
        b -= 8192L;
        return localalk;
      }
      return new alk();
    }
    finally {}
  }
  
  static void a(alk paramalk)
  {
    if ((paramalk.f == null) && (paramalk.g == null))
    {
      if (paramalk.d) {
        return;
      }
      try
      {
        if (b + 8192L > 65536L) {
          return;
        }
        b += 8192L;
        paramalk.f = a;
        paramalk.c = 0;
        paramalk.b = 0;
        a = paramalk;
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.all
 * JD-Core Version:    0.7.0.1
 */