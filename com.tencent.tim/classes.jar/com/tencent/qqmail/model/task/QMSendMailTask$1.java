package com.tencent.qqmail.model.task;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.mail.watcher.DownloadAttachWatcher;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMCancelError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class QMSendMailTask$1
  implements DownloadAttachWatcher
{
  QMSendMailTask$1(QMSendMailTask paramQMSendMailTask) {}
  
  public boolean abort()
  {
    return false;
  }
  
  public boolean goOn()
  {
    return false;
  }
  
  public boolean isAbort()
  {
    return false;
  }
  
  public boolean isMatch(long paramLong)
  {
    return false;
  }
  
  public void onError(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    QMLog.log(6, "QMSendMailTask", "send mail task download attach error:" + paramString2 + ",mailId:" + paramLong1 + ",attachId" + paramLong2 + ",proType:" + paramInt);
    if (!(paramObject instanceof QMCancelError))
    {
      paramString1 = QMSendMailTask.access$300(this.this$0, paramLong2);
      if (paramString1 != null) {
        paramString1.setLoadError(true);
      }
      QMSendMailTask.access$400(this.this$0).cancelAll();
      paramString1 = new QMNetworkError(5, -10002, QMApplicationContext.sharedInstance().getString(2131692929));
      QMNotification.postNotification("refresh_sending_progress", Integer.valueOf(this.this$0.getId()));
      if (this.this$0.getTaskState() == QMTask.QMTaskState.QMTaskStateWaiting)
      {
        this.this$0.handleError(paramString1);
        this.this$0.handleComplete();
      }
    }
  }
  
  public void onProcess(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    paramLong1 = paramLong3;
    Attach localAttach;
    if (paramLong3 == 0L)
    {
      localAttach = QMSendMailTask.access$100(this.this$0, paramLong2, "");
      paramLong1 = paramLong3;
      if (localAttach != null)
      {
        if (localAttach.getBytes() <= 0L) {
          break label57;
        }
        paramLong1 = localAttach.getBytes();
      }
    }
    for (;;)
    {
      QMSendMailTask.access$200(this.this$0, paramLong1, paramLong4);
      return;
      label57:
      paramLong1 = paramLong3;
      if (localAttach.getSize() != null)
      {
        paramLong1 = paramLong3;
        if (!localAttach.getSize().equals(""))
        {
          localAttach.setBytes(StringExtention.sizeStrToLong(localAttach.getSize()));
          paramLong1 = localAttach.getBytes();
        }
      }
    }
  }
  
  public void onSuccess(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt)
  {
    QMSendMailTask.access$000(this.this$0, paramLong2, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.task.QMSendMailTask.1
 * JD-Core Version:    0.7.0.1
 */