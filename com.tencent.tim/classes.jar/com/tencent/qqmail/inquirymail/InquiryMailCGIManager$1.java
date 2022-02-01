package com.tencent.qqmail.inquirymail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class InquiryMailCGIManager$1
  implements QMCallback.IBeforeSendCallback
{
  InquiryMailCGIManager$1(InquiryMailCGIManager paramInquiryMailCGIManager, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    QMLog.log(3, "InquiryMailCGIManager", "loadInquiryMailList OnBeforeSend account:" + this.val$accountId);
    QMWatcherCenter.triggerLoadInquiryMailListBefore(this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager.1
 * JD-Core Version:    0.7.0.1
 */