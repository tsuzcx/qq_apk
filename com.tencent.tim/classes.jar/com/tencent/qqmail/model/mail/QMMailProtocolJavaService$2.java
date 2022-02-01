package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.protocol.activesync.SyncKeyHandler.SyncKeyCallback;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailProtocolJavaService$2
  implements SyncKeyHandler.SyncKeyCallback
{
  QMMailProtocolJavaService$2(QMMailProtocolJavaService paramQMMailProtocolJavaService) {}
  
  public void onSyncKey(int paramInt, String paramString)
  {
    QMFolderManager.sharedInstance().updateFolderSyncKey(paramInt, paramString);
    QMLog.log(4, "QMMailProtocolJavaService", "SetSyncKeyCallback:" + paramInt + ":" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.2
 * JD-Core Version:    0.7.0.1
 */