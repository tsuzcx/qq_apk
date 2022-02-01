package com.tencent.qqmail.activity.setting;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

class SettingQmDefaultNickActivity$4
  implements TextWatcher
{
  SettingQmDefaultNickActivity$4(SettingQmDefaultNickActivity paramSettingQmDefaultNickActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    SettingQmDefaultNickActivity.access$502(this.this$0, true);
    SettingQmDefaultNickActivity.access$602(this.this$0, paramEditable.toString());
    Log.d("SettingNicknameActivity", "isNickChanged" + SettingQmDefaultNickActivity.access$500(this.this$0));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultNickActivity.4
 * JD-Core Version:    0.7.0.1
 */