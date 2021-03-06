package okio;

import java.io.IOException;
import java.io.OutputStream;

class RealBufferedSink$1
  extends OutputStream
{
  RealBufferedSink$1(RealBufferedSink paramRealBufferedSink) {}
  
  public void close()
    throws IOException
  {
    this.this$0.close();
  }
  
  public void flush()
    throws IOException
  {
    if (!this.this$0.closed) {
      this.this$0.flush();
    }
  }
  
  public String toString()
  {
    return this.this$0 + ".outputStream()";
  }
  
  public void write(int paramInt)
    throws IOException
  {
    if (this.this$0.closed) {
      throw new IOException("closed");
    }
    this.this$0.buffer.writeByte((byte)paramInt);
    this.this$0.emitCompleteSegments();
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.this$0.closed) {
      throw new IOException("closed");
    }
    this.this$0.buffer.write(paramArrayOfByte, paramInt1, paramInt2);
    this.this$0.emitCompleteSegments();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.RealBufferedSink.1
 * JD-Core Version:    0.7.0.1
 */