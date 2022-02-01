package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.download.watcher.DownloadWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class QMReadEmlActivity$3
  implements DownloadWatcher
{
  QMReadEmlActivity$3(QMReadEmlActivity paramQMReadEmlActivity) {}
  
  public void onError(int paramInt, long paramLong, Object paramObject)
  {
    Threads.runOnMainThread(new QMReadEmlActivity.3.3(this, paramLong, paramObject));
  }
  
  public void onProcess(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    long l = System.currentTimeMillis();
    if (l - QMReadEmlActivity.access$1200(this.this$0) < 200L) {
      return;
    }
    QMReadEmlActivity.access$1202(this.this$0, l);
    Threads.runOnMainThread(new QMReadEmlActivity.3.1(this, paramLong2, paramLong3, paramLong1));
  }
  
  public void onSuccess(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    QMLog.log(4, "QMReadEmlActivity", "download onSuccess attachID :" + paramLong + " storagePath:" + paramString1 + " copyPath:" + paramString2);
    Threads.runOnMainThread(new QMReadEmlActivity.3.2(this, paramLong, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.3
 * JD-Core Version:    0.7.0.1
 */