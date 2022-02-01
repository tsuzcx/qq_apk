package com.tencent.qqmail.activity.setting;

import android.widget.EditText;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.view.QMBaseView.OnCompleteInputListener;

class SettingAccountActivity$9
  implements QMBaseView.OnCompleteInputListener
{
  SettingAccountActivity$9(SettingAccountActivity paramSettingAccountActivity) {}
  
  public void onComplete()
  {
    String str = SettingAccountActivity.access$1500(this.this$0).getText().toString();
    SettingAccountActivity.access$500(this.this$0).setDetail(str);
    SettingAccountActivity.access$1200(this.this$0, false);
    SettingAccountActivity.access$1600(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.9
 * JD-Core Version:    0.7.0.1
 */