package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class xm
  implements DialogInterface.OnClickListener
{
  xm(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a)
    {
      paramDialogInterface = new Intent(this.b, IndexActivity.class);
      paramDialogInterface.addFlags(67108864);
      this.b.startActivity(paramDialogInterface);
      this.b.finish();
      return;
    }
    this.b.dismissDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xm
 * JD-Core Version:    0.7.0.1
 */