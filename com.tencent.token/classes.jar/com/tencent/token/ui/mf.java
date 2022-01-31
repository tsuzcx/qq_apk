package com.tencent.token.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.af;

final class mf
  implements DialogInterface.OnClickListener
{
  mf(mb parammb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    IndexActivity.access$700(this.a.a).dismiss();
    af.a().b(IndexActivity.access$300(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mf
 * JD-Core Version:    0.7.0.1
 */