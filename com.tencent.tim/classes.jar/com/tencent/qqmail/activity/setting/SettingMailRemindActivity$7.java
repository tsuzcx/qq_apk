package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingMailRemindActivity$7
  implements UITableView.ClickListener
{
  SettingMailRemindActivity$7(SettingMailRemindActivity paramSettingMailRemindActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingMailRemindActivity.access$1200(this.this$0)) {
      if (paramUITableItemView.isChecked()) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setChecked(bool);
      QMSettingManager.sharedInstance().setUseNightMode(paramUITableItemView.isChecked());
      QMMailManager.sharedInstance().setPushNightMode(paramUITableItemView.isChecked());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingMailRemindActivity.7
 * JD-Core Version:    0.7.0.1
 */