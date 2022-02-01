package com.tencent.qqmail.download.watcher;

import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.qqmail.model.mail.watcher.DownloadAttachWatcher;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.QMMath;
import moai.core.watcher.Watchers;

public class ProtocolAttachDownloadWatcher
  implements DownloadAttachWatcher
{
  private long attachId;
  private boolean isAbort = false;
  private DownloadTaskListener listener = null;
  private long taskId;
  private String url;
  
  public ProtocolAttachDownloadWatcher(long paramLong, String paramString, DownloadTaskListener paramDownloadTaskListener)
  {
    this.attachId = paramLong;
    this.url = paramString;
    this.listener = paramDownloadTaskListener;
    this.taskId = QMMath.hashLong(paramString);
  }
  
  public boolean abort()
  {
    this.isAbort = true;
    if (this.listener != null) {
      this.listener.onAbort(this.taskId, this.url);
    }
    Watchers.bind(this, false);
    QMWatcherCenter.bindDownloadAttachListener(this, false);
    return true;
  }
  
  public boolean goOn()
  {
    this.isAbort = false;
    return true;
  }
  
  public boolean isAbort()
  {
    return this.isAbort;
  }
  
  public boolean isMatch(long paramLong)
  {
    return this.attachId == paramLong;
  }
  
  public void onError(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    if ((this.listener != null) && (!this.isAbort) && (isMatch(paramLong2))) {
      this.listener.onFail(this.taskId, this.url, new DownloadTaskError(2, paramString2));
    }
  }
  
  public void onProcess(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    if ((this.listener != null) && (isMatch(paramLong2))) {
      this.listener.onProgress(this.taskId, this.url, paramLong4, paramLong3);
    }
  }
  
  public void onSuccess(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt)
  {
    if ((this.listener != null) && (isMatch(paramLong2))) {
      this.listener.onSuccess(this.taskId, this.url, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.watcher.ProtocolAttachDownloadWatcher
 * JD-Core Version:    0.7.0.1
 */