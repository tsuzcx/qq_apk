package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.IListStatusCallback;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Exchange.ExchangeContent;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.ProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;

class QMMailProtocolNativeService$8
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$8(QMMailProtocolNativeService paramQMMailProtocolNativeService, QMFolder paramQMFolder, IListStatusCallback paramIListStatusCallback, Profile paramProfile) {}
  
  public void onResult(ProtocolResult paramProtocolResult)
  {
    QMLog.log(4, "QMMailProtocolNativeService", "syncFolderStatus folder:" + this.val$folder.getId() + ",result:" + paramProtocolResult.error_code_);
    boolean bool;
    if (paramProtocolResult.error_code_ == 0) {
      if ((this.val$folder.isOverdue()) || (paramProtocolResult.exchange_content_.activesync_estimate_ != 0))
      {
        bool = true;
        this.this$0.saveActiveSync(this.val$folder.getAccountId(), paramProtocolResult);
        if (this.val$callback != null) {
          this.val$callback.success(bool, 0, 0);
        }
      }
    }
    for (;;)
    {
      if (paramProtocolResult.error_code_ != 0) {
        break label372;
      }
      QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "syncFolderStatus", true);
      return;
      bool = false;
      break;
      if (paramProtocolResult.error_code_ == 13)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "syncFolderStatus wipe account. fld info : " + this.val$folder.getRemoteId() + ", " + this.val$folder.getId());
        QMPrivateProtocolManager.sharedInstance().triggerWipeAppWatcher(this.val$folder.getAccountId());
        if (this.val$callback != null) {
          this.val$callback.error(new QMProtocolError(paramProtocolResult.error_code_));
        }
      }
      else if (paramProtocolResult.error_code_ == 4)
      {
        QMLog.log(6, "QMMailProtocolNativeService", "syncFolderStatus auth err : " + this.val$folder.getAccountId());
        PasswordErrHandler.saveStateAndShowErr(this.val$folder.getAccountId(), -1);
        if (this.val$callback != null) {
          this.val$callback.error(new QMProtocolError(paramProtocolResult.error_code_));
        }
      }
      else
      {
        QMLog.log(6, "QMMailProtocolNativeService", "syncFolderStatus err : " + paramProtocolResult.error_code_);
        if (this.val$callback != null) {
          this.val$callback.error(new QMProtocolError(paramProtocolResult.error_code_));
        }
      }
    }
    label372:
    QMMailProtocolNativeService.access$100(this.this$0, this.val$profile, "syncFolderStatus", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.8
 * JD-Core Version:    0.7.0.1
 */