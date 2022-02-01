package com.tencent.qqmail.utilities.ui;

class QMTips$8
  implements Runnable
{
  QMTips$8(QMTips paramQMTips, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (QMTips.access$000(this.this$0) != null) {
      QMTips.access$000(this.this$0).showLoading(this.val$msg, this.val$subTitleString);
    }
    QMTips.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMTips.8
 * JD-Core Version:    0.7.0.1
 */