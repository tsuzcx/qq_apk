package com.tencent.qqmail.inquirymail;

import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ICompleteCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class InquiryMailCGIManager$16
  implements QMCallback.ICompleteCallback
{
  InquiryMailCGIManager$16(InquiryMailCGIManager paramInquiryMailCGIManager, int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(3, "InquiryMailCGIManager", "retrieveMail OnComplete account:" + this.val$accountId + " page:" + this.val$page + " edgeTime:" + this.val$edgeTime + " msgId:" + this.val$msgId);
    RequestFilter.resetRequestRunningState(this.val$requestFilterKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager.16
 * JD-Core Version:    0.7.0.1
 */