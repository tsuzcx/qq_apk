package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;

class AttachFolderPreviewActivity$1
  implements AttachDownloadListener
{
  AttachFolderPreviewActivity$1(AttachFolderPreviewActivity paramAttachFolderPreviewActivity) {}
  
  public void onBeforeSend(String paramString) {}
  
  public void onError(String paramString, Object paramObject)
  {
    QMLog.log(5, "AttachFolderPreviewActivity", "normal attach download error:" + paramString);
    if (paramString.equals(AttachFolderPreviewActivity.access$300(this.this$0))) {
      AttachFolderPreviewActivity.access$800(this.this$0, new AttachFolderPreviewActivity.1.1(this));
    }
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    if (paramString.equals(AttachFolderPreviewActivity.access$300(this.this$0)))
    {
      paramLong2 = System.currentTimeMillis();
      if (paramLong2 - AttachFolderPreviewActivity.access$400(this.this$0) > 300L)
      {
        AttachFolderPreviewActivity.access$402(this.this$0, paramLong2);
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.setDownloadSize(paramLong1);
        localDownloadInfo.setUrl(paramString);
        AttachFolderPreviewActivity.access$500(this.this$0, localDownloadInfo);
      }
    }
  }
  
  public void onSuccess(String paramString1, File paramFile, String paramString2)
  {
    if (paramString1.equals(AttachFolderPreviewActivity.access$300(this.this$0)))
    {
      paramString2 = new DownloadInfo();
      paramString2.setUrl(paramString1);
      if (paramFile == null) {
        break label50;
      }
    }
    label50:
    for (paramString1 = paramFile.getAbsolutePath();; paramString1 = "")
    {
      paramString2.setFilePath(paramString1);
      AttachFolderPreviewActivity.access$600(this.this$0, paramString2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachFolderPreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */