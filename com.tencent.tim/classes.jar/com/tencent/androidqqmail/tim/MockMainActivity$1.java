package com.tencent.androidqqmail.tim;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.launcher.base.LauncherUtils;

class MockMainActivity$1
  implements View.OnClickListener
{
  MockMainActivity$1(MockMainActivity paramMockMainActivity) {}
  
  public void onClick(View paramView)
  {
    LauncherUtils.gotoMainPage(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MockMainActivity.1
 * JD-Core Version:    0.7.0.1
 */