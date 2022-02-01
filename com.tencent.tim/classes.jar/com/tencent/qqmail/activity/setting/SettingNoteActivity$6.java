package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingNoteActivity$6
  implements UITableView.ClickListener
{
  SettingNoteActivity$6(SettingNoteActivity paramSettingNoteActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramUITableItemView = SettingSelectAccountActivity.createNoteIntent(SettingNoteActivity.access$500(this.this$0));
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNoteActivity.6
 * JD-Core Version:    0.7.0.1
 */