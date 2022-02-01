package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingCardActivity$5
  implements UITableView.ClickListener
{
  SettingCardActivity$5(SettingCardActivity paramSettingCardActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool = true;
    if (paramUITableItemView == SettingCardActivity.access$600(this.this$0)) {
      SettingCardActivity.access$500(this.this$0, true);
    }
    while (paramUITableItemView != SettingCardActivity.access$800(this.this$0)) {
      return;
    }
    if (!paramUITableItemView.isChecked()) {}
    for (;;)
    {
      paramUITableItemView.setChecked(bool);
      QMSettingManager.sharedInstance().setCardBirthdayRemind(paramUITableItemView.isChecked());
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCardActivity.5
 * JD-Core Version:    0.7.0.1
 */