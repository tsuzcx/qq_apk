package com.tencent.av.utils;

import android.os.Handler;

class SparkDot$1
  implements Runnable
{
  SparkDot$1(SparkDot paramSparkDot) {}
  
  public void run()
  {
    this.this$0.aBb %= this.this$0.aBc;
    this.this$0.nP(this.this$0.aBb);
    SparkDot localSparkDot = this.this$0;
    localSparkDot.aBb += 1;
    if (SparkDot.a(this.this$0)) {
      this.this$0.mHandler.postDelayed(this.this$0.mRunnable, this.this$0.mDuration);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.SparkDot.1
 * JD-Core Version:    0.7.0.1
 */