package com.tencent.qqlive.module.videoreport.report;

import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class AppEventReporter$2$1
  implements ListenerMgr.INotifyCallback<AppEventReporter.IAppEventListener>
{
  AppEventReporter$2$1(AppEventReporter.2 param2) {}
  
  public void onNotify(AppEventReporter.IAppEventListener paramIAppEventListener)
  {
    paramIAppEventListener.onAppIn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.AppEventReporter.2.1
 * JD-Core Version:    0.7.0.1
 */