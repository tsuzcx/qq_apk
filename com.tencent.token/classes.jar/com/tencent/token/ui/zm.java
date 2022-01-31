package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class zm
  implements DialogInterface.OnCancelListener
{
  zm(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.unbindResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zm
 * JD-Core Version:    0.7.0.1
 */