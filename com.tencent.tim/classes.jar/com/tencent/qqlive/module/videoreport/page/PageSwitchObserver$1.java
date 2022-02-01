package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class PageSwitchObserver$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  PageSwitchObserver$1(PageSwitchObserver paramPageSwitchObserver, Activity paramActivity, View paramView) {}
  
  public void onGlobalLayout()
  {
    this.this$0.postAppearDetectionTask(this.val$activity);
    this.val$view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver.1
 * JD-Core Version:    0.7.0.1
 */