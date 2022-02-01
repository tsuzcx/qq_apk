package com.tencent.qqmail.activity.setting;

import android.widget.EditText;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingTestHostIpActivity$1
  implements UITableView.ClickListener
{
  SettingTestHostIpActivity$1(SettingTestHostIpActivity paramSettingTestHostIpActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (paramUITableItemView == SettingTestHostIpActivity.access$000(this.this$0))
    {
      paramUITableItemView = SettingTestHostIpActivity.access$100(this.this$0).getText().toString().trim();
      str = SettingTestHostIpActivity.access$200(this.this$0).getText().toString().trim();
      SettingTestHostIpActivity.access$300(this.this$0, paramUITableItemView, str);
    }
    while (paramUITableItemView != SettingTestHostIpActivity.access$400(this.this$0))
    {
      String str;
      return;
    }
    SettingTestHostIpActivity.access$500(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingTestHostIpActivity.1
 * JD-Core Version:    0.7.0.1
 */