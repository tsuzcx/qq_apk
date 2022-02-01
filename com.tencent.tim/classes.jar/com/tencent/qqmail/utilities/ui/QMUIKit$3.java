package com.tencent.qqmail.utilities.ui;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class QMUIKit$3
  implements View.OnTouchListener
{
  @SuppressLint({"NewApi"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (i != 0) {
        break label25;
      }
      paramView.setAlpha(0.6F);
    }
    for (;;)
    {
      return false;
      label25:
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMUIKit.3
 * JD-Core Version:    0.7.0.1
 */