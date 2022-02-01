package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;

public final class DummyDataSource
  implements DataSource
{
  public static final DataSource.Factory FACTORY = new DummyDataSource.1();
  public static final DummyDataSource INSTANCE = new DummyDataSource();
  
  public void close()
    throws IOException
  {}
  
  public Uri getUri()
  {
    return null;
  }
  
  public long open(DataSpec paramDataSpec)
    throws IOException
  {
    throw new IOException("Dummy source");
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DummyDataSource
 * JD-Core Version:    0.7.0.1
 */