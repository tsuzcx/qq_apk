package com.tencent.feedback.upload;

import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

final class c$a$1
  implements HttpRequestRetryHandler
{
  c$a$1(c.a parama) {}
  
  public final boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.c.a.1
 * JD-Core Version:    0.7.0.1
 */