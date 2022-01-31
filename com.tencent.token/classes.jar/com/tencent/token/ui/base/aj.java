package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.res.Resources;
import com.tencent.token.cj;
import com.tencent.token.cp;
import com.tencent.token.global.RqdApplication;
import gameloginsdk.CallbackPushStruct;

class aj
  implements az
{
  aj(GameLoginSndConfirmDialog paramGameLoginSndConfirmDialog) {}
  
  public void a()
  {
    this.a.dismiss();
  }
  
  public void a(int paramInt)
  {
    cj localcj = cj.a(RqdApplication.l());
    CallbackPushStruct localCallbackPushStruct = localcj.d();
    if (localCallbackPushStruct != null)
    {
      localcj.a(localCallbackPushStruct.uin, cp.a(RqdApplication.l()).b(), paramInt, GameLoginSndConfirmDialog.d(this.a));
      if (GameLoginSndConfirmDialog.a(this.a) == null) {
        GameLoginSndConfirmDialog.a(this.a, new ProDialog(GameLoginSndConfirmDialog.c(this.a), 2131362182));
      }
      GameLoginSndConfirmDialog.a(this.a).show();
    }
  }
  
  public void b()
  {
    CallbackPushStruct localCallbackPushStruct = cj.a(RqdApplication.l()).d();
    if (localCallbackPushStruct != null)
    {
      if (localCallbackPushStruct.schemeFlag != 2) {
        break label111;
      }
      new AlertDialog.Builder(GameLoginSndConfirmDialog.c(this.a)).setTitle(2131230843).setMessage("" + localCallbackPushStruct.expirtTime + GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131231081)).setPositiveButton(2131231082, new ak(this)).create().show();
    }
    for (;;)
    {
      this.a.dismiss();
      return;
      label111:
      new AlertDialog.Builder(GameLoginSndConfirmDialog.c(this.a)).setTitle(2131230843).setMessage(GameLoginSndConfirmDialog.c(this.a).getResources().getString(2131231080)).setPositiveButton(2131231085, new am(this)).setNegativeButton(2131230886, new al(this)).create().show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.aj
 * JD-Core Version:    0.7.0.1
 */