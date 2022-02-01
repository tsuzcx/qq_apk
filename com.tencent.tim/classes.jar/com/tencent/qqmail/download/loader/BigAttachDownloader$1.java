package com.tencent.qqmail.download.loader;

import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachState;
import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import java.io.File;

class BigAttachDownloader$1
  implements AttachDownloadListener
{
  BigAttachDownloader$1(BigAttachDownloader paramBigAttachDownloader) {}
  
  public void onBeforeSend(String paramString)
  {
    if (BigAttachDownloader.access$000(this.this$0) != null) {
      BigAttachDownloader.access$000(this.this$0).handleBeforeSend(paramString);
    }
  }
  
  public void onError(String paramString, Object paramObject)
  {
    if (BigAttachDownloader.access$000(this.this$0) != null)
    {
      BigAttachDownloader.access$000(this.this$0).handleError(paramObject);
      BigAttachDownloader.access$000(this.this$0).handleComplete(null);
    }
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2)
  {
    BigAttachDownloader.access$100(this.this$0).getState().setDownloadSizeByte(paramLong1);
    if (BigAttachDownloader.access$000(this.this$0) != null) {
      BigAttachDownloader.access$000(this.this$0).handleSendData(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
    }
  }
  
  public void onSuccess(String paramString1, File paramFile, String paramString2)
  {
    BigAttachDownloader.access$100(this.this$0).getState().setIsDownload("1");
    BigAttachDownloader.access$100(this.this$0).getPreview().setMyDisk(paramFile.getAbsolutePath());
    if (BigAttachDownloader.access$000(this.this$0) != null)
    {
      BigAttachDownloader.access$000(this.this$0).handleSuccess(BigAttachDownloader.access$100(this.this$0).getPreview().getDownloadUrl(), BigAttachDownloader.access$100(this.this$0));
      BigAttachDownloader.access$000(this.this$0).handleComplete(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.loader.BigAttachDownloader.1
 * JD-Core Version:    0.7.0.1
 */