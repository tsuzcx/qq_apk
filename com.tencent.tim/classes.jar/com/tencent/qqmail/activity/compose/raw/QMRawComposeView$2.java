package com.tencent.qqmail.activity.compose.raw;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmail.activity.compose.ComposeViewCallback;

class QMRawComposeView$2
  implements TextWatcher
{
  QMRawComposeView$2(QMRawComposeView paramQMRawComposeView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (QMRawComposeView.access$100(this.this$0) != null) {
      QMRawComposeView.access$100(this.this$0).contentTextDidChange(this.this$0, QMRawComposeView.access$000(this.this$0));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.raw.QMRawComposeView.2
 * JD-Core Version:    0.7.0.1
 */