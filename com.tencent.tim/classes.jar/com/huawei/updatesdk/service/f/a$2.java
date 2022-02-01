package com.huawei.updatesdk.service.f;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class a$2
  implements DialogInterface.OnDismissListener
{
  a$2(a parama) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (a.c(this.a) != null) {
      a.c(this.a).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.f.a.2
 * JD-Core Version:    0.7.0.1
 */