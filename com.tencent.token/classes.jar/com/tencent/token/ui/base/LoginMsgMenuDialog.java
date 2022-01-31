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
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing())))
    {
      dismiss();
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2130903125);
    this.b = ((Button)findViewById(2131296780));
    this.c = ((Button)findViewById(2131296781));
    this.b.setOnClickListener(this.e);
    this.c.setOnClickListener(this.d);
    setCanceledOnTouchOutside(true);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawableResource(2130837639);
    paramBundle.getAttributes().width = -1;
    paramBundle.setGravity(80);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.LoginMsgMenuDialog
 * JD-Core Version:    0.7.0.1
 */