package com.tencent.qqmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;

class WelcomeActivity$3
  implements View.OnClickListener
{
  WelcomeActivity$3(WelcomeActivity paramWelcomeActivity) {}
  
  public void onClick(View paramView)
  {
    PopularizeUIHelper.handleAction(this.this$0, WelcomeActivity.access$500(this.this$0), new WelcomeActivity.3.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomeActivity.3
 * JD-Core Version:    0.7.0.1
 */