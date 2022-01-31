package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.af;

final class pt
  implements DialogInterface.OnClickListener
{
  pt(ModifyQQPwdActivity paramModifyQQPwdActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    af.a().a(0L, this.a.mPwdText, 1, this.a.mHandler);
    this.a.showProDialog(this.a, 2131361808, 2131361931, new pu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pt
 * JD-Core Version:    0.7.0.1
 */