package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.x;

final class ado
  implements DialogInterface.OnClickListener
{
  ado(UtilsActivity paramUtilsActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ax.a().e();
    if (paramDialogInterface == null) {
      return;
    }
    paramDialogInterface = "" + paramDialogInterface.mRealUin;
    x localx = x.a(RqdApplication.i());
    if (!localx.b(paramDialogInterface, 523005425L))
    {
      localx.a(paramDialogInterface, this.a.mHandler, 523005425L);
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      return;
    }
    this.a.showUserDialog(2131362364, this.a.getResources().getString(2131362365), 2131361800, new adp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ado
 * JD-Core Version:    0.7.0.1
 */