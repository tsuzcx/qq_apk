package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import moai.oss.KvHelper;

class SettingMailRemindActivity$4
  implements UITableView.ClickListener
{
  SettingMailRemindActivity$4(SettingMailRemindActivity paramSettingMailRemindActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = true;
    if (paramUITableItemView == SettingMailRemindActivity.access$500(this.this$0)) {
      if (!paramUITableItemView.isChecked())
      {
        bool1 = true;
        paramUITableItemView.setChecked(bool1);
        if (bool1) {
          break label61;
        }
        bool1 = bool2;
        label41:
        QMSettingManager.sharedInstance().setAdMailNotify(bool1);
        QMMailManager.sharedInstance().setAdMailNotify(bool1);
      }
    }
    label61:
    do
    {
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label41;
      if (paramUITableItemView == SettingMailRemindActivity.access$600(this.this$0))
      {
        if (!paramUITableItemView.isChecked()) {}
        for (;;)
        {
          paramUITableItemView.setChecked(bool1);
          QMSettingManager.sharedInstance().setOnlyNotifyVIP(bool1);
          QMMailManager.sharedInstance().setPushMode(bool1);
          SettingMailRemindActivity.access$700(this.this$0);
          return;
          bool1 = false;
        }
      }
    } while (paramUITableItemView != SettingMailRemindActivity.access$800(this.this$0));
    if (!paramUITableItemView.isChecked()) {}
    for (bool1 = bool3;; bool1 = false)
    {
      paramUITableItemView.setChecked(bool1);
      QMSettingManager.sharedInstance().setShowMailDetail(bool1);
      QMMailManager.sharedInstance().setEnableNotifyDetail(bool1);
      if (!bool1) {
        break;
      }
      KvHelper.eventOpenShowPushMailDetail(new double[0]);
      return;
    }
    KvHelper.eventCloseShowPushMailDetail(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingMailRemindActivity.4
 * JD-Core Version:    0.7.0.1
 */