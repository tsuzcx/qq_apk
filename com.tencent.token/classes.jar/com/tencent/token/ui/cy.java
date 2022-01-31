package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.cx;
import com.tencent.token.dh;
import com.tencent.token.dj;

class cy
  implements DialogInterface.OnClickListener
{
  cy(CorrectTokenActivity paramCorrectTokenActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    cx.c().a.b.a(86630087L);
    CorrectTokenActivity.access$502(this.a, false);
    this.a.showUserDialog(6);
    this.a.startTimeTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cy
 * JD-Core Version:    0.7.0.1
 */