package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class TimestampAdjusterProvider
{
  private final SparseArray<TimestampAdjuster> timestampAdjusters = new SparseArray();
  
  public TimestampAdjuster getAdjuster(int paramInt)
  {
    TimestampAdjuster localTimestampAdjuster2 = (TimestampAdjuster)this.timestampAdjusters.get(paramInt);
    TimestampAdjuster localTimestampAdjuster1 = localTimestampAdjuster2;
    if (localTimestampAdjuster2 == null)
    {
      localTimestampAdjuster1 = new TimestampAdjuster(9223372036854775807L);
      this.timestampAdjusters.put(paramInt, localTimestampAdjuster1);
    }
    return localTimestampAdjuster1;
  }
  
  public void reset()
  {
    this.timestampAdjusters.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.TimestampAdjusterProvider
 * JD-Core Version:    0.7.0.1
 */