package com.tencent.qqmail.model.task;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.mail.watcher.DownloadImgWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMSendMailTask$4
  implements DownloadImgWatcher
{
  QMSendMailTask$4(QMSendMailTask paramQMSendMailTask) {}
  
  public void onError(long paramLong, String paramString1, String paramString2, Object paramObject)
  {
    QMLog.log(6, "QMSendMailTask", "send mail task download image error:" + paramString2 + ",mailId:" + paramLong);
    if (!(paramObject instanceof QMCancelError))
    {
      QMSendMailTask.access$400(this.this$0).cancelAll();
      paramString1 = new QMNetworkError(5, -10002, QMApplicationContext.sharedInstance().getString(2131692943));
      this.this$0.handleError(paramString1);
      this.this$0.handleComplete();
    }
  }
  
  public void onProcess(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    QMSendMailTask.access$200(this.this$0, paramLong2, paramLong3);
  }
  
  public void onSuccess(long paramLong, String paramString1, String paramString2)
  {
    QMSendMailTask.access$000(this.this$0, 0L, paramString2, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.4
 * JD-Core Version:    0.7.0.1
 */