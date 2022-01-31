package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class pc
  implements DialogInterface.OnClickListener
{
  pc(LogoActivity paramLogoActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      LogoActivity.access$100(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pc
 * JD-Core Version:    0.7.0.1
 */