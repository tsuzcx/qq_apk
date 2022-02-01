package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.NotifyUtil;
import java.util.List;

class QMMailManager$25
  implements GroupMailAccountWatcher
{
  QMMailManager$25(QMMailManager paramQMMailManager, boolean paramBoolean1, List paramList, boolean paramBoolean2, long[] paramArrayOfLong) {}
  
  public boolean isQQMail(int paramInt)
  {
    return AccountManager.shareInstance().getAccountList().isQQMailAccount(paramInt);
  }
  
  public void onSyncAdConv(int paramInt, boolean paramBoolean) {}
  
  public void onSyncLocal(int paramInt, boolean paramBoolean, long[] paramArrayOfLong)
  {
    QMMailManager.access$800(this.this$0, paramInt, paramBoolean, paramArrayOfLong, this.val$isPurgeDelete);
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        NotifyUtil.removeMailId(paramInt, paramArrayOfLong[i]);
        i += 1;
      }
    }
  }
  
  public void onSyncLocalComplete()
  {
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.DELETE, this.val$mailIds);
  }
  
  public void onSyncRemote(int paramInt1, int paramInt2, boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    if (!this.val$networkConnected)
    {
      QMMailManager.access$600(this.this$0).saveDel(paramInt1, paramInt2, paramList1, paramList2);
      return;
    }
    if (paramBoolean)
    {
      this.val$requests.add(QMMailManager.access$500(this.this$0).deleteMails(paramInt1, this.val$isPurgeDelete, (String[])paramList1.toArray(new String[paramList1.size()]), null));
      return;
    }
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    QMFolder localQMFolder1 = QMMailManager.access$400(this.this$0).getFolder(paramInt2);
    QMFolder localQMFolder2 = QMMailManager.access$400(this.this$0).getFolder(QMMailManager.access$400(this.this$0).getTrashFolderId(paramInt1));
    if (this.val$isPurgeDelete)
    {
      QMMailManager.access$700(this.this$0).removeMails(localAccount, localQMFolder1, paramList1, paramList2, null);
      return;
    }
    MailManagerDelegate localMailManagerDelegate = new MailManagerDelegate();
    localMailManagerDelegate.setOnComplete(new QMMailManager.25.1(this, localAccount, localQMFolder1, localQMFolder2, paramList1, paramList2));
    QMMailManager.access$700(this.this$0).unreadMails(localAccount, localQMFolder1, false, paramList1, paramList2, localMailManagerDelegate);
  }
  
  public void onSyncSubscribeConv(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.25
 * JD-Core Version:    0.7.0.1
 */