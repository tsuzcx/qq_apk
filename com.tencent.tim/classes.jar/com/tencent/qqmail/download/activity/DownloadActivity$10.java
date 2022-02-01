package com.tencent.qqmail.download.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DownloadActivity$10
  implements View.OnClickListener
{
  DownloadActivity$10(DownloadActivity paramDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (DownloadActivity.access$1500(this.this$0)) {
      DownloadActivity.access$1100(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.showPopMenuWindow(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.10
 * JD-Core Version:    0.7.0.1
 */