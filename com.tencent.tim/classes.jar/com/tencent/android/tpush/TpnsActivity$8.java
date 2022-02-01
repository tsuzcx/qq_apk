package com.tencent.android.tpush;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class TpnsActivity$8
  implements DialogInterface.OnClickListener
{
  TpnsActivity$8(TpnsActivity paramTpnsActivity, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TpnsActivity.a(this.b, this.a);
    paramDialogInterface.cancel();
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.TpnsActivity.8
 * JD-Core Version:    0.7.0.1
 */