package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class me
  implements DialogInterface.OnClickListener
{
  me(IndexActivity paramIndexActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    IndexActivity.s_FromOtherApp = true;
    IndexActivity.access$2800(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.me
 * JD-Core Version:    0.7.0.1
 */