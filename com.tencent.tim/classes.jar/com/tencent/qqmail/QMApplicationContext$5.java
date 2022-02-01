package com.tencent.qqmail;

import com.tencent.qqmail.utilities.osslog.QMOssClient;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

class QMApplicationContext$5
  implements Runnable
{
  QMApplicationContext$5(QMApplicationContext paramQMApplicationContext) {}
  
  public void run()
  {
    OssHelper.setClient(QMOssClient.getInstance());
    KvHelper.setClient(QMOssClient.getInstance());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMApplicationContext.5
 * JD-Core Version:    0.7.0.1
 */