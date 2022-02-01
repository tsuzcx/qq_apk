package com.tencent.qqmail.activity.readmail;

import android.util.Log;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class ReadMailFragment$45
  implements QMCallback.IErrorCallback
{
  ReadMailFragment$45(ReadMailFragment paramReadMailFragment) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    Log.i("ReadMailFragment", "queryMailReminderCreditBillSetting setOnError " + paramQMNetworkResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.45
 * JD-Core Version:    0.7.0.1
 */