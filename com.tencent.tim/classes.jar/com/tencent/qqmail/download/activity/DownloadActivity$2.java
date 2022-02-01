package com.tencent.qqmail.download.activity;

import com.tencent.qqmail.download.watcher.DownloadWatcher;

class DownloadActivity$2
  implements DownloadWatcher
{
  DownloadActivity$2(DownloadActivity paramDownloadActivity) {}
  
  public void onError(int paramInt, long paramLong, Object paramObject)
  {
    DownloadActivity.access$000(this.this$0);
  }
  
  public void onProcess(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    DownloadActivity.access$100(this.this$0, paramInt, paramLong2, paramLong3);
  }
  
  public void onSuccess(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    DownloadActivity.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.2
 * JD-Core Version:    0.7.0.1
 */