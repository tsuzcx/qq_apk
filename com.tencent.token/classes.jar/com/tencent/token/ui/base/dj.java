package com.tencent.token.ui.base;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

final class dj
  implements View.OnClickListener
{
  dj(UtilsAccountLockTipDialog paramUtilsAccountLockTipDialog) {}
  
  public final void onClick(View paramView)
  {
    if (UtilsAccountLockTipDialog.a(this.a) != null)
    {
      paramView = UtilsAccountLockTipDialog.a(this.a).obtainMessage(3035);
      if (!UtilsAccountLockTipDialog.b(this.a)) {
        break label72;
      }
    }
    label72:
    for (int i = 1;; i = 0)
    {
      paramView.arg1 = i;
      paramView.obj = UtilsAccountLockTipDialog.c(this.a);
      UtilsAccountLockTipDialog.a(this.a).sendMessage(paramView);
      this.a.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.dj
 * JD-Core Version:    0.7.0.1
 */