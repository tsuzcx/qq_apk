package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

final class DiskLruCache$4
  implements Sink
{
  public void close()
    throws IOException
  {}
  
  public void flush()
    throws IOException
  {}
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    paramBuffer.skip(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.DiskLruCache.4
 * JD-Core Version:    0.7.0.1
 */