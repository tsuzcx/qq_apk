package com.tencent.qqmail.model.mail;

class QMMailListCursor$11
  implements Runnable
{
  QMMailListCursor$11(QMMailListCursor paramQMMailListCursor) {}
  
  public void run()
  {
    QMMailListCursor.access$602(this.this$0, this.this$0.queryCanPopIn());
    if (this.this$0.canPopIn()) {
      QMMailManager.sharedInstance().popIn(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor.11
 * JD-Core Version:    0.7.0.1
 */