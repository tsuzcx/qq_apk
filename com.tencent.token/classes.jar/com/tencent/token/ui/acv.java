package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class acv
  implements DialogInterface.OnCancelListener
{
  acv(UnbindUinActivity paramUnbindUinActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.unbindResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acv
 * JD-Core Version:    0.7.0.1
 */