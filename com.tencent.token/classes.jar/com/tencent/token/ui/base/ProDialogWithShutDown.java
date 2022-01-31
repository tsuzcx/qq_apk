package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.cw;
import com.tencent.token.global.h;

public class ProDialogWithShutDown
  extends Dialog
{
  private Activity a;
  private ImageView b;
  private View.OnClickListener c;
  private String d;
  private boolean e;
  
  public ProDialogWithShutDown(Activity paramActivity, int paramInt, View.OnClickListener paramOnClickListener, String paramString)
  {
    super(paramActivity, paramInt);
    this.a = paramActivity;
    this.c = paramOnClickListener;
    this.d = paramString;
  }
  
  private void a()
  {
    h.c("dismiss and cancel request");
    if (this.a != null) {
      cw.a().a(this.a.getClass().getName());
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing())))
    {
      dismiss();
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2130968718);
    getWindow().setBackgroundDrawableResource(2130837730);
    if (this.e)
    {
      paramBundle = (TextView)findViewById(2131559125);
      if ((this.d != null) && (this.d.length() > 0)) {
        paramBundle.setText(this.d);
      }
    }
    ((ImageView)findViewById(2131559124)).startAnimation(AnimationUtils.loadAnimation(this.a, 2131034130));
    this.b = ((ImageView)findViewById(2131559127));
    this.b.setOnClickListener(new cb(this));
    setOnDismissListener(new cc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ProDialogWithShutDown
 * JD-Core Version:    0.7.0.1
 */