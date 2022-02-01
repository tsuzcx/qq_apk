package com.tencent.qqmail.activity.compose.raw;

import com.tencent.qqmail.utilities.richeditor.QMEditText;

class QMRawComposeView$7$1$1
  implements Runnable
{
  QMRawComposeView$7$1$1(QMRawComposeView.7.1 param1) {}
  
  public void run()
  {
    if (QMRawComposeView.access$800(this.this$2.this$1.this$0) > 0)
    {
      if (QMRawComposeView.access$800(this.this$2.this$1.this$0) > QMRawComposeView.access$300(this.this$2.this$1.this$0).getText().toString().length()) {
        QMRawComposeView.access$802(this.this$2.this$1.this$0, QMRawComposeView.access$300(this.this$2.this$1.this$0).getText().toString().length());
      }
      QMRawComposeView.access$300(this.this$2.this$1.this$0).setSelection(QMRawComposeView.access$800(this.this$2.this$1.this$0));
      QMRawComposeView.access$802(this.this$2.this$1.this$0, 0);
      return;
    }
    if (QMRawComposeView.access$500(this.this$2.this$1.this$0) > QMRawComposeView.access$300(this.this$2.this$1.this$0).getText().toString().length()) {
      QMRawComposeView.access$502(this.this$2.this$1.this$0, QMRawComposeView.access$300(this.this$2.this$1.this$0).getText().toString().length());
    }
    QMRawComposeView.access$300(this.this$2.this$1.this$0).setSelection(QMRawComposeView.access$500(this.this$2.this$1.this$0));
    QMRawComposeView.access$502(this.this$2.this$1.this$0, 0);
    QMRawComposeView.access$802(this.this$2.this$1.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.raw.QMRawComposeView.7.1.1
 * JD-Core Version:    0.7.0.1
 */