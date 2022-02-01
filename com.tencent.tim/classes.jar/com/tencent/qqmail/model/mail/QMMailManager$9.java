package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.folderlist.QMFolderManager.FolderOperationType;
import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.mail.rule.QMRuleManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class QMMailManager$9
  extends FolderOperationCallback
{
  QMMailManager$9(QMMailManager paramQMMailManager, boolean paramBoolean, int paramInt1, QMFolder paramQMFolder, int paramInt2, QMFolderManager.FolderOperationType paramFolderOperationType) {}
  
  public void onError(QMFolder paramQMFolder, QMNetworkError paramQMNetworkError)
  {
    QMWatcherCenter.triggrFolderOpertionError(this.val$type, paramQMNetworkError);
  }
  
  public void onSuccess(QMFolder paramQMFolder)
  {
    localSQLiteDatabase1 = QMMailManager.access$000(this.this$0).getWritableDatabase();
    localSQLiteDatabase1.beginTransactionNonExclusive();
    try
    {
      if (this.val$isTag) {
        this.this$0.withFolderUnreadCount(this.val$accountId, new QMMailManager.9.1(this));
      }
      Object localObject = QMMailManager.access$000(this.this$0).mail;
      int i = this.val$oldFolder.getId();
      int j = this.val$saveFolderId;
      boolean bool = this.val$isTag;
      ((QMMailSQLite)localObject).updateMailsFolderId(localSQLiteDatabase1, new int[] { i }, j, bool);
      this.this$0.updateAdvertiseEntrance(localSQLiteDatabase1, this.val$accountId);
      localObject = QMMailManager.access$000(this.this$0).folder;
      SQLiteDatabase localSQLiteDatabase2 = QMMailManager.access$000(this.this$0).getWritableDatabase();
      i = this.val$accountId;
      j = this.val$oldFolder.getId();
      int k = this.val$saveFolderId;
      bool = this.val$isTag;
      ((QMFolderSQLite)localObject).removeFolder(localSQLiteDatabase2, i, new int[] { j }, k, bool);
      if (!this.val$isTag) {
        QMMailManager.access$100(this.this$0).removeAutoMove(this.val$accountId, this.val$oldFolder.getId(), this.val$oldFolder.getRemoteId());
      }
      localSQLiteDatabase1.setTransactionSuccessful();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, "QMMailManager", Log.getStackTraceString(localException));
        localSQLiteDatabase1.endTransaction();
      }
    }
    finally
    {
      localSQLiteDatabase1.endTransaction();
    }
    QMWatcherCenter.triggrFolderOpertionSuccess(this.val$type, paramQMFolder, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.9
 * JD-Core Version:    0.7.0.1
 */