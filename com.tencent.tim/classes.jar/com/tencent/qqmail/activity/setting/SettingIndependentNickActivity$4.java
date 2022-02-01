package com.tencent.qqmail.activity.setting;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingIndependentNickActivity$4
  implements Runnable
{
  SettingIndependentNickActivity$4(SettingIndependentNickActivity paramSettingIndependentNickActivity) {}
  
  public void run()
  {
    int i = this.this$0.getResources().getDimensionPixelSize(2131299385);
    SettingIndependentNickActivity.access$300(this.this$0).getDetailView().setMaxWidth(SettingIndependentNickActivity.access$300(this.this$0).getWidth() - i);
    SettingIndependentNickActivity.access$1000(this.this$0);
    SettingIndependentNickActivity.access$400(this.this$0, false);
    if (SettingIndependentNickActivity.access$1100(this.this$0) == "") {
      SettingIndependentNickActivity.access$1102(this.this$0, this.this$0.getResources().getString(2131720009));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingIndependentNickActivity.4
 * JD-Core Version:    0.7.0.1
 */