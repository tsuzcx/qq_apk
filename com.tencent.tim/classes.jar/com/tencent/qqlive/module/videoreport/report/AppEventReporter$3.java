package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class AppEventReporter$3
  implements ListenerMgr.INotifyCallback<AppEventReporter.IAppEventListener>
{
  AppEventReporter$3(AppEventReporter paramAppEventReporter, boolean paramBoolean) {}
  
  public void onNotify(AppEventReporter.IAppEventListener paramIAppEventListener)
  {
    paramIAppEventListener.onAppOut(this.val$isMainThread);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.3
 * JD-Core Version:    0.7.0.1
 */