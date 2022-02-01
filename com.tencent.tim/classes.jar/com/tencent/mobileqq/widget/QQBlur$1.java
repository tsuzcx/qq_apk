package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.View;
import arhv;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.qphone.base.util.QLog;

public class QQBlur$1
  implements Runnable
{
  private int ehP = -1;
  
  public QQBlur$1(arhv paramarhv, StackBlurManager paramStackBlurManager) {}
  
  public void run()
  {
    if (arhv.a(this.this$0)) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    if ((this.ehP != -1) && (this.ehP != arhv.ehN)) {
      arhv.a(this.this$0, this.ehP, arhv.ehN);
    }
    this.ehP = arhv.ehN;
    int i = arhv.ehN;
    Object localObject = this.a.process(arhv.a(this.this$0));
    if (localObject != null) {
      arhv.a(this.this$0, (Bitmap)localObject);
    }
    for (;;)
    {
      long l2 = SystemClock.elapsedRealtime();
      arhv.a(this.this$0);
      arhv.a(this.this$0, l2 - l1 + arhv.b(this.this$0));
      localObject = arhv.a(this.this$0);
      if ((localObject == null) || (!arhv.b(this.this$0))) {
        break;
      }
      ((View)localObject).postInvalidate();
      return;
      QLog.e("QQBlur", 1, "run: outBitmap is null. OOM ?");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQBlur.1
 * JD-Core Version:    0.7.0.1
 */