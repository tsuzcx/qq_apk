package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.HandlerThread;

final class vx
  implements DialogInterface.OnClickListener
{
  vx(vu paramvu) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RealNameSmsContentTipActivity.access$500(this.a.a) == null)
    {
      RealNameSmsContentTipActivity.access$502(this.a.a, new HandlerThread("uploadphoto", 1));
      RealNameSmsContentTipActivity.access$500(this.a.a).start();
    }
    if (RealNameSmsContentTipActivity.access$600(this.a.a) == null) {
      RealNameSmsContentTipActivity.access$602(this.a.a, new Handler(RealNameSmsContentTipActivity.access$500(this.a.a).getLooper()));
    }
    RealNameSmsContentTipActivity.access$600(this.a.a).post(new vy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vx
 * JD-Core Version:    0.7.0.1
 */