package moai.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DuplexStream
  extends FilterInputStream
{
  private final boolean autoClosedInput;
  private final OutputStream out;
  
  public DuplexStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean)
  {
    super(paramInputStream);
    this.out = paramOutputStream;
    this.autoClosedInput = paramBoolean;
  }
  
  public void close()
    throws IOException
  {
    if (this.autoClosedInput) {
      super.close();
    }
    this.out.close();
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    int i = this.in.read();
    this.out.write(i);
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    return i;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      throw new UnsupportedOperationException();
    }
    finally {}
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.DuplexStream
 * JD-Core Version:    0.7.0.1
 */