package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.animation.SmoothProgressBar;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachState;
import com.tencent.qqmail.ftn.watcher.FtnDownloadWatcher;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class FtnAttachmentActivity$1
  implements FtnDownloadWatcher
{
  FtnAttachmentActivity$1(FtnAttachmentActivity paramFtnAttachmentActivity) {}
  
  public void onError(int paramInt1, String paramString, int paramInt2)
  {
    if (paramString.equals(FtnAttachmentActivity.access$000(this.this$0).getFid()))
    {
      QMLog.log(5, "FtnAttachmentActivity", "ftn download error:" + paramInt2);
      if (paramInt2 != FtnAttachmentActivity.access$500(this.this$0)) {
        FtnAttachmentActivity.access$700(this.this$0, new FtnAttachmentActivity.1.2(this));
      }
    }
  }
  
  public void onProgress(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    if (paramString.equals(FtnAttachmentActivity.access$000(this.this$0).getFid()))
    {
      FtnAttachmentActivity.access$000(this.this$0).getState().setDownloadSize(paramLong1 + "");
      FtnAttachmentActivity.access$800(this.this$0).sendEmptyMessage(5);
    }
  }
  
  public void onSuccess(int paramInt, String paramString1, String paramString2)
  {
    if (paramString1.equals(FtnAttachmentActivity.access$000(this.this$0).getFid()))
    {
      QMLog.log(4, "FtnAttachmentActivity", "ftn download success:" + paramString2);
      FtnAttachmentActivity.access$102(this.this$0, true);
      FtnAttachmentActivity.access$200(this.this$0).setProgressSmooth(100, true);
      FtnAttachmentActivity.access$302(this.this$0, paramString2);
      FtnAttachmentActivity.access$000(this.this$0).getPreview().setMyDisk(FtnAttachmentActivity.access$300(this.this$0));
      Threads.runOnMainThread(new FtnAttachmentActivity.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.1
 * JD-Core Version:    0.7.0.1
 */