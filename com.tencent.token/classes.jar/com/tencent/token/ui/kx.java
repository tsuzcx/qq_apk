package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class kx
  implements DialogInterface.OnDismissListener
{
  kx(GetBarcodeVerifyMsgActivity paramGetBarcodeVerifyMsgActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kx
 * JD-Core Version:    0.7.0.1
 */