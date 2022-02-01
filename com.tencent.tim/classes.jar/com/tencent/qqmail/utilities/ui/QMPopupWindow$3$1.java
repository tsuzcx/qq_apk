package com.tencent.qqmail.utilities.ui;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.Window;

class QMPopupWindow$3$1
  implements Runnable
{
  QMPopupWindow$3$1(QMPopupWindow.3 param3) {}
  
  public void run()
  {
    ViewGroup localViewGroup = (ViewGroup)((Activity)this.this$1.this$0.context).getWindow().getDecorView();
    localViewGroup.removeView(this.this$1.this$0.mask);
    localViewGroup.setTag(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMPopupWindow.3.1
 * JD-Core Version:    0.7.0.1
 */