package com.tencent.biz.qqstory.view.widget;

import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;

final class TipsView$1
  implements Runnable
{
  TipsView$1(PopupWindow paramPopupWindow) {}
  
  public void run()
  {
    try
    {
      if (this.val$popupWindow.isShowing()) {
        this.val$popupWindow.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("View", 2, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.TipsView.1
 * JD-Core Version:    0.7.0.1
 */