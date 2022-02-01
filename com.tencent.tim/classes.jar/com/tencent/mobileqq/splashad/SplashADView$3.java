package com.tencent.mobileqq.splashad;

import com.tencent.qphone.base.util.QLog;

class SplashADView$3
  implements Runnable
{
  SplashADView$3(SplashADView paramSplashADView) {}
  
  public void run()
  {
    if (SplashADView.a(this.this$0) != null)
    {
      QLog.i("SplashAD", 1, "mVideoPlayer is prepare");
      SplashADView.a(this.this$0).aRp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.splashad.SplashADView.3
 * JD-Core Version:    0.7.0.1
 */