package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.watcher.TranslateMailWatcher;
import com.tencent.qqmail.model.qmdomain.MailTranslate;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class ReadMailFragment$32
  implements TranslateMailWatcher
{
  ReadMailFragment$32(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(long paramLong, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "translate", "mailId: " + paramLong + " translate error:" + paramQMNetworkError);
    DataCollector.logEvent("Event_Translate_Fail");
    ReadMailFragment.access$9600(this.this$0, new ReadMailFragment.32.1(this, paramQMNetworkError));
  }
  
  public void onLocalSuccess(MailTranslate paramMailTranslate)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onLocalSuccess, id:");
    if (paramMailTranslate != null) {}
    for (Object localObject = Long.valueOf(paramMailTranslate.getMailId());; localObject = "")
    {
      QMLog.log(4, "translate", localObject);
      ReadMailFragment.access$9500(this.this$0, paramMailTranslate);
      return;
    }
  }
  
  public void onSuccess(long paramLong)
  {
    QMLog.log(4, "translate", "onSuccess, id:" + paramLong);
    MailTranslate localMailTranslate = QMMailManager.sharedInstance().readMailTranslateSync(ReadMailFragment.access$400(this.this$0));
    ReadMailFragment.access$9500(this.this$0, localMailTranslate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.32
 * JD-Core Version:    0.7.0.1
 */