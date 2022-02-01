package com.tencent.qqmail.download.activity;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.utilities.thread.Threads;

class DownloadActivity$6$1$1
  extends QMRefreshCallback
{
  DownloadActivity$6$1$1(DownloadActivity.6.1 param1) {}
  
  public void onRefreshComplete()
  {
    Threads.runOnMainThread(new DownloadActivity.6.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.6.1.1
 * JD-Core Version:    0.7.0.1
 */