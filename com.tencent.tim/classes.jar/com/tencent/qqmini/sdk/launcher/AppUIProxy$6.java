package com.tencent.qqmini.sdk.launcher;

import android.view.ViewGroup;

class AppUIProxy$6
  implements Runnable
{
  AppUIProxy$6(AppUIProxy paramAppUIProxy) {}
  
  public void run()
  {
    if ((AppUIProxy.access$500(this.this$0) != null) && (this.this$0.mRootLayout != null))
    {
      AppUIProxy.access$500(this.this$0).setVisibility(0);
      AppUIProxy.access$500(this.this$0).bringToFront();
      this.this$0.mRootLayout.requestLayout();
      this.this$0.mRootLayout.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy.6
 * JD-Core Version:    0.7.0.1
 */