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
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class QMMailCGIManager$29
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$29(QMMailCGIManager paramQMMailCGIManager, int paramInt1, int paramInt2, String paramString, long paramLong, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    do
    {
      try
      {
        int i = this.val$mailFlag;
        paramQMNetworkRequest = QMMailCGIManager.access$1100(this.this$0, this.val$accountId, i | 0x400, paramQMNetworkRequest);
        if ((paramQMNetworkRequest != null) && (((Boolean)paramQMNetworkRequest[2]).booleanValue()))
        {
          paramQMNetworkResponse = (String)paramQMNetworkRequest[4];
          if ((paramQMNetworkResponse != null) && (paramQMNetworkResponse.contains(this.val$remoteId)))
          {
            paramQMNetworkRequest = new QMNetworkError(3, -10011, "该邮件已被删除");
            QMWatcherCenter.triggerReadMailError(this.val$mailId, paramQMNetworkRequest);
            if (this.val$callback != null) {
              this.val$callback.handleError(paramQMNetworkRequest);
            }
            return;
          }
        }
      }
      catch (Exception paramQMNetworkRequest)
      {
        do
        {
          for (;;)
          {
            QMLog.log(6, "QMMailCGIManager", Log.getStackTraceString(paramQMNetworkRequest));
            paramQMNetworkRequest = null;
          }
          QMWatcherCenter.triggerReadRemoteMailSuccess(this.val$mailId);
          if (this.val$callback != null) {
            this.val$callback.handleSuccess(Long.valueOf(this.val$mailId), null);
          }
          paramQMNetworkRequest = (long[])paramQMNetworkRequest[1];
        } while ((!QMNetworkUtils.isWifiConnected()) || (paramQMNetworkRequest == null) || (paramQMNetworkRequest.length <= 0));
        QMMailCGIManager.access$1900(this.this$0, this.val$accountId, paramQMNetworkRequest);
        paramQMNetworkResponse = QMMailCGIManager.access$000(this.this$0).getReadableDatabase();
        QMMailCGIManager.access$000(this.this$0).mail.getMailsPreload(paramQMNetworkResponse, paramQMNetworkRequest, new QMMailCGIManager.29.1(this));
        return;
      }
      paramQMNetworkRequest = new QMNetworkError(3, -10008, "邮件解析失败");
      QMWatcherCenter.triggerReadMailError(this.val$mailId, paramQMNetworkRequest);
    } while (this.val$callback == null);
    this.val$callback.handleError(paramQMNetworkRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.29
 * JD-Core Version:    0.7.0.1
 */