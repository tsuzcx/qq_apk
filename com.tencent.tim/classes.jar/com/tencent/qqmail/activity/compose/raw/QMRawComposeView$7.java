package com.tencent.qqmail.activity.compose.raw;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.qqmail.activity.compose.ComposeViewCallback;
import com.tencent.qqmail.utilities.richeditor.QMEditText;

class QMRawComposeView$7
  implements View.OnFocusChangeListener
{
  QMRawComposeView$7(QMRawComposeView paramQMRawComposeView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && ((QMRawComposeView.access$500(this.this$0) > 0) || (QMRawComposeView.access$800(this.this$0) > 0))) {
      QMRawComposeView.access$300(this.this$0).postDelayed(new QMRawComposeView.7.1(this), 100L);
    }
    if (QMRawComposeView.access$100(this.this$0) != null) {
      QMRawComposeView.access$100(this.this$0).onFocusChange(this.this$0, null, QMRawComposeView.access$300(this.this$0), paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.raw.QMRawComposeView.7
 * JD-Core Version:    0.7.0.1
 */