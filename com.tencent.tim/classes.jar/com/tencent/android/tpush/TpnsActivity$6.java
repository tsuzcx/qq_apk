package com.tencent.android.tpush;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class TpnsActivity$6
  implements DialogInterface.OnClickListener
{
  TpnsActivity$6(TpnsActivity paramTpnsActivity, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.putExtra("action", NotificationAction.open.getType());
    TpnsActivity.a(this.b, this.a);
    try
    {
      this.b.startActivity(this.a);
      label38:
      this.b.finish();
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.TpnsActivity.6
 * JD-Core Version:    0.7.0.1
 */