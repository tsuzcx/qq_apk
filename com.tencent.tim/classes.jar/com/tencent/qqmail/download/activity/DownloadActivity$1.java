package com.tencent.qqmail.download.activity;

import com.tencent.qqmail.ftn.watcher.FtnDownloadWatcher;

class DownloadActivity$1
  implements FtnDownloadWatcher
{
  DownloadActivity$1(DownloadActivity paramDownloadActivity) {}
  
  public void onError(int paramInt1, String paramString, int paramInt2)
  {
    DownloadActivity.access$000(this.this$0);
  }
  
  public void onProgress(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    DownloadActivity.access$100(this.this$0, paramInt, paramLong1, paramLong2);
  }
  
  public void onSuccess(int paramInt, String paramString1, String paramString2)
  {
    DownloadActivity.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.1
 * JD-Core Version:    0.7.0.1
 */