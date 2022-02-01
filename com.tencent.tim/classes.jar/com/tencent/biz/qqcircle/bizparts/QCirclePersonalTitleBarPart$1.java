package com.tencent.biz.qqcircle.bizparts;

import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;
import ows;

public class QCirclePersonalTitleBarPart$1
  implements Runnable
{
  public QCirclePersonalTitleBarPart$1(ows paramows, PopupWindow paramPopupWindow) {}
  
  public void run()
  {
    try
    {
      if ((this.val$popupWindow != null) && (this.val$popupWindow.isShowing())) {
        this.val$popupWindow.dismiss();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QCirclePersonalTitleBar", 2, "tryShowingInviteGuideBubble error! ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.1
 * JD-Core Version:    0.7.0.1
 */