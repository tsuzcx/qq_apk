package com.tencent.qqmail;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.osslog.CovFileClient;

class QMApplicationContext$6
  implements Runnable
{
  QMApplicationContext$6(QMApplicationContext paramQMApplicationContext) {}
  
  public void run()
  {
    QMLog.log(4, "QMApplicationContext", "covtest upload");
    CovFileClient.getInstance().submit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMApplicationContext.6
 * JD-Core Version:    0.7.0.1
 */