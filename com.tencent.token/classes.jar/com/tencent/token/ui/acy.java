package com.tencent.token.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.core.bean.h;
import com.tencent.token.dr;
import com.tmsdk.TMSDKContext;

class acy
  implements CompoundButton.OnCheckedChangeListener
{
  acy(UtilsMailProtectActivity paramUtilsMailProtectActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = dr.a().h();
    if ((paramCompoundButton == null) || (paramBoolean != paramCompoundButton.c)) {
      return;
    }
    if (!paramBoolean) {
      TMSDKContext.saveActionData(1150080);
    }
    for (;;)
    {
      UtilsMailProtectActivity.access$102(this.a, paramCompoundButton);
      UtilsMailProtectActivity.access$200(this.a);
      return;
      TMSDKContext.saveActionData(1150081);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acy
 * JD-Core Version:    0.7.0.1
 */