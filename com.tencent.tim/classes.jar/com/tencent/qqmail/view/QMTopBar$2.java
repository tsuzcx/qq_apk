package com.tencent.qqmail.view;

import android.graphics.Rect;
import android.view.TouchDelegate;

class QMTopBar$2
  implements Runnable
{
  QMTopBar$2(QMTopBar paramQMTopBar) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    localRect.left = (this.this$0.getWidth() / 4);
    localRect.right = (this.this$0.getWidth() * 3 / 4);
    localRect.top = 0;
    localRect.bottom = this.this$0.getHeight();
    this.this$0.setTouchDelegate(new TouchDelegate(localRect, QMTopBar.access$000(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMTopBar.2
 * JD-Core Version:    0.7.0.1
 */