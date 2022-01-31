package com.tencent.token.ui;

import android.text.Editable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

final class ahk
  implements CompoundButton.OnCheckedChangeListener
{
  ahk(WtLoginAccountInput paramWtLoginAccountInput) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramCompoundButton.isChecked())
    {
      WtLoginAccountInput.access$1600(this.a).setInputType(145);
      WtLoginAccountInput.access$1700(this.a).setVisibility(4);
      WtLoginAccountInput.access$1800(this.a).setVisibility(0);
    }
    for (;;)
    {
      WtLoginAccountInput.access$1600(this.a).requestFocus();
      WtLoginAccountInput.access$1600(this.a).setSelection(WtLoginAccountInput.access$1600(this.a).getText().length());
      return;
      WtLoginAccountInput.access$1600(this.a).setInputType(129);
      WtLoginAccountInput.access$1700(this.a).setVisibility(0);
      WtLoginAccountInput.access$1800(this.a).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ahk
 * JD-Core Version:    0.7.0.1
 */