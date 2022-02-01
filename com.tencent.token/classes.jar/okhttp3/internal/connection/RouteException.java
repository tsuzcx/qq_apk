package okhttp3.internal.connection;

import com.tencent.token.ff;
import java.io.IOException;

public final class RouteException
  extends RuntimeException
{
  private IOException firstException;
  private IOException lastException;
  
  public RouteException(IOException paramIOException)
  {
    super(paramIOException);
    this.firstException = paramIOException;
    this.lastException = paramIOException;
  }
  
  public IOException a()
  {
    return this.firstException;
  }
  
  public void a(IOException paramIOException)
  {
    ff.a(this.firstException, paramIOException);
    this.lastException = paramIOException;
  }
  
  public IOException b()
  {
    return this.lastException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.connection.RouteException
 * JD-Core Version:    0.7.0.1
 */