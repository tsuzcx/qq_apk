package com.tencent.qqmail.view;

import android.widget.TextView;

class QMReadMailTranslateView$1
  implements QMReadMailTranslateView.TranslateRotateAnimation.InterpolatedTimeListener
{
  QMReadMailTranslateView$1(QMReadMailTranslateView paramQMReadMailTranslateView, CharSequence paramCharSequence) {}
  
  public void interpolatedTime(float paramFloat)
  {
    if ((((Boolean)QMReadMailTranslateView.access$000(this.this$0).getTag()).booleanValue()) && (paramFloat > 0.5F))
    {
      QMReadMailTranslateView.access$000(this.this$0).setText(this.val$text);
      QMReadMailTranslateView.access$000(this.this$0).setTag(Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailTranslateView.1
 * JD-Core Version:    0.7.0.1
 */