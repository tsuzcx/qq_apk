package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingGestureConfigActivity$4
  implements UITableView.ClickListener
{
  SettingGestureConfigActivity$4(SettingGestureConfigActivity paramSettingGestureConfigActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramUITableItemView = this.this$0;
    if (!SettingGestureConfigActivity.access$300(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      SettingGestureConfigActivity.access$302(paramUITableItemView, bool);
      if (!SettingGestureConfigActivity.access$300(this.this$0)) {
        break;
      }
      SettingGestureConfigActivity.access$400(this.this$0);
      return;
    }
    paramUITableItemView = new Intent(this.this$0.getActivity(), GesturePwdActivity.class);
    paramUITableItemView.putExtra("arg_page_state", 4);
    this.this$0.startActivity(paramUITableItemView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureConfigActivity.4
 * JD-Core Version:    0.7.0.1
 */