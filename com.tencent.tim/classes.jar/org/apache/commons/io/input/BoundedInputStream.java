package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class BoundedInputStream
  extends InputStream
{
  private final InputStream in;
  private long mark = -1L;
  private final long max;
  private long pos = 0L;
  private boolean propagateClose = true;
  
  public BoundedInputStream(InputStream paramInputStream)
  {
    this(paramInputStream, -1L);
  }
  
  public BoundedInputStream(InputStream paramInputStream, long paramLong)
  {
    this.max = paramLong;
    this.in = paramInputStream;
  }
  
  public int available()
    throws IOException
  {
    if ((this.max >= 0L) && (this.pos >= this.max)) {
      return 0;
    }
    return this.in.available();
  }
  
  public void close()
    throws IOException
  {
    if (this.propagateClose) {
      this.in.close();
    }
  }
  
  public boolean isPropagateClose()
  {
    return this.propagateClose;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      this.in.mark(paramInt);
      this.mark = this.pos;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return this.in.markSupported();
  }
  
  public int read()
    throws IOException
  {
    if ((this.max >= 0L) && (this.pos >= this.max)) {
      return -1;
    }
    int i = this.in.read();
    this.pos += 1L;
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((this.max >= 0L) && (this.pos >= this.max)) {
      return -1;
    }
    if (this.max >= 0L) {}
    for (long l = Math.min(paramInt2, this.max - this.pos);; l = paramInt2)
    {
      paramInt1 = this.in.read(paramArrayOfByte, paramInt1, (int)l);
      if (paramInt1 != -1) {
        break;
      }
      return -1;
    }
    this.pos += paramInt1;
    return paramInt1;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      this.in.reset();
      this.pos = this.mark;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setPropagateClose(boolean paramBoolean)
  {
    this.propagateClose = paramBoolean;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    long l = paramLong;
    if (this.max >= 0L) {
      l = Math.min(paramLong, this.max - this.pos);
    }
    paramLong = this.in.skip(l);
    this.pos += paramLong;
    return paramLong;
  }
  
  public String toString()
  {
    return this.in.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.BoundedInputStream
 * JD-Core Version:    0.7.0.1
 */