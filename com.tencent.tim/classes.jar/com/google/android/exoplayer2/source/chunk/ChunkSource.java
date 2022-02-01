package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.SeekParameters;
import java.io.IOException;
import java.util.List;

public abstract interface ChunkSource
{
  public abstract long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters);
  
  public abstract void getNextChunk(MediaChunk paramMediaChunk, long paramLong1, long paramLong2, ChunkHolder paramChunkHolder);
  
  public abstract int getPreferredQueueSize(long paramLong, List<? extends MediaChunk> paramList);
  
  public abstract void maybeThrowError()
    throws IOException;
  
  public abstract void onChunkLoadCompleted(Chunk paramChunk);
  
  public abstract boolean onChunkLoadError(Chunk paramChunk, boolean paramBoolean, Exception paramException);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.ChunkSource
 * JD-Core Version:    0.7.0.1
 */