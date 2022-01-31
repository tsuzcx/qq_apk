package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.token.upload.useraction.CustomerEditText;

class uy
  implements View.OnFocusChangeListener
{
  uy(RealNameFindActivity paramRealNameFindActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    try
    {
      ((CustomerEditText)RealNameFindActivity.access$2500(this.a)).a(paramBoolean);
      RealNameFindActivity.access$3100(this.a);
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
 * Qualified Name:     com.tencent.token.ui.uy
 * JD-Core Version:    0.7.0.1
 */