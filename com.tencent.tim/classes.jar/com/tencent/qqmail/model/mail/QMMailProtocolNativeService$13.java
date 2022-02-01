package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$13
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$13(QMMailProtocolNativeService paramQMMailProtocolNativeService, int paramInt, QMFolder paramQMFolder, FolderOperationCallback paramFolderOperationCallback, Profile paramProfile) {}
  
  public void onResult(ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "removeFolder accountId:" + this.val$accountId + " folder:" + this.val$folder.getName() + " result:" + paramProtocolResult.error_code_);
    if (paramProtocolResult.error_code_ == 0)
    {
      this.val$callback.onSuccess(this.val$folder);
      this.val$callback.onComplete(this.val$folder, null);
      QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "removeFolder", true);
      return;
    }
    paramProtocolResult = new QMProtocolError(paramProtocolResult.error_code_);
    this.val$callback.onError(this.val$folder, paramProtocolResult);
    this.val$callback.onComplete(this.val$folder, paramProtocolResult);
    QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "removeFolder", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.13
 * JD-Core Version:    0.7.0.1
 */