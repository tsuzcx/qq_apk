package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;

class xk
  implements DialogInterface.OnClickListener
{
  xk(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RealNameStep1InputNameIdActivity.access$2800(this.b) == null)
    {
      RealNameStep1InputNameIdActivity.access$2802(this.b, new HandlerThread("uploadphoto", 1));
      RealNameStep1InputNameIdActivity.access$2800(this.b).start();
    }
    if (RealNameStep1InputNameIdActivity.access$2900(this.b) == null) {
      RealNameStep1InputNameIdActivity.access$2902(this.b, new Handler(RealNameStep1InputNameIdActivity.access$2800(this.b).getLooper()));
    }
    RealNameStep1InputNameIdActivity.access$2900(this.b).post(new xl(this));
    if (this.a)
    {
      this.b.showProDialogWithoutShutDown(this.b, this.b.getResources().getString(2131231298));
      return;
    }
    RealNameStep1InputNameIdActivity.access$3000(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xk
 * JD-Core Version:    0.7.0.1
 */