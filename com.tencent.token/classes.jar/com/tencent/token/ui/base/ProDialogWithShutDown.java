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
    super(paramActivity, 2131558791);
    this.a = paramActivity;
    this.c = paramOnClickListener;
    this.d = paramString;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = this.a;
    if ((localObject != null) && ((localObject == null) || (!((Activity)localObject).isFinishing())))
    {
      super.onCreate(paramBundle);
      setContentView(2131296400);
      getWindow().setBackgroundDrawableResource(2131099877);
      if (this.e)
      {
        paramBundle = (TextView)findViewById(2131165825);
        localObject = this.d;
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          paramBundle.setText(this.d);
        }
      }
      ((ImageView)findViewById(2131165823)).startAnimation(AnimationUtils.loadAnimation(this.a, 2130771986));
      this.b = ((ImageView)findViewById(2131165824));
      this.b.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          ProDialogWithShutDown.this.dismiss();
        }
      });
      setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          ProDialogWithShutDown.a(ProDialogWithShutDown.this);
          if (ProDialogWithShutDown.b(ProDialogWithShutDown.this) != null) {
            ProDialogWithShutDown.b(ProDialogWithShutDown.this).onClick(ProDialogWithShutDown.c(ProDialogWithShutDown.this));
          }
        }
      });
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ProDialogWithShutDown
 * JD-Core Version:    0.7.0.1
 */