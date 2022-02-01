package com.tencent.qqmail.model.mail;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.MailOperationType;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.ArrayList;
import java.util.List;

class QMMailManager$22
  implements GroupMailAccountWatcher
{
  QMMailManager$22(QMMailManager paramQMMailManager, boolean paramBoolean1, boolean paramBoolean2, SQLiteDatabase paramSQLiteDatabase, long[] paramArrayOfLong, List paramList, boolean paramBoolean3, boolean paramBoolean4, String[] paramArrayOfString) {}
  
  public boolean isQQMail(int paramInt)
  {
    return AccountManager.shareInstance().getAccountList().isQQMailAccount(paramInt);
  }
  
  public void onSyncAdConv(int paramInt, boolean paramBoolean) {}
  
  public void onSyncLocal(int paramInt, boolean paramBoolean, long[] paramArrayOfLong)
  {
    this.this$0.withFolderUnreadCount(paramInt, new QMMailManager.22.1(this, paramBoolean, paramInt, paramArrayOfLong));
  }
  
  public void onSyncLocalComplete()
  {
    QMWatcherCenter.triggerMailOpertionSuccess(QMWatcherCenter.MailOperationType.REJECT, this.val$mailIds);
  }
  
  public void onSyncRemote(int paramInt1, int paramInt2, boolean paramBoolean, List<String> paramList1, List<String> paramList2)
  {
    if (!this.val$networkConnected)
    {
      QMMailManager.access$600(this.this$0).saveReject(paramInt1, paramInt2, paramList1, paramList2);
      return;
    }
    if (paramBoolean)
    {
      if (this.val$isSubscribeFolder)
      {
        paramList1 = new ArrayList();
        paramList2 = QMMailManager.access$000(this.this$0).mail.getMailInfoByIds(this.val$readableDb, this.val$mailIds, "colid");
        if (paramList2 != null)
        {
          paramInt2 = 0;
          while (paramInt2 < paramList2.length)
          {
            paramList1.add((String)paramList2[paramInt2]);
            paramInt2 += 1;
          }
        }
        this.val$requests.add(QMMailManager.access$500(this.this$0).unSubscribeMails(paramInt1, (String[])paramList1.toArray(new String[0])));
      }
      for (;;)
      {
        QMPrivateProtocolManager.sharedInstance().syncRejectAddress(paramInt1, this.val$address, this.val$isReject);
        return;
        if (this.val$isGroupFolder)
        {
          paramList1 = QMMailManager.access$000(this.this$0).mail.getGroupIdByMailIds(this.val$readableDb, this.val$mailIds);
          this.val$requests.add(QMMailManager.access$500(this.this$0).rejectGroupMails(paramInt1, paramList1));
        }
        else
        {
          paramList1 = new ArrayList();
          paramList2 = QMMailManager.access$000(this.this$0).mail.getMailInfoByIds(this.val$readableDb, this.val$mailIds, "remoteId");
          if (paramList2 != null)
          {
            paramInt2 = 0;
            while (paramInt2 < paramList2.length)
            {
              paramList1.add((String)paramList2[paramInt2]);
              paramInt2 += 1;
            }
          }
          this.val$requests.add(QMMailManager.access$500(this.this$0).rejectMails(paramInt1, (String[])paramList1.toArray(new String[0])));
        }
      }
    }
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    QMFolder localQMFolder = QMMailManager.access$400(this.this$0).getFolder(paramInt2);
    Object localObject = QMMailManager.access$400(this.this$0);
    if (this.val$isReject) {}
    for (paramInt2 = QMMailManager.access$400(this.this$0).getTrashFolderId(paramInt1);; paramInt2 = QMMailManager.access$400(this.this$0).getInboxFolderId(paramInt1))
    {
      localObject = ((QMFolderManager)localObject).getFolder(paramInt2);
      QMMailManager.access$700(this.this$0).moveMails(localAccount, localQMFolder, (QMFolder)localObject, paramList1, paramList2, null);
      break;
    }
  }
  
  public void onSyncSubscribeConv(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.22
 * JD-Core Version:    0.7.0.1
 */