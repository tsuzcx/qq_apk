package com.tencent.qqmail.view;

import com.tencent.qqmail.utilities.log.QMLog;

class QMBaseView$2
  implements Runnable
{
  QMBaseView$2(QMBaseView paramQMBaseView) {}
  
  public void run()
  {
    QMLog.log(4, "QMBaseView", "HIT destroyAdvertiseViewInFuture");
    this.this$0.removeAdvertiseView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMBaseView.2
 * JD-Core Version:    0.7.0.1
 */