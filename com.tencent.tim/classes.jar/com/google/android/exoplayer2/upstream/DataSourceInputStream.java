package com.google.android.exoplayer2.upstream;

import android.support.annotation.NonNull;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.io.InputStream;

public final class DataSourceInputStream
  extends InputStream
{
  private boolean closed = false;
  private final DataSource dataSource;
  private final DataSpec dataSpec;
  private boolean opened = false;
  private final byte[] singleByteArray;
  private long totalBytesRead;
  
  public DataSourceInputStream(DataSource paramDataSource, DataSpec paramDataSpec)
  {
    this.dataSource = paramDataSource;
    this.dataSpec = paramDataSpec;
    this.singleByteArray = new byte[1];
  }
  
  private void checkOpened()
    throws IOException
  {
    if (!this.opened)
    {
      this.dataSource.open(this.dataSpec);
      this.opened = true;
    }
  }
  
  public long bytesRead()
  {
    return this.totalBytesRead;
  }
  
  public void close()
    throws IOException
  {
    if (!this.closed)
    {
      this.dataSource.close();
      this.closed = true;
    }
  }
  
  public void open()
    throws IOException
  {
    checkOpened();
  }
  
  public int read()
    throws IOException
  {
    if (read(this.singleByteArray) == -1) {
      return -1;
    }
    return this.singleByteArray[0] & 0xFF;
  }
  
  public int read(@NonNull byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!this.closed) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      checkOpened();
      paramInt1 = this.dataSource.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        break;
      }
      return -1;
    }
    this.totalBytesRead += paramInt1;
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DataSourceInputStream
 * JD-Core Version:    0.7.0.1
 */