package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class xx
  implements DialogInterface.OnClickListener
{
  xx(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
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
 * Qualified Name:     com.tencent.token.ui.xx
 * JD-Core Version:    0.7.0.1
 */