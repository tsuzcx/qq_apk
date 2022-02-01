package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.download.AttachDownloadManager;

class ZipInnerAttachDownloadActivity$6
  implements View.OnClickListener
{
  ZipInnerAttachDownloadActivity$6(ZipInnerAttachDownloadActivity paramZipInnerAttachDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    AttachDownloadManager localAttachDownloadManager = AttachDownloadManager.shareInstance();
    if (ZipInnerAttachDownloadActivity.access$500(this.this$0)) {}
    for (String str = this.this$0.generateBigZipInnerAttachKey();; str = ZipInnerAttachDownloadActivity.access$600(this.this$0))
    {
      localAttachDownloadManager.abort(str);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipInnerAttachDownloadActivity.6
 * JD-Core Version:    0.7.0.1
 */