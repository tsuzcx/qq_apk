package com.tencent.qqmail.utilities.ui;

class QMTips$5
  implements Runnable
{
  QMTips$5(QMTips paramQMTips, String paramString) {}
  
  public void run()
  {
    if (QMTips.access$000(this.this$0) != null) {
      QMTips.access$000(this.this$0).showInfo(this.val$msg);
    }
    QMTips.access$100(this.this$0);
    this.this$0.hideDelay(1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMTips.5
 * JD-Core Version:    0.7.0.1
 */