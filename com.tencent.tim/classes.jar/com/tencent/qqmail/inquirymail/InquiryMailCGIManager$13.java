package com.tencent.qqmail.inquirymail;

import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IBeforeSendCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class InquiryMailCGIManager$13
  implements QMCallback.IBeforeSendCallback
{
  InquiryMailCGIManager$13(InquiryMailCGIManager paramInquiryMailCGIManager, int paramInt1, int paramInt2, long paramLong, String paramString, InquiryMail paramInquiryMail) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest)
  {
    QMLog.log(3, "InquiryMailCGIManager", "retrieveMail OnBeforeSend account:" + this.val$accountId + " page:" + this.val$page + " edgeTime:" + this.val$edgeTime + " msgId:" + this.val$msgId);
    QMWatcherCenter.triggerRetrieveMailListBefore(this.val$accountId, this.val$inquiryMail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager.13
 * JD-Core Version:    0.7.0.1
 */