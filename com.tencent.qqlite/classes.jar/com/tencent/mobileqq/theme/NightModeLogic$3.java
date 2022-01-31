package com.tencent.mobileqq.theme;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;

class NightModeLogic$3
  implements DialogInterface.OnDismissListener
{
  NightModeLogic$3(NightModeLogic paramNightModeLogic) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.this$0.mCallback != null)
    {
      paramDialogInterface = new Bundle();
      paramDialogInterface.putInt("start_status", 2);
      this.this$0.mCallback.c(paramDialogInterface);
    }
    this.this$0.downloadDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic.3
 * JD-Core Version:    0.7.0.1
 */