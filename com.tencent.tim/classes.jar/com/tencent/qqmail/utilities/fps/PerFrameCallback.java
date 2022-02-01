package com.tencent.qqmail.utilities.fps;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

@TargetApi(16)
public class PerFrameCallback
  implements Choreographer.FrameCallback
{
  private static final long DEFAULT_BLOCK_THRESHOLD = 25L;
  private static final String TAG = "QMFrameCallback";
  private float averageFrame = 16.6F;
  private long blockThreshold = 25L;
  private long frameTimeDiff;
  private long lastFrameTimeNanos;
  
  public void block() {}
  
  public void doFrame(long paramLong)
  {
    this.frameTimeDiff = (paramLong / 1000000L - this.lastFrameTimeNanos / 1000000L);
    this.averageFrame = ((this.averageFrame + (float)this.frameTimeDiff) / 2.0F);
    if ((this.lastFrameTimeNanos != -1L) && (this.frameTimeDiff > this.blockThreshold))
    {
      block();
      Log.i("QMFrameCallback", "block " + this.frameTimeDiff);
    }
    this.lastFrameTimeNanos = paramLong;
    Choreographer.getInstance().postFrameCallback(this);
  }
  
  public String lastFpsDetail()
  {
    return String.format("Fps %s (%s)", new Object[] { 1000.0F / (float)this.frameTimeDiff + "", this.frameTimeDiff + "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.fps.PerFrameCallback
 * JD-Core Version:    0.7.0.1
 */