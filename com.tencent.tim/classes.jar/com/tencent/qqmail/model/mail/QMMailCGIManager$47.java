package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;

class QMMailCGIManager$47
  implements AttachDownloadListener
{
  QMMailCGIManager$47(QMMailCGIManager paramQMMailCGIManager, MailManagerDelegate paramMailManagerDelegate, Attach paramAttach) {}
  
  public void onBeforeSend(String paramString)
  {
    if (this.val$callback != null) {
      this.val$callback.handleBeforeSend(paramString);
    }
  }
  
  public void onError(String paramString, Object paramObject)
  {
    DataCollector.logDetailEvent("DetailEvent_App_Download", this.val$attach.getAccountId(), 1L, "cgimgr download attach err:" + paramString);
    if (this.val$callback != null)
    {
      this.val$callback.handleError(paramObject);
      this.val$callback.handleComplete(null);
    }
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    if (this.val$callback != null) {
      this.val$callback.handleSendData(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    }
  }
  
  public void onSuccess(String paramString1, File paramFile, String paramString2)
  {
    DataCollector.logDetailEvent("DetailEvent_App_Download", this.val$attach.getAccountId(), 0L, "");
    paramFile = paramFile.getAbsolutePath();
    this.val$attach.getPreview().setMyDisk(paramFile);
    QMLog.log(4, "QMMailCGIManager", "download success:" + paramString1 + ",save:" + paramFile);
    if (this.val$callback != null)
    {
      this.val$callback.handleSuccess(paramFile, this.val$attach);
      this.val$callback.handleComplete(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailCGIManager.47
 * JD-Core Version:    0.7.0.1
 */