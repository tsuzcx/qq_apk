package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SdcardFileExplorer$10
  implements View.OnClickListener
{
  SdcardFileExplorer$10(SdcardFileExplorer paramSdcardFileExplorer) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    this.this$0.overridePendingTransition(2130772430, 2130772402);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer.10
 * JD-Core Version:    0.7.0.1
 */