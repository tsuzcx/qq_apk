package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;

public abstract class MediaChunk
  extends Chunk
{
  public final long chunkIndex;
  
  public MediaChunk(DataSource paramDataSource, DataSpec paramDataSpec, Format paramFormat, int paramInt, Object paramObject, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramDataSource, paramDataSpec, 1, paramFormat, paramInt, paramObject, paramLong1, paramLong2);
    Assertions.checkNotNull(paramFormat);
    this.chunkIndex = paramLong3;
  }
  
  public long getNextChunkIndex()
  {
    return this.chunkIndex + 1L;
  }
  
  public abstract boolean isLoadCompleted();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.MediaChunk
 * JD-Core Version:    0.7.0.1
 */