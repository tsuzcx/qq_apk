package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class abc
  implements DialogInterface.OnClickListener
{
  abc(aba paramaba) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.a, StartPwdGestureForgetActivity.class);
    paramDialogInterface.putExtra("startpwd_forget_source", 3);
    this.a.a.startActivity(paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abc
 * JD-Core Version:    0.7.0.1
 */