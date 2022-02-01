package okhttp3.internal.huc;

import java.io.IOException;
import java.io.OutputStream;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okio.Buffer;
import okio.BufferedSink;

final class BufferedRequestBody
  extends OutputStreamRequestBody
{
  final Buffer buffer = new Buffer();
  long contentLength = -1L;
  
  BufferedRequestBody(long paramLong)
  {
    initOutputStream(this.buffer, paramLong);
  }
  
  public long contentLength()
    throws IOException
  {
    return this.contentLength;
  }
  
  public Request prepareToSendRequest(Request paramRequest)
    throws IOException
  {
    if (paramRequest.header("Content-Length") != null) {
      return paramRequest;
    }
    outputStream().close();
    this.contentLength = this.buffer.size();
    return paramRequest.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", Long.toString(this.buffer.size())).build();
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    this.buffer.copyTo(paramBufferedSink.buffer(), 0L, this.buffer.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.huc.BufferedRequestBody
 * JD-Core Version:    0.7.0.1
 */