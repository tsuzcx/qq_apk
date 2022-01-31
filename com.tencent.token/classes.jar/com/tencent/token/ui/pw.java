package com.tencent.token.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class pw
  implements DialogInterface.OnClickListener
{
  pw(pv parampv, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((BaseActivity)this.a).dismissDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pw
 * JD-Core Version:    0.7.0.1
 */