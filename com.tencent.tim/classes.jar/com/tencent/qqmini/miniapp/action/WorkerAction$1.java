package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.ValueCallback;

class WorkerAction$1
  implements ValueCallback
{
  WorkerAction$1(WorkerAction paramWorkerAction) {}
  
  public void onReceiveValue(Object paramObject)
  {
    QMLog.i("minisdk-worker", "[postMessageToService] over");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.WorkerAction.1
 * JD-Core Version:    0.7.0.1
 */