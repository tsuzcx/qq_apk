package com.tencent.qqmail.utilities.ui;

class QMTips$6
  implements Runnable
{
  QMTips$6(QMTips paramQMTips, String paramString, long paramLong) {}
  
  public void run()
  {
    if (QMTips.access$000(this.this$0) != null) {
      QMTips.access$000(this.this$0).showInfo(this.val$msg);
    }
    QMTips.access$100(this.this$0);
    this.this$0.hideDelay(this.val$mills);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMTips.6
 * JD-Core Version:    0.7.0.1
 */