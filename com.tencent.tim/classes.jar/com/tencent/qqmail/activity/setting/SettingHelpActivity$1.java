package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMWebView;

class SettingHelpActivity$1
  implements View.OnClickListener
{
  SettingHelpActivity$1(SettingHelpActivity paramSettingHelpActivity) {}
  
  public void onClick(View paramView)
  {
    paramView.setSelected(true);
    SettingHelpActivity.access$000(this.this$0).stopLoading();
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingHelpActivity.1
 * JD-Core Version:    0.7.0.1
 */