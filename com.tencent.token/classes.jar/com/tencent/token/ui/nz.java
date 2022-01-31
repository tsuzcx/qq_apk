package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.token.core.bean.f;
import com.tencent.token.cw;

class nz
  implements DialogInterface.OnClickListener
{
  nz(nw paramnw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    nu.c(this.a.a).f.d = true;
    nu.a(this.a.a, nu.c(this.a.a));
    int i = nw.a(this.a).f.a;
    if (nw.a(this.a).f.c) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramDialogInterface = cw.a();
      String str = nu.a(this.a.a).mA2;
      Handler localHandler = nu.a(this.a.a).mHandler;
      paramDialogInterface.a(0L, new int[] { i, 71 }, new int[] { paramInt, 1 }, str, localHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nz
 * JD-Core Version:    0.7.0.1
 */