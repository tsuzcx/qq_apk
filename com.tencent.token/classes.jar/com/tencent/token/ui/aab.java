package com.tencent.token.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class aab
  implements TextWatcher
{
  aab(SettingSubmitCommentActivity paramSettingSubmitCommentActivity) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.checkMenuBtnEnable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aab
 * JD-Core Version:    0.7.0.1
 */