package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.callback.FolderListCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import java.util.ArrayList;
import moai.oss.OssHelper;

class QMMailProtocolManager$4
  implements FolderListCallback
{
  QMMailProtocolManager$4(QMMailProtocolManager paramQMMailProtocolManager, String paramString, int paramInt, Account paramAccount) {}
  
  public void onError(QMProtocolError paramQMProtocolError)
  {
    RequestFilter.resetRequestRunningState(this.val$req);
    QMWatcherCenter.triggerSyncError(this.val$accountId, paramQMProtocolError);
    QMWatcherCenter.triggerSyncEnd(this.val$accountId, true);
  }
  
  public void onSuccess(QMFolder[] paramArrayOfQMFolder1, QMFolder[] paramArrayOfQMFolder2, QMFolder[] paramArrayOfQMFolder3)
  {
    int i = 0;
    RequestFilter.resetRequestRunningState(this.val$req);
    QMWatcherCenter.triggerSyncSuccess(this.val$accountId);
    QMWatcherCenter.triggerSyncEnd(this.val$accountId, true);
    paramArrayOfQMFolder3 = QMMailProtocolManager.access$000(this.this$0).folder.getFoldersByAccountAndType(this.val$accountId, 3);
    if ((paramArrayOfQMFolder3 == null) || (paramArrayOfQMFolder3.size() == 0))
    {
      QMLog.log(4, "QMMailProtocolManager", "no sent box id:" + this.val$account.getEmail());
      paramArrayOfQMFolder2 = this.val$account.getEmail();
      paramArrayOfQMFolder1 = paramArrayOfQMFolder2;
      if (paramArrayOfQMFolder2.contains("@")) {
        paramArrayOfQMFolder1 = paramArrayOfQMFolder2.split("@")[1];
      }
      OssHelper.noSentBox(new Object[] { paramArrayOfQMFolder1, Integer.valueOf(this.val$account.getProfile().protocolType) });
    }
    if ((this.val$account.isActiveSyncMail()) || (this.val$account.isExchangeMail()))
    {
      this.this$0.initList(QMMailProtocolManager.access$100(this.this$0).getInboxFolderId(this.val$accountId));
      this.this$0.initList(QMMailProtocolManager.access$100(this.this$0).getSentFolderId(this.val$accountId));
    }
    for (;;)
    {
      return;
      paramArrayOfQMFolder1 = QMMailProtocolManager.access$000(this.this$0).folder.getFolders(this.val$accountId, true, new int[] { 3, 4, 6, 5 });
      paramArrayOfQMFolder2 = new ArrayList();
      if ((paramArrayOfQMFolder3 != null) && (paramArrayOfQMFolder3.size() > 0)) {
        paramArrayOfQMFolder2.addAll(paramArrayOfQMFolder3);
      }
      if ((paramArrayOfQMFolder1 != null) && (paramArrayOfQMFolder1.size() > 0)) {
        paramArrayOfQMFolder2.addAll(paramArrayOfQMFolder1);
      }
      int j = Math.min(paramArrayOfQMFolder2.size(), 3);
      while (i < j)
      {
        this.this$0.initList(((QMFolder)paramArrayOfQMFolder2.get(i)).getId());
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.4
 * JD-Core Version:    0.7.0.1
 */