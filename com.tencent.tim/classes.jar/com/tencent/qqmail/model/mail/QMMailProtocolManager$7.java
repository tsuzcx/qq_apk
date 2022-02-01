package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.mail.cursor.QMSyncFolderCursor;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.ArrayList;

class QMMailProtocolManager$7
  implements IListStatusCallback
{
  QMMailProtocolManager$7(QMMailProtocolManager paramQMMailProtocolManager, int paramInt1, IListStatusCallback paramIListStatusCallback, QMFolder paramQMFolder, int paramInt2, Account paramAccount) {}
  
  public void error(QMNetworkError paramQMNetworkError)
  {
    QMLog.log(5, "QMMailProtocolManager", "syncFolder onError, error: " + paramQMNetworkError + ", folder: " + this.val$folder);
    QMWatcherCenter.triggerSyncError(this.val$accountId, paramQMNetworkError);
    if (this.val$callback != null) {
      this.val$callback.error(paramQMNetworkError);
    }
  }
  
  public void process()
  {
    QMWatcherCenter.triggerSyncBegin(this.val$accountId, true);
    if (this.val$callback != null) {
      this.val$callback.process();
    }
  }
  
  public void success(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "QMMailProtocolManager", "syncFolder onSuccess, updated: " + paramBoolean + ", unreadCount: " + paramInt1 + ", count: " + paramInt2 + ", folder: " + this.val$folder);
    QMWatcherCenter.triggerSyncSuccess(this.val$accountId);
    if (this.val$callback != null) {
      this.val$callback.success(paramBoolean, paramInt1, paramInt2);
    }
    QMSyncFolderCursor localQMSyncFolderCursor = new QMSyncFolderCursor(QMMailProtocolManager.access$000(this.this$0), this.val$folderId, true);
    ArrayList localArrayList = QMMailProtocolManager.access$200(this.this$0).getRemoteIds(localQMSyncFolderCursor);
    localQMSyncFolderCursor.close();
    this.this$0.updateList(this.val$account, this.val$folder, localArrayList, new QMMailProtocolManager.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.7
 * JD-Core Version:    0.7.0.1
 */