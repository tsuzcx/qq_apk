package com.tencent.qqmail.qmui.popup;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

class QMUIBasePopup$1
  implements View.OnTouchListener
{
  QMUIBasePopup$1(QMUIBasePopup paramQMUIBasePopup) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4) {
      this.this$0.mWindow.dismiss();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.popup.QMUIBasePopup.1
 * JD-Core Version:    0.7.0.1
 */