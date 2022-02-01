package com.tencent.qqmail.attachment.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.download.AttachDownloadManager;

class ZipInnerAttachDownloadActivity$5
  implements CompoundButton.OnCheckedChangeListener
{
  ZipInnerAttachDownloadActivity$5(ZipInnerAttachDownloadActivity paramZipInnerAttachDownloadActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ZipInnerAttachDownloadActivity.access$400(this.this$0);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    AttachDownloadManager localAttachDownloadManager = AttachDownloadManager.shareInstance();
    if (ZipInnerAttachDownloadActivity.access$500(this.this$0)) {}
    for (String str = this.this$0.generateBigZipInnerAttachKey();; str = ZipInnerAttachDownloadActivity.access$600(this.this$0))
    {
      localAttachDownloadManager.abort(str);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipInnerAttachDownloadActivity.5
 * JD-Core Version:    0.7.0.1
 */