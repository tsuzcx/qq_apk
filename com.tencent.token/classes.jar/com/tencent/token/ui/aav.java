package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class aav
  implements DialogInterface.OnCancelListener
{
  aav(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.unbindResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aav
 * JD-Core Version:    0.7.0.1
 */