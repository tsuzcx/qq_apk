package com.tencent.qqmail.activity.setting;

import android.widget.EditText;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMBaseView.OnCompleteInputListener;

class SettingIndependentNickActivity$2
  implements QMBaseView.OnCompleteInputListener
{
  SettingIndependentNickActivity$2(SettingIndependentNickActivity paramSettingIndependentNickActivity) {}
  
  public void onComplete()
  {
    String str = SettingIndependentNickActivity.access$200(this.this$0).getText().toString();
    SettingIndependentNickActivity.access$700(this.this$0).post(new SettingIndependentNickActivity.2.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingIndependentNickActivity.2
 * JD-Core Version:    0.7.0.1
 */