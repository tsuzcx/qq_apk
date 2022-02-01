package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingGestureConfigActivity$5
  implements UITableView.ClickListener
{
  SettingGestureConfigActivity$5(SettingGestureConfigActivity paramSettingGestureConfigActivity, UITableItemView paramUITableItemView) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == this.val$modifyItem)
    {
      paramUITableItemView = new Intent(this.this$0.getActivity(), GesturePwdActivity.class);
      paramUITableItemView.putExtra("arg_page_state", 5);
      this.this$0.startActivity(paramUITableItemView);
    }
    while (paramUITableItemView != SettingGestureConfigActivity.access$500(this.this$0)) {
      return;
    }
    paramUITableItemView = SettingGestureConfigActivity.access$500(this.this$0);
    if (!SettingGestureConfigActivity.access$500(this.this$0).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramUITableItemView.setChecked(bool);
      SharedPreferenceUtil.setGesturePasswordShowTrack(SettingGestureConfigActivity.access$500(this.this$0).isChecked());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingGestureConfigActivity.5
 * JD-Core Version:    0.7.0.1
 */