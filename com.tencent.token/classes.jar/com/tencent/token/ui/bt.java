package com.tencent.token.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import oicq.wlogin_sdk.tools.ErrMsg;

class bt
  implements DialogInterface.OnClickListener
{
  bt(BaseActivity paramBaseActivity, int paramInt, ErrMsg paramErrMsg, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a == 40)
    {
      str = this.d.getResources().getString(2131230774);
      paramDialogInterface = str;
      if (this.b != null)
      {
        paramDialogInterface = str;
        if (this.b.getOtherinfo() != null)
        {
          paramDialogInterface = str;
          if (this.b.getOtherinfo().length() != 0) {
            paramDialogInterface = this.b.getOtherinfo();
          }
        }
      }
      h.c(this + "goToRemoveProtectH5WithLoginTask url:" + paramDialogInterface);
      w.a(this.c, paramDialogInterface, this.d.getResources().getString(2131230924));
    }
    while (this.a != 42) {
      return;
    }
    String str = this.d.getResources().getString(2131230764);
    paramDialogInterface = str;
    if (this.b != null)
    {
      paramDialogInterface = str;
      if (this.b.getOtherinfo() != null)
      {
        paramDialogInterface = str;
        if (this.b.getOtherinfo().length() != 0) {
          paramDialogInterface = this.b.getOtherinfo();
        }
      }
    }
    h.c(this + "goToRemoveProtectH5WithLoginTask url:" + paramDialogInterface);
    w.a(this.c, paramDialogInterface, this.d.getResources().getString(2131231122));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bt
 * JD-Core Version:    0.7.0.1
 */