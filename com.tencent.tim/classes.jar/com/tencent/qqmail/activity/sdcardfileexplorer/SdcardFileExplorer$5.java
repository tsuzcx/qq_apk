package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.view.CustomViewPager;

class SdcardFileExplorer$5
  implements View.OnClickListener
{
  SdcardFileExplorer$5(SdcardFileExplorer paramSdcardFileExplorer) {}
  
  public void onClick(View paramView)
  {
    if (SdcardFileExplorer.access$100(this.this$0) != null) {
      SdcardFileExplorer.access$400(this.this$0).setCurrentItem(SdcardFileExplorer.FileExplorerPage.SDCARD.ordinal(), false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer.5
 * JD-Core Version:    0.7.0.1
 */