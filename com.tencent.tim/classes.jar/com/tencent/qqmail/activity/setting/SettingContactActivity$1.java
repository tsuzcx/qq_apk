package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingContactActivity$1
  implements UITableView.ClickListener
{
  SettingContactActivity$1(SettingContactActivity paramSettingContactActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool;
    if (!paramUITableItemView.isChecked())
    {
      bool = true;
      paramUITableItemView.setChecked(bool);
      SettingContactActivity.access$002(this.this$0, paramUITableItemView.isChecked());
      if (!SettingContactActivity.access$000(this.this$0)) {
        break label72;
      }
      DataCollector.logEvent("Event_Addressbook_Setting_On");
    }
    for (;;)
    {
      QMSettingManager.sharedInstance().setContactDisplay(paramUITableItemView.isChecked());
      this.this$0.refreshData();
      this.this$0.render();
      return;
      bool = false;
      break;
      label72:
      DataCollector.logEvent("Event_Addressbook_Setting_Off");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingContactActivity.1
 * JD-Core Version:    0.7.0.1
 */