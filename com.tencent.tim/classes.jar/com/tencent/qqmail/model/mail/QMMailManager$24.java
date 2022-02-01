package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.List;

class QMMailManager$24
  implements GroupMailAccountWatcher
{
  QMMailManager$24(QMMailManager paramQMMailManager, boolean paramBoolean, int paramInt1, List paramList, int paramInt2, long[] paramArrayOfLong) {}
  
  public boolean isQQMail(int paramInt)
  {
    return AccountManager.shareInstance().getAccountList().isQQMailAccount(paramInt);
  }
  
  public void onSyncAdConv(int paramInt, boolean paramBoolean) {}
  
  public void onSyncLocal(int paramInt, boolean paramBoolean, long[] paramArrayOfLong)
  {
    this.this$0.withFolderUnreadCount(paramInt, new QMMailManager.24.1(this, paramInt, paramArrayOfLong, paramBoolean));
  }
  
  public void onSyncLocalComplete()
  {
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.MOVE, this.val$mailIds);
  }
  
  public void onSyncRemote(int paramInt1, int paramInt2, boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    if (!this.val$networkConnected)
    {
      QMMailManager.access$600(this.this$0).saveMove(paramInt1, paramInt2, this.val$toFolderId, paramList1, paramList2);
      return;
    }
    if (paramBoolean)
    {
      this.val$requests.add(QMMailManager.access$500(this.this$0).moveMails(paramInt1, (String[])paramList1.toArray(new String[paramList1.size()]), this.val$toFolderId));
      return;
    }
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    QMFolder localQMFolder1 = QMMailManager.access$400(this.this$0).getFolder(paramInt2);
    QMFolder localQMFolder2 = QMMailManager.access$400(this.this$0).getFolder(this.val$toFolderId);
    QMMailManager.access$700(this.this$0).moveMails(localAccount, localQMFolder1, localQMFolder2, paramList1, paramList2, null);
  }
  
  public void onSyncSubscribeConv(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.24
 * JD-Core Version:    0.7.0.1
 */