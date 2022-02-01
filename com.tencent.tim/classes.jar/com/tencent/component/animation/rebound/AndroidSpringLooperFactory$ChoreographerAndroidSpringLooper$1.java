package com.tencent.component.animation.rebound;

import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

class AndroidSpringLooperFactory$ChoreographerAndroidSpringLooper$1
  implements Choreographer.FrameCallback
{
  AndroidSpringLooperFactory$ChoreographerAndroidSpringLooper$1(AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper paramChoreographerAndroidSpringLooper) {}
  
  public void doFrame(long paramLong)
  {
    if ((!AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.access$0(this.this$1)) || (this.this$1.mSpringSystem == null)) {
      return;
    }
    paramLong = SystemClock.uptimeMillis();
    this.this$1.mSpringSystem.loop(paramLong - AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.access$1(this.this$1));
    AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.access$2(this.this$1, paramLong);
    AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.access$3(this.this$1).postFrameCallback(AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.access$4(this.this$1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.animation.rebound.AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.1
 * JD-Core Version:    0.7.0.1
 */