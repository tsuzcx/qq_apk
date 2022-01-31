package com.tencent.token.ui;

import android.text.Editable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

final class abf
  implements CompoundButton.OnCheckedChangeListener
{
  abf(StartPwdGestureForgetActivity paramStartPwdGestureForgetActivity) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramCompoundButton.isChecked())
    {
      StartPwdGestureForgetActivity.access$000(this.a).setInputType(145);
      StartPwdGestureForgetActivity.access$100(this.a).setVisibility(4);
      StartPwdGestureForgetActivity.access$200(this.a).setVisibility(0);
    }
    for (;;)
    {
      StartPwdGestureForgetActivity.access$000(this.a).requestFocus();
      StartPwdGestureForgetActivity.access$000(this.a).setSelection(StartPwdGestureForgetActivity.access$000(this.a).getText().length());
      return;
      StartPwdGestureForgetActivity.access$000(this.a).setInputType(129);
      StartPwdGestureForgetActivity.access$100(this.a).setVisibility(0);
      StartPwdGestureForgetActivity.access$200(this.a).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abf
 * JD-Core Version:    0.7.0.1
 */