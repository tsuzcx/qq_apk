package com.tencent.qqmail.view.imageview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class QMGestureImageView$1
  implements View.OnTouchListener
{
  QMGestureImageView$1(QMGestureImageView paramQMGestureImageView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QMGestureImageView.access$000(this.this$0) != null) {
      QMGestureImageView.access$000(this.this$0).onTouch(paramView, paramMotionEvent);
    }
    return QMGestureImageView.access$100(this.this$0).onTouch(paramView, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.QMGestureImageView.1
 * JD-Core Version:    0.7.0.1
 */