package okio;

import java.io.OutputStream;

final class p
  implements x
{
  p(z paramz, OutputStream paramOutputStream) {}
  
  public z a()
  {
    return this.a;
  }
  
  public void a_(f paramf, long paramLong)
  {
    ab.a(paramf.b, 0L, paramLong);
    while (paramLong > 0L)
    {
      this.a.g();
      v localv = paramf.a;
      int i = (int)Math.min(paramLong, localv.c - localv.b);
      this.b.write(localv.a, localv.b, i);
      localv.b += i;
      long l = paramLong - i;
      paramf.b -= i;
      paramLong = l;
      if (localv.b == localv.c)
      {
        paramf.a = localv.b();
        w.a(localv);
        paramLong = l;
      }
    }
  }
  
  public void close()
  {
    this.b.close();
  }
  
  public void flush()
  {
    this.b.flush();
  }
  
  public String toString()
  {
    return "sink(" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.p
 * JD-Core Version:    0.7.0.1
 */