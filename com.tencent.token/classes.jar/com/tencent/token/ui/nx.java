package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.token.core.bean.f;
import com.tencent.token.cw;

class nx
  implements DialogInterface.OnClickListener
{
  nx(nw paramnw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    nu.b(this.a.a).f.d = true;
    nu.a(this.a.a, nu.b(this.a.a));
    if (nw.a(this.a).f.e) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramDialogInterface = cw.a();
      String str = nu.a(this.a.a).mA2;
      Handler localHandler = nu.a(this.a.a).mHandler;
      paramDialogInterface.a(0L, new int[] { 71, 82 }, new int[] { paramInt, 0 }, str, localHandler);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nx
 * JD-Core Version:    0.7.0.1
 */