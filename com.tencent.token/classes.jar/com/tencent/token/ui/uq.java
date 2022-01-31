package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.HandlerThread;

class uq
  implements DialogInterface.OnClickListener
{
  uq(ui paramui) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RealNameFindActivity.access$2900(this.a.a) == null)
    {
      RealNameFindActivity.access$2902(this.a.a, new HandlerThread("uploadphoto", 1));
      RealNameFindActivity.access$2900(this.a.a).start();
    }
    if (RealNameFindActivity.access$3000(this.a.a) == null) {
      RealNameFindActivity.access$3002(this.a.a, new Handler(RealNameFindActivity.access$2900(this.a.a).getLooper()));
    }
    RealNameFindActivity.access$3000(this.a.a).post(new ur(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.uq
 * JD-Core Version:    0.7.0.1
 */