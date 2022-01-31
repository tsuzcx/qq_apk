package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class of
  implements DialogInterface.OnCancelListener
{
  of(LogoActivity paramLogoActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      LogoActivity.access$400(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.of
 * JD-Core Version:    0.7.0.1
 */