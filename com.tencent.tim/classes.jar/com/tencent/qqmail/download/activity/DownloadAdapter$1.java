package com.tencent.qqmail.download.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DownloadAdapter$1
  implements View.OnClickListener
{
  DownloadAdapter$1(DownloadAdapter paramDownloadAdapter, DownloadAdapter.ViewHolder paramViewHolder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.this$0.changeDownloadState(this.val$holder, this.val$position);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadAdapter.1
 * JD-Core Version:    0.7.0.1
 */