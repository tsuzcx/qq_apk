package com.tencent.qqmail.account.helper;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.qqmail.utilities.ui.QMUIKit;

final class Helper$2
  implements TextWatcher
{
  Helper$2(HelperTextChange paramHelperTextChange, EditText paramEditText, View paramView) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.val$textChangeCallback != null) {
      this.val$textChangeCallback.onChange(this.val$editText);
    }
    if (paramCharSequence.length() == 0) {
      this.val$clearButton.setVisibility(8);
    }
    while (!this.val$editText.isFocused()) {
      return;
    }
    this.val$clearButton.setVisibility(0);
    QMUIKit.expendTouchArea(this.val$clearButton, QMUIKit.dpToPx(20));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.Helper.2
 * JD-Core Version:    0.7.0.1
 */