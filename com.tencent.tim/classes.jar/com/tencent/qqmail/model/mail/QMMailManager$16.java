package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback;

class QMMailManager$16
  implements Runnable
{
  QMMailManager$16(QMMailManager paramQMMailManager, int paramInt, String paramString, QMCallback paramQMCallback) {}
  
  public void run()
  {
    QMMailManager.access$500(this.this$0).getMailWeatherParseResult(this.val$accountId, this.val$mailId, this.val$qmCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.16
 * JD-Core Version:    0.7.0.1
 */