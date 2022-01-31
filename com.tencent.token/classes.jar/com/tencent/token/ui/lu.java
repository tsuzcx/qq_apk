package com.tencent.token.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.cw;

class lu
  implements DialogInterface.OnClickListener
{
  lu(lp paramlp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    IndexActivity.access$1000(this.a.a).dismiss();
    cw.a().b(IndexActivity.access$100(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.lu
 * JD-Core Version:    0.7.0.1
 */