package com.tencent.image;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class URLState$PreDownloadRunnable$1
  implements Runnable
{
  URLState$PreDownloadRunnable$1(URLState.PreDownloadRunnable paramPreDownloadRunnable) {}
  
  public void run()
  {
    URLState.PreDownloadRunnable localPreDownloadRunnable = null;
    if (QLog.isColorLevel()) {
      QLog.i("URLDrawable_", 2, "PreDwonloadAsyncTask doInBackground." + URLState.PreDownloadRunnable.access$000(this.this$1));
    }
    if (this.this$1.mDownloadRunnable.isCancelled()) {
      return;
    }
    long l = System.currentTimeMillis();
    this.this$1.mDownloadRunnable.postTime = l;
    if (l - URLState.slastCheckTime > 300000L) {
      URLState.access$100(this.this$1.this$0);
    }
    if (this.this$1.hasFile)
    {
      this.this$1.mDownloadRunnable.flag = 0;
      ThreadManagerV2.excute(this.this$1.mDownloadRunnable, 64, null, false);
    }
    for (;;)
    {
      this.this$1.this$0.onLoadStart();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("URLDrawable_", 2, "PreDwonloadAsyncTask onLoadStart." + URLState.PreDownloadRunnable.access$000(this.this$1));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("URLDrawable_", 2, "schedule load image " + this.this$1.this$0.mUrlStr + ",useThreadPool=" + this.this$1.this$0.mUseThreadPool);
      }
      this.this$1.mDownloadRunnable.flag = 1;
      if (this.this$1.mDownloadRunnable.mQueue != null)
      {
        this.this$1.mDownloadRunnable.mQueue.execute(this.this$1.mDownloadRunnable, 128, true);
      }
      else
      {
        if (URLState.PreDownloadRunnable.access$000(this.this$1).getProtocol().equals("chatthumb")) {
          localPreDownloadRunnable = this.this$1;
        }
        ThreadManagerV2.excute(this.this$1.mDownloadRunnable, 128, localPreDownloadRunnable, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.URLState.PreDownloadRunnable.1
 * JD-Core Version:    0.7.0.1
 */