package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SdcardFileExplorer$3
  implements View.OnClickListener
{
  SdcardFileExplorer$3(SdcardFileExplorer paramSdcardFileExplorer) {}
  
  public void onClick(View paramView)
  {
    if ((SdcardFileExplorer.access$100(this.this$0) != null) && (SdcardFileExplorer.access$200(this.this$0) == SdcardFileExplorer.FileExplorerPage.SDCARD)) {
      SdcardFileExplorer.access$100(this.this$0).smoothToTop();
    }
    if ((SdcardFileExplorer.access$300(this.this$0) != null) && (SdcardFileExplorer.access$200(this.this$0) == SdcardFileExplorer.FileExplorerPage.SYSTEM)) {
      SdcardFileExplorer.access$300(this.this$0).smoothToTop();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer.3
 * JD-Core Version:    0.7.0.1
 */