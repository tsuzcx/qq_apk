package com.tencent.qqmail.qmui.popup;

import android.widget.PopupWindow.OnDismissListener;

class QMUIBasePopup$3
  implements PopupWindow.OnDismissListener
{
  QMUIBasePopup$3(QMUIBasePopup paramQMUIBasePopup) {}
  
  public void onDismiss()
  {
    this.this$0.onDismiss();
    if (QMUIBasePopup.access$000(this.this$0) != null) {
      QMUIBasePopup.access$000(this.this$0).onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.popup.QMUIBasePopup.3
 * JD-Core Version:    0.7.0.1
 */