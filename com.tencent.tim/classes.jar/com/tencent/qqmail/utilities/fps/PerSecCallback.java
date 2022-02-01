package com.tencent.qqmail.utilities.fps;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

@TargetApi(16)
public class PerSecCallback
  implements Choreographer.FrameCallback
{
  private static final long ONE_SECOND_NANOS = 200000000L;
  private static final String TAG = "PerSecCallback";
  private int frameCountIntCurrentSecond = 0;
  private long lastFrameTimeNanos = -1L;
  
  public void doFrame(long paramLong)
  {
    if (this.lastFrameTimeNanos <= 0L) {
      this.lastFrameTimeNanos = paramLong;
    }
    for (;;)
    {
      Choreographer.getInstance().postFrameCallback(this);
      return;
      long l = paramLong - this.lastFrameTimeNanos;
      if (l < 200000000L)
      {
        this.frameCountIntCurrentSecond += 1;
      }
      else
      {
        float f = (float)(l / this.frameCountIntCurrentSecond / 1000000L);
        Log.i("PerSecCallback", "fps = " + f);
        this.lastFrameTimeNanos = paramLong;
        this.frameCountIntCurrentSecond = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.fps.PerSecCallback
 * JD-Core Version:    0.7.0.1
 */