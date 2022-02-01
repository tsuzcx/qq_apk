package com.tencent.qqmail.activity.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingBottleActivity$7$1
  implements DialogInterface.OnDismissListener
{
  SettingBottleActivity$7$1(SettingBottleActivity.7 param7, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$1.this$0.getString(2131691006)))
    {
      SettingBottleActivity.access$1100(this.this$1.this$0).setDetail(this.this$1.this$0.getString(2131691006));
      SettingBottleActivity.access$1500(this.this$1.this$0, true);
    }
    while (!this.val$tag.equals(this.this$1.this$0.getString(2131691005))) {
      return;
    }
    SettingBottleActivity.access$1100(this.this$1.this$0).setDetail(this.this$1.this$0.getString(2131691005));
    SettingBottleActivity.access$1500(this.this$1.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity.7.1
 * JD-Core Version:    0.7.0.1
 */