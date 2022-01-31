package com.tencent.token.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.token.ui.ModifyQQPwdActivity;
import com.tencent.token.ui.pv;

final class l
  implements DialogInterface.OnClickListener
{
  l(DualMsgShowDialog paramDualMsgShowDialog) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(DualMsgShowDialog.b(this.a), ModifyQQPwdActivity.class);
    pv.a().a(DualMsgShowDialog.b(this.a), paramDialogInterface, pv.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.l
 * JD-Core Version:    0.7.0.1
 */