package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class abl
  implements DialogInterface.OnClickListener
{
  abl(StartPwdGestureForgetActivity paramStartPwdGestureForgetActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, StartPwdGestureModifyActivity.class);
    this.a.startActivityForResult(paramDialogInterface, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abl
 * JD-Core Version:    0.7.0.1
 */