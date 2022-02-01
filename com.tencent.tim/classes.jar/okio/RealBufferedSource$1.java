package okio;

import java.io.IOException;
import java.io.InputStream;

class RealBufferedSource$1
  extends InputStream
{
  RealBufferedSource$1(RealBufferedSource paramRealBufferedSource) {}
  
  public int available()
    throws IOException
  {
    if (this.this$0.closed) {
      throw new IOException("closed");
    }
    return (int)Math.min(this.this$0.buffer.size, 2147483647L);
  }
  
  public void close()
    throws IOException
  {
    this.this$0.close();
  }
  
  public int read()
    throws IOException
  {
    if (this.this$0.closed) {
      throw new IOException("closed");
    }
    if ((this.this$0.buffer.size == 0L) && (this.this$0.source.read(this.this$0.buffer, 8192L) == -1L)) {
      return -1;
    }
    return this.this$0.buffer.readByte() & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.this$0.closed) {
      throw new IOException("closed");
    }
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    if ((this.this$0.buffer.size == 0L) && (this.this$0.source.read(this.this$0.buffer, 8192L) == -1L)) {
      return -1;
    }
    return this.this$0.buffer.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return this.this$0 + ".inputStream()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.RealBufferedSource.1
 * JD-Core Version:    0.7.0.1
 */