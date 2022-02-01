package com.tencent.mobileqq.mini.tfs;

import android.os.SystemClock;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/tfs/Timing;", "", "()V", "<set-?>", "", "duration", "getDuration", "()J", "startTimeMs", "end", "", "start", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class Timing
{
  private long duration;
  private long startTimeMs;
  
  public final void end()
  {
    this.duration = (SystemClock.uptimeMillis() - this.duration);
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final void start()
  {
    this.startTimeMs = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.Timing
 * JD-Core Version:    0.7.0.1
 */