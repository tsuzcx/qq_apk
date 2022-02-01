package com.tencent.component.network.downloader.impl.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class ExGZIPInputStream
  extends GZIPInputStream
{
  protected long realReadLen = 0L;
  
  public ExGZIPInputStream(InputStream paramInputStream)
    throws IOException
  {
    super(paramInputStream);
  }
  
  public ExGZIPInputStream(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    super(paramInputStream, paramInt);
  }
  
  protected void fill()
    throws IOException
  {
    super.fill();
    this.realReadLen += this.len;
  }
  
  public long getRealReadLen()
  {
    return this.realReadLen + 10L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.strategy.ExGZIPInputStream
 * JD-Core Version:    0.7.0.1
 */