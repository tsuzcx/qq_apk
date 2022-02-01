package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.FolderSyncExchangeCallBack;
import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$9
  implements FolderSyncExchangeCallBack
{
  QMMailProtocolJavaService$9(QMMailProtocolJavaService paramQMMailProtocolJavaService, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, int paramInt) {}
  
  public void onSyncStatusError(int paramInt1, int paramInt2, String paramString)
  {
    int i = ProtocolResult.mapToProtocolResult(paramInt1);
    QMLog.log(6, "QMMailProtocolJavaService", "syncExchangeFolderStatus error : " + paramInt1 + ";" + paramInt2 + ";" + paramString);
    if (paramInt1 == 4) {
      PasswordErrHandler.saveStateAndShowErr(this.val$accountId, -1);
    }
    if (this.val$callback != null) {
      this.val$callback.error(new QMProtocolError(i));
    }
    QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "syncFolderStatus", paramInt2, paramString);
  }
  
  public void onSyncStatusSuccess(int paramInt)
  {
    if ((this.val$folder.isOverdue()) || (paramInt != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.val$callback != null) {
        this.val$callback.success(bool, -1, -1);
      }
      QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "syncFolderStatus");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.9
 * JD-Core Version:    0.7.0.1
 */