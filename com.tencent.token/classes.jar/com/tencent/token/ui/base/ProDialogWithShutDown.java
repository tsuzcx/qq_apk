package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.cb;
import com.tencent.token.global.g;

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
    g.c("dismiss and cancel request");
    if (this.a != null) {
      cb.a().a(this.a.getClass().getName());
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
      paramBundle = (TextView)findViewById(2131559126);
      if ((this.d != null) && (this.d.length() > 0)) {
        paramBundle.setText(this.d);
      }
    }
    ((ImageView)findViewById(2131559125)).startAnimation(AnimationUtils.loadAnimation(this.a, 2131034130));
    this.b = ((ImageView)findViewById(2131559128));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ProDialogWithShutDown.this.dismiss();
      }
    });
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        ProDialogWithShutDown.a(ProDialogWithShutDown.this);
        if (ProDialogWithShutDown.b(ProDialogWithShutDown.this) != null) {
          ProDialogWithShutDown.b(ProDialogWithShutDown.this).onClick(ProDialogWithShutDown.c(ProDialogWithShutDown.this));
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ProDialogWithShutDown
 * JD-Core Version:    0.7.0.1
 */