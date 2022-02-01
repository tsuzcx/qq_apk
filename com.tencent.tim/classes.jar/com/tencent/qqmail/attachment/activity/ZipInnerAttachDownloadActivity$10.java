package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachState;
import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.protocol.DataCollector;
import java.io.File;

class ZipInnerAttachDownloadActivity$10
  implements AttachDownloadListener
{
  ZipInnerAttachDownloadActivity$10(ZipInnerAttachDownloadActivity paramZipInnerAttachDownloadActivity) {}
  
  public void onBeforeSend(String paramString) {}
  
  public void onError(String paramString, Object paramObject)
  {
    ZipInnerAttachDownloadActivity.access$1700(this.this$0, new ZipInnerAttachDownloadActivity.10.3(this));
    DataCollector.logDetailEvent("DetailEvent_App_Download", ZipInnerAttachDownloadActivity.access$900(this.this$0).getAccountId(), 1L, "compress attach err:" + paramString);
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    if (paramString.equals(ZipInnerAttachDownloadActivity.access$600(this.this$0)))
    {
      ZipInnerAttachDownloadActivity.access$900(this.this$0).getState().setDownloadSize(paramLong1 + "");
      ZipInnerAttachDownloadActivity.access$900(this.this$0).setSize(paramLong2 + "");
      ZipInnerAttachDownloadActivity.access$1100(this.this$0, new ZipInnerAttachDownloadActivity.10.1(this, paramLong2, paramLong1));
    }
  }
  
  public void onSuccess(String paramString1, File paramFile, String paramString2)
  {
    if ((paramString1.equals(ZipInnerAttachDownloadActivity.access$600(this.this$0))) && (paramFile != null) && (paramFile.exists()))
    {
      ZipInnerAttachDownloadActivity.access$900(this.this$0).getState().setIsDownload("2");
      ZipInnerAttachDownloadActivity.access$900(this.this$0).getPreview().setMyDisk(paramFile.getAbsolutePath());
      ZipInnerAttachDownloadActivity.access$1202(this.this$0, paramFile.getAbsolutePath());
      ZipInnerAttachDownloadActivity.access$1500(this.this$0, new ZipInnerAttachDownloadActivity.10.2(this));
      DataCollector.logDetailEvent("DetailEvent_App_Download", ZipInnerAttachDownloadActivity.access$900(this.this$0).getAccountId(), 0L, "compress attach");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipInnerAttachDownloadActivity.10
 * JD-Core Version:    0.7.0.1
 */