package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ck
  implements DialogInterface.OnClickListener
{
  ck(CorrectTokenActivity paramCorrectTokenActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    CorrectTokenActivity.access$502(this.a, true);
    this.a.removeTimeTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ck
 * JD-Core Version:    0.7.0.1
 */