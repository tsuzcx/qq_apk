package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
@GwtIncompatible
public final class CountingOutputStream
  extends FilterOutputStream
{
  private long count;
  
  public CountingOutputStream(OutputStream paramOutputStream)
  {
    super((OutputStream)Preconditions.checkNotNull(paramOutputStream));
  }
  
  public void close()
    throws IOException
  {
    this.out.close();
  }
  
  public long getCount()
  {
    return this.count;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.out.write(paramInt);
    this.count += 1L;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.count += paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.CountingOutputStream
 * JD-Core Version:    0.7.0.1
 */