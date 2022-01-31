package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.token.af;
import com.tencent.token.core.bean.e;

final class ou
  implements DialogInterface.OnClickListener
{
  ou(ot paramot) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    or.b(this.a.a).f.d = true;
    or.a(this.a.a, or.b(this.a.a));
    if (ot.a(this.a).f.e) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramDialogInterface = af.a();
      String str = or.a(this.a.a).mA2;
      Handler localHandler = or.a(this.a.a).mHandler;
      paramDialogInterface.b(0L, new int[] { 71, 82 }, new int[] { paramInt, 0 }, str, localHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ou
 * JD-Core Version:    0.7.0.1
 */