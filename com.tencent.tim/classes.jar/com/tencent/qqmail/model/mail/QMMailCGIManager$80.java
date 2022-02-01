package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$80
  implements QMCallback.IErrorCallback
{
  QMMailCGIManager$80(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    int j = 2131691178;
    QMLog.log(6, "followShareCalendarFolder", paramQMNetworkError.toString());
    int i = j;
    if ((paramQMNetworkError instanceof QMCGIError))
    {
      paramQMNetworkRequest = (QMCGIError)paramQMNetworkError;
      i = j;
      switch (paramQMNetworkRequest.appCode)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      QMLog.log(6, "followShareCalendarFolder", "error code :" + paramQMNetworkRequest.appCode);
      paramQMNetworkRequest = QMApplicationContext.sharedInstance().getString(i);
      if (this.val$callback != null) {
        this.val$callback.handleError(paramQMNetworkRequest);
      }
      return;
      i = 2131691187;
      continue;
      i = 2131691180;
      continue;
      i = 2131691182;
      continue;
      i = 2131691181;
      continue;
      i = 2131691179;
      continue;
      i = 2131691186;
      continue;
      i = 2131691185;
      continue;
      i = 2131691184;
      continue;
      i = 2131691183;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.80
 * JD-Core Version:    0.7.0.1
 */