package com.tencent.component.animation.rebound;

import android.os.Handler;
import android.os.SystemClock;

class AndroidSpringLooperFactory$LegacyAndroidSpringLooper$1
  implements Runnable
{
  AndroidSpringLooperFactory$LegacyAndroidSpringLooper$1(AndroidSpringLooperFactory.LegacyAndroidSpringLooper paramLegacyAndroidSpringLooper) {}
  
  public void run()
  {
    if ((!AndroidSpringLooperFactory.LegacyAndroidSpringLooper.access$0(this.this$1)) || (this.this$1.mSpringSystem == null)) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    this.this$1.mSpringSystem.loop(l - AndroidSpringLooperFactory.LegacyAndroidSpringLooper.access$1(this.this$1));
    AndroidSpringLooperFactory.LegacyAndroidSpringLooper.access$2(this.this$1).post(AndroidSpringLooperFactory.LegacyAndroidSpringLooper.access$3(this.this$1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.animation.rebound.AndroidSpringLooperFactory.LegacyAndroidSpringLooper.1
 * JD-Core Version:    0.7.0.1
 */