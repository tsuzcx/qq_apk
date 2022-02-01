package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class QMCalendarManager$14$2
  implements MailManagerDelegate.DataCallback
{
  QMCalendarManager$14$2(QMCalendarManager.14 param14) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMLog.log(4, "QMCalendarManager", "followShareCalendarFolder success accountId:" + this.this$1.val$accountId + " code:" + this.this$1.val$code + " email" + this.this$1.val$email);
    paramObject1 = AccountManager.shareInstance().getAccountList().getAccountById(this.this$1.val$accountId);
    paramObject2 = new MailManagerDelegate();
    paramObject2.setOnSuccess(new QMCalendarManager.14.2.1(this));
    paramObject2.setOnError(new QMCalendarManager.14.2.2(this));
    this.this$1.this$0.syncCalendarAfterSync(paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.14.2
 * JD-Core Version:    0.7.0.1
 */