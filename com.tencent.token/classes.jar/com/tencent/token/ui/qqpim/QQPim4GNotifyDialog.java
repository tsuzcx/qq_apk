package com.tencent.token.ui.qqpim;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.token.ui.IndexActivity;

public class QQPim4GNotifyDialog
  extends Dialog
{
  private Context a;
  private d b = null;
  
  public QQPim4GNotifyDialog(Context paramContext, int paramInt, d paramd)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
    this.b = paramd;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968719);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
      localLayoutParams.width = ((int)(((Activity)this.a).getWindowManager().getDefaultDisplay().getWidth() - 84.0F * IndexActivity.S_DENSITY));
      paramBundle.setAttributes(localLayoutParams);
      ((TextView)findViewById(2131559129)).setOnClickListener(new b(this));
      ((TextView)findViewById(2131559128)).setOnClickListener(new c(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qqpim.QQPim4GNotifyDialog
 * JD-Core Version:    0.7.0.1
 */