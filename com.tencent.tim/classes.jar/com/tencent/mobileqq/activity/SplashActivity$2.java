package com.tencent.mobileqq.activity;

import com.tencent.widget.immersive.ImmersiveUtils;

class SplashActivity$2
  implements Runnable
{
  SplashActivity$2(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    if (ImmersiveUtils.a(this.this$0.getWindow())) {
      this.this$0.recreate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity.2
 * JD-Core Version:    0.7.0.1
 */