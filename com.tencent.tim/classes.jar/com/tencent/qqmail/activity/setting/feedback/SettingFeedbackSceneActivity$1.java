package com.tencent.qqmail.activity.setting.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SettingFeedbackSceneActivity$1
  implements View.OnClickListener
{
  SettingFeedbackSceneActivity$1(SettingFeedbackSceneActivity paramSettingFeedbackSceneActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.SettingFeedbackSceneActivity.1
 * JD-Core Version:    0.7.0.1
 */