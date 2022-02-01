package com.tencent.gamecenter.common.util;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import tbl;

public class ScreenshotManager$3
  implements Runnable
{
  public ScreenshotManager$3(tbl paramtbl, WebView paramWebView) {}
  
  public void run()
  {
    QLog.i("ScreenshotManager", 1, "addMaskAsync mRemoveCall=" + tbl.a(this.this$0));
    if ((tbl.a(this.this$0) != null) && (!tbl.a(this.this$0))) {}
    try
    {
      if (tbl.a(this.this$0) == null)
      {
        tbl.a(this.this$0, new ImageView(this.c.getContext()));
        tbl.a(this.this$0).setScaleType(ImageView.ScaleType.FIT_XY);
      }
      tbl.a(this.this$0).setImageBitmap(tbl.a(this.this$0));
      this.this$0.bCs();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ((ViewGroup)this.c.getParent()).addView(tbl.a(this.this$0), localLayoutParams);
      tbl.a(this.this$0).setVisibility(0);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ScreenshotManager", 1, "addMaskAsync e=" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.3
 * JD-Core Version:    0.7.0.1
 */