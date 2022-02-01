package com.tencent.qqmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseActivity$2
  implements View.OnClickListener
{
  BaseActivity$2(BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onTopBarCenterClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivity.2
 * JD-Core Version:    0.7.0.1
 */