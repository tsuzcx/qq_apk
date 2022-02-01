package com.tencent.qqmail.inquirymail;

import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class InquiryMailCGIManager$15
  implements QMCallback.IErrorCallback
{
  InquiryMailCGIManager$15(InquiryMailCGIManager paramInquiryMailCGIManager, int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, InquiryMail paramInquiryMail) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(3, "InquiryMailCGIManager", "retrieveMail OnError account:" + this.val$accountId + " page:" + this.val$page + " edgeTime:" + this.val$edgeTime + " msgId:" + this.val$msgId);
    RequestFilter.resetRequestRunningState(this.val$requestFilterKey);
    QMWatcherCenter.triggerRetrieveMailListError(this.val$accountId, this.val$inquiryMail, paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager.15
 * JD-Core Version:    0.7.0.1
 */