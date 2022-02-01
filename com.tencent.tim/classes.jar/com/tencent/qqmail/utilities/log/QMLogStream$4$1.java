package com.tencent.qqmail.utilities.log;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import java.util.List;

class QMLogStream$4$1
  implements QMCallback.IErrorCallback
{
  QMLogStream$4$1(QMLogStream.4 param4, List paramList) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    paramQMNetworkRequest = new StringBuilder().append("getinvestigate end : ");
    if (paramQMNetworkError == null) {}
    for (boolean bool = true;; bool = false)
    {
      QMLog.log(6, "QMLogStream", bool);
      if (paramQMNetworkError != null)
      {
        QMLog.log(6, "QMLogStream", "submitlog err:" + paramQMNetworkError.code + "," + paramQMNetworkError.desp + "," + this.val$data.size() + ",network:" + QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()));
        QMLogStream.saveLog(QMLogStream.access$800());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLogStream.4.1
 * JD-Core Version:    0.7.0.1
 */