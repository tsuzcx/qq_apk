package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.token.af;
import com.tencent.token.core.bean.e;

final class ow
  implements DialogInterface.OnClickListener
{
  ow(ot paramot) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    or.c(this.a.a).f.d = true;
    or.a(this.a.a, or.c(this.a.a));
    int i = ot.a(this.a).f.a;
    if (ot.a(this.a).f.c) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramDialogInterface = af.a();
      String str = or.a(this.a.a).mA2;
      Handler localHandler = or.a(this.a.a).mHandler;
      paramDialogInterface.b(0L, new int[] { i, 71 }, new int[] { paramInt, 1 }, str, localHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ow
 * JD-Core Version:    0.7.0.1
 */