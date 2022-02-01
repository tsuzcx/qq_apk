package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailProtocolNativeService$2
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$2(QMMailProtocolNativeService paramQMMailProtocolNativeService) {}
  
  public void onSyncKey(int paramInt, String paramString)
  {
    QMFolderManager.sharedInstance().updateFolderSyncKey(paramInt, paramString);
    QMLog.log(4, "QMMailProtocolNativeService", "SetSyncKeyCallback:" + paramInt + ":" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.2
 * JD-Core Version:    0.7.0.1
 */