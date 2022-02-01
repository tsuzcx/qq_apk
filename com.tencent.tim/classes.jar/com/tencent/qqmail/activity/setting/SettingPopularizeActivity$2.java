package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingPopularizeActivity$2
  implements UITableView.ClickListener
{
  SettingPopularizeActivity$2(SettingPopularizeActivity paramSettingPopularizeActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (!paramUITableItemView.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setChecked(bool);
      if (!paramUITableItemView.isChecked()) {
        break;
      }
      SettingPopularizeActivity.access$100(this.this$0).setMove(1);
      PopularizeManager.sharedInstance().updatePopularizeMoved(SettingPopularizeActivity.access$100(this.this$0).getId(), 1);
      DataCollector.logEvent("Event_Popularize_Setting_Show_Home");
      return;
    }
    SettingPopularizeActivity.access$100(this.this$0).setMove(2);
    PopularizeManager.sharedInstance().updatePopularizeMoved(SettingPopularizeActivity.access$100(this.this$0).getId(), 2);
    DataCollector.logEvent("Event_Popularize_Setting_Show_Inner");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPopularizeActivity.2
 * JD-Core Version:    0.7.0.1
 */