package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.Sink;

public abstract interface HttpStream
{
  public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;
  
  public abstract void cancel();
  
  public abstract Sink createRequestBody(Request paramRequest, long paramLong)
    throws IOException;
  
  public abstract void finishRequest()
    throws IOException;
  
  public abstract ResponseBody openResponseBody(Response paramResponse)
    throws IOException;
  
  public abstract Response.Builder readResponseHeaders()
    throws IOException;
  
  public abstract void setHttpEngine(HttpEngine paramHttpEngine);
  
  public abstract void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException;
  
  public abstract void writeRequestHeaders(Request paramRequest)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpStream
 * JD-Core Version:    0.7.0.1
 */