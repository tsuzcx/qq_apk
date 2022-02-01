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
  
  public CameraPrepareDialog(Activity paramActivity)
  {
    super(paramActivity, 2131558791);
    this.a = paramActivity;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = this.a;
    if ((localObject != null) && ((localObject == null) || (!((Activity)localObject).isFinishing())))
    {
      super.onCreate(paramBundle);
      setContentView(2131296307);
      setCanceledOnTouchOutside(false);
      paramBundle = getWindow();
      paramBundle.setBackgroundDrawableResource(2131099877);
      localObject = (ViewGroup.MarginLayoutParams)findViewById(2131165362).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).width = paramBundle.getWindowManager().getDefaultDisplay().getWidth();
      ((ViewGroup.MarginLayoutParams)localObject).height = paramBundle.getWindowManager().getDefaultDisplay().getHeight();
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.CameraPrepareDialog
 * JD-Core Version:    0.7.0.1
 */