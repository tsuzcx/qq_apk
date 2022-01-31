package okio;

import java.io.IOException;
import java.io.InputStream;

final class q
  implements y
{
  q(z paramz, InputStream paramInputStream) {}
  
  public long a(f paramf, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (paramLong == 0L) {
      return 0L;
    }
    try
    {
      this.a.g();
      v localv = paramf.e(1);
      int i = (int)Math.min(paramLong, 8192 - localv.c);
      i = this.b.read(localv.a, localv.c, i);
      if (i == -1) {
        return -1L;
      }
      localv.c += i;
      paramf.b += i;
      return i;
    }
    catch (AssertionError paramf)
    {
      if (o.a(paramf)) {
        throw new IOException(paramf);
      }
      throw paramf;
    }
  }
  
  public z a()
  {
    return this.a;
  }
  
  public void close()
  {
    this.b.close();
  }
  
  public String toString()
  {
    return "source(" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.q
 * JD-Core Version:    0.7.0.1
 */