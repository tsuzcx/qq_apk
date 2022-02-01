package com.tencent.qqmail.utilities.services;

import com.tencent.qqmail.protocol.DataCollectorImpl;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.osslog.QMOssClient;

class QMNotifyService$2
  implements Runnable
{
  QMNotifyService$2(QMNotifyService paramQMNotifyService) {}
  
  public void run()
  {
    QMLog.flush();
    QMOssClient.getInstance().flush();
    DataCollectorImpl.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.services.QMNotifyService.2
 * JD-Core Version:    0.7.0.1
 */