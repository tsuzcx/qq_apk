package com.tencent.qqmail.activity.setting;

import android.widget.EditText;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.view.QMBaseView.OnCompleteInputListener;

class SettingBottleActivity$8
  implements QMBaseView.OnCompleteInputListener
{
  SettingBottleActivity$8(SettingBottleActivity paramSettingBottleActivity) {}
  
  public void onComplete()
  {
    if ((SettingBottleActivity.access$1600(this.this$0) != null) && (SettingBottleActivity.access$1600(this.this$0).isChecked()))
    {
      String str = SettingBottleActivity.access$1700(this.this$0).getText().toString();
      SettingBottleActivity.access$900(this.this$0).setDetail(str);
      SettingBottleActivity.access$1000(this.this$0, false);
      SettingBottleActivity.access$700(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity.8
 * JD-Core Version:    0.7.0.1
 */