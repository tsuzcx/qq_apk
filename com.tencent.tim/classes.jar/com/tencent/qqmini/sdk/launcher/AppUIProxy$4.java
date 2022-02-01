package com.tencent.qqmini.sdk.launcher;

class AppUIProxy$4
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  AppUIProxy$4(AppUIProxy paramAppUIProxy) {}
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    if (paramMiniAppStateMessage.what == 11) {
      this.this$0.hideLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppUIProxy.4
 * JD-Core Version:    0.7.0.1
 */