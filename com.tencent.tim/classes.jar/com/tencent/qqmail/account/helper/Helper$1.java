package com.tencent.qqmail.account.helper;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

final class Helper$1
  implements View.OnFocusChangeListener
{
  Helper$1(EditText paramEditText, View paramView, HelperFocusChange paramHelperFocusChange) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((paramBoolean) && (this.val$editText.isEnabled()))
      {
        if (this.val$editText.getText().length() == 0) {
          this.val$clearButton.setVisibility(8);
        }
      }
      else if (this.val$focusChangeCallback != null) {
        this.val$focusChangeCallback.onChange(true);
      }
    }
    do
    {
      return;
      this.val$clearButton.setVisibility(0);
      break;
      this.val$clearButton.setVisibility(8);
    } while (this.val$focusChangeCallback == null);
    this.val$focusChangeCallback.onChange(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.Helper.1
 * JD-Core Version:    0.7.0.1
 */