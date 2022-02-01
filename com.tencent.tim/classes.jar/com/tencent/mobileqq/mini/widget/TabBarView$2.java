package com.tencent.mobileqq.mini.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.TabBarInfo.ButtonInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TabBarView$2
  implements View.OnClickListener
{
  TabBarView$2(TabBarView paramTabBarView, int paramInt, TabBarInfo.ButtonInfo paramButtonInfo) {}
  
  public void onClick(View paramView)
  {
    if (TabBarView.access$000(this.this$0) != null) {
      TabBarView.access$000(this.this$0).onTabItemClick(this.val$pos, this.val$info.pagePath, this.val$info.text);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.TabBarView.2
 * JD-Core Version:    0.7.0.1
 */