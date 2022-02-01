package com.tencent.qqmail.view;

import android.widget.RelativeLayout;

class QMReadMailView$1
  implements Runnable
{
  QMReadMailView$1(QMReadMailView paramQMReadMailView) {}
  
  public void run()
  {
    if ((QMReadMailView.access$000(this.this$0) != null) && (QMReadMailView.access$000(this.this$0).isShown()))
    {
      QMReadMailView.access$000(this.this$0).setOnClickListener(null);
      this.this$0.hideNightModeGuideBar(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailView.1
 * JD-Core Version:    0.7.0.1
 */