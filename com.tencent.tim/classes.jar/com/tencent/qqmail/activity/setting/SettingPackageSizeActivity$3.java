package com.tencent.qqmail.activity.setting;

import android.content.pm.PackageStats;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingPackageSizeActivity$3
  implements UITableView.ClickListener
{
  SettingPackageSizeActivity$3(SettingPackageSizeActivity paramSettingPackageSizeActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    paramUITableItemView = (PackageStats)paramUITableItemView.getTag();
    this.this$0.startActivity(SettingPackageSizeActivity.createCompareIntent(paramUITableItemView, SettingPackageSizeActivity.access$000(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingPackageSizeActivity.3
 * JD-Core Version:    0.7.0.1
 */