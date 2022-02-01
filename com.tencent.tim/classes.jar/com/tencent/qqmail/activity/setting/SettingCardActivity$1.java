package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingCardActivity$1
  implements UITableView.ClickListener
{
  SettingCardActivity$1(SettingCardActivity paramSettingCardActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (!paramUITableItemView.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setChecked(bool);
      SettingCardActivity.access$002(this.this$0, paramUITableItemView.isChecked());
      QMSettingManager.sharedInstance().setCardDisplay(SettingCardActivity.access$000(this.this$0));
      this.this$0.refreshData();
      this.this$0.render();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCardActivity.1
 * JD-Core Version:    0.7.0.1
 */