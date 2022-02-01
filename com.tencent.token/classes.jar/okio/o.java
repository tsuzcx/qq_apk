package okio;

import javax.annotation.Nullable;

final class o
{
  @Nullable
  static n a;
  static long b;
  
  static n a()
  {
    try
    {
      if (a != null)
      {
        n localn = a;
        a = localn.f;
        localn.f = null;
        b -= 8192L;
        return localn;
      }
      return new n();
    }
    finally {}
  }
  
  static void a(n paramn)
  {
    if ((paramn.f != null) || (paramn.g != null)) {
      throw new IllegalArgumentException();
    }
    if (paramn.d) {
      return;
    }
    try
    {
      if (b + 8192L > 65536L) {
        return;
      }
    }
    finally {}
    b += 8192L;
    paramn.f = a;
    paramn.c = 0;
    paramn.b = 0;
    a = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.o
 * JD-Core Version:    0.7.0.1
 */