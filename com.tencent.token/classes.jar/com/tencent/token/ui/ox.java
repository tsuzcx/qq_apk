package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.cw;

class ox
  implements DialogInterface.OnClickListener
{
  ox(ot paramot) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.dismissDialog();
    cw.a().b(this.a.a.mHandler);
    this.a.a.showProDialog(this.a.a, 2131230843, 2131231298, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ox
 * JD-Core Version:    0.7.0.1
 */