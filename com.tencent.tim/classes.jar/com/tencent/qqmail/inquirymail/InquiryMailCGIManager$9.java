package com.tencent.qqmail.inquirymail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class InquiryMailCGIManager$9
  implements QMCallback.IBeforeSendCallback
{
  InquiryMailCGIManager$9(InquiryMailCGIManager paramInquiryMailCGIManager, int paramInt, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    QMLog.log(3, "InquiryMailCGIManager", "removeBlackList OnBeforeSend account:" + this.val$accountId + " address:" + this.val$senderAddress);
    QMWatcherCenter.triggerRemoveBlackListBefore(this.val$accountId, this.val$senderAddress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager.9
 * JD-Core Version:    0.7.0.1
 */