package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.io.File;

class SdcardFileExplorer$7
  implements ViewPager.OnPageChangeListener
{
  SdcardFileExplorer$7(SdcardFileExplorer paramSdcardFileExplorer) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (SdcardFileExplorer.access$500(this.this$0) != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)SdcardFileExplorer.access$500(this.this$0).getLayoutParams();
      localLayoutParams.leftMargin = (SdcardFileExplorer.access$500(this.this$0).getWidth() * paramInt1 + paramInt2 / SdcardFileExplorer.FileExplorerPage.SIZE.ordinal());
      SdcardFileExplorer.access$500(this.this$0).setLayoutParams(localLayoutParams);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    SdcardFileExplorer.FileExplorerPage localFileExplorerPage = SdcardFileExplorer.FileExplorerPage.from(paramInt);
    switch (SdcardFileExplorer.15.$SwitchMap$com$tencent$qqmail$activity$sdcardfileexplorer$SdcardFileExplorer$FileExplorerPage[localFileExplorerPage.ordinal()])
    {
    default: 
      return;
    case 1: 
      SdcardFileExplorer.access$000(this.this$0, SdcardFileExplorer.access$300(this.this$0).getCurrentParent().getAbsolutePath());
      SdcardFileExplorer.access$202(this.this$0, SdcardFileExplorer.FileExplorerPage.SYSTEM);
      SdcardFileExplorer.access$600(this.this$0).setSelected(true);
      SdcardFileExplorer.access$700(this.this$0).setSelected(false);
      return;
    }
    SdcardFileExplorer.access$000(this.this$0, SdcardFileExplorer.access$100(this.this$0).getCurrentParent().getAbsolutePath());
    SdcardFileExplorer.access$202(this.this$0, SdcardFileExplorer.FileExplorerPage.SDCARD);
    SdcardFileExplorer.access$700(this.this$0).setSelected(true);
    SdcardFileExplorer.access$600(this.this$0).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer.7
 * JD-Core Version:    0.7.0.1
 */