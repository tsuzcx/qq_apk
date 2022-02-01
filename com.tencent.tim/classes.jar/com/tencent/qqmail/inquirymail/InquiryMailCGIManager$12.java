package com.tencent.qqmail.inquirymail;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ICompleteCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class InquiryMailCGIManager$12
  implements QMCallback.ICompleteCallback
{
  InquiryMailCGIManager$12(InquiryMailCGIManager paramInquiryMailCGIManager, int paramInt, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(3, "InquiryMailCGIManager", "removeBlackList OnComplete account:" + this.val$accountId + " address:" + this.val$senderAddress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager.12
 * JD-Core Version:    0.7.0.1
 */