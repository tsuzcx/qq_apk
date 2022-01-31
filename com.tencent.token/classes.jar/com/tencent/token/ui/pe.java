package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class pe
  implements DialogInterface.OnClickListener
{
  pe(LogoActivity paramLogoActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, StartPwdGestureModifyActivity.class);
    this.a.startActivityForResult(paramDialogInterface, 260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pe
 * JD-Core Version:    0.7.0.1
 */