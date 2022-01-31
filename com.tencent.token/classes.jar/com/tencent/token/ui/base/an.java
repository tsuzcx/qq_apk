package com.tencent.token.ui.base;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.r;

final class an
  implements DialogInterface.OnDismissListener
{
  an(GameLoginSndConfirmDialog paramGameLoginSndConfirmDialog) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    GameLoginSndConfirmDialog.b(this.a).d();
    r.a(RqdApplication.i()).e();
    if (GameLoginSndConfirmDialog.a(this.a) != null) {
      GameLoginSndConfirmDialog.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.an
 * JD-Core Version:    0.7.0.1
 */