package com.tencent.qqmail.activity.setting;

import android.app.Application;
import android.os.Vibrator;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingMailRemindActivity$2
  implements UITableView.ClickListener
{
  SettingMailRemindActivity$2(SettingMailRemindActivity paramSettingMailRemindActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramUITableItemView == SettingMailRemindActivity.access$200(this.this$0)) {
      if (!paramUITableItemView.isChecked())
      {
        paramUITableItemView.setChecked(bool1);
        QMSettingManager.sharedInstance().setNewMailPushSound(paramUITableItemView.isChecked());
        QMMailManager.sharedInstance().setNewMailPushSound(paramUITableItemView.isChecked());
        if (SettingMailRemindActivity.access$300(this.this$0) != null)
        {
          if (!paramUITableItemView.isChecked()) {
            break label83;
          }
          SettingMailRemindActivity.access$300(this.this$0).setVisibility(0);
        }
      }
    }
    label83:
    while (paramUITableItemView != SettingMailRemindActivity.access$400(this.this$0))
    {
      for (;;)
      {
        return;
        bool1 = false;
      }
      SettingMailRemindActivity.access$300(this.this$0).setVisibility(8);
      return;
    }
    if (!paramUITableItemView.isChecked()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramUITableItemView.setChecked(bool1);
      if (paramUITableItemView.isChecked()) {
        ((Vibrator)this.this$0.getApplication().getSystemService("vibrator")).vibrate(new long[] { 200L, 200L, 200L, 200L }, -1);
      }
      QMSettingManager.sharedInstance().setNewMailPushVibrate(paramUITableItemView.isChecked());
      QMMailManager.sharedInstance().setNewMailPushViberate(paramUITableItemView.isChecked());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingMailRemindActivity.2
 * JD-Core Version:    0.7.0.1
 */