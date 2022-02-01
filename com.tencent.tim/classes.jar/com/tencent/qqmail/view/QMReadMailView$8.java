package com.tencent.qqmail.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout.LayoutParams;

class QMReadMailView$8
  extends Animation
{
  QMReadMailView$8(QMReadMailView paramQMReadMailView, LinearLayout.LayoutParams paramLayoutParams, int paramInt) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (paramFloat < 1.0F)
    {
      this.val$params.topMargin = ((int)((0 - this.val$quickReplyHeight) * paramFloat));
      QMReadMailView.access$600(this.this$0).setLayoutParams(this.val$params);
    }
    for (;;)
    {
      QMReadMailView.access$400(this.this$0).invalidateWebView();
      return;
      QMReadMailView.access$600(this.this$0).setVisibility(8);
      this.val$params.topMargin = 0;
      QMReadMailView.access$600(this.this$0).setLayoutParams(this.val$params);
      QMReadMailView.access$400(this.this$0).scrollToWebView(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailView.8
 * JD-Core Version:    0.7.0.1
 */