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
  private dj b;
  private boolean c;
  
  public UtilsAccountLockTipDialog(Context paramContext, int paramInt, Handler paramHandler, dj paramdj, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.a = paramHandler;
    this.b = paramdj;
    this.c = paramBoolean;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968787);
    getWindow().setBackgroundDrawableResource(2130837730);
    findViewById(2131559347).setOnClickListener(new db(this));
    findViewById(2131559346).setOnClickListener(new dc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.UtilsAccountLockTipDialog
 * JD-Core Version:    0.7.0.1
 */