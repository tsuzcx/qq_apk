package com.tencent.qqmail.view;

import android.widget.LinearLayout;

class QMReadMailView$3
  implements Runnable
{
  QMReadMailView$3(QMReadMailView paramQMReadMailView) {}
  
  public void run()
  {
    if ((QMReadMailView.access$100(this.this$0) != null) && (QMReadMailView.access$100(this.this$0).isShown()))
    {
      QMReadMailView.access$202(this.this$0, true);
      if (!QMReadMailView.access$100(this.this$0).isPressed()) {
        this.this$0.hideBubbleViewAndShowNext();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailView.3
 * JD-Core Version:    0.7.0.1
 */