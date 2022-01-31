package okhttp3.internal.http2;

import java.io.IOException;
import java.net.SocketTimeoutException;
import okio.a;

class ac
  extends a
{
  ac(z paramz) {}
  
  protected IOException a(IOException paramIOException)
  {
    SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
    if (paramIOException != null) {
      localSocketTimeoutException.initCause(paramIOException);
    }
    return localSocketTimeoutException;
  }
  
  protected void a()
  {
    this.a.b(ErrorCode.CANCEL);
  }
  
  public void b()
  {
    if (b_()) {
      throw a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.ac
 * JD-Core Version:    0.7.0.1
 */