package okhttp3.internal.huc;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okio.BufferedSink;

class OutputStreamRequestBody$1
  extends OutputStream
{
  private long bytesReceived;
  
  OutputStreamRequestBody$1(OutputStreamRequestBody paramOutputStreamRequestBody, long paramLong, BufferedSink paramBufferedSink) {}
  
  public void close()
    throws IOException
  {
    this.this$0.closed = true;
    if ((this.val$expectedContentLength != -1L) && (this.bytesReceived < this.val$expectedContentLength)) {
      throw new ProtocolException("expected " + this.val$expectedContentLength + " bytes but received " + this.bytesReceived);
    }
    this.val$sink.close();
  }
  
  public void flush()
    throws IOException
  {
    if (this.this$0.closed) {
      return;
    }
    this.val$sink.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    write(new byte[] { (byte)paramInt }, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.this$0.closed) {
      throw new IOException("closed");
    }
    if ((this.val$expectedContentLength != -1L) && (this.bytesReceived + paramInt2 > this.val$expectedContentLength)) {
      throw new ProtocolException("expected " + this.val$expectedContentLength + " bytes but received " + this.bytesReceived + paramInt2);
    }
    this.bytesReceived += paramInt2;
    try
    {
      this.val$sink.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (InterruptedIOException paramArrayOfByte)
    {
      throw new SocketTimeoutException(paramArrayOfByte.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.huc.OutputStreamRequestBody.1
 * JD-Core Version:    0.7.0.1
 */