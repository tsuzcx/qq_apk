package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.token.cb;
import com.tencent.token.global.g;

public class ProDialog
  extends Dialog
{
  private Activity a;
  private String b;
  
  public ProDialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    this.a = paramActivity;
  }
  
  public ProDialog(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt);
    this.a = paramActivity;
    this.b = paramString;
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
    setContentView(2130968717);
    getWindow().setBackgroundDrawableResource(2130837730);
    ((ImageView)findViewById(2131559125)).startAnimation(AnimationUtils.loadAnimation(this.a, 2131034130));
    setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        ProDialog.a(ProDialog.this);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ProDialog
 * JD-Core Version:    0.7.0.1
 */