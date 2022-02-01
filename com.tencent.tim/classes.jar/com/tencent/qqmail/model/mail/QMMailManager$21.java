package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;
import java.util.List;

class QMMailManager$21
  implements GroupMailAccountWatcher
{
  QMMailManager$21(QMMailManager paramQMMailManager, boolean paramBoolean, int paramInt, long[] paramArrayOfLong) {}
  
  public boolean isQQMail(int paramInt)
  {
    return AccountManager.shareInstance().getAccountList().isQQMailAccount(paramInt);
  }
  
  public void onSyncAdConv(int paramInt, boolean paramBoolean)
  {
    this.this$0.withFolderUnreadCount(paramInt, new QMMailManager.21.2(this, paramInt));
  }
  
  public void onSyncLocal(int paramInt, boolean paramBoolean, long[] paramArrayOfLong)
  {
    this.this$0.withFolderUnreadCount(paramInt, new QMMailManager.21.1(this, paramArrayOfLong));
  }
  
  public void onSyncLocalComplete()
  {
    QMMailManager.access$000(this.this$0).folder.updateFolder(QMMailManager.access$000(this.this$0).getWritableDatabase(), this.val$folderId, 0, -1, false, false);
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.UNREAD, this.val$mailIds);
  }
  
  public void onSyncRemote(int paramInt1, int paramInt2, boolean paramBoolean, List<String> paramList1, List<String> paramList2) {}
  
  public void onSyncSubscribeConv(int paramInt, boolean paramBoolean)
  {
    this.this$0.withFolderUnreadCount(paramInt, new QMMailManager.21.3(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.21
 * JD-Core Version:    0.7.0.1
 */