package okio;

import java.io.IOException;

class c
  implements y
{
  c(a parama, y paramy) {}
  
  public long a(f paramf, long paramLong)
  {
    this.b.c();
    try
    {
      paramLong = this.a.a(paramf, paramLong);
      this.b.a(true);
      return paramLong;
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
  
  public z a()
  {
    return this.b;
  }
  
  public void close()
  {
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
  
  public String toString()
  {
    return "AsyncTimeout.source(" + this.a + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.c
 * JD-Core Version:    0.7.0.1
 */