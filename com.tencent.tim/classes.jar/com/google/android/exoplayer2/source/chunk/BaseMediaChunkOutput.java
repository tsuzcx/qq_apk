package com.google.android.exoplayer2.source.chunk;

import android.util.Log;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;

final class BaseMediaChunkOutput
  implements ChunkExtractorWrapper.TrackOutputProvider
{
  private static final String TAG = "BaseMediaChunkOutput";
  private final SampleQueue[] sampleQueues;
  private final int[] trackTypes;
  
  public BaseMediaChunkOutput(int[] paramArrayOfInt, SampleQueue[] paramArrayOfSampleQueue)
  {
    this.trackTypes = paramArrayOfInt;
    this.sampleQueues = paramArrayOfSampleQueue;
  }
  
  public int[] getWriteIndices()
  {
    int[] arrayOfInt = new int[this.sampleQueues.length];
    int i = 0;
    while (i < this.sampleQueues.length)
    {
      if (this.sampleQueues[i] != null) {
        arrayOfInt[i] = this.sampleQueues[i].getWriteIndex();
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void setSampleOffsetUs(long paramLong)
  {
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    int i = 0;
    while (i < j)
    {
      SampleQueue localSampleQueue = arrayOfSampleQueue[i];
      if (localSampleQueue != null) {
        localSampleQueue.setSampleOffsetUs(paramLong);
      }
      i += 1;
    }
  }
  
  public TrackOutput track(int paramInt1, int paramInt2)
  {
    paramInt1 = 0;
    while (paramInt1 < this.trackTypes.length)
    {
      if (paramInt2 == this.trackTypes[paramInt1]) {
        return this.sampleQueues[paramInt1];
      }
      paramInt1 += 1;
    }
    Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + paramInt2);
    return new DummyTrackOutput();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.BaseMediaChunkOutput
 * JD-Core Version:    0.7.0.1
 */