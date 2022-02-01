package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.proxy.FileType;
import java.io.IOException;

public abstract interface DataSource
{
  public abstract long available();
  
  public abstract void close()
    throws IOException;
  
  public abstract FileType getFileType();
  
  public abstract String getLogTag();
  
  public abstract long getTotalLength();
  
  public abstract long open(DataSpec paramDataSpec)
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void setLogTag(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DataSource
 * JD-Core Version:    0.7.0.1
 */