package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.utilities.log.QMLog;

class QMConvMailCursor$3
  implements Runnable
{
  QMConvMailCursor$3(QMConvMailCursor paramQMConvMailCursor) {}
  
  public void run()
  {
    Mail localMail = this.this$0.getParentMail();
    if (localMail != null) {
      if (QMMailManager.sharedInstance().getConvUnreadCount(localMail.getInformation().getId()) <= 0) {
        break label109;
      }
    }
    label109:
    for (boolean bool = true;; bool = false)
    {
      if (localMail.getStatus().isUnread() != bool)
      {
        QMLog.log(4, "QMMailListCursor", "parent mail unread not match children, parent: " + localMail.getStatus().isUnread() + ", children: " + bool + ", fix it.");
        QMMailManager.sharedInstance().unreadMails(new long[] { localMail.getInformation().getId() }, bool, false);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMConvMailCursor.3
 * JD-Core Version:    0.7.0.1
 */