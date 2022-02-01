package com.tencent.qqmail.model.sendmail;

import android.util.Log;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISendDataCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class SendMailManager$28
  implements QMCallback.ISendDataCallback
{
  SendMailManager$28(SendMailManager paramSendMailManager, SendMailManager.BytesWrittenRecord paramBytesWrittenRecord, long paramLong, QMCallback paramQMCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, Long paramLong1, Long paramLong2)
  {
    long l1 = this.val$bytesWrittenRecord.totalBytes;
    long l2 = this.val$postDataBytesEstimation;
    l1 = paramLong1.longValue() + (l1 - l2);
    l2 = this.val$bytesWrittenRecord.totalBytes;
    long l3 = this.val$postDataBytesEstimation;
    l2 = paramLong2.longValue() + (l2 - l3);
    Log.d(SendMailManager.access$100(), "sendMailPostProcess: bytesWritten:" + l1 + " totalBytesWritten:" + l2 + ", totalPostDataBytesWritten:" + paramLong2);
    if (this.val$qmcallback != null) {
      this.val$qmcallback.handleSendData(paramQMNetworkRequest, l1, l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.sendmail.SendMailManager.28
 * JD-Core Version:    0.7.0.1
 */