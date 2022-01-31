package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class pd
  implements DialogInterface.OnCancelListener
{
  pd(LogoActivity paramLogoActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      LogoActivity.access$100(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pd
 * JD-Core Version:    0.7.0.1
 */