package com.tencent.av.ui.redbag;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.RelativeLayout;
import jib;

public class GuideTip2$5
  implements Runnable
{
  public GuideTip2$5(jib paramjib, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2) {}
  
  public void run()
  {
    Object localObject = this.this$0.getAVActivity();
    if (localObject != null)
    {
      localObject = (RelativeLayout)((Activity)localObject).findViewById(2131368219);
      if (Build.VERSION.SDK_INT < 16) {
        break label118;
      }
      ((RelativeLayout)localObject).findViewById(2131368220).setBackground(null);
      ((RelativeLayout)localObject).findViewById(2131368221).setBackground(null);
    }
    for (;;)
    {
      this.ev.removeView(this.ew);
      if (this.this$0.bl != null)
      {
        this.this$0.bl.recycle();
        this.this$0.bl = null;
      }
      if (this.this$0.bi != null)
      {
        this.this$0.bi.recycle();
        this.this$0.bi = null;
      }
      return;
      label118:
      ((RelativeLayout)localObject).findViewById(2131368220).setBackgroundDrawable(null);
      ((RelativeLayout)localObject).findViewById(2131368221).setBackgroundDrawable(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GuideTip2.5
 * JD-Core Version:    0.7.0.1
 */