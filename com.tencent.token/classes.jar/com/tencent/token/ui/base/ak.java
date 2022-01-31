package com.tencent.token.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ak
  implements DialogInterface.OnClickListener
{
  ak(aj paramaj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ak
 * JD-Core Version:    0.7.0.1
 */