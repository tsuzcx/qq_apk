package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.HandlerThread;

final class uy
  implements DialogInterface.OnClickListener
{
  uy(ux paramux) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RealNameFindActivity.access$1300(this.a.a) == null)
    {
      RealNameFindActivity.access$1302(this.a.a, new HandlerThread("uploadphoto", 1));
      RealNameFindActivity.access$1300(this.a.a).start();
    }
    if (RealNameFindActivity.access$1400(this.a.a) == null) {
      RealNameFindActivity.access$1402(this.a.a, new Handler(RealNameFindActivity.access$1300(this.a.a).getLooper()));
    }
    RealNameFindActivity.access$1400(this.a.a).post(new uz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.uy
 * JD-Core Version:    0.7.0.1
 */