package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;

class acc
  implements DialogInterface.OnClickListener
{
  acc(UtilsActivity paramUtilsActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = do.a().e();
    if (paramDialogInterface == null) {
      return;
    }
    paramDialogInterface = "" + paramDialogInterface.mRealUin;
    cp localcp = cp.a(RqdApplication.l());
    if (!localcp.b(paramDialogInterface, 523005419L))
    {
      localcp.a(paramDialogInterface, this.a.mHandler, 523005419L);
      this.a.showProDialog(this.a, 2131230843, 2131231298, null);
      return;
    }
    this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new acd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.acc
 * JD-Core Version:    0.7.0.1
 */