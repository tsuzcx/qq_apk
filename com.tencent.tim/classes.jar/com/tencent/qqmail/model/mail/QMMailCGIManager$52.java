package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$52
  implements QMCallback.IErrorCallback
{
  QMMailCGIManager$52(QMMailCGIManager paramQMMailCGIManager, long paramLong, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "QMMailCGIManager", "recallMail Error:" + paramQMNetworkError.code + ":" + paramQMNetworkError.desp);
    if (((paramQMNetworkError instanceof QMCGIError)) && (((QMCGIError)paramQMNetworkError).appCode == -300))
    {
      QMMailCGIManager.access$000(this.this$0).mail.updateMailAttr(QMMailCGIManager.access$000(this.this$0).getWritableDatabase(), new long[] { this.val$mailId }, 16L);
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(Long.valueOf(this.val$mailId), new long[] { 0L });
      }
      QMWatcherCenter.triggerRecallMailSuccess(this.val$mailId, 0L);
      return;
    }
    if (this.val$callback != null) {
      this.val$callback.handleError(paramQMNetworkError);
    }
    QMWatcherCenter.triggerRecallMailError(this.val$mailId, paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.52
 * JD-Core Version:    0.7.0.1
 */