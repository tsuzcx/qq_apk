package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

public abstract class DataChunk
  extends Chunk
{
  private static final int READ_GRANULARITY = 16384;
  private byte[] data;
  private int limit;
  private volatile boolean loadCanceled;
  
  public DataChunk(DataSource paramDataSource, DataSpec paramDataSpec, int paramInt1, Format paramFormat, int paramInt2, Object paramObject, byte[] paramArrayOfByte)
  {
    super(paramDataSource, paramDataSpec, paramInt1, paramFormat, paramInt2, paramObject, -9223372036854775807L, -9223372036854775807L);
    this.data = paramArrayOfByte;
  }
  
  private void maybeExpandData()
  {
    if (this.data == null) {
      this.data = new byte[16384];
    }
    while (this.data.length >= this.limit + 16384) {
      return;
    }
    this.data = Arrays.copyOf(this.data, this.data.length + 16384);
  }
  
  public long bytesLoaded()
  {
    return this.limit;
  }
  
  public final void cancelLoad()
  {
    this.loadCanceled = true;
  }
  
  protected abstract void consume(byte[] paramArrayOfByte, int paramInt)
    throws IOException;
  
  public byte[] getDataHolder()
  {
    return this.data;
  }
  
  public final boolean isLoadCanceled()
  {
    return this.loadCanceled;
  }
  
  public final void load()
    throws IOException, InterruptedException
  {
    int i = 0;
    try
    {
      this.dataSource.open(this.dataSpec);
      this.limit = 0;
      while ((i != -1) && (!this.loadCanceled))
      {
        maybeExpandData();
        int j = this.dataSource.read(this.data, this.limit, 16384);
        i = j;
        if (j != -1)
        {
          this.limit += j;
          i = j;
        }
      }
      if (this.loadCanceled) {
        break label109;
      }
    }
    finally
    {
      Util.closeQuietly(this.dataSource);
    }
    consume(this.data, this.limit);
    label109:
    Util.closeQuietly(this.dataSource);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.DataChunk
 * JD-Core Version:    0.7.0.1
 */