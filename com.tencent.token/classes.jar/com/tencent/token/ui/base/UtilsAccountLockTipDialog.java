package com.tencent.token.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class UtilsAccountLockTipDialog
  extends Dialog
{
  private Handler a;
  private l b;
  private boolean c;
  
  public UtilsAccountLockTipDialog(Context paramContext, int paramInt, Handler paramHandler, l paraml, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.a = paramHandler;
    this.b = paraml;
    this.c = paramBoolean;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968787);
    getWindow().setBackgroundDrawableResource(2130837730);
    findViewById(2131559348).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        UtilsAccountLockTipDialog.this.dismiss();
      }
    });
    findViewById(2131559347).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (UtilsAccountLockTipDialog.a(UtilsAccountLockTipDialog.this) != null)
        {
          paramAnonymousView = UtilsAccountLockTipDialog.a(UtilsAccountLockTipDialog.this).obtainMessage(3035);
          if (!UtilsAccountLockTipDialog.b(UtilsAccountLockTipDialog.this)) {
            break label72;
          }
        }
        label72:
        for (int i = 1;; i = 0)
        {
          paramAnonymousView.arg1 = i;
          paramAnonymousView.obj = UtilsAccountLockTipDialog.c(UtilsAccountLockTipDialog.this);
          UtilsAccountLockTipDialog.a(UtilsAccountLockTipDialog.this).sendMessage(paramAnonymousView);
          UtilsAccountLockTipDialog.this.dismiss();
          return;
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.UtilsAccountLockTipDialog
 * JD-Core Version:    0.7.0.1
 */