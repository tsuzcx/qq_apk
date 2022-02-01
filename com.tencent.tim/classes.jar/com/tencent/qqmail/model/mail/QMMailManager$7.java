package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.List;

class QMMailManager$7
  implements GroupMailAccountWatcher
{
  QMMailManager$7(QMMailManager paramQMMailManager, QMFolder paramQMFolder, long[] paramArrayOfLong) {}
  
  public boolean isQQMail(int paramInt)
  {
    return AccountManager.shareInstance().getAccountList().isQQMailAccount(paramInt);
  }
  
  public void onSyncAdConv(int paramInt, boolean paramBoolean) {}
  
  public void onSyncLocal(int paramInt, boolean paramBoolean, long[] paramArrayOfLong)
  {
    this.this$0.withFolderUnreadCount(paramInt, new QMMailManager.7.1(this, paramInt, paramArrayOfLong, paramBoolean));
  }
  
  public void onSyncLocalComplete()
  {
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.MOVE, this.val$mailIds);
  }
  
  public void onSyncRemote(int paramInt1, int paramInt2, boolean paramBoolean, List<String> paramList1, List<String> paramList2) {}
  
  public void onSyncSubscribeConv(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.7
 * JD-Core Version:    0.7.0.1
 */