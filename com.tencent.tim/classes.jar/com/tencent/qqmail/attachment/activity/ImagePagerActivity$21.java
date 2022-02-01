package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.download.listener.AttachDownloadListener;
import com.tencent.qqmail.download.util.DownloadUtil;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;

class ImagePagerActivity$21
  implements AttachDownloadListener
{
  ImagePagerActivity$21(ImagePagerActivity paramImagePagerActivity, int paramInt) {}
  
  public void onBeforeSend(String paramString) {}
  
  public void onError(String paramString, Object paramObject)
  {
    DataCollector.logDetailEvent("DetailEvent_App_Download", ImagePagerActivity.access$700(this.this$0).getAccountId(), 1L, "image saveas err");
    Threads.runOnMainThread(new ImagePagerActivity.21.1(this));
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccess(String paramString1, File paramFile, String paramString2)
  {
    QMLog.log(4, "ImagePagerActivity", "download before save succ");
    DataCollector.logDetailEvent("DetailEvent_App_Download", ImagePagerActivity.access$700(this.this$0).getAccountId(), 0L, "image saveas");
    paramString1 = new FtnDownloadInfo(ImagePagerActivity.access$300(this.this$0).getFid(), paramFile.getAbsolutePath(), ImagePagerActivity.access$300(this.this$0).getCreateTime(), Long.valueOf(ImagePagerActivity.access$300(this.this$0).getSize()).longValue());
    FtnManager.sharedInstance().insertDownloadInfo(paramString1);
    ImagePagerActivity.access$700(this.this$0).getPreview().setMyDisk(paramFile.getAbsolutePath());
    if (this.val$operation == 0) {
      DownloadUtil.existFileSaveAs(ImagePagerActivity.access$700(this.this$0), this.this$0.desiredSavePath, true);
    }
    while (this.val$operation != 1) {
      return;
    }
    ImagePagerActivity.access$2800(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.21
 * JD-Core Version:    0.7.0.1
 */