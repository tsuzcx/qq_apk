package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import java.util.ArrayList;
import java.util.Iterator;

class QMSubscribeColumnCursor$1
  implements Runnable
{
  QMSubscribeColumnCursor$1(QMSubscribeColumnCursor paramQMSubscribeColumnCursor) {}
  
  public void run()
  {
    Object localObject = QMMailSQLite.getMailsFromCursor(QMSubscribeColumnCursor.access$300(this.this$0).mail.getUnloadSubscribeMails(QMSubscribeColumnCursor.access$000(this.this$0).getReadableDatabase(), QMSubscribeColumnCursor.access$100(this.this$0), QMSubscribeColumnCursor.access$200(this.this$0)));
    QMSubscribeColumnCursor.access$402(this.this$0, ((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Mail localMail = (Mail)((Iterator)localObject).next();
      QMSubscribeColumnCursor.access$500(this.this$0).subscribeMails(localMail.getInformation().getAccountId(), localMail);
    }
    if (QMSubscribeColumnCursor.access$400(this.this$0) == 0) {
      QMWatcherCenter.triggerSubscribeMailSuccess(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSubscribeColumnCursor.1
 * JD-Core Version:    0.7.0.1
 */