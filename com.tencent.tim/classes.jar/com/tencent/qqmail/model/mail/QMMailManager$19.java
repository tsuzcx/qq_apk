package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.List;

class QMMailManager$19
  implements GroupMailAccountWatcher
{
  QMMailManager$19(QMMailManager paramQMMailManager, boolean paramBoolean1, boolean paramBoolean2, List paramList, long[] paramArrayOfLong) {}
  
  public boolean isQQMail(int paramInt)
  {
    return AccountManager.shareInstance().getAccountList().isQQMailAccount(paramInt);
  }
  
  public void onSyncAdConv(int paramInt, boolean paramBoolean)
  {
    this.this$0.markAdAllAsStarred(paramInt, this.val$isStar);
  }
  
  public void onSyncLocal(int paramInt, boolean paramBoolean, long[] paramArrayOfLong)
  {
    this.this$0.withFolderUnreadCount(paramInt, new QMMailManager.19.1(this, paramArrayOfLong));
  }
  
  public void onSyncLocalComplete()
  {
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.STAR, this.val$mailIds);
  }
  
  public void onSyncRemote(int paramInt1, int paramInt2, boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    if (!this.val$networkConnected)
    {
      QMMailManager.access$600(this.this$0).saveStar(paramInt1, paramInt2, paramList1, paramList2, this.val$isStar);
      return;
    }
    if (paramBoolean)
    {
      this.val$requests.add(QMMailManager.access$500(this.this$0).starMails(paramInt1, this.val$isStar, (String[])paramList1.toArray(new String[paramList1.size()])));
      return;
    }
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    QMFolder localQMFolder = QMMailManager.access$400(this.this$0).getFolder(paramInt2);
    QMMailManager.access$700(this.this$0).starMails(localAccount, localQMFolder, this.val$isStar, paramList1, paramList2, null);
  }
  
  public void onSyncSubscribeConv(int paramInt, boolean paramBoolean)
  {
    this.this$0.markSubscribeAllAsStarred(paramInt, this.val$isStar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.19
 * JD-Core Version:    0.7.0.1
 */