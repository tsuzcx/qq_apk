package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.model.mail.watcher.ReadMailDefaultWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMReadEmlActivity$1
  implements ReadMailDefaultWatcher
{
  QMReadEmlActivity$1(QMReadEmlActivity paramQMReadEmlActivity) {}
  
  public void onConvChildSuccess(long paramLong1, long paramLong2) {}
  
  public void onError(long paramLong, QMNetworkError paramQMNetworkError)
  {
    if (QMReadEmlActivity.access$000(this.this$0) == paramLong) {
      QMReadEmlActivity.access$600(this.this$0, new QMReadEmlActivity.1.3(this));
    }
    QMLog.log(6, "QMReadEmlActivity", "readMailWatcher onError: " + paramLong);
  }
  
  public void onLocalSuccess(Mail paramMail)
  {
    if (paramMail.getInformation().getId() == QMReadEmlActivity.access$000(this.this$0)) {
      QMReadEmlActivity.access$200(this.this$0, new QMReadEmlActivity.1.1(this));
    }
  }
  
  public void onProcess(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onSuccess(long paramLong)
  {
    if (QMReadEmlActivity.access$000(this.this$0) == paramLong) {
      QMReadEmlActivity.access$400(this.this$0, new QMReadEmlActivity.1.2(this));
    }
    QMLog.log(4, "QMReadEmlActivity", "readMailWatcher onSuccess:" + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.1
 * JD-Core Version:    0.7.0.1
 */