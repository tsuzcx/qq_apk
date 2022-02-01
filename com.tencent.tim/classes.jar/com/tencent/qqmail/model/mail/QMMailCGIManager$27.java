package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$27
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$27(QMMailCGIManager paramQMMailCGIManager, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    paramQMNetworkRequest = null;
    try
    {
      paramQMNetworkResponse = QMMailCGIManager.access$1100(this.this$0, this.val$accountId, 1024, paramQMNetworkResponse);
      paramQMNetworkRequest = paramQMNetworkResponse;
    }
    catch (Exception paramQMNetworkResponse)
    {
      for (;;)
      {
        int j;
        int i;
        QMLog.log(6, "QMMailCGIManager", Log.getStackTraceString(paramQMNetworkResponse));
      }
    }
    if ((paramQMNetworkRequest != null) && (((Boolean)paramQMNetworkRequest[2]).booleanValue()))
    {
      paramQMNetworkRequest = (long[])paramQMNetworkRequest[1];
      if ((paramQMNetworkRequest != null) && (paramQMNetworkRequest.length > 0))
      {
        QMMailCGIManager.access$1900(this.this$0, this.val$accountId, paramQMNetworkRequest);
        j = paramQMNetworkRequest.length;
        i = 0;
        while (i < j)
        {
          QMWatcherCenter.triggerReadRemoteMailSuccess(paramQMNetworkRequest[i]);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.27
 * JD-Core Version:    0.7.0.1
 */