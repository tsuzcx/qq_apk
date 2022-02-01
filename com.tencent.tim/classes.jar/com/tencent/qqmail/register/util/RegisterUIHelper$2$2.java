package com.tencent.qqmail.register.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class RegisterUIHelper$2$2
  implements DialogInterface.OnDismissListener
{
  RegisterUIHelper$2$2(RegisterUIHelper.2 param2) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.this$0.val$onDismissListener != null) {
      this.this$0.val$onDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.util.RegisterUIHelper.2.2
 * JD-Core Version:    0.7.0.1
 */