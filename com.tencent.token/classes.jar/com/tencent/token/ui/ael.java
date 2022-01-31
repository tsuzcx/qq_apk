package com.tencent.token.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.ba;
import com.tencent.token.core.bean.g;

final class ael
  implements CompoundButton.OnCheckedChangeListener
{
  ael(UtilsMailProtectActivity paramUtilsMailProtectActivity) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = ba.a().h();
    if ((paramCompoundButton == null) || (paramBoolean != paramCompoundButton.c)) {
      return;
    }
    UtilsMailProtectActivity.access$102(this.a, paramCompoundButton);
    UtilsMailProtectActivity.access$200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ael
 * JD-Core Version:    0.7.0.1
 */