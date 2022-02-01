package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtIncompatible
final class MultiInputStream
  extends InputStream
{
  private InputStream in;
  private Iterator<? extends ByteSource> it;
  
  public MultiInputStream(Iterator<? extends ByteSource> paramIterator)
    throws IOException
  {
    this.it = ((Iterator)Preconditions.checkNotNull(paramIterator));
    advance();
  }
  
  private void advance()
    throws IOException
  {
    close();
    if (this.it.hasNext()) {
      this.in = ((ByteSource)this.it.next()).openStream();
    }
  }
  
  public int available()
    throws IOException
  {
    if (this.in == null) {
      return 0;
    }
    return this.in.available();
  }
  
  public void close()
    throws IOException
  {
    if (this.in != null) {}
    try
    {
      this.in.close();
      return;
    }
    finally
    {
      this.in = null;
    }
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    if (this.in == null) {
      return -1;
    }
    int i = this.in.read();
    if (i == -1)
    {
      advance();
      return read();
    }
    return i;
  }
  
  public int read(@Nullable byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.in == null) {
      return -1;
    }
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i == -1)
    {
      advance();
      return read(paramArrayOfByte, paramInt1, paramInt2);
    }
    return i;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    long l1;
    if ((this.in == null) || (paramLong <= 0L)) {
      l1 = 0L;
    }
    long l2;
    do
    {
      return l1;
      l2 = this.in.skip(paramLong);
      l1 = l2;
    } while (l2 != 0L);
    if (read() == -1) {
      return 0L;
    }
    return this.in.skip(paramLong - 1L) + 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.MultiInputStream
 * JD-Core Version:    0.7.0.1
 */