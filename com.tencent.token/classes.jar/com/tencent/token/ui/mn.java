package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;

class mn
  implements DialogInterface.OnClickListener
{
  mn(IndexActivity paramIndexActivity, int paramInt, Message paramMessage) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a == 40)
    {
      str = this.c.getResources().getString(2131230774);
      paramDialogInterface = str;
      if (this.b.getData().getString("loginurl") != null)
      {
        paramDialogInterface = str;
        if (this.b.getData().getString("loginurl").length() != 0) {
          paramDialogInterface = this.b.getData().getString("loginurl");
        }
      }
      h.c(this + "goToRemoveProtectH5 url:" + paramDialogInterface);
      w.a(this.c, paramDialogInterface, this.c.getResources().getString(2131230924));
    }
    while (this.a != 42) {
      return;
    }
    String str = this.c.getResources().getString(2131230764);
    paramDialogInterface = str;
    if (this.b.getData().getString("loginurl") != null)
    {
      paramDialogInterface = str;
      if (this.b.getData().getString("loginurl").length() != 0) {
        paramDialogInterface = this.b.getData().getString("loginurl");
      }
    }
    h.c(this + "goToRemoveProtectH5 url:" + paramDialogInterface);
    w.a(this.c, paramDialogInterface, this.c.getResources().getString(2131231122));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mn
 * JD-Core Version:    0.7.0.1
 */