package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.watcher.SecurityAppWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class BaseActivityImpl$6
  implements SecurityAppWatcher
{
  BaseActivityImpl$6(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onSecAppHappen(String paramString)
  {
    if ((BaseActivityImpl.access$500(this.this$0)) && (BaseActivityImpl.access$600(this.this$0)))
    {
      Threads.runOnMainThread(new BaseActivityImpl.6.1(this, paramString));
      return;
    }
    QMLog.log(5, "BaseActivityImpl", "page not ready for secapp:" + BaseActivityImpl.access$000(this.this$0));
    Threads.runInBackground(new BaseActivityImpl.6.2(this, paramString), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.6
 * JD-Core Version:    0.7.0.1
 */