package com.tencent.qqmail.inquirymail;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class InquiryMailCGIManager$10
  implements QMCallback.ISuccessCallback
{
  InquiryMailCGIManager$10(InquiryMailCGIManager paramInquiryMailCGIManager, int paramInt, String paramString) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(3, "InquiryMailCGIManager", "removeBlackList OnSuccess account:" + this.val$accountId + " address:" + this.val$senderAddress);
    paramQMNetworkRequest = InquiryMailCGIManager.access$000(this.this$0).getWritableDatabase();
    try
    {
      paramQMNetworkRequest.beginTransaction();
      InquiryMailCGIManager.access$000(this.this$0).inquiryMail.updateInquiryMailReasonBySenderAddressAndReason(paramQMNetworkRequest, 12, InquiryMail.REASONS_CAN_REMOVE_BLACK_LIST, this.val$senderAddress);
      paramQMNetworkRequest.setTransactionSuccessful();
    }
    catch (Exception paramQMNetworkResponse)
    {
      for (;;)
      {
        QMLog.log(6, "InquiryMailCGIManager", Log.getStackTraceString(paramQMNetworkResponse));
        paramQMNetworkRequest.endTransaction();
      }
    }
    finally
    {
      paramQMNetworkRequest.endTransaction();
    }
    QMWatcherCenter.triggerRemoveBlackListSuccess(this.val$accountId, this.val$senderAddress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager.10
 * JD-Core Version:    0.7.0.1
 */