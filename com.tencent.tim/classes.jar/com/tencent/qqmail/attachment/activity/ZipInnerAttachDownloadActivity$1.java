package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ZipInnerAttachDownloadActivity$1
  implements View.OnClickListener
{
  ZipInnerAttachDownloadActivity$1(ZipInnerAttachDownloadActivity paramZipInnerAttachDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipInnerAttachDownloadActivity.1
 * JD-Core Version:    0.7.0.1
 */