package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import com.tencent.qqmail.utilities.ui.ShortcutUtility;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingCalendarActivity$2
  implements UITableView.ClickListener
{
  SettingCalendarActivity$2(SettingCalendarActivity paramSettingCalendarActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (!paramUITableItemView.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setChecked(bool);
      SettingCalendarActivity.access$402(this.this$0, paramUITableItemView.isChecked());
      QMSettingManager.sharedInstance().setCalendarDisplay(paramUITableItemView.isChecked());
      if (!SettingCalendarActivity.access$400(this.this$0))
      {
        ShortcutUtility.deleteApplicationShortcut(this.this$0.getString(2131690401));
        paramUITableItemView = this.this$0.getString(2131690401);
        SettingCalendarActivity.access$500(this.this$0).setChecked(ShortcutUtility.isShortcutExist(paramUITableItemView));
        QMNotificationConstructor.getInstance().clearCalendarPushNotifyList();
      }
      QMNotification.postNotification("BROADCAST_WIDGET_ACCOUNT_CHANGE", null);
      this.this$0.refreshData();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarActivity.2
 * JD-Core Version:    0.7.0.1
 */