package com.tencent.token.ui;

import android.text.Editable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

final class ahq
  implements CompoundButton.OnCheckedChangeListener
{
  ahq(WtloginSigExpireActivity paramWtloginSigExpireActivity) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramCompoundButton.isChecked())
    {
      WtloginSigExpireActivity.access$600(this.a).setInputType(145);
      WtloginSigExpireActivity.access$700(this.a).setVisibility(4);
      WtloginSigExpireActivity.access$800(this.a).setVisibility(0);
    }
    for (;;)
    {
      WtloginSigExpireActivity.access$600(this.a).requestFocus();
      WtloginSigExpireActivity.access$600(this.a).setSelection(WtloginSigExpireActivity.access$600(this.a).getText().length());
      return;
      WtloginSigExpireActivity.access$600(this.a).setInputType(129);
      WtloginSigExpireActivity.access$700(this.a).setVisibility(0);
      WtloginSigExpireActivity.access$800(this.a).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ahq
 * JD-Core Version:    0.7.0.1
 */