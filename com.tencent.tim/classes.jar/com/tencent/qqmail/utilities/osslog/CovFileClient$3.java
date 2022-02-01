package com.tencent.qqmail.utilities.osslog;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.functions.Func1;

class CovFileClient$3
  implements Func1<Throwable, QMNetworkResponse>
{
  CovFileClient$3(CovFileClient paramCovFileClient) {}
  
  public QMNetworkResponse call(Throwable paramThrowable)
  {
    QMLog.log(5, "CovFileClient", "upload covtest failed", paramThrowable);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.osslog.CovFileClient.3
 * JD-Core Version:    0.7.0.1
 */