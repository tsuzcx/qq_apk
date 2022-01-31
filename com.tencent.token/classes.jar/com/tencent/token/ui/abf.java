package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class abf
  implements DialogInterface.OnCancelListener
{
  abf(UnbindUinActivity paramUnbindUinActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.unbindResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abf
 * JD-Core Version:    0.7.0.1
 */