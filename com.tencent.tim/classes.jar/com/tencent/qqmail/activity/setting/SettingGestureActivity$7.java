package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMGesturePasswordView;
import com.tencent.qqmail.view.fingerprint.FingerPrintDialog;

class SettingGestureActivity$7
  implements View.OnClickListener
{
  SettingGestureActivity$7(SettingGestureActivity paramSettingGestureActivity) {}
  
  public void onClick(View paramView)
  {
    SettingGestureActivity.access$1200(this.this$0).show(this.this$0.getFragmentManager(), "FingerPrintDialog");
    SettingGestureActivity.access$000(this.this$0).switchState(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureActivity.7
 * JD-Core Version:    0.7.0.1
 */