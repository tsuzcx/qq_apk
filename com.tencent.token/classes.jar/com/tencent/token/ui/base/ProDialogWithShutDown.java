package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ProDialogWithShutDown
  extends Dialog
{
  private Activity a;
  private ImageView b;
  private View.OnClickListener c;
  private String d;
  private boolean e;
  
  public ProDialogWithShutDown(Activity paramActivity, View.OnClickListener paramOnClickListener, String paramString)
  {
    super(paramActivity, 2131427400);
    this.a = paramActivity;
    this.c = paramOnClickListener;
    this.d = paramString;
  }
  
  public ProDialogWithShutDown(Activity paramActivity, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    super(paramActivity, 2131427400);
    this.a = paramActivity;
    this.c = paramOnClickListener;
    this.d = paramString;
    this.e = paramBoolean;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing())))
    {
      dismiss();
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2130903156);
    getWindow().setBackgroundDrawableResource(2130837639);
    if (this.e)
    {
      paramBundle = (TextView)findViewById(2131296915);
      if ((this.d != null) && (this.d.length() > 0)) {
        paramBundle.setText(this.d);
      }
    }
    ((ImageView)findViewById(2131296914)).startAnimation(AnimationUtils.loadAnimation(this.a, 2130968581));
    this.b = ((ImageView)findViewById(2131296917));
    this.b.setOnClickListener(new cm(this));
    setOnDismissListener(new cn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ProDialogWithShutDown
 * JD-Core Version:    0.7.0.1
 */