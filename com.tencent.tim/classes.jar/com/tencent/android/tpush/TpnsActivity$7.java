package com.tencent.android.tpush;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;

class TpnsActivity$7
  implements DialogInterface.OnCancelListener
{
  TpnsActivity$7(TpnsActivity paramTpnsActivity, Intent paramIntent) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.putExtra("action", NotificationAction.open_cancel.getType());
    TpnsActivity.a(this.b, this.a);
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.TpnsActivity.7
 * JD-Core Version:    0.7.0.1
 */