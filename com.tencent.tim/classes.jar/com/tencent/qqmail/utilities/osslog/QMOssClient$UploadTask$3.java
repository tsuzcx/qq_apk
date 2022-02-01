package com.tencent.qqmail.utilities.osslog;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import rx.functions.Func1;

class QMOssClient$UploadTask$3
  implements Func1<Throwable, QMNetworkResponse>
{
  QMOssClient$UploadTask$3(QMOssClient.UploadTask paramUploadTask) {}
  
  public QMNetworkResponse call(Throwable paramThrowable)
  {
    QMLog.log(5, "QMOssClient", "upload kv/osslog failed", paramThrowable);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.osslog.QMOssClient.UploadTask.3
 * JD-Core Version:    0.7.0.1
 */