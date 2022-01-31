package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class aak
  implements DialogInterface.OnClickListener
{
  aak(StartPwdGestureVerifyActivity paramStartPwdGestureVerifyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, StartPwdGestureModifyActivity.class);
    this.a.startActivity(paramDialogInterface);
    this.a.setResult(35);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aak
 * JD-Core Version:    0.7.0.1
 */