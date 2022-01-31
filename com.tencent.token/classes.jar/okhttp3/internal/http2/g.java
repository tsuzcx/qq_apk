package okhttp3.internal.http2;

import java.io.IOException;
import okio.k;
import okio.y;

class g
  extends k
{
  boolean a = false;
  long b = 0L;
  
  g(f paramf, y paramy)
  {
    super(paramy);
  }
  
  private void a(IOException paramIOException)
  {
    if (this.a) {
      return;
    }
    this.a = true;
    this.c.a.a(false, this.c, this.b, paramIOException);
  }
  
  public long a(okio.f paramf, long paramLong)
  {
    try
    {
      paramLong = b().a(paramf, paramLong);
      if (paramLong > 0L) {
        this.b += paramLong;
      }
      return paramLong;
    }
    catch (IOException paramf)
    {
      a(paramf);
      throw paramf;
    }
  }
  
  public void close()
  {
    super.close();
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.g
 * JD-Core Version:    0.7.0.1
 */