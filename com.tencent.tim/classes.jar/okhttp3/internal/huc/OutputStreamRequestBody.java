package okhttp3.internal.huc;

import java.io.IOException;
import java.io.OutputStream;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Timeout;

abstract class OutputStreamRequestBody
  extends RequestBody
{
  boolean closed;
  private long expectedContentLength;
  private OutputStream outputStream;
  private Timeout timeout;
  
  public long contentLength()
    throws IOException
  {
    return this.expectedContentLength;
  }
  
  public final MediaType contentType()
  {
    return null;
  }
  
  protected void initOutputStream(BufferedSink paramBufferedSink, long paramLong)
  {
    this.timeout = paramBufferedSink.timeout();
    this.expectedContentLength = paramLong;
    this.outputStream = new OutputStreamRequestBody.1(this, paramLong, paramBufferedSink);
  }
  
  public final boolean isClosed()
  {
    return this.closed;
  }
  
  public final OutputStream outputStream()
  {
    return this.outputStream;
  }
  
  public Request prepareToSendRequest(Request paramRequest)
    throws IOException
  {
    return paramRequest;
  }
  
  public final Timeout timeout()
  {
    return this.timeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.huc.OutputStreamRequestBody
 * JD-Core Version:    0.7.0.1
 */