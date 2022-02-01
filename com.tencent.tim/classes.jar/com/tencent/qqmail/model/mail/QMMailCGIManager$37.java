package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$37
  implements QMCallback.ISuccessCallback
{
  QMMailCGIManager$37(QMMailCGIManager paramQMMailCGIManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setMailReminderRequestState setOnSuccess ");
    if (paramQMNetworkResponse == null) {}
    for (paramQMNetworkRequest = null;; paramQMNetworkRequest = paramQMNetworkResponse.getResponseJson())
    {
      Log.i("QMMailCGIManager", paramQMNetworkRequest);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.37
 * JD-Core Version:    0.7.0.1
 */