package com.tencent.qqmail.utilities.ui;

class QMTips$9
  implements Runnable
{
  QMTips$9(QMTips paramQMTips, String paramString, long paramLong) {}
  
  public void run()
  {
    if (QMTips.access$000(this.this$0) != null) {
      QMTips.access$000(this.this$0).showSuccess(this.val$msg);
    }
    QMTips.access$100(this.this$0);
    QMTips localQMTips = this.this$0;
    if (this.val$stayMillis > 0L) {}
    for (long l = this.val$stayMillis;; l = 1000L)
    {
      localQMTips.hideDelay(l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMTips.9
 * JD-Core Version:    0.7.0.1
 */