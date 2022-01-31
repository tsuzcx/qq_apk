package com.tencent.token.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.token.cy;
import com.tencent.token.global.RqdApplication;

class aan
  implements DialogInterface.OnCancelListener
{
  aan(StartPwdGestureVerifyActivity paramStartPwdGestureVerifyActivity, Context paramContext) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    cy.a().a(this.a);
    RqdApplication.i();
    this.b.setResult(35);
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aan
 * JD-Core Version:    0.7.0.1
 */