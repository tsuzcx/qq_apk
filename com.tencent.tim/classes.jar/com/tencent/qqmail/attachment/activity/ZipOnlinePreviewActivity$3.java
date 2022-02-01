package com.tencent.qqmail.attachment.activity;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ZipOnlinePreviewActivity$3
  implements View.OnClickListener
{
  ZipOnlinePreviewActivity$3(ZipOnlinePreviewActivity paramZipOnlinePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      ZipOnlinePreviewActivity.access$700(this.this$0).smoothScrollToPosition(0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ZipOnlinePreviewActivity.access$700(this.this$0).setSelection(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipOnlinePreviewActivity.3
 * JD-Core Version:    0.7.0.1
 */