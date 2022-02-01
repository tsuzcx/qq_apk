package com.tencent.mobileqq.mini.app;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class InternalAppUIProxy$1
  implements View.OnClickListener
{
  InternalAppUIProxy$1(InternalAppUIProxy paramInternalAppUIProxy, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.val$activity.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.InternalAppUIProxy.1
 * JD-Core Version:    0.7.0.1
 */