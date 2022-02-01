package com.tencent.viola.ui.component;

import android.os.Handler;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.concurrent.atomic.AtomicBoolean;

class VImage$2
  implements Runnable
{
  VImage$2(VImage paramVImage) {}
  
  public void run()
  {
    if (!VImage.access$400(this.this$0).get())
    {
      VImage.access$508(this.this$0);
      if (VImage.access$100(this.this$0)) {
        this.this$0.setRemoteSrc(VImage.access$600(this.this$0), false, false);
      }
    }
    else
    {
      return;
    }
    if (VImage.access$500(this.this$0) <= 150)
    {
      VImage.access$300(this.this$0).postDelayed(this, 100L);
      return;
    }
    ViolaLogUtils.e("VComponent", "initHandler setPlaceHolder load image url fail:" + VImage.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.VImage.2
 * JD-Core Version:    0.7.0.1
 */