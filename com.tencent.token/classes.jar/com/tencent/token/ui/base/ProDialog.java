package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ProDialog
  extends Dialog
{
  private Activity a;
  private String b;
  
  public ProDialog(Activity paramActivity)
  {
    super(paramActivity, 2131427400);
    this.a = paramActivity;
  }
  
  public ProDialog(Activity paramActivity, String paramString)
  {
    super(paramActivity, 2131427400);
    this.a = paramActivity;
    this.b = paramString;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing())))
    {
      dismiss();
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2130903155);
    getWindow().setBackgroundDrawableResource(2130837639);
    ((ImageView)findViewById(2131296914)).startAnimation(AnimationUtils.loadAnimation(this.a, 2130968581));
    setOnDismissListener(new cl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ProDialog
 * JD-Core Version:    0.7.0.1
 */