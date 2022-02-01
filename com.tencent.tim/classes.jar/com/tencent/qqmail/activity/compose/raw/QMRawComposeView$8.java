package com.tencent.qqmail.activity.compose.raw;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.qqmail.activity.compose.ComposeViewCallback;
import com.tencent.qqmail.utilities.richeditor.QMEditText;

class QMRawComposeView$8
  implements TextWatcher
{
  QMRawComposeView$8(QMRawComposeView paramQMRawComposeView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    QMRawComposeView.access$300(this.this$0).postDelayed(new QMRawComposeView.8.1(this), 200L);
    if (QMRawComposeView.access$100(this.this$0) != null) {
      QMRawComposeView.access$100(this.this$0).contentTextDidChange(this.this$0, QMRawComposeView.access$300(this.this$0));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = (SpannableStringBuilder)QMRawComposeView.access$300(this.this$0).getText();
    try
    {
      localObject = ((SpannableStringBuilder)localObject).subSequence(paramInt1, paramInt1 + paramInt3).toString();
      QMRawComposeView.access$900(this.this$0, paramInt1, (String)localObject);
      QMRawComposeView.access$1000(this.this$0, paramCharSequence, paramInt1, paramInt2, paramInt3);
      QMRawComposeView.access$1100(this.this$0, paramCharSequence, paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (Exception paramCharSequence) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.raw.QMRawComposeView.8
 * JD-Core Version:    0.7.0.1
 */