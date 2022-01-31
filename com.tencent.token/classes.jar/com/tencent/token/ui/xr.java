package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.token.upload.useraction.CustomerEditText;

class xr
  implements View.OnFocusChangeListener
{
  xr(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    try
    {
      ((CustomerEditText)RealNameStep1InputNameIdActivity.access$1900(this.a)).a(paramBoolean);
      RealNameStep1InputNameIdActivity.access$3200(this.a);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xr
 * JD-Core Version:    0.7.0.1
 */