package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SdcardFileExplorer$2
  implements View.OnClickListener
{
  SdcardFileExplorer$2(SdcardFileExplorer paramSdcardFileExplorer) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer.2
 * JD-Core Version:    0.7.0.1
 */