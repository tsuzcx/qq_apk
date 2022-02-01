package com.tencent.qqmail.model.mail;

import com.tencent.moai.mailsdk.callback.FolderCallBack;
import com.tencent.moai.mailsdk.model.Folder;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolJavaService$14
  implements FolderCallBack
{
  QMMailProtocolJavaService$14(QMMailProtocolJavaService paramQMMailProtocolJavaService, FolderOperationCallback paramFolderOperationCallback, Account paramAccount, com.tencent.qqmail.protocol.Profile paramProfile, com.tencent.moai.mailsdk.model.Profile paramProfile1, QMFolder paramQMFolder) {}
  
  public void operateFolderError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.log(6, "QMMailProtocolJavaService", "renameFolder error : " + paramInt1 + ";" + paramInt2 + ";" + paramString);
    if (this.val$callback != null)
    {
      QMProtocolError localQMProtocolError = new QMProtocolError(ProtocolResult.mapToProtocolResult(paramInt1));
      this.val$callback.onError(this.val$folder, localQMProtocolError);
      this.val$callback.onComplete(this.val$folder, localQMProtocolError);
    }
    QMMailProtocolJavaService.access$400(this.this$0, this.val$profile, this.val$protocolProfile.getProtocol(), "renameFolder", paramInt2, paramString);
  }
  
  public void operateFolderSuccess(Folder paramFolder)
  {
    QMLog.log(4, "QMMailProtocolJavaService", "renameFolder success");
    if (this.val$callback != null)
    {
      paramFolder = QMMailProtocolJavaService.access$500(this.this$0, this.val$account.getId(), paramFolder);
      this.val$callback.onSuccess(paramFolder);
      this.val$callback.onComplete(paramFolder, null);
    }
    QMMailProtocolJavaService.access$300(this.this$0, this.val$profile.mailAddress, this.val$protocolProfile.getProtocol(), "renameFolder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.14
 * JD-Core Version:    0.7.0.1
 */