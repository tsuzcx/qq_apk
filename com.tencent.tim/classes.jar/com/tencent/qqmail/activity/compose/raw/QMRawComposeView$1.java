package com.tencent.qqmail.activity.compose.raw;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

class QMRawComposeView$1
  implements View.OnFocusChangeListener
{
  QMRawComposeView$1(QMRawComposeView paramQMRawComposeView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      paramView = QMRawComposeView.access$000(this.this$0).getText().toString();
      if (paramView != null) {
        i = paramView.length();
      }
      QMRawComposeView.access$000(this.this$0).setSelection(i);
      return;
    }
    QMRawComposeView.access$000(this.this$0).setSelection(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.raw.QMRawComposeView.1
 * JD-Core Version:    0.7.0.1
 */