package com.tencent.qqmail.utilities.log;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.io.File;
import java.util.List;

class QMLogStream$4$2
  implements QMCallback.ISuccessCallback
{
  QMLogStream$4$2(QMLogStream.4 param4, List paramList, File paramFile) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMLog.log(4, "QMLogStream", "submitlogsuccess:" + this.val$data.size());
    this.val$remoteLogFile.delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLogStream.4.2
 * JD-Core Version:    0.7.0.1
 */