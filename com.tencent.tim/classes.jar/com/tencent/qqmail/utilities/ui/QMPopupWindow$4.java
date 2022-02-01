package com.tencent.qqmail.utilities.ui;

import android.widget.PopupWindow.OnDismissListener;

class QMPopupWindow$4
  implements PopupWindow.OnDismissListener
{
  QMPopupWindow$4(QMPopupWindow paramQMPopupWindow, PopupWindow.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss()
  {
    this.this$0.deMask();
    this.val$listener.onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMPopupWindow.4
 * JD-Core Version:    0.7.0.1
 */