package com.tencent.qqmail.inquirymail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class InquiryMailCGIManager$5
  implements QMCallback.IBeforeSendCallback
{
  InquiryMailCGIManager$5(InquiryMailCGIManager paramInquiryMailCGIManager, int paramInt, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    QMLog.log(3, "InquiryMailCGIManager", "addWhiteList OnBeforeSend account:" + this.val$accountId + " address:" + this.val$senderAddress);
    QMWatcherCenter.triggerAddToWhiteListBefore(this.val$accountId, this.val$senderAddress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager.5
 * JD-Core Version:    0.7.0.1
 */