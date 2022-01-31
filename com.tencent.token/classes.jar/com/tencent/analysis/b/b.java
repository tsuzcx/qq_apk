package com.tencent.analysis.b;

import java.io.IOException;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

final class b
  implements HttpRequestRetryHandler
{
  public final boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    if (paramInt >= 3) {}
    do
    {
      return false;
      if ((paramIOException instanceof NoHttpResponseException)) {
        return true;
      }
    } while (!(paramIOException instanceof SSLHandshakeException));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.b.b
 * JD-Core Version:    0.7.0.1
 */