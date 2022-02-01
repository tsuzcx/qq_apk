package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$51
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$51(QMMailCGIManager paramQMMailCGIManager, long paramLong, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "QMMailCGIManager", "recallMail Success:" + paramQMNetworkResponse.getResponseString());
    int i = 1;
    long l1 = 0L;
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    if (paramQMNetworkResponse != null) {}
    for (;;)
    {
      try
      {
        paramQMNetworkRequest = paramQMNetworkResponse.getString("taskid");
        paramQMNetworkResponse = paramQMNetworkResponse.getString("errcode");
        if ((paramQMNetworkRequest == null) || (paramQMNetworkRequest.equals("")) || (paramQMNetworkResponse == null) || (paramQMNetworkResponse.equals(""))) {
          continue;
        }
        l2 = Long.valueOf(paramQMNetworkRequest).longValue();
        l3 = Long.valueOf(paramQMNetworkResponse).longValue();
        if ((l2 <= 0L) || (l3 != 0L)) {
          continue;
        }
        i = 0;
        l1 = l2;
      }
      catch (Exception paramQMNetworkRequest)
      {
        long l2;
        long l3;
        QMLog.log(6, "QMMailCGIManager", Log.getStackTraceString(paramQMNetworkRequest));
        continue;
        paramQMNetworkRequest = new QMNetworkError(3, -10014, "撤回邮件失败");
        if (this.val$callback == null) {
          continue;
        }
        this.val$callback.handleError(paramQMNetworkRequest);
        QMWatcherCenter.triggerRecallMailError(this.val$mailId, paramQMNetworkRequest);
      }
      if (i != 0) {
        continue;
      }
      QMMailCGIManager.access$000(this.this$0).mail.updateMailAttr(QMMailCGIManager.access$000(this.this$0).getWritableDatabase(), new long[] { this.val$mailId }, 16L);
      if (this.val$callback != null) {
        this.val$callback.handleSuccess(Long.valueOf(this.val$mailId), new long[] { l1 });
      }
      QMWatcherCenter.triggerRecallMailSuccess(this.val$mailId, l1);
      return;
      QMLog.log(5, "QMMailCGIManager", "recallMail mTaskId:" + l2 + " mErrCode:" + l3);
      l1 = 0L;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.51
 * JD-Core Version:    0.7.0.1
 */