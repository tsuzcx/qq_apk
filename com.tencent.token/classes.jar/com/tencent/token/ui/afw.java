package com.tencent.token.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.ba;
import com.tencent.token.core.bean.g;

final class afw
  implements CompoundButton.OnCheckedChangeListener
{
  afw(UtilsQbQdProtectActivity paramUtilsQbQdProtectActivity) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = ba.a().g();
    if ((paramCompoundButton == null) || (!ba.a().o()) || (paramBoolean != paramCompoundButton.c)) {
      return;
    }
    UtilsQbQdProtectActivity.access$600(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afw
 * JD-Core Version:    0.7.0.1
 */