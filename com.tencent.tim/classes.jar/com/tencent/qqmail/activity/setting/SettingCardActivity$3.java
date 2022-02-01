package com.tencent.qqmail.activity.setting;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

class SettingCardActivity$3
  implements TextWatcher
{
  SettingCardActivity$3(SettingCardActivity paramSettingCardActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    SettingCardActivity.access$202(this.this$0, true);
    SettingCardActivity.access$302(this.this$0, paramEditable.toString());
    Log.d("SettingCardActivity", "isNickChanged" + SettingCardActivity.access$200(this.this$0));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCardActivity.3
 * JD-Core Version:    0.7.0.1
 */