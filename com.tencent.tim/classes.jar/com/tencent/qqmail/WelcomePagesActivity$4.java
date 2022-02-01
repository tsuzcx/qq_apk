package com.tencent.qqmail;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WelcomePagesActivity$4
  implements View.OnClickListener
{
  WelcomePagesActivity$4(WelcomePagesActivity paramWelcomePagesActivity) {}
  
  public void onClick(View paramView)
  {
    int i = ((ViewGroup)paramView.getParent()).indexOfChild(paramView);
    WelcomePagesActivity.access$300(this.this$0).setCurrentItem(i, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomePagesActivity.4
 * JD-Core Version:    0.7.0.1
 */