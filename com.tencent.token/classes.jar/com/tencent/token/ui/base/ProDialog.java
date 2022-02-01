package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
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
    super(paramActivity, 2131558791);
    this.a = paramActivity;
  }
  
  public ProDialog(Activity paramActivity, String paramString)
  {
    super(paramActivity, 2131558791);
    this.a = paramActivity;
    this.b = paramString;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Activity localActivity = this.a;
    if ((localActivity != null) && ((localActivity == null) || (!localActivity.isFinishing())))
    {
      super.onCreate(paramBundle);
      setContentView(2131296399);
      getWindow().setBackgroundDrawableResource(2131099877);
      ((ImageView)findViewById(2131165824)).startAnimation(AnimationUtils.loadAnimation(this.a, 2130771986));
      setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          ProDialog.a(ProDialog.this);
        }
      });
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ProDialog
 * JD-Core Version:    0.7.0.1
 */