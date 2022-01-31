package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.res.Resources;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.r;
import com.tencent.token.x;
import gameloginsdk.CallbackPushStruct;

final class aj
  implements az
{
  aj(GameLoginSndConfirmDialog paramGameLoginSndConfirmDialog) {}
  
  public final void a()
  {
    this.a.dismiss();
  }
  
  public final void a(int paramInt)
  {
    r localr = r.a(RqdApplication.i());
    CallbackPushStruct localCallbackPushStruct = localr.d();
    if (localCallbackPushStruct != null)
    {
      localr.a(localCallbackPushStruct.uin, x.a(RqdApplication.i()).c(), paramInt, GameLoginSndConfirmDialog.d(this.a));
      if (GameLoginSndConfirmDialog.a(this.a) == null) {
        GameLoginSndConfirmDialog.a(this.a, new ProDialog(GameLoginSndConfirmDialog.c(this.a)));
      }
      GameLoginSndConfirmDialog.a(this.a).show();
    }
  }
  
  public final void b()
  {
    CallbackPushStruct localCallbackPushStruct = r.a(RqdApplication.i()).d();
    if (localCallbackPushStruct != null)
    {
      if (localCallbackPushStruct.schemeFlag != 2) {
        break label111;
      }
      new AlertDialog.Builder(GameLoginSndConfirmDialog.c(this.a)).setTitle(2131361808).setMessage("" + localCallbackPushStruct.expirtTime + GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131362440)).setPositiveButton(2131362441, new ak(this)).create().show();
    }
    for (;;)
    {
      this.a.dismiss();
      return;
      label111:
      new AlertDialog.Builder(GameLoginSndConfirmDialog.c(this.a)).setTitle(2131361808).setMessage(GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131362442)).setPositiveButton(2131362443, new am(this)).setNegativeButton(2131361804, new al(this)).create().show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.aj
 * JD-Core Version:    0.7.0.1
 */