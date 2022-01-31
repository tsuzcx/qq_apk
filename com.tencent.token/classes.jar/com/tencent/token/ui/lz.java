package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class lz
  implements DialogInterface.OnClickListener
{
  lz(IndexActivity paramIndexActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    IndexActivity.s_FromOtherApp = true;
    IndexActivity.access$2400(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.lz
 * JD-Core Version:    0.7.0.1
 */