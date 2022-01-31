package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class og
  implements DialogInterface.OnClickListener
{
  og(LogoActivity paramLogoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, StartPwdGestureModifyActivity.class);
    this.a.startActivityForResult(paramDialogInterface, 260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.og
 * JD-Core Version:    0.7.0.1
 */