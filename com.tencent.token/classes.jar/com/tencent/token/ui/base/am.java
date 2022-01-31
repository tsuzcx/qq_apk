package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.token.ui.VerifyStartScanActivity;

class am
  implements DialogInterface.OnClickListener
{
  am(aj paramaj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.dismiss();
    paramDialogInterface = new Intent(GameLoginSndConfirmDialog.c(this.a.a), VerifyStartScanActivity.class);
    GameLoginSndConfirmDialog.c(this.a.a).startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.am
 * JD-Core Version:    0.7.0.1
 */