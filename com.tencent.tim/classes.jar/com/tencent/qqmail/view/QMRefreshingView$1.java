package com.tencent.qqmail.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class QMRefreshingView$1
  extends Animation
{
  QMRefreshingView$1(QMRefreshingView paramQMRefreshingView) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    QMRefreshingView.access$002(this.this$0, 1.0F);
    QMRefreshingView.access$102(this.this$0, (float)(paramFloat * 3.141592653589793D * 1.98D));
    if ((this.this$0.advertiseMode) && (!QMRefreshingView.access$200(this.this$0)) && (QMRefreshingView.access$300(this.this$0) != null) && (QMRefreshingView.access$300(this.this$0).length > 1))
    {
      QMRefreshingView.access$402(this.this$0, (int)(QMRefreshingView.access$300(this.this$0).length * paramFloat));
      this.this$0.updateCurrentBodyBmp(QMRefreshingView.access$400(this.this$0));
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMRefreshingView.1
 * JD-Core Version:    0.7.0.1
 */