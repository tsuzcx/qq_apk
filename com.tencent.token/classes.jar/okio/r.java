package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class r
  extends a
{
  r(Socket paramSocket) {}
  
  protected IOException a(@Nullable IOException paramIOException)
  {
    SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
    if (paramIOException != null) {
      localSocketTimeoutException.initCause(paramIOException);
    }
    return localSocketTimeoutException;
  }
  
  protected void a()
  {
    try
    {
      this.a.close();
      return;
    }
    catch (Exception localException)
    {
      o.a.log(Level.WARNING, "Failed to close timed out socket " + this.a, localException);
      return;
    }
    catch (AssertionError localAssertionError)
    {
      if (o.a(localAssertionError))
      {
        o.a.log(Level.WARNING, "Failed to close timed out socket " + this.a, localAssertionError);
        return;
      }
      throw localAssertionError;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.r
 * JD-Core Version:    0.7.0.1
 */