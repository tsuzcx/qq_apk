package com.tencent.qqmail.utilities.ui;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qqmail.view.TitleBarWebView2;

class QMScaleWebViewController$2
  implements View.OnTouchListener
{
  private boolean isSelectionMode;
  private float mSecondX;
  private float mSecondY;
  private float mX;
  private float mY;
  
  QMScaleWebViewController$2(QMScaleWebViewController paramQMScaleWebViewController) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return false;
        this.isSelectionMode = QMScaleWebViewController.access$000(this.this$0).isSelectionMode();
        this.mX = paramMotionEvent.getX();
        this.mY = paramMotionEvent.getY();
        continue;
        if ((this.isSelectionMode) && (QMScaleWebViewController.access$000(this.this$0) != null) && (paramMotionEvent.getX() - this.mX == 0.0F) && (paramMotionEvent.getY() - this.mY == 0.0F)) {
          QMScaleWebViewController.access$000(this.this$0).setSelectionRanger(0);
        }
        this.mX = -1.0F;
        this.mSecondX = -1.0F;
        this.mY = -1.0F;
        this.mSecondY = -1.0F;
        continue;
        if (paramMotionEvent.getPointerCount() == 2)
        {
          this.mX = paramMotionEvent.getX(0);
          this.mY = paramMotionEvent.getY(0);
          this.mSecondX = paramMotionEvent.getX(1);
          this.mSecondY = paramMotionEvent.getY(1);
        }
      }
    } while ((paramMotionEvent.getPointerCount() != 2) || ((this.mX == -1.0F) && (this.mSecondX == -1.0F)));
    float f1 = paramMotionEvent.getX(0);
    float f2 = paramMotionEvent.getY(0);
    float f3 = paramMotionEvent.getX(1);
    float f4 = paramMotionEvent.getY(1);
    float f5 = (float)Math.sqrt(Math.pow(this.mSecondX - this.mX, 2.0D) + Math.pow(this.mSecondY - this.mY, 2.0D));
    float f6 = (float)Math.sqrt(Math.pow(f3 - f1, 2.0D) + Math.pow(f4 - f2, 2.0D));
    if (f5 - f6 >= 25.0F)
    {
      Log.e("baggiotest", "zoomOut");
      QMScaleWebViewController.access$102(this.this$0, true);
    }
    for (;;)
    {
      this.mX = f1;
      this.mSecondX = f3;
      this.mY = f2;
      this.mSecondY = f4;
      break;
      if (f6 - f5 >= 25.0F)
      {
        Log.e("baggiotest", "zoomIn");
        QMScaleWebViewController.access$102(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.2
 * JD-Core Version:    0.7.0.1
 */