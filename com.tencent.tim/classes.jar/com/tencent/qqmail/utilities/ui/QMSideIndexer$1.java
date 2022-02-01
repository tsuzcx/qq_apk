package com.tencent.qqmail.utilities.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class QMSideIndexer$1
  implements View.OnTouchListener
{
  QMSideIndexer$1(QMSideIndexer paramQMSideIndexer) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 0) || (i == 2)) {
      QMSideIndexer.access$000(this.this$0, paramMotionEvent.getY());
    }
    for (;;)
    {
      return false;
      if (i != 1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMSideIndexer.1
 * JD-Core Version:    0.7.0.1
 */