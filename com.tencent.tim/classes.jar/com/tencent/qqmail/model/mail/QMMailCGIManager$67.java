package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.data.CalendarShareError;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.verify.QMVerify;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class QMMailCGIManager$67
  implements QMCallback.IErrorCallback
{
  QMMailCGIManager$67(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate, QMVerify paramQMVerify) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "shareCalendarFolder", paramQMNetworkError.toString());
    int i = paramQMNetworkError.getCode();
    paramQMNetworkRequest = paramQMNetworkError.getMessage();
    if ((paramQMNetworkError instanceof QMCGIError))
    {
      paramQMNetworkRequest = (QMCGIError)paramQMNetworkError;
      i = paramQMNetworkRequest.appCode;
      paramQMNetworkRequest = paramQMNetworkRequest.desp;
    }
    paramQMNetworkResponse = paramQMNetworkRequest;
    if (StringExtention.isNullOrEmpty(paramQMNetworkRequest)) {
      paramQMNetworkResponse = QMApplicationContext.sharedInstance().getString(2131691170);
    }
    if (this.val$callback != null)
    {
      paramQMNetworkRequest = new CalendarShareError(i, paramQMNetworkResponse);
      paramQMNetworkRequest.setShareVerify(this.val$shareVerify);
      paramQMNetworkRequest.setErrorEmails(null);
      this.val$callback.handleError(paramQMNetworkRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.67
 * JD-Core Version:    0.7.0.1
 */