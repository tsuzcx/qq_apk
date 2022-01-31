package okio;

import java.io.IOException;

class b
  implements x
{
  b(a parama, x paramx) {}
  
  public z a()
  {
    return this.b;
  }
  
  public void a_(f paramf, long paramLong)
  {
    ab.a(paramf.b, 0L, paramLong);
    if (paramLong > 0L)
    {
      v localv = paramf.a;
      long l1 = 0L;
      for (;;)
      {
        for (;;)
        {
          long l2 = l1;
          if (l1 < 65536L)
          {
            l1 = localv.c - localv.b + l1;
            if (l1 >= paramLong) {
              l2 = paramLong;
            }
          }
          else
          {
            this.b.c();
          }
          try
          {
            this.a.a_(paramf, l2);
            paramLong -= l2;
            this.b.a(true);
            break;
          }
          catch (IOException paramf)
          {
            throw this.b.b(paramf);
          }
          finally
          {
            this.b.a(false);
          }
        }
        localv = localv.f;
      }
    }
  }
  
  public void close()
  {
    this.b.c();
    try
    {
      this.a.close();
      this.b.a(true);
      return;
    }
    catch (IOException localIOException)
    {
      throw this.b.b(localIOException);
    }
    finally
    {
      this.b.a(false);
    }
  }
  
  public void flush()
  {
    this.b.c();
    try
    {
      this.a.flush();
      this.b.a(true);
      return;
    }
    catch (IOException localIOException)
    {
      throw this.b.b(localIOException);
    }
    finally
    {
      this.b.a(false);
    }
  }
  
  public String toString()
  {
    return "AsyncTimeout.sink(" + this.a + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.b
 * JD-Core Version:    0.7.0.1
 */