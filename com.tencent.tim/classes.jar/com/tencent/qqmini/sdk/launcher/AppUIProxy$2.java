package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;

class AppUIProxy$2
  implements Runnable
{
  AppUIProxy$2(AppUIProxy paramAppUIProxy) {}
  
  public void run()
  {
    if (this.this$0.mActivity != null) {
      this.this$0.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy.2
 * JD-Core Version:    0.7.0.1
 */