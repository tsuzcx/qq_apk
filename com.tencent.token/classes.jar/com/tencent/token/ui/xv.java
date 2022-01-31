package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;

final class xv
  implements DialogInterface.OnClickListener
{
  xv(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RealNameStep1InputNameIdActivity.access$2100(this.b) == null)
    {
      RealNameStep1InputNameIdActivity.access$2102(this.b, new HandlerThread("uploadphoto", 1));
      RealNameStep1InputNameIdActivity.access$2100(this.b).start();
    }
    if (RealNameStep1InputNameIdActivity.access$2200(this.b) == null) {
      RealNameStep1InputNameIdActivity.access$2202(this.b, new Handler(RealNameStep1InputNameIdActivity.access$2100(this.b).getLooper()));
    }
    RealNameStep1InputNameIdActivity.access$2200(this.b).post(new xw(this));
    if (this.a)
    {
      this.b.showProDialogWithoutShutDown(this.b, this.b.getResources().getString(2131361817));
      return;
    }
    RealNameStep1InputNameIdActivity.access$2700(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xv
 * JD-Core Version:    0.7.0.1
 */