package com.tencent.qqmail.activity.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;

class SettingAccountActivity$12
  implements View.OnClickListener
{
  SettingAccountActivity$12(SettingAccountActivity paramSettingAccountActivity, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.this$0).setTitle(this.this$0.getString(2131696424))).setMessage(this.this$0.getString(2131719580)).addAction(2131691246, new SettingAccountActivity.12.2(this))).addAction(2131696547, new SettingAccountActivity.12.1(this))).create().show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.12
 * JD-Core Version:    0.7.0.1
 */