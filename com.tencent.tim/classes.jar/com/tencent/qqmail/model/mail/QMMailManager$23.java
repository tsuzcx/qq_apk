package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;
import java.util.List;

class QMMailManager$23
  implements GroupMailAccountWatcher
{
  QMMailManager$23(QMMailManager paramQMMailManager, boolean paramBoolean, List paramList, long[] paramArrayOfLong, int paramInt) {}
  
  public boolean isQQMail(int paramInt)
  {
    return AccountManager.shareInstance().getAccountList().isQQMailAccount(paramInt);
  }
  
  public void onSyncAdConv(int paramInt, boolean paramBoolean) {}
  
  public void onSyncLocal(int paramInt, boolean paramBoolean, long[] paramArrayOfLong)
  {
    this.this$0.withFolderUnreadCount(paramInt, new QMMailManager.23.1(this, paramInt, paramBoolean));
  }
  
  public void onSyncLocalComplete()
  {
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.SPAM, this.val$mailIds);
  }
  
  public void onSyncRemote(int paramInt1, int paramInt2, boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    if (!this.val$networkConnected) {
      QMMailManager.access$600(this.this$0).saveSpam(paramInt1, paramInt2, paramList1, paramList2);
    }
    while (!paramBoolean) {
      return;
    }
    this.val$requests.add(QMMailManager.access$500(this.this$0).spamMails(paramInt1, (String[])paramList1.toArray(new String[paramList1.size()])));
  }
  
  public void onSyncSubscribeConv(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.23
 * JD-Core Version:    0.7.0.1
 */