package org.apache.commons.io.input;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class NullInputStream
  extends InputStream
{
  private boolean eof;
  private long mark = -1L;
  private final boolean markSupported;
  private long position;
  private long readlimit;
  private final long size;
  private final boolean throwEofException;
  
  public NullInputStream(long paramLong)
  {
    this(paramLong, true, false);
  }
  
  public NullInputStream(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.size = paramLong;
    this.markSupported = paramBoolean1;
    this.throwEofException = paramBoolean2;
  }
  
  private int doEndOfFile()
    throws EOFException
  {
    this.eof = true;
    if (this.throwEofException) {
      throw new EOFException();
    }
    return -1;
  }
  
  public int available()
  {
    long l = this.size - this.position;
    if (l <= 0L) {
      return 0;
    }
    if (l > 2147483647L) {
      return 2147483647;
    }
    return (int)l;
  }
  
  public void close()
    throws IOException
  {
    this.eof = false;
    this.position = 0L;
    this.mark = -1L;
  }
  
  public long getPosition()
  {
    return this.position;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      if (!this.markSupported) {
        throw new UnsupportedOperationException("Mark not supported");
      }
    }
    finally {}
    this.mark = this.position;
    this.readlimit = paramInt;
  }
  
  public boolean markSupported()
  {
    return this.markSupported;
  }
  
  protected int processByte()
  {
    return 0;
  }
  
  protected void processBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public int read()
    throws IOException
  {
    if (this.eof) {
      throw new IOException("Read after end of file");
    }
    if (this.position == this.size) {
      return doEndOfFile();
    }
    this.position += 1L;
    return processByte();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.eof) {
      throw new IOException("Read after end of file");
    }
    if (this.position == this.size) {
      return doEndOfFile();
    }
    this.position += paramInt2;
    int i = paramInt2;
    if (this.position > this.size)
    {
      i = paramInt2 - (int)(this.position - this.size);
      this.position = this.size;
    }
    processBytes(paramArrayOfByte, paramInt1, i);
    return i;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      if (!this.markSupported) {
        throw new UnsupportedOperationException("Mark not supported");
      }
    }
    finally {}
    if (this.mark < 0L) {
      throw new IOException("No position has been marked");
    }
    if (this.position > this.mark + this.readlimit) {
      throw new IOException("Marked position [" + this.mark + "] is no longer valid - passed the read limit [" + this.readlimit + "]");
    }
    this.position = this.mark;
    this.eof = false;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    if (this.eof) {
      throw new IOException("Skip after end of file");
    }
    if (this.position == this.size) {
      l1 = doEndOfFile();
    }
    do
    {
      return l1;
      this.position += paramLong;
      l1 = paramLong;
    } while (this.position <= this.size);
    long l1 = this.position;
    long l2 = this.size;
    this.position = this.size;
    return paramLong - (l1 - l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.NullInputStream
 * JD-Core Version:    0.7.0.1
 */