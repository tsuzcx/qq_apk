package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.ArrayList;

class SettingAppActivity$1
  implements UITableView.ClickListener
{
  SettingAppActivity$1(SettingAppActivity paramSettingAppActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramUITableItemView = (Popularize)SettingAppActivity.access$100(this.this$0).get(SettingAppActivity.access$000(this.this$0).indexOf(paramUITableItemView));
    if (paramUITableItemView != null)
    {
      paramUITableItemView = SettingPopularizeActivity.createIntent(paramUITableItemView.getId());
      this.this$0.startActivity(paramUITableItemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAppActivity.1
 * JD-Core Version:    0.7.0.1
 */