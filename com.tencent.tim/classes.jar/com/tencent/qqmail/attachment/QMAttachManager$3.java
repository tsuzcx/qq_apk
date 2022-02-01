package com.tencent.qqmail.attachment;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.GroupAttachFolderWatcher;
import com.tencent.qqmail.model.mail.watcher.GroupAttachFolderWatcher.SyncRemoteParams;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter.AttachFolderOperationType;

class QMAttachManager$3
  implements GroupAttachFolderWatcher
{
  QMAttachManager$3(QMAttachManager paramQMAttachManager, long[] paramArrayOfLong, boolean paramBoolean) {}
  
  public boolean isQQMail(int paramInt)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localAccount != null) {
      return localAccount.isQQMail();
    }
    return false;
  }
  
  public void onSyncLocal(int paramInt, long[] paramArrayOfLong)
  {
    SQLiteDatabase localSQLiteDatabase = QMAttachManager.access$200(this.this$0).getWritableDatabase();
    QMAttachManager.access$200(this.this$0).attach.updateAttachFavorite(localSQLiteDatabase, paramArrayOfLong, this.val$isFavorite);
  }
  
  public void onSyncLocalComplete()
  {
    QMWatcherCenter.triggerAttachFolderOpertionSuccess(QMWatcherCenter.AttachFolderOperationType.FAVORITE, this.val$attachIds);
  }
  
  public void onSyncRemote(int paramInt, GroupAttachFolderWatcher.SyncRemoteParams[] paramArrayOfSyncRemoteParams)
  {
    SQLiteDatabase localSQLiteDatabase = QMAttachManager.access$200(this.this$0).getWritableDatabase();
    QMAttachManager.access$200(this.this$0).attach.updateAttachFavorite(localSQLiteDatabase, this.val$attachIds, this.val$isFavorite);
    this.this$0.attachFolderFavorite(paramInt, this.val$attachIds, this.val$isFavorite, paramArrayOfSyncRemoteParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.QMAttachManager.3
 * JD-Core Version:    0.7.0.1
 */