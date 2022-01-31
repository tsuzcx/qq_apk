package com.tencent.token.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;

public class UtilsAccountLockTipDialog
  extends Dialog
{
  private Handler a;
  private ds b;
  private boolean c;
  
  public UtilsAccountLockTipDialog(Context paramContext, Handler paramHandler, ds paramds, boolean paramBoolean)
  {
    super(paramContext, 2131427400);
    this.a = paramHandler;
    this.b = paramds;
    this.c = paramBoolean;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903224);
    getWindow().setBackgroundDrawableResource(2130837639);
    findViewById(2131297186).setOnClickListener(new di(this));
    findViewById(2131297185).setOnClickListener(new dj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.UtilsAccountLockTipDialog
 * JD-Core Version:    0.7.0.1
 */