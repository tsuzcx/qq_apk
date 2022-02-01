package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.ftn.watcher.FtnGetDownloadUrlWatcher;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class FtnAttachmentActivity$2
  implements FtnGetDownloadUrlWatcher
{
  FtnAttachmentActivity$2(FtnAttachmentActivity paramFtnAttachmentActivity) {}
  
  public void onError(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (paramString1.equals(FtnAttachmentActivity.access$000(this.this$0).getFid()))
    {
      paramString1 = paramInt1 + "; " + paramInt2 + "; " + paramInt3 + "; " + paramString2;
      QMLog.log(6, "FtnAttachmentActivity", "ftn get downloadUrl error : " + paramString1);
      DataCollector.logDetailEvent("DetailEvent_App_Download", FtnAttachmentActivity.access$1100(this.this$0), 1L, "ftn download err:" + paramString1);
      FtnAttachmentActivity.access$1200(this.this$0, new FtnAttachmentActivity.2.2(this));
    }
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    if (paramString1.equals(FtnAttachmentActivity.access$000(this.this$0).getFid()))
    {
      QMLog.log(4, "FtnAttachmentActivity", "ftn get downloadUrl success:" + paramString2);
      FtnAttachmentActivity.access$000(this.this$0).getPreview().setDownloadUrl(paramString2);
      FtnAttachmentActivity.access$1000(this.this$0, new FtnAttachmentActivity.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.2
 * JD-Core Version:    0.7.0.1
 */