package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager.FolderOperationType;
import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailManager$8
  extends FolderOperationCallback
{
  QMMailManager$8(QMMailManager paramQMMailManager, boolean paramBoolean, int paramInt, String paramString1, String paramString2, QMFolder paramQMFolder, QMFolderManager.FolderOperationType paramFolderOperationType) {}
  
  public void onError(QMFolder paramQMFolder, QMNetworkError paramQMNetworkError)
  {
    QMWatcherCenter.triggrFolderOpertionError(this.val$type, paramQMNetworkError);
  }
  
  public void onSuccess(QMFolder paramQMFolder)
  {
    localSQLiteDatabase = QMMailManager.access$000(this.this$0).getWritableDatabase();
    localSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      if (this.val$isTag)
      {
        long[] arrayOfLong = QMMailManager.access$000(this.this$0).mail.getFolderMailIds(localSQLiteDatabase, paramQMFolder);
        QMMailManager.access$000(this.this$0).mail.renameTag(localSQLiteDatabase, this.val$accountId, arrayOfLong, paramQMFolder.getRemoteId(), this.val$newFolderName, this.val$oldFolderName);
      }
      QMMailManager.access$000(this.this$0).folder.renameFolder(localSQLiteDatabase, this.val$oldFolder.getId(), this.val$newFolderName);
      if ((!this.val$isTag) && (AccountManager.shareInstance().getAccountList().getAccountById(this.val$oldFolder.getAccountId()).isImapMail())) {
        QMMailManager.access$000(this.this$0).folder.updateFolderRemoteId(localSQLiteDatabase, this.val$oldFolder.getId(), paramQMFolder.getRemoteId());
      }
      localSQLiteDatabase.setTransactionSuccessful();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMMailManager", Log.getStackTraceString(localException));
        localSQLiteDatabase.endTransaction();
      }
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    QMWatcherCenter.triggrFolderOpertionSuccess(this.val$type, paramQMFolder, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.8
 * JD-Core Version:    0.7.0.1
 */