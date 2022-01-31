package com.tencent.token.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.token.ah;
import com.tencent.token.global.RqdApplication;

final class abo
  implements DialogInterface.OnCancelListener
{
  abo(StartPwdGestureForgetActivity paramStartPwdGestureForgetActivity, Context paramContext) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    ah.a().f();
    RqdApplication.f();
    this.b.setResult(35);
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abo
 * JD-Core Version:    0.7.0.1
 */