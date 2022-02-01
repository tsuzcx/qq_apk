package com.tencent.qqmail.model.mail.loader;

import com.tencent.qqmail.model.mail.watcher.DownloadImgWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class MailContentLoader$1
  implements DownloadImgWatcher
{
  MailContentLoader$1(MailContentLoader paramMailContentLoader) {}
  
  public void onError(long paramLong, String paramString1, String paramString2, Object paramObject)
  {
    QMLog.log(6, MailContentLoader.TAG, "downloadImgWatcher onError : " + paramString1 + "; " + paramString2);
    Threads.runOnMainThread(new MailContentLoader.1.1(this, paramString1, paramString2));
  }
  
  public void onProcess(long paramLong1, String paramString, long paramLong2, long paramLong3) {}
  
  public void onSuccess(long paramLong, String paramString1, String paramString2)
  {
    QMLog.log(4, MailContentLoader.TAG, "downloadImgWatcher onSuccess : " + paramString2 + " src " + paramString1);
    MailContentLoader.access$100(this.this$0, MailContentLoader.access$000(this.this$0, paramString1), paramString1, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.loader.MailContentLoader.1
 * JD-Core Version:    0.7.0.1
 */