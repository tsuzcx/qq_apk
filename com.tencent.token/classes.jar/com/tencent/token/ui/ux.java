package com.tencent.token.ui;

import android.text.Editable;
import android.text.TextWatcher;

class ux
  implements TextWatcher
{
  ux(RealNameFindActivity paramRealNameFindActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    RealNameFindActivity.access$302(this.a, false);
    RealNameFindActivity.access$600(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ux
 * JD-Core Version:    0.7.0.1
 */