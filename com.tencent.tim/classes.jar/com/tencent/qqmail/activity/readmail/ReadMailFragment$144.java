package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class ReadMailFragment$144
  implements QMCallback.IErrorCallback
{
  ReadMailFragment$144(ReadMailFragment paramReadMailFragment) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "ReadMailFragment", "vote error, response: " + paramQMNetworkResponse);
    ReadMailFragment.access$22900(this.this$0, new ReadMailFragment.144.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.144
 * JD-Core Version:    0.7.0.1
 */