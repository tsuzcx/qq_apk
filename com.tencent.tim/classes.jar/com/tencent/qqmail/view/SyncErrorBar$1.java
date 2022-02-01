package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SyncErrorBar$1
  implements View.OnClickListener
{
  SyncErrorBar$1(SyncErrorBar paramSyncErrorBar) {}
  
  public void onClick(View paramView)
  {
    if (SyncErrorBar.access$000(this.this$0) != null) {
      SyncErrorBar.access$000(this.this$0).onItemClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.SyncErrorBar.1
 * JD-Core Version:    0.7.0.1
 */