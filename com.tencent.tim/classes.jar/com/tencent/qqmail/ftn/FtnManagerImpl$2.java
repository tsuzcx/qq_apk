package com.tencent.qqmail.ftn;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.moai.downloader.model.DownloadTask;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

final class FtnManagerImpl$2
  implements DownloadTaskListener
{
  FtnManagerImpl$2(FtnDefine.FtnCallback paramFtnCallback, DownloadInfo paramDownloadInfo, AtomicInteger paramAtomicInteger, DownloadTask paramDownloadTask) {}
  
  public void onAbort(long paramLong, String paramString)
  {
    FtnManagerImpl.access$200(paramLong);
    QMLog.log(5, "FtnManagerImpl", "fileDownload onAbort, url: " + paramString);
    this.val$info.setStatus(6);
    DownloadInfoManager.shareInstance().updateDownloadInfoStatus(this.val$info);
  }
  
  public void onFail(long paramLong, String paramString, DownloadTaskError paramDownloadTaskError)
  {
    QMLog.log(5, "FtnManagerImpl", "fileDownload onFail, retry: " + this.val$retry.get() + ", url: " + paramString + ", error: " + paramDownloadTaskError.getErrorCode() + ", msg: " + paramDownloadTaskError.getMessage() + ", network: " + QMNetworkUtils.getActiveNetworkName() + ", level:" + QMNetworkUtils.getNetworkLevel());
    if (this.val$retry.getAndIncrement() > 50)
    {
      FtnManagerImpl.access$100(paramString, paramDownloadTaskError, this.val$info);
      FtnManagerImpl.access$200(paramLong);
      this.val$info.setStatus(5);
      DownloadInfoManager.shareInstance().updateDownloadInfoStatus(this.val$info);
      if (this.val$callback != null) {
        this.val$callback.onError(0, 0, 7, "");
      }
      QMWatcherCenter.triggerFtnDownloadError(this.val$info.getId(), this.val$info.getFid(), 0);
      return;
    }
    if (FtnManagerImpl.access$300() == null) {}
    try
    {
      if (FtnManagerImpl.access$300() == null) {
        FtnManagerImpl.access$302(new ConcurrentHashMap());
      }
      paramDownloadTaskError = (Handler)FtnManagerImpl.access$300().get(Long.valueOf(paramLong));
      paramString = paramDownloadTaskError;
      if (paramDownloadTaskError == null)
      {
        paramString = new HandlerThread("ftndownload-" + paramLong, 19);
        paramString.start();
        paramString = new Handler(paramString.getLooper());
        FtnManagerImpl.access$300().put(Long.valueOf(paramLong), paramString);
      }
      paramString.postDelayed(new FtnManagerImpl.2.1(this, paramLong), 1000L);
      return;
    }
    finally {}
  }
  
  public void onProgress(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    if ((this.val$info.getStatus() != 6) && (this.val$info.getStatus() != 2))
    {
      this.val$info.setStatus(2);
      DownloadInfoManager.shareInstance().updateDownloadInfoStatus(this.val$info);
    }
    this.val$info.setDownloadSize(paramLong2);
    if (this.val$callback != null) {
      this.val$callback.onProcessData(paramLong2, this.val$info.getFileSize());
    }
    QMWatcherCenter.triggerFtnDownloadProgress(this.val$info.getId(), this.val$info.getFid(), paramLong2, this.val$info.getFileSize());
  }
  
  public void onStart(long paramLong, String paramString)
  {
    if (this.val$callback != null) {
      this.val$callback.onBeforeSend();
    }
    this.val$info.setStatus(1);
    DownloadInfoManager.shareInstance().updateDownloadInfoStatus(this.val$info);
  }
  
  public void onSuccess(long paramLong, String paramString1, String paramString2)
  {
    File localFile;
    if ((paramString1.equals(this.val$info.getUrl())) && (!StringExtention.isNullOrEmpty(paramString2)))
    {
      localFile = new File(paramString2);
      if (localFile.exists())
      {
        QMLog.log(4, "FtnManagerImpl", "fileDownload onSuccess, url: " + paramString1 + ", path: " + paramString2 + ", local:" + localFile.length() + ", server:" + this.val$info.getFileSize());
        FtnManagerImpl.access$200(paramLong);
        if (!DownloadUtil.isDownloadFileSizeError(localFile.length(), this.val$info.getFileSize())) {
          break label238;
        }
        QMLog.log(6, "FtnManagerImpl", "attach download file size error");
        this.val$info.setDownloadSize(0L);
        Threads.runInBackground(new FtnManagerImpl.2.2(this, localFile));
        onFail(paramLong, paramString1, new DownloadTaskError(-1000, "download file size error local:" + localFile.length() + " server:" + this.val$info.getFileSize() + ", detail:" + FileUtil.readString(paramString2, 64L, Charset.forName("ISO-8859-1"))));
      }
    }
    return;
    label238:
    this.val$info.setStatus(4);
    this.val$info.setFilePath(paramString2);
    this.val$info.setDisplayName(localFile.getName());
    DownloadInfoManager.shareInstance().updateDownloadInfo(this.val$info);
    if (this.val$callback != null) {
      this.val$callback.onSuccess(null, null);
    }
    QMWatcherCenter.triggerFtnDownloadSuccess(this.val$info.getId(), this.val$info.getFid(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */