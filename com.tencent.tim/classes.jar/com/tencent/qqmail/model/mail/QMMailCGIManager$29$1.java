package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.qmdomain.Mail;
import java.util.ArrayList;

class QMMailCGIManager$29$1
  implements QMMailSQLite.GroupMailPreloadWatcher
{
  QMMailCGIManager$29$1(QMMailCGIManager.29 param29) {}
  
  public void onPreloadMail(ArrayList<Mail> paramArrayList)
  {
    if (paramArrayList.size() > 0) {
      this.this$1.this$0.preloadMails(this.this$1.val$accountId, paramArrayList, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.29.1
 * JD-Core Version:    0.7.0.1
 */