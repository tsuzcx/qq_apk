package com.tencent.qqmail.model.mail;

import android.util.Log;
import com.tencent.qqmail.calendar.fragment.CalendarMainFragment.CreditCardDetailCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMMailCGIManager$36
  implements QMCallback.IErrorCallback
{
  QMMailCGIManager$36(QMMailCGIManager paramQMMailCGIManager, CalendarMainFragment.CreditCardDetailCallback paramCreditCardDetailCallback) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    Log.i("QMMailCGIManager", "getMailReminderCreditDetail setOnError " + paramQMNetworkResponse);
    this.val$creditCardDetailCallback.callback(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.36
 * JD-Core Version:    0.7.0.1
 */