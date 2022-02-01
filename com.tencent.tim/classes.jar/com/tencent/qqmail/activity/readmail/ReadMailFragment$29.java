package com.tencent.qqmail.activity.readmail;

import android.util.Log;
import com.tencent.qqmail.download.watcher.DownloadWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class ReadMailFragment$29
  implements DownloadWatcher
{
  ReadMailFragment$29(ReadMailFragment paramReadMailFragment) {}
  
  public void onError(int paramInt, long paramLong, Object paramObject)
  {
    Threads.runOnMainThread(new ReadMailFragment.29.4(this, paramLong, paramObject));
  }
  
  public void onProcess(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong2 == paramLong3)
    {
      Log.i("ReadMailFragment", "downloadSize == totalSize");
      Threads.runOnMainThread(new ReadMailFragment.29.1(this));
    }
    long l = System.currentTimeMillis();
    if (l - ReadMailFragment.access$8300(this.this$0) < 30L) {
      return;
    }
    ReadMailFragment.access$8302(this.this$0, l);
    Threads.runOnMainThread(new ReadMailFragment.29.2(this, paramLong2, paramLong3, paramLong1));
  }
  
  public void onSuccess(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    QMLog.log(4, "ReadMailFragment", "download onSuccess attachID :" + paramLong + " storagePath:" + paramString1 + " copyPath:" + paramString2);
    Threads.runOnMainThread(new ReadMailFragment.29.3(this, paramLong, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.29
 * JD-Core Version:    0.7.0.1
 */