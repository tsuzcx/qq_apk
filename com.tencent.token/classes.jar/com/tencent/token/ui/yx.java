package com.tencent.token.ui;

import android.text.Editable;
import android.text.TextWatcher;

class yx
  implements TextWatcher
{
  yx(SettingSubmitCommentActivity paramSettingSubmitCommentActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.checkMenuBtnEnable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yx
 * JD-Core Version:    0.7.0.1
 */