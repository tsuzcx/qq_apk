package com.tencent.qqmail.activity.compose;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ComposeMailActivity$44
  implements DialogInterface.OnCancelListener
{
  ComposeMailActivity$44(ComposeMailActivity paramComposeMailActivity, DialogInterface.OnCancelListener paramOnCancelListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ComposeMailActivity.access$5602(this.this$0, false);
    if (this.val$dismissListener != null) {
      this.val$dismissListener.onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.44
 * JD-Core Version:    0.7.0.1
 */