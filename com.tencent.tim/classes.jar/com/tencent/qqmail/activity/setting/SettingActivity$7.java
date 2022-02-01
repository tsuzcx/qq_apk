package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingActivity$7
  implements UITableView.ClickListener
{
  SettingActivity$7(SettingActivity paramSettingActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingActivity.access$1400(this.this$0))
    {
      paramUITableItemView = SettingAutoClearAttachmentsActivity.createIntent();
      this.this$0.startActivity(paramUITableItemView);
    }
    while (paramUITableItemView != SettingActivity.access$1500(this.this$0)) {
      return;
    }
    paramUITableItemView = SettingCacheClearActivity.createIntent();
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingActivity.7
 * JD-Core Version:    0.7.0.1
 */