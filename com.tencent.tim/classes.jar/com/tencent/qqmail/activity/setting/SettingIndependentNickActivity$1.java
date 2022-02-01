package com.tencent.qqmail.activity.setting;

import android.text.Editable;
import android.text.TextWatcher;

class SettingIndependentNickActivity$1
  implements TextWatcher
{
  SettingIndependentNickActivity$1(SettingIndependentNickActivity paramSettingIndependentNickActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    SettingIndependentNickActivity.access$102(this.this$0, true);
    if (paramEditable.length() == 0) {
      SettingIndependentNickActivity.access$000(this.this$0, true);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0) {
      SettingIndependentNickActivity.access$000(this.this$0, false);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingIndependentNickActivity.1
 * JD-Core Version:    0.7.0.1
 */