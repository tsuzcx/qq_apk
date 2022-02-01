package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;
import java.util.List;

class QMMailManager$17
  implements GroupMailAccountWatcher
{
  QMMailManager$17(QMMailManager paramQMMailManager, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, List paramList, long[] paramArrayOfLong) {}
  
  public boolean isQQMail(int paramInt)
  {
    return AccountManager.shareInstance().getAccountList().isQQMailAccount(paramInt);
  }
  
  public void onSyncAdConv(int paramInt, boolean paramBoolean) {}
  
  public void onSyncLocal(int paramInt, boolean paramBoolean, long[] paramArrayOfLong)
  {
    this.this$0.withFolderUnreadCount(paramInt, new QMMailManager.17.1(this, paramInt, paramArrayOfLong));
  }
  
  public void onSyncLocalComplete()
  {
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.TAG, this.val$mailIds);
  }
  
  public void onSyncRemote(int paramInt1, int paramInt2, boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    if (!this.val$networkConnected) {
      QMMailManager.access$600(this.this$0).saveTag(paramInt1, (String[])paramList1.toArray(new String[paramList1.size()]), this.val$addTagIds, this.val$deleteTagIds);
    }
    while (!paramBoolean) {
      return;
    }
    this.val$requests.addAll(QMMailManager.access$500(this.this$0).tagMails(paramInt1, (String[])paramList1.toArray(new String[paramList1.size()]), this.val$addTagIds, this.val$deleteTagIds));
  }
  
  public void onSyncSubscribeConv(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.17
 * JD-Core Version:    0.7.0.1
 */