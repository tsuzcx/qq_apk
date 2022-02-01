package com.tencent.android.tpush;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class TpnsActivity$5
  implements DialogInterface.OnClickListener
{
  TpnsActivity$5(TpnsActivity paramTpnsActivity, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.putExtra("action", NotificationAction.open_cancel.getType());
    TpnsActivity.a(this.b, this.a);
    paramDialogInterface.dismiss();
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.TpnsActivity.5
 * JD-Core Version:    0.7.0.1
 */