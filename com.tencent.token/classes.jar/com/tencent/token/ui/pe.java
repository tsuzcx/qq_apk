package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.cw;

class pe
  implements DialogInterface.OnClickListener
{
  pe(ModifyQQPwdActivity paramModifyQQPwdActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    cw.a().d(0L, this.a.mPwdText, 1, this.a.mHandler);
    this.a.showProDialog(this.a, 2131230843, 2131230942, new pf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pe
 * JD-Core Version:    0.7.0.1
 */