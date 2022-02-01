package com.tencent.qqmail.activity.compose;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class QMTextField$3
  implements TextView.OnEditorActionListener
{
  QMTextField$3(QMTextField paramQMTextField) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 5)
    {
      if (QMTextField.access$000(this.this$0) != null) {
        QMTextField.access$000(this.this$0).onKeyNext();
      }
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMTextField.3
 * JD-Core Version:    0.7.0.1
 */