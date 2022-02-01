package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.FolderOperationCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.ProtocolResult.FolderOperationResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$12
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$12(QMMailProtocolNativeService paramQMMailProtocolNativeService, int paramInt1, QMFolder paramQMFolder, int paramInt2, FolderOperationCallback paramFolderOperationCallback, Profile paramProfile) {}
  
  public void onResult(ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "rename accountId:" + this.val$accountId + " folder:" + this.val$folder.getName() + " result:" + paramProtocolResult.error_code_);
    if (paramProtocolResult.error_code_ == 0)
    {
      paramProtocolResult = QMMailProtocolNativeService.access$300(this.this$0, this.val$accountId, this.val$protocolType, paramProtocolResult.folder_operation_result_.update_folder_);
      this.val$callback.onSuccess(paramProtocolResult);
      this.val$callback.onComplete(paramProtocolResult, null);
      QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "renameFolder", true);
      return;
    }
    paramProtocolResult = new QMProtocolError(paramProtocolResult.error_code_);
    this.val$callback.onError(this.val$folder, paramProtocolResult);
    this.val$callback.onComplete(this.val$folder, paramProtocolResult);
    QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "renameFolder", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.12
 * JD-Core Version:    0.7.0.1
 */