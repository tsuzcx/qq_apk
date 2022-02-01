package com.tencent.qqmail.register.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class RegisterUIHelper$4$3
  implements DialogInterface.OnDismissListener
{
  RegisterUIHelper$4$3(RegisterUIHelper.4 param4) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.this$0.val$onDismissListener != null) {
      this.this$0.val$onDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.util.RegisterUIHelper.4.3
 * JD-Core Version:    0.7.0.1
 */