package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.ag;
import com.tencent.token.aq;
import com.tencent.token.as;

final class cj
  implements DialogInterface.OnClickListener
{
  cj(CorrectTokenActivity paramCorrectTokenActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ag.c().a.b.a();
    CorrectTokenActivity.access$502(this.a, false);
    this.a.showUserDialog(6);
    this.a.startTimeTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cj
 * JD-Core Version:    0.7.0.1
 */