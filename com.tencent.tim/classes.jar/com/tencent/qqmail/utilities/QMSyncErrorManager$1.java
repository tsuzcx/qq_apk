package com.tencent.qqmail.utilities;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class QMSyncErrorManager$1
  implements Runnable
{
  QMSyncErrorManager$1(QMSyncErrorManager paramQMSyncErrorManager, QMNetworkError paramQMNetworkError, int paramInt) {}
  
  public void run()
  {
    boolean bool2 = QMNetworkUtils.isNetworkAvailable();
    Object localObject = this.this$0;
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      ((QMSyncErrorManager)localObject).setNetworkUnavailable(bool1);
      if (!bool2) {
        break label211;
      }
      if ((this.val$error == null) || (this.this$0.skipErrorCode(this.val$accountId, this.val$error.getCode()))) {
        break label117;
      }
      QMLog.log(6, "QMSyncErrorManager", "sync serve error:" + this.val$accountId + ", errorCode:" + this.val$error.getCode());
      this.this$0.addSyncError(this.val$accountId, 4);
    }
    for (;;)
    {
      QMWatcherCenter.triggerRenderSyncErrorBar();
      return;
      bool1 = false;
      break;
      label117:
      StringBuilder localStringBuilder = new StringBuilder().append("other error:").append(this.val$accountId).append(", error:");
      if (this.val$error != null) {}
      for (localObject = this.val$error.getCode() + "," + this.val$error.getMessage();; localObject = "null")
      {
        QMLog.log(6, "QMSyncErrorManager", (String)localObject);
        break;
      }
      label211:
      QMLog.log(6, "QMSyncErrorManager", "check network unAvailable");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMSyncErrorManager.1
 * JD-Core Version:    0.7.0.1
 */