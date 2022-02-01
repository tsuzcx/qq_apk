package com.tencent.qqmail.download.activity;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.utilities.thread.Threads;

class DownloadActivity$3
  extends QMRefreshCallback
{
  DownloadActivity$3(DownloadActivity paramDownloadActivity) {}
  
  public void onRefreshComplete()
  {
    Threads.runOnMainThread(new DownloadActivity.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.3
 * JD-Core Version:    0.7.0.1
 */