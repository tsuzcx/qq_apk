package com.tencent.token.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;

final class px
  implements DialogInterface.OnCancelListener
{
  px(pv parampv, Activity paramActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new Intent(this.a, WtLoginAccountInput.class);
    this.a.startActivity(paramDialogInterface);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.px
 * JD-Core Version:    0.7.0.1
 */