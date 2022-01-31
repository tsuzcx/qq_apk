package com.tencent.token.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.token.ui.ModifyQQPwdActivity;
import com.tencent.token.ui.pv;

final class ai
  implements DialogInterface.OnClickListener
{
  ai(af paramaf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.dismiss();
    paramDialogInterface = new Intent(GameLoginSndConfirmDialog.c(this.a.a), ModifyQQPwdActivity.class);
    pv.a().a(GameLoginSndConfirmDialog.c(this.a.a), paramDialogInterface, pv.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.ai
 * JD-Core Version:    0.7.0.1
 */