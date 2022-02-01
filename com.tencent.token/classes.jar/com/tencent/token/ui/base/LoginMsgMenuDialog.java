package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class LoginMsgMenuDialog
  extends Dialog
{
  private Activity a;
  private Button b;
  private Button c;
  private View.OnClickListener d;
  private View.OnClickListener e;
  
  protected void onCreate(Bundle paramBundle)
  {
    Activity localActivity = this.a;
    if ((localActivity != null) && ((localActivity == null) || (!localActivity.isFinishing())))
    {
      super.onCreate(paramBundle);
      setContentView(2131296364);
      this.b = ((Button)findViewById(2131165733));
      this.c = ((Button)findViewById(2131165732));
      this.b.setOnClickListener(this.e);
      this.c.setOnClickListener(this.d);
      setCanceledOnTouchOutside(true);
      paramBundle = getWindow();
      paramBundle.setBackgroundDrawableResource(2131099877);
      paramBundle.getAttributes().width = -1;
      paramBundle.setGravity(80);
      return;
    }
    dismiss();
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.LoginMsgMenuDialog
 * JD-Core Version:    0.7.0.1
 */