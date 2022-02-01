package com.tencent.qqmail.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class QMTopBar$4
  implements View.OnTouchListener
{
  QMTopBar$4(QMTopBar paramQMTopBar) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      QMTopBar.access$500(this.this$0).setPressed(true);
      return false;
    }
    QMTopBar.access$500(this.this$0).setPressed(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMTopBar.4
 * JD-Core Version:    0.7.0.1
 */