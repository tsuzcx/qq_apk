package com.tencent.qqmail.download.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DownloadActivity$9
  implements View.OnClickListener
{
  DownloadActivity$9(DownloadActivity paramDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool;
    if (DownloadActivity.access$1500(this.this$0))
    {
      DownloadActivity localDownloadActivity = this.this$0;
      if (!DownloadActivity.access$1600(this.this$0))
      {
        bool = true;
        DownloadActivity.access$1700(localDownloadActivity, bool);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      this.this$0.onBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.9
 * JD-Core Version:    0.7.0.1
 */