package com.tencent.qqmail.activity.compose;

class QMComposeMailView$7
  implements Runnable
{
  QMComposeMailView$7(QMComposeMailView paramQMComposeMailView) {}
  
  public void run()
  {
    if ((QMComposeMailView.access$800(this.this$0)) && (!QMComposeMailView.access$900(this.this$0).hasFocusCursor())) {
      if (!QMComposeMailView.access$1000(this.this$0)) {}
    }
    do
    {
      do
      {
        return;
        this.this$0.showformatToolbar(false);
      } while (QMComposeMailView.access$1100(this.this$0) == null);
      QMComposeMailView.access$1100(this.this$0).onFormatToobarChange(true);
      return;
      this.this$0.hideformatToolbar(false);
    } while (QMComposeMailView.access$1100(this.this$0) == null);
    QMComposeMailView.access$1100(this.this$0).onFormatToobarChange(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeMailView.7
 * JD-Core Version:    0.7.0.1
 */