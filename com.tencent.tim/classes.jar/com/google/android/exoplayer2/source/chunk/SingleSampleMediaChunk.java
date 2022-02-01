package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class SingleSampleMediaChunk
  extends BaseMediaChunk
{
  private volatile int bytesLoaded;
  private volatile boolean loadCanceled;
  private volatile boolean loadCompleted;
  private final Format sampleFormat;
  private final int trackType;
  
  public SingleSampleMediaChunk(DataSource paramDataSource, DataSpec paramDataSpec, Format paramFormat1, int paramInt1, Object paramObject, long paramLong1, long paramLong2, long paramLong3, int paramInt2, Format paramFormat2)
  {
    super(paramDataSource, paramDataSpec, paramFormat1, paramInt1, paramObject, paramLong1, paramLong2, paramLong3);
    this.trackType = paramInt2;
    this.sampleFormat = paramFormat2;
  }
  
  public long bytesLoaded()
  {
    return this.bytesLoaded;
  }
  
  public void cancelLoad()
  {
    this.loadCanceled = true;
  }
  
  public boolean isLoadCanceled()
  {
    return this.loadCanceled;
  }
  
  public boolean isLoadCompleted()
  {
    return this.loadCompleted;
  }
  
  public void load()
    throws IOException, InterruptedException
  {
    Object localObject1 = this.dataSpec.subrange(this.bytesLoaded);
    try
    {
      long l2 = this.dataSource.open((DataSpec)localObject1);
      long l1 = l2;
      if (l2 != -1L) {
        l1 = l2 + this.bytesLoaded;
      }
      localObject1 = new DefaultExtractorInput(this.dataSource, this.bytesLoaded, l1);
      Object localObject3 = getOutput();
      ((BaseMediaChunkOutput)localObject3).setSampleOffsetUs(0L);
      localObject3 = ((BaseMediaChunkOutput)localObject3).track(0, this.trackType);
      ((TrackOutput)localObject3).format(this.sampleFormat);
      for (int i = 0; i != -1; i = ((TrackOutput)localObject3).sampleData((ExtractorInput)localObject1, 2147483647, true)) {
        this.bytesLoaded = (i + this.bytesLoaded);
      }
      i = this.bytesLoaded;
      ((TrackOutput)localObject3).sampleMetadata(this.startTimeUs, 1, i, 0, null);
      Util.closeQuietly(this.dataSource);
      this.loadCompleted = true;
      return;
    }
    finally
    {
      Util.closeQuietly(this.dataSource);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk
 * JD-Core Version:    0.7.0.1
 */