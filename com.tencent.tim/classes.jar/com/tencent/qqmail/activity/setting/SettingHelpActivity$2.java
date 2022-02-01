package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.setting.feedback.SettingFeedbackSceneActivity;
import com.tencent.qqmail.view.QMTopBar;

class SettingHelpActivity$2
  implements View.OnClickListener
{
  SettingHelpActivity$2(SettingHelpActivity paramSettingHelpActivity) {}
  
  public void onClick(View paramView)
  {
    SettingHelpActivity.access$100(this.this$0).getButtonRight().setEnabled(false);
    if (SettingHelpActivity.access$200(this.this$0) == null) {
      SettingHelpActivity.access$202(this.this$0, SettingFeedbackSceneActivity.parseFeedbackAssets());
    }
    Intent localIntent = SettingFeedbackSceneActivity.createIntent(SettingHelpActivity.access$200(this.this$0));
    this.this$0.startActivity(localIntent);
    paramView.postDelayed(new SettingHelpActivity.2.1(this), 300L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingHelpActivity.2
 * JD-Core Version:    0.7.0.1
 */