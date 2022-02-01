package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingPopularizeActivity$1
  implements UITableView.ClickListener
{
  SettingPopularizeActivity$1(SettingPopularizeActivity paramSettingPopularizeActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool;
    if (!paramUITableItemView.isChecked())
    {
      bool = true;
      paramUITableItemView.setChecked(bool);
      SettingPopularizeActivity.access$002(this.this$0, paramUITableItemView.isChecked());
      if (!SettingPopularizeActivity.access$000(this.this$0)) {
        break label102;
      }
      DataCollector.logEvent("Event_Popularize_Setting_On");
    }
    for (;;)
    {
      SettingPopularizeActivity.access$100(this.this$0).setIsOpen(SettingPopularizeActivity.access$000(this.this$0));
      PopularizeManager.sharedInstance().updatePopularizeOpen(SettingPopularizeActivity.access$100(this.this$0).getId(), SettingPopularizeActivity.access$000(this.this$0));
      this.this$0.refreshData();
      this.this$0.render();
      return;
      bool = false;
      break;
      label102:
      DataCollector.logEvent("Event_Popularize_Setting_Off");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPopularizeActivity.1
 * JD-Core Version:    0.7.0.1
 */