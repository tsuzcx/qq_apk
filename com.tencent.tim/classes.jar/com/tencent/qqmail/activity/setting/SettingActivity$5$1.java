package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingActivity$5$1
  implements Runnable
{
  SettingActivity$5$1(SettingActivity.5 param5, UITableItemView paramUITableItemView) {}
  
  public void run()
  {
    QMSettingManager.sharedInstance().setAggregateAdMail(this.val$view.isChecked());
    QMMailManager.sharedInstance().setAggregateAd(this.val$view.isChecked());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingActivity.5.1
 * JD-Core Version:    0.7.0.1
 */