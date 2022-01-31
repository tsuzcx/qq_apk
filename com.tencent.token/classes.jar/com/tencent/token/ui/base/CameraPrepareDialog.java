package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;

public class CameraPrepareDialog
  extends Dialog
{
  private Activity a;
  
  public CameraPrepareDialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.a = paramActivity;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing())))
    {
      dismiss();
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2130968625);
    setCanceledOnTouchOutside(false);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837730);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)findViewById(2131558745).getLayoutParams();
    localMarginLayoutParams.width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
    localMarginLayoutParams.height = paramBundle.getWindowManager().getDefaultDisplay().getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.CameraPrepareDialog
 * JD-Core Version:    0.7.0.1
 */