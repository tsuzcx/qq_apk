package com.tencent.qqmail.ftn;

import com.tencent.moai.downloader.model.DownloadTask;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Map;

class FtnManagerImpl$2$1
  implements Runnable
{
  FtnManagerImpl$2$1(FtnManagerImpl.2 param2, long paramLong) {}
  
  public void run()
  {
    if (!QMNetworkUtils.isNetworkConnected()) {
      synchronized (FtnManagerImpl.access$000())
      {
        if (!QMNetworkUtils.isNetworkConnected())
        {
          FtnManagerImpl.access$400();
          Threads.waitNoException(FtnManagerImpl.access$000(), 60000L);
        }
      }
    }
    synchronized (FtnManagerImpl.access$500())
    {
      boolean bool = FtnManagerImpl.access$500().containsKey(Long.valueOf(this.val$id));
      QMLog.log(4, "FtnManagerImpl", "fileDownload, need retry: " + bool);
      if (bool) {
        this.this$0.val$task.start();
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.2.1
 * JD-Core Version:    0.7.0.1
 */