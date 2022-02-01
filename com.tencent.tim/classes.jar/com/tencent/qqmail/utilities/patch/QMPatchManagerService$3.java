package com.tencent.qqmail.utilities.patch;

import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.moai.downloader.listener.DownloadTaskListener;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Map;

class QMPatchManagerService$3
  implements DownloadTaskListener
{
  QMPatchManagerService$3(QMPatchManagerService paramQMPatchManagerService, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAbort(long paramLong, String paramString)
  {
    QMLog.log(5, "QMPatchManagerService", "Download onAbort, url: " + paramString);
    QMPatchManagerService.access$200().remove(Long.valueOf(paramLong));
  }
  
  public void onFail(long paramLong, String paramString, DownloadTaskError paramDownloadTaskError)
  {
    QMPatchManagerService.access$200().remove(Long.valueOf(paramLong));
    StringBuilder localStringBuilder = new StringBuilder().append("Download onFail, url: ").append(paramString).append(", error: ");
    if (paramDownloadTaskError != null) {}
    for (paramString = paramDownloadTaskError.getErrorCode() + ", " + paramDownloadTaskError.getMessage();; paramString = null)
    {
      QMLog.log(5, "QMPatchManagerService", paramString);
      return;
    }
  }
  
  public void onProgress(long paramLong1, String paramString, long paramLong2, long paramLong3) {}
  
  public void onStart(long paramLong, String paramString) {}
  
  public void onSuccess(long paramLong, String paramString1, String paramString2)
  {
    QMLog.log(4, "QMPatchManagerService", "Download onSuccess, url: " + paramString1 + ", path: " + paramString2);
    QMPatchManagerService.access$200().remove(Long.valueOf(paramLong));
    if (this.val$install) {
      QMPatchManagerService.access$300(this.this$0, paramString1, paramString2, this.val$needCheck);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.patch.QMPatchManagerService.3
 * JD-Core Version:    0.7.0.1
 */