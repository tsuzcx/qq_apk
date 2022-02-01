package com.tencent.qqmail.activity.compose;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class QMTextField$2
  implements View.OnTouchListener
{
  private int touchType = -1;
  private float y = 0.0F;
  
  QMTextField$2(QMTextField paramQMTextField) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.touchType = 0;
      this.y = paramMotionEvent.getY();
    }
    while (((paramMotionEvent.getAction() == 2) && (Math.abs(paramMotionEvent.getY() - this.y) < 1.0F)) || (paramMotionEvent.getAction() != 1) || (this.touchType != 0) || (QMTextField.access$000(this.this$0) == null)) {
      return false;
    }
    QMTextField.access$000(this.this$0).onClickChange(this.this$0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMTextField.2
 * JD-Core Version:    0.7.0.1
 */