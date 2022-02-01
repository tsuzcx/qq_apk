package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailProtocolNativeService$3
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$3(QMMailProtocolNativeService paramQMMailProtocolNativeService) {}
  
  public void onSyncKey(int paramInt, String paramString)
  {
    AccountManager.shareInstance().updateFolderListSyncKey(paramInt, paramString);
    QMLog.log(4, "QMMailProtocolNativeService", "SetFolderListSyncKeyCallback:" + paramInt + ":" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.3
 * JD-Core Version:    0.7.0.1
 */