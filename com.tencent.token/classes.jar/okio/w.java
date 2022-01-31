package okio;

import javax.annotation.Nullable;

final class w
{
  @Nullable
  static v a;
  static long b;
  
  static v a()
  {
    try
    {
      if (a != null)
      {
        v localv = a;
        a = localv.f;
        localv.f = null;
        b -= 8192L;
        return localv;
      }
      return new v();
    }
    finally {}
  }
  
  static void a(v paramv)
  {
    if ((paramv.f != null) || (paramv.g != null)) {
      throw new IllegalArgumentException();
    }
    if (paramv.d) {
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
    paramv.f = a;
    paramv.c = 0;
    paramv.b = 0;
    a = paramv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.w
 * JD-Core Version:    0.7.0.1
 */