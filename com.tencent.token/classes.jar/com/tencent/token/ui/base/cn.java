package com.tencent.token.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View.OnClickListener;

final class cn
  implements DialogInterface.OnDismissListener
{
  cn(ProDialogWithShutDown paramProDialogWithShutDown) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    ProDialogWithShutDown.a(this.a);
    if (ProDialogWithShutDown.b(this.a) != null) {
      ProDialogWithShutDown.b(this.a).onClick(ProDialogWithShutDown.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.cn
 * JD-Core Version:    0.7.0.1
 */