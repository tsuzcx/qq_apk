package com.tencent.qqmail.activity.setting.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SettingFeedbackDetailActivity$3
  implements View.OnClickListener
{
  SettingFeedbackDetailActivity$3(SettingFeedbackDetailActivity paramSettingFeedbackDetailActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.SettingFeedbackDetailActivity.3
 * JD-Core Version:    0.7.0.1
 */