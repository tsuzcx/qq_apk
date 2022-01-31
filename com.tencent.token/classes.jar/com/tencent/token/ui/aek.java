package com.tencent.token.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.core.bean.h;
import com.tencent.token.dr;

class aek
  implements CompoundButton.OnCheckedChangeListener
{
  aek(UtilsQbQdProtectActivity paramUtilsQbQdProtectActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = dr.a().g();
    if ((paramCompoundButton == null) || (!dr.a().p()) || (paramBoolean != paramCompoundButton.c)) {
      return;
    }
    UtilsQbQdProtectActivity.access$400(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aek
 * JD-Core Version:    0.7.0.1
 */