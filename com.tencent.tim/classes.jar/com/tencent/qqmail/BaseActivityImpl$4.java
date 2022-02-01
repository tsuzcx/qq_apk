package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.watcher.AppUpdateWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class BaseActivityImpl$4
  implements AppUpdateWatcher
{
  BaseActivityImpl$4(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onUpdate(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    QMLog.log(4, "BaseActivityImpl", "version : " + paramString1 + ", desp : " + paramString2 + ", title : " + paramString3 + ", forceType : " + paramInt);
    Threads.runOnMainThread(new BaseActivityImpl.4.1(this, paramString2, paramString3, paramString4, paramString1, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.4
 * JD-Core Version:    0.7.0.1
 */