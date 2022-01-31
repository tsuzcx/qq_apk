package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;

class wt
  implements DialogInterface.OnCancelListener
{
  wt(wp paramwp) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new Intent(this.a.a, IndexActivity.class);
    paramDialogInterface.addFlags(67108864);
    this.a.a.startActivity(paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wt
 * JD-Core Version:    0.7.0.1
 */