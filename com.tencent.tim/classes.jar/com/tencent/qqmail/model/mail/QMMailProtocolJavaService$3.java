package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.protocol.activesync.SyncKeyHandler.SyncKeyCallback;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailProtocolJavaService$3
  implements SyncKeyHandler.SyncKeyCallback
{
  QMMailProtocolJavaService$3(QMMailProtocolJavaService paramQMMailProtocolJavaService) {}
  
  public void onSyncKey(int paramInt, String paramString)
  {
    AccountManager.shareInstance().updateFolderListSyncKey(paramInt, paramString);
    QMLog.log(4, "QMMailProtocolJavaService", "SetFolderListSyncKeyCallback:" + paramInt + ":" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.3
 * JD-Core Version:    0.7.0.1
 */