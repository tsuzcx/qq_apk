package com.tencent.qqmail.qmui.popup;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class QMUIBasePopup$2
  implements View.OnAttachStateChangeListener
{
  QMUIBasePopup$2(QMUIBasePopup paramQMUIBasePopup) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (this.this$0.isShowing()) {
      this.this$0.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.popup.QMUIBasePopup.2
 * JD-Core Version:    0.7.0.1
 */